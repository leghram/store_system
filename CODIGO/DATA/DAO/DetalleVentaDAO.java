package CODIGO.DATA.DAO;

import CODIGO.DATA.Acceso.AccesoDatos;
import CODIGO.DATA.DOMINIOS.Category;
import CODIGO.DATA.DOMINIOS.DetalleVenta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DetalleVentaDAO {

    String nameTable = "DETALLE_VENTAS";
    String primaryKey = "DETALLEID";
    String consulta;
    AccesoDatos conectionBD;
    Statement ejecutor;
    PreparedStatement preparador;
    ResultSet resultadosTabla;

    List<DetalleVenta> listaElementosObtenidos = new ArrayList<DetalleVenta>();
    int tamanoListaElementos = 0;

    public DetalleVentaDAO() {
        conectionBD = new AccesoDatos();
    }

    public List<DetalleVenta> GetAllElements() {
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
                        new DetalleVenta(
                                resultadosTabla.getInt("detalleid"),
                                resultadosTabla.getInt("ventaid"),
                                resultadosTabla.getInt("productoid"),
                                resultadosTabla.getInt("cantidad"),
                                resultadosTabla.getDouble("cosuni"),
                                resultadosTabla.getDouble("preuni")
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

    public DetalleVenta GetElementById(int idElement) {
        this.conectionBD.conectar();
        consulta = "SELECT * FROM " + this.nameTable + " WHERE " + this.primaryKey + " = " + idElement;
        try {
            ejecutor = conectionBD.con.createStatement();
            resultadosTabla = ejecutor.executeQuery(consulta);
            while (resultadosTabla.next()) {
                return new DetalleVenta(
                        resultadosTabla.getInt("detalleid"),
                        resultadosTabla.getInt("ventaid"),
                        resultadosTabla.getInt("productoid"),
                        resultadosTabla.getInt("cantidad"),
                        resultadosTabla.getDouble("cosuni"),
                        resultadosTabla.getDouble("preuni")
                );
            }

            this.conectionBD.cerrar();

        } catch (Exception e) {
            System.out.println("Laconection fallo");
        }

        return new DetalleVenta();
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


    public void IngresarElemento(DetalleVenta objetoDominio) {
        this.conectionBD.conectar();
        consulta = "INSERT INTO " + this.nameTable + " (detalleid, ventaid, productoid, cantidad, cosuni,preuni) VALUES (" +
                objetoDominio.detalleVentaId + "," +
                objetoDominio.ventaId + "," +
                objetoDominio.productoId + "," +
                objetoDominio.cantidad + "," +
                objetoDominio.costoUni + "," +
                objetoDominio.precioUni + ")";

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

    public void ActualizarElemento(DetalleVenta objetoDominio) {
        this.conectionBD.conectar();
        consulta = "UPDATE " + this.nameTable + " SET " +
                "ventaid = " + objetoDominio.ventaId + "," +
                "productoid = '" + objetoDominio.productoId + "'," +
                "cantidad = '" + objetoDominio.cantidad + "'," +
                "cosuni = '" + objetoDominio.costoUni + "'," +
                "preuni = '" + objetoDominio.precioUni + "' WHERE " +
                this.primaryKey + " = " + objetoDominio.detalleVentaId;
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

