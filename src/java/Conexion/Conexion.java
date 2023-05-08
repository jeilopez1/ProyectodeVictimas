package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Yeisson Lopez
 */
public class Conexion {
    public static Conexion instance;
    private static Connection conn; 
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "ezL2TuPrsCmFMTBfxfS05A==";
    private static final String pass = "";
    private static final String url = "va1EDtmcfe1zIDyiupDBh+XfsfRK4FCoSBBwESjx/O8C6vKde2nPHZqEkbw8UGdi";
   // encriptado para el proyecto de base de datos
    AES AES=new AES();
     
    private Conexion() {                 
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(AES.decrypt(url), AES.decrypt(user),pass);
            if(conn != null){
                System.out.println("Conecxion establecida");
            }
        }catch (ClassNotFoundException | SQLException e){
            System.out.println("Error de conexion" + e);            
        }
    }
    
    public synchronized static Conexion conectar(){
        if (instance == null) {
            instance = new Conexion();
        }
            return instance;
    }    
    
    public void cerrarConexion(){
        this.instance = null;
        //conn = null;
    }
    
    public Connection getConnection(){
        return conn;
    }   
}
