import Utils.devEnvironment;
import config.OracleConnection;
import controller.ImagenController;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        //Initialize objects for instance methods
        devEnvironment envi = new devEnvironment();
        ImagenController controller = new ImagenController();

        //Environment Develop Variables
        String apiUrl = envi.GetUrlApi();
        String directorioLocal = envi.GetDirectoryDownload();

        //Start Singleton Oracle Connection
        OracleConnection.getInstance();

        //Capture Info User
        Scanner sc = new Scanner(System.in);System.out.print("¿Cuántas imágenes quieres descargar? ");
        int cantidad = sc.nextInt();
        if(cantidad == 0){
            throw new Exception("Favor de ingresar un número concreto de imagenes a descargar.");
        }
        //Run Main program
        controller.descargarVariasImagenes(apiUrl,directorioLocal,cantidad);
    }
}