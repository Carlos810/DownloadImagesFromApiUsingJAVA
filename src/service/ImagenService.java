package service;

import model.Imagen;
import repository.ImagenRepository;

import java.util.ArrayList;
import java.util.List;
import factory.RepositoryFactory;

public class ImagenService {
    private final ImagenRepository repository;

    public ImagenService(){
        //Permite cambiar la implementacion del servicio
        this.repository = RepositoryFactory.getImagenRepository();
    }

    /*
    *Descarga varias imagenes desde API y las guarda en carpeta destino
    *@param apiUrlUrl del endpoint que devuelve imagenes
    *@param carpetaDestino directorio en local donde se guardan las imagenes
    *@param cantidad numero de imagenes a descargar
    *@return lista de objetos tipo 'Imagen' de cada archivo guardado
     */
    public List<Imagen> descargarVarias(String apiUrl, String carpetaDestino, int cantidad){
        List<Imagen> imagenes = new ArrayList<>();
        for (int i = 1; i<= cantidad;i++){
            System.out.println("Descargando imagen: "+i+" de "+cantidad+" ...");
            Imagen img = repository.DescargarYGuardar(apiUrl, carpetaDestino);
            if(img!=null)
                imagenes.add(img);
        }
        return imagenes;
    }

}
