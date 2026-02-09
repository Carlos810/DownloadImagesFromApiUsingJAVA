package repository;

import model.Imagen;

public interface ImagenRepository {

    /**
     * Metodo abstracto que debe implementarse en una clase concreta
     * Su funcion es descargar una imagen desde una URL de una API y guardarla
     * en una carpeta local del sistema
     * @param urlApi  de la api deswde donde se descargara la imagen
     * @param carpetaDestino Rutalocal donde se guardara la imagen descargada
     * @return Un objeto de tipo Imagen que contiene los datos de la imagen descargada
     * */
    Imagen DescargarYGuardar(String apiUrl, String carpetaDestino);
}
