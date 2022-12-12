package CODIGO.DATA.DAO;

import CODIGO.DATA.Acceso.AccesoDatos;
import CODIGO.DATA.DOMINIOS.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    String nameTable = "CATEGORIAS";
    String primaryKey = "CATEGORIAID";
    String consulta;
    AccesoDatos conectionBD;
    Statement ejecutor;
    PreparedStatement preparador;
    ResultSet resultadosTabla;

    List<Category> listaElementosObtenidos = new ArrayList<Category>();
    int tamanoListaElementos = 0;

    public CategoryDAO() {
        conectionBD = new AccesoDatos();
    }

    public List<Category> GetAllElements() {
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
                        new Category(
                                resultadosTabla.getInt("categoriaid"),
                                resultadosTabla.getInt("proveedorid"),
                                resultadosTabla.getString("codcat"),
                                resultadosTabla.getString("nombrecat"),
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

    public Category GetElementById(int idElement) {
        this.conectionBD.conectar();
        consulta = "SELECT * FROM " + this.nameTable + " WHERE " + this.primaryKey + " = " + idElement;
        try {
            ejecutor = conectionBD.con.createStatement();
            resultadosTabla = ejecutor.executeQuery(consulta);
            while (resultadosTabla.next()) {
                return new Category(
                        resultadosTabla.getInt("categoriaid"),
                        resultadosTabla.getInt("proveedorid"),
                        resultadosTabla.getString("codcat"),
                        resultadosTabla.getString("nombrecat"),
                        resultadosTabla.getString("estado")
                );
            }

            this.conectionBD.cerrar();

        } catch (Exception e) {
            System.out.println("Laconection fallo");
        }

        return new Category();
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


    public void IngresarElemento(Category objetoDominio) {
        this.conectionBD.conectar();
        consulta = "INSERT INTO " + this.nameTable + " (categoriaid, proveedorid, codcat, nombrecat, estado) VALUES (" +
                objetoDominio.categoriaId + "," +
                objetoDominio.proveedorId + ",'" +
                objetoDominio.codCat + "','" +
                objetoDominio.nombreCat + "','" +
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

    public void ActualizarElemento(Category objetoDominio) {
        this.conectionBD.conectar();
        consulta = "UPDATE " + this.nameTable + " SET " +
                "proveedorid = " + objetoDominio.proveedorId + "," +
                "codcat = '" + objetoDominio.codCat + "'," +
                "nombrecat = '" + objetoDominio.nombreCat + "'," +
                "estado = '" + objetoDominio.estado + "' WHERE " +
                this.primaryKey + " = " + objetoDominio.categoriaId;
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


