package CODIGO.DATA.DAO;

import CODIGO.DATA.Acceso.AccesoDatos;
import CODIGO.DATA.DOMINIOS.Category;
import CODIGO.DATA.DOMINIOS.Documento;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DocumentoDAO {

    String nameTable = "DOCUMENTO";
    String primaryKey = "DOCUMENTOID";
    String consulta;
    AccesoDatos conectionBD;
    Statement ejecutor;
    PreparedStatement preparador;
    ResultSet resultadosTabla;

    List<Documento> listaElementosObtenidos = new ArrayList<Documento>();
    int tamanoListaElementos = 0;

    public DocumentoDAO() {
        conectionBD = new AccesoDatos();
    }

    public List<Documento> GetAllElements() {
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
                        new Documento(
                                resultadosTabla.getInt("documentoid"),
                                resultadosTabla.getInt("codigodoc"),
                                resultadosTabla.getString("nomdocumento")
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

    public Documento GetElementById(int idElement) {
        this.conectionBD.conectar();
        consulta = "SELECT * FROM " + this.nameTable + " WHERE " + this.primaryKey + " = " + idElement;
        try {
            ejecutor = conectionBD.con.createStatement();
            resultadosTabla = ejecutor.executeQuery(consulta);
            while (resultadosTabla.next()) {
                return new Documento(
                        resultadosTabla.getInt("documentoid"),
                        resultadosTabla.getInt("codigodoc"),
                        resultadosTabla.getString("nomdocumento")
                );
            }

            this.conectionBD.cerrar();

        } catch (Exception e) {
            System.out.println("Laconection fallo");
        }

        return new Documento();
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


    public void IngresarElemento(Documento objetoDominio) {
        this.conectionBD.conectar();
        consulta = "INSERT INTO " + this.nameTable + " (documentoid, codigodoc, nomdocumento) VALUES (" +
                objetoDominio.documentoId + "," +
                objetoDominio.codigoDoc + ",'" +
                objetoDominio.nombreDoc + "')";

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

    public void ActualizarElemento(Documento objetoDominio) {
        this.conectionBD.conectar();
        consulta = "UPDATE " + this.nameTable + " SET " +
                "codigodoc = " + objetoDominio.codigoDoc + "," +
                "nomdocumento = '" + objetoDominio.nombreDoc + "' WHERE " +
                this.primaryKey + " = " + objetoDominio.documentoId;
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


