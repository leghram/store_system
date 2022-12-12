package CODIGO.DATA.DAO;

import CODIGO.DATA.Acceso.AccesoDatos;
import CODIGO.DATA.DOMINIOS.Documento;
import CODIGO.DATA.DOMINIOS.Proveedor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {

    String nameTable = "PROVEEDORES";
    String primaryKey = "PROVEEDORID";
    String consulta;
    AccesoDatos conectionBD;
    Statement ejecutor;
    PreparedStatement preparador;
    ResultSet resultadosTabla;

    List<Proveedor> listaElementosObtenidos = new ArrayList<Proveedor>();
    int tamanoListaElementos = 0;

    public ProveedorDAO() {
        conectionBD = new AccesoDatos();
    }

    public List<Proveedor> GetAllElements() {
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
                        new Proveedor(
                                resultadosTabla.getInt("proveedorid"),
                                resultadosTabla.getString("codigoprov"),
                                resultadosTabla.getString("nombreprov"),
                                resultadosTabla.getString("direccion"),
                                resultadosTabla.getString("celuprov"),
                                resultadosTabla.getString("rucprov"),
                                resultadosTabla.getString("emailprov"),
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

    public Proveedor GetElementById(int idElement) {
        this.conectionBD.conectar();
        consulta = "SELECT * FROM " + this.nameTable + " WHERE " + this.primaryKey + " = " + idElement;
        try {
            ejecutor = conectionBD.con.createStatement();
            resultadosTabla = ejecutor.executeQuery(consulta);
            while (resultadosTabla.next()) {
                return new Proveedor(
                        resultadosTabla.getInt("proveedorid"),
                        resultadosTabla.getString("codigoprov"),
                        resultadosTabla.getString("nombreprov"),
                        resultadosTabla.getString("direccion"),
                        resultadosTabla.getString("celuprov"),
                        resultadosTabla.getString("rucprov"),
                        resultadosTabla.getString("emailprov"),
                        resultadosTabla.getString("estado")
                );
            }

            this.conectionBD.cerrar();

        } catch (Exception e) {
            System.out.println("Laconection fallo");
        }

        return new Proveedor();
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


    public void IngresarElemento(Proveedor objetoDominio) {
        this.conectionBD.conectar();
        consulta = "INSERT INTO " + this.nameTable + " (proveedorid, codigoprov, nombreprov, direccion, celuprov, rucprov, emailprov, estado) VALUES (" +
                objetoDominio.proveeId + ",'" +
                objetoDominio.codigoProvee + "','" +
                objetoDominio.nombreProvee + "','" +
                objetoDominio.direccion + "','" +
                objetoDominio.celular + "','" +
                objetoDominio.ruc + "','" +
                objetoDominio.email + "','" +
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

    public void ActualizarElemento(Proveedor objetoDominio) {
        this.conectionBD.conectar();
        consulta = "UPDATE " + this.nameTable + " SET " +
                "codigoprov = '" + objetoDominio.codigoProvee + "'," +
                "nombreprov = '" + objetoDominio.nombreProvee + "'," +
                "direccion = '" + objetoDominio.direccion + "'," +
                "celuprov = '" + objetoDominio.celular + "'," +
                "rucprov = '" + objetoDominio.ruc + "'," +
                "emailprov = '" + objetoDominio.email + "'," +
                "estado = '" + objetoDominio.estado + "' WHERE " +
                this.primaryKey + " = " + objetoDominio.proveeId;
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


