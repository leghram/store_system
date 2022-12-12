package CODIGO.DATA.DAO;

import CODIGO.DATA.Acceso.AccesoDatos;
import CODIGO.DATA.DOMINIOS.Usuario;
import CODIGO.DATA.DOMINIOS.Ventas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VentasDAO {

    String nameTable = "VENTAS";
    String primaryKey = "VENTAID";
    String consulta;
    AccesoDatos conectionBD;
    Statement ejecutor;
    PreparedStatement preparador;
    ResultSet resultadosTabla;

    List<Ventas> listaElementosObtenidos = new ArrayList<Ventas>();
    int tamanoListaElementos = 0;

    public VentasDAO() {
        conectionBD = new AccesoDatos();
    }

    public List<Ventas> GetAllElements() {
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
                        new Ventas(
                                resultadosTabla.getInt("ventaid"),
                                resultadosTabla.getInt("usuarioid"),
                                resultadosTabla.getInt("clienteid"),
                                resultadosTabla.getInt("documentoid"),
                                resultadosTabla.getString("fecha"),
                                resultadosTabla.getDouble("importe"),
                                resultadosTabla.getDouble("igv"),
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

    public Ventas GetElementById(int idElement) {
        this.conectionBD.conectar();
        consulta = "SELECT * FROM " + this.nameTable + " WHERE " + this.primaryKey + " = " + idElement;
        try {
            ejecutor = conectionBD.con.createStatement();
            resultadosTabla = ejecutor.executeQuery(consulta);
            while (resultadosTabla.next()) {
                return new Ventas(
                        resultadosTabla.getInt("ventaid"),
                        resultadosTabla.getInt("usuarioid"),
                        resultadosTabla.getInt("clienteid"),
                        resultadosTabla.getInt("documentoid"),
                        resultadosTabla.getString("fecha"),
                        resultadosTabla.getDouble("importe"),
                        resultadosTabla.getDouble("igv"),
                        resultadosTabla.getString("estado")
                );
            }

            this.conectionBD.cerrar();

        } catch (Exception e) {
            System.out.println("Laconection fallo");
        }

        return new Ventas();
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


    public void IngresarElemento(Ventas objetoDominio) {
        this.conectionBD.conectar();
        consulta = "INSERT INTO " + this.nameTable + " (ventaid, usuarioid, clienteid, documentoid, fecha, importe, igv, estado) VALUES (" +
                objetoDominio.ventasId + "," +
                objetoDominio.usuarioId + "," +
                objetoDominio.clienteId + "," +
                objetoDominio.documentoId + ",'" +
                objetoDominio.fecha + "'," +
                objetoDominio.importe + "," +
                objetoDominio.igv + ",'" +
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

    public void ActualizarElemento(Ventas objetoDominio) {
        this.conectionBD.conectar();
        consulta = "UPDATE " + this.nameTable + " SET " +
                "usuarioid = " + objetoDominio.usuarioId + "," +
                "clienteid = " + objetoDominio.clienteId + "," +
                "documentoid = " + objetoDominio.documentoId + "," +
                "fecha = '" + objetoDominio.fecha + "'," +
                "importe = " + objetoDominio.importe + "," +
                "igv = " + objetoDominio.igv + "," +
                "estado = '" + objetoDominio.estado + "' WHERE " +
                this.primaryKey + " = " + objetoDominio.ventasId;
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


