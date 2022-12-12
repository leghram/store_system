package CODIGO.DATA.Acceso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class AccesoDatos {

    public Connection con = null;

    String url = "jdbc:postgresql://localhost/SYSTEMDB";

    String usuario = "postgres";
    String contrasena = "root";



    public void conectar(){
        try{
            //Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url,usuario,contrasena);
            System.out.println("Se pudo");
        }
        catch(Exception e){
            System.out.println("Laconection fallo");
        }
    }

    public void cerrar(){
        try{
            con.close();
        }
        catch(Exception e){
            System.out.println("Cerrado");
        }
    }


//
// public static Connection conectar(){
// String usuario;
// String clave;
// String url;
//
// usuario = "postgres";
// clave = "root";
// url = "jdbc:postgresql://localhost/PROYECTO";
//
// try {
//
// Class.forName("org.postgresql.Driver");
//
// return DriverManager.getConnection(url,usuario,clave);
//
//
//
// } catch (ClassNotFoundException ex) {
// throw new RuntimeException(ex + "Error, No se puede conectar a la BD");
// } catch (SQLException ex) {
// throw new RuntimeException(ex + "Error, No existe el driver");
// }
// }
//
// public static void main(String[] args) throws SQLException {
// Connection c = AccesoDatos.conectar();
// System.out.println(c.isClosed());
// }
}