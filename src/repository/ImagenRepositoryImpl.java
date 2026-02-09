package repository;

import config.OracleConnection;
import model.Imagen;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImagenRepositoryImpl implements ImagenRepository{
    /**
     * Implementación del método descargarYGuardar.
     *
     * @param apiUrl URL desde donde se descargará la imagen.
     * @param carpetaDestino Carpeta local donde se almacenará la imagen descargada.
     * @return Un objeto Imagen con la información generada (id, url, nombreArchivo).
     */
    @Override
    public Imagen DescargarYGuardar(String apiUrl, String carpetaDestino) {
        try{
            // Descargar imagen desde la API -------------------------------

            // Crea un objeto URL con la dirección proporcionada
            URL url = new URL(apiUrl);
            // Abre la conexión HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // Define el método HTTP como GET (descarga de datos)
            connection.setRequestMethod("GET");

            String nombreArchivo = "imagen_" + System.currentTimeMillis()+".jpg";
            File destino =  new File(carpetaDestino, nombreArchivo);

            if (!destino.getParentFile().exists()){
                destino.getParentFile().mkdir();
            }

            try(InputStream in = connection.getInputStream();
                FileOutputStream out = new FileOutputStream(destino)
            )
            {
                byte[] buffer = new byte[1024] ;//1kilobyte
                int bytesLeidos;

                while((bytesLeidos = in.read(buffer)) != -1){
                    out.write(buffer,0,bytesLeidos);
                }
            }

            System.out.println("Imagen descargada: "+destino.getAbsolutePath());
            //Crea un objeto de imagen con los datos de la descarga
            Imagen imagen = new Imagen(apiUrl,nombreArchivo);

            //Devuelve el objeto imagen creado
            guardarEnBase(imagen);

            return imagen;

        }catch(IOException io){
            System.err.println("Error al descargar imagen: "+io.getMessage());
            return null;
        }
    }

    private void guardarEnBase(Imagen imagen){
        //Consulta SQL para insertar los datos en la tabla IMAGENES
        String sql = "INSERT INTO IMAGENES(ID,URL,NOMBRE_ARCHIVO) VALUES(?,?,?)";
        //Try-with-resources: garantiza que laconexion y el prepareStatement se cierren automaticamente
        try(Connection conn = OracleConnection.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql))
        {
            //Asignamos los valores de la imagen a los parámetros de la consulta
            ps.setString(1,imagen.getId());
            ps.setString(2,imagen.getUrl());
            ps.setString(3,imagen.getNombreArchivo());
            //Ejecuta la insercion en la base de datos
            ps.executeUpdate();
            System.out.println("Imagen guardada en oracle: "+ imagen.getNombreArchivo() );
        }catch(SQLException io){
            System.err.println("Error al guardar en Oracle: "+io.getMessage());
        }
    }
}
