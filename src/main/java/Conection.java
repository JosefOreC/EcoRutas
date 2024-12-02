

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {
    private String url="jdbc:sqlserver://localhost:1433;databaseName=dbEcoRutas;encrypt=true;trustServerCertificate=true";
    private String user="sa";
    private String password="123456";
    public Connection con = null;
    public Conection(){
        Conectarse();
    }
    public Connection Conectarse(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=DriverManager.getConnection(url, user, password);
            System.out.println("Se logró conexion");
        }catch(ClassNotFoundException e){
            System.out.println("No se logró conexion\n"+e);
        }catch(SQLException e){
            System.out.println("No se logró conexion\n"+e);
        }
        return con;
    }
}

