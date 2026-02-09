package model;

import java.util.UUID;

public class Imagen {

    //atributos encapsulados de la clase
    private String id;
    private String url;
    private String nombreArchivo;

    /**
     * Constructor de la clase imagen.
     * Este método se ejecuta al crear un nuevo objeto imagen
     * @param url   Dirección donde se almacena la imagen
     * @param nombreArchivo nombre del archivo de la imagen
     */
    public Imagen(String url, String nombreArchivo) {
        this.id = UUID.randomUUID().toString();
        this.url = url;
        this.nombreArchivo = nombreArchivo;
    }

    //Metodos getters para acceder a los elementos privados
    public String getId(){return id;}
    public String getUrl(){return url;}
    public String getNombreArchivo(){return nombreArchivo;}

    /** * Sobrescribe el método toString() de la clase Object. * Permite mostrar la información completa del objeto Imagen en formato legible. */
    @Override public String toString() { return "Imagen{ " + "id='" + id + '\'' + ", url='" + url + '\'' + ", nombreArchivo='" + nombreArchivo + '\'' + '}'; }
}
