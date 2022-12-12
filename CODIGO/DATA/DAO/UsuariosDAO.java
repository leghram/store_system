package CODIGO.DATA.DAO;

import CODIGO.DATA.Acceso.AccesoDatos;
import CODIGO.DATA.DOMINIOS.Proveedor;
import CODIGO.DATA.DOMINIOS.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuariosDAO {

    String nameTable = "USUARIOS";
    String primaryKey = "USUARIOID";
    String consulta;
    AccesoDatos conectionBD;
    Statement ejecutor;
    PreparedStatement preparador;
    ResultSet resultadosTabla;

    List<Usuario> listaElementosObtenidos = new ArrayList<Usuario>();
    int tamanoListaElementos = 0;

    public UsuariosDAO() {
        conectionBD = new AccesoDatos();
    }

    public List<Usuario> GetAllElements() {
        this.conectionBD.conectar();
        consulta = "SELECT * FROM " + this.nameTable;

        listaElementosObtenidos.clear();

        try {
            ejecutor = conectionBD.con.createStatement();
            resultadosTabla = ejecutor.executeQuery(consulta);
            tamanoListaElementos = 0;
            while (resultadosTabla.next()) {
                tamanoListaElementos = tamanoListaElementos + 1;
                listaElementosObtenidos.add(
                        new Usuario(
                                resultadosTabla.getInt("usuarioid"),
                                resultadosTabla.getString("codigo"),
                                resultadosTabla.getString("nombre"),
                                resultadosTabla.getString("apellido"),
                                resultadosTabla.getString("fecha_nac"),
                                resultadosTabla.getString("dni"),
                                resultadosTabla.getString("password"),
                                resultadosTabla.getString("estado")
                        )
                );
            }

            System.out.println("tnemos os datos las categorias");
            this.conectionBD.cerrar();

        } catch (Exception e) {
            System.out.println("Laconection fallo");
        }

        return  listaElementosObtenidos;

    }

    public Usuario GetElementById(int idElement) {
        this.conectionBD.conectar();
        consulta = "SELECT * FROM " + this.nameTable + " WHERE " + this.primaryKey + " = " + idElement;
        try {
            ejecutor = conectionBD.con.createStatement();
            resultadosTabla = ejecutor.executeQuery(consulta);
            while (resultadosTabla.next()) {
                return new Usuario(
                        resultadosTabla.getInt("usuarioid"),
                        resultadosTabla.getString("codigo"),
                        resultadosTabla.getString("nombre"),
                        resultadosTabla.getString("apellido"),
                        resultadosTabla.getString("fecha_nac"),
                        resultadosTabla.getString("dni"),
                        resultadosTabla.getString("password"),
                        resultadosTabla.getString("estado")
                );
            }

            this.conectionBD.cerrar();

        } catch (Exception e) {
            System.out.println("Laconection fallo");
        }

        return new Usuario();
    }


    public void EliminarElemento(int idElement) {
        this.conectionBD.conectar();
        consulta = "DELETE FROM " + this.nameTable + " WHERE " + this.primaryKey + " = " + idElement;
        try {
            preparador = conectionBD.con.prepareStatement(consulta);
            preparador.executeUpdate();

            System.out.println("se ha eliminado");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.conectionBD.cerrar();
    }


    public void IngresarElemento(Usuario objetoDominio) {
        this.conectionBD.conectar();
        consulta = "INSERT INTO " + this.nameTable + " (usuarioid, codigo, nombre, apellido, fecha_nac, dni, password, estado) VALUES (" +
                objetoDominio.usuarioId + ",'" +
                objetoDominio.codigoUsuario + "','" +
                objetoDominio.nombre + "','" +
                objetoDominio.apellido + "','" +
                objetoDominio.fechaNac + "','" +
                objetoDominio.dni + "','" +
                objetoDominio.password + "','" +
                objetoDominio.estado + "')";

        System.out.println(consulta);

        try {
            preparador = conectionBD.con.prepareStatement(consulta);
            preparador.executeUpdate();
            System.out.println("se inserto el registro");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.conectionBD.cerrar();


    }

    public void ActualizarElemento(Usuario objetoDominio) {
        this.conectionBD.conectar();
        consulta = "UPDATE " + this.nameTable + " SET " +
                "codigo = '" + objetoDominio.codigoUsuario + "'," +
                "nombre = '" + objetoDominio.nombre + "'," +
                "apellido = '" + objetoDominio.apellido + "'," +
                "fecha_nac = '" + objetoDominio.fechaNac + "'," +
                "dni = '" + objetoDominio.dni + "'," +
                "password = '" + objetoDominio.password + "'," +
                "estado = '" + objetoDominio.estado + "' WHERE " +
                this.primaryKey + " = " + objetoDominio.usuarioId;
        System.out.println(consulta);
        try {
            preparador = conectionBD.con.prepareStatement(consulta);
            preparador.executeUpdate();
            System.out.println("se actualizo la consulta");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.conectionBD.cerrar();


    }

}


