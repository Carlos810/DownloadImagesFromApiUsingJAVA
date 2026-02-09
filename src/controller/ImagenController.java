package controller;

import model.Imagen;
import service.ImagenService;

import java.util.List;

public class ImagenController{
    private final ImagenService service;

    public ImagenController() {
        //crea una instancia del servicio.
        //controlador NO hace la lógica, solo delega.
        this.service = new ImagenService();
    }

    /**
     *  Método del controlador encargado de coordinar la descarga
     * de varias imágenes. Recibe los parámetros desde donde sea que
     * se invoque (una UI, una consola, un endpoint, etc).
     *
     * @param apiUrl         URL del API que devuelve una imagen por llamada
     * @param carpetaDestino Carpeta local donde se guardarán los archivos
     * @param cantidad       Número de imágenes a descargar
     */
    public void descargarVariasImagenes(String apiUrl, String carpetaDestino, int cantidad) {

        // delega la lógica de descarga al servicio
        List<Imagen> imagenes = service.descargarVarias(apiUrl, carpetaDestino, cantidad);

        // muestra el total de imágenes descargadas
        System.out.println(" Total imágenes descargadas: " + imagenes.size());

        // Se imprimen los datos de cada imagen descargada
        // usando una referencia a método (::)
        imagenes.forEach(System.out::println);
    }
}
