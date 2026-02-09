package config;

import Utils.devEnvironment;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.Class.forName;
import static javax.management.remote.JMXConnectorFactory.connect;

public class OracleConnection {
    private static OracleConnection instance;

    private Connection connection;

    devEnvironment envi = new devEnvironment();

    private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private final String USER = envi.GetUserTesting();
    private final String PASSWORD = envi.GetPassForTesting();

    /*
    * constructor privado
    * */
    private OracleConnection(){connect();}

    private void connect(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Conexion oracle establecida");

        }catch(ClassNotFoundException | SQLException e){
            System.err.println("Error al conectar con Oracle: "+ e.getMessage());
        }
    }

    /*
    *Metodo estatico el cual devuelve (Singleton)
     */
    public static OracleConnection getInstance(){
        if (instance == null){
            synchronized (OracleConnection.class){
                if(instance == null){
                    instance = new OracleConnection();
                }
            }
        }
        return instance;
    }

    public Connection getConnection(){
        try{

            if(connection == null || connection.isClosed()){
                System.out.print("Reconectando a Oracle..");
                connect();
            }
        } catch (Exception e) {
            System.err.println("Error: verificando la conexion"+e.getMessage());
        }
        return connection;
    }


}
