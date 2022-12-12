package CODIGO.DATA.DAO;

import CODIGO.DATA.Acceso.AccesoDatos;
import CODIGO.DATA.DOMINIOS.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    String nameTable = "CLIENTES";
    String primaryKey = "CLIENTEID";
    String consulta;
    AccesoDatos conectionBD;
    Statement ejecutor;
    PreparedStatement preparador;
    ResultSet resultadosTabla;

    List<Cliente> listaElementosObtenidos = new ArrayList<Cliente>();
    int tamanoListaElementos = 0;

    public ClienteDAO() {
        conectionBD = new AccesoDatos();
    }

    public List<Cliente> GetAllElements() {
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
                        new Cliente(
                                resultadosTabla.getInt("clienteid"),
                                resultadosTabla.getInt("tipoid"),
                                resultadosTabla.getInt("zonaid"),
                                resultadosTabla.getString("ruc"),
                                resultadosTabla.getString("nombre"),
                                resultadosTabla.getString("direccioncli"),
                                resultadosTabla.getString("email"),
                                resultadosTabla.getString("celular"),
                                resultadosTabla.getString("estado")
                        )
                );
            }

            this.conectionBD.cerrar();

        } catch (Exception e) {
            System.out.println("Laconection fallo");
        }

        return  listaElementosObtenidos;

    }

    public Cliente GetElementById(int idElement) {
        this.conectionBD.conectar();
        consulta = "SELECT * FROM " + this.nameTable + " WHERE " + this.primaryKey + " = " + idElement;
        try {
            ejecutor = conectionBD.con.createStatement();
            resultadosTabla = ejecutor.executeQuery(consulta);
            while (resultadosTabla.next()) {
                return new Cliente(
                        resultadosTabla.getInt("clienteid"),
                        resultadosTabla.getInt("tipoid"),
                        resultadosTabla.getInt("zonaid"),
                        resultadosTabla.getString("ruc"),
                        resultadosTabla.getString("nombre"),
                        resultadosTabla.getString("direccioncli"),
                        resultadosTabla.getString("email"),
                        resultadosTabla.getString("celular"),
                        resultadosTabla.getString("estado")
                );
            }

            this.conectionBD.cerrar();

        } catch (Exception e) {
            System.out.println("Laconection fallo");
        }

        return new Cliente();
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


    public void IngresarElemento(Cliente objetoDominio) {
        this.conectionBD.conectar();
        consulta = "INSERT INTO " + this.nameTable + " (clienteid, tipoid, zonaid, ruc, nombre, direccioncli, email, celular, estado) VALUES (" +
                objetoDominio.clienteId + "," +
                objetoDominio.tipoClienteId + "," +
                objetoDominio.zonaid + ",'" +
                objetoDominio.ruc + "','" +
                objetoDominio.nombre + "','" +
                objetoDominio.direccion + "','" +
                objetoDominio.email + "','" +
                objetoDominio.celular + "','" +
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

    public void ActualizarElemento(Cliente objetoDominio) {
        this.conectionBD.conectar();
        consulta = "UPDATE " + this.nameTable + " SET " +
                "tipoid = " + objetoDominio.tipoClienteId + "," +
                "zonaid = " + objetoDominio.zonaid + "," +
                "ruc = '" + objetoDominio.ruc + "'," +
                "nombre = '" + objetoDominio.nombre + "'," +
                "direccioncli = '" + objetoDominio.direccion + "'," +
                "email = '" + objetoDominio.email + "'," +
                "celular = '" + objetoDominio.celular + "'," +
                "estado = '" + objetoDominio.estado + "' WHERE " +
                this.primaryKey + " = " + objetoDominio.clienteId;
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


