package CODIGO.DATA.DAO;

import CODIGO.DATA.Acceso.AccesoDatos;
import CODIGO.DATA.DOMINIOS.Proveedor;
import CODIGO.DATA.DOMINIOS.TipoCliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TipoClienteDAO {

    String nameTable = "TIPO_CLIENTE";
    String primaryKey = "TIPOID";
    String consulta;
    AccesoDatos conectionBD;
    Statement ejecutor;
    PreparedStatement preparador;
    ResultSet resultadosTabla;

    List<TipoCliente> listaElementosObtenidos = new ArrayList<TipoCliente>();
    int tamanoListaElementos = 0;

    public TipoClienteDAO() {
        conectionBD = new AccesoDatos();
    }

    public List<TipoCliente> GetAllElements() {
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
                        new TipoCliente(
                                resultadosTabla.getInt("tipoid"),
                                resultadosTabla.getString("nomtipo")
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

    public TipoCliente GetElementById(int idElement) {
        this.conectionBD.conectar();
        consulta = "SELECT * FROM " + this.nameTable + " WHERE " + this.primaryKey + " = " + idElement;
        try {
            ejecutor = conectionBD.con.createStatement();
            resultadosTabla = ejecutor.executeQuery(consulta);
            while (resultadosTabla.next()) {
                return new TipoCliente(
                        resultadosTabla.getInt("tipoid"),
                        resultadosTabla.getString("nomtipo")
                );
            }

            this.conectionBD.cerrar();

        } catch (Exception e) {
            System.out.println("Laconection fallo");
        }

        return new TipoCliente();
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


    public void IngresarElemento(TipoCliente objetoDominio) {
        this.conectionBD.conectar();
        consulta = "INSERT INTO " + this.nameTable + " (tipoid, nomtipo) VALUES (" +
                objetoDominio.tipoClienteId + ",'" +
                objetoDominio.nombre + "')";

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

    public void ActualizarElemento(TipoCliente objetoDominio) {
        this.conectionBD.conectar();
        consulta = "UPDATE " + this.nameTable + " SET " +
                "nomtipo = '" + objetoDominio.nombre + "' WHERE " +
                this.primaryKey + " = " + objetoDominio.tipoClienteId;
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


