package factory;

import repository.ImagenRepository;
import repository.ImagenRepositoryImpl;

public class RepositoryFactory {
    public static ImagenRepository getImagenRepository() {return new ImagenRepositoryImpl();}
}
