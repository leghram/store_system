package CODIGO.DATA.DAO;

import CODIGO.DATA.Acceso.AccesoDatos;
import CODIGO.DATA.DOMINIOS.Producto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductoDAO {

    String nameTable = "PRODUCTOS";
    String primaryKey = "PRODUCTOID";
    String consulta;
    AccesoDatos conectionBD;
    Statement ejecutor;
    PreparedStatement preparador;
    ResultSet resultadosTabla;

    List<Producto> listaProductos = new ArrayList<Producto>();
    int tamanoListaProductos = 0;

    public  ProductoDAO(){
        conectionBD = new AccesoDatos();
    }

    public List<Producto> GetAllProducts(){
        this.conectionBD.conectar();
        consulta = "SELECT * FROM " + this.nameTable;

        listaProductos.clear();

        try{
        ejecutor = conectionBD.con.createStatement();
        resultadosTabla = ejecutor.executeQuery(consulta);
        tamanoListaProductos = 0;
        while(resultadosTabla.next()){
            tamanoListaProductos = tamanoListaProductos + 1;
            listaProductos.add(
                    new Producto(
                            resultadosTabla.getInt("productoid"),
                            resultadosTabla.getInt("categoriaid"),
                            resultadosTabla.getInt("stock"),
                            resultadosTabla.getDouble("cosuni"),
                            resultadosTabla.getDouble("preuni"),
                            resultadosTabla.getString("unimed"),
                            resultadosTabla.getString("descripcion"),
                            resultadosTabla.getString("estado")
                    )
            );
        }

        System.out.println("tnemos os datos de productos");
        this.conectionBD.cerrar();

        } catch(Exception e){
            System.out.println("Laconection fallo");
        }

        return listaProductos;

    }

    public Producto GetProductById(int IdProduct){
        this.conectionBD.conectar();
        consulta = "SELECT * FROM " + this.nameTable + " WHERE " + this.primaryKey +" = " + IdProduct;
        try{
            ejecutor = conectionBD.con.createStatement();
            resultadosTabla = ejecutor.executeQuery(consulta);
            while(resultadosTabla.next()){
                System.out.println(resultadosTabla.getString("unimed"));
                return new Producto(
                                resultadosTabla.getInt("productoid"),
                                resultadosTabla.getInt("categoriaid"),
                                resultadosTabla.getInt("stock"),
                                resultadosTabla.getDouble("cosuni"),
                                resultadosTabla.getDouble("preuni"),
                                resultadosTabla.getString("unimed"),
                                resultadosTabla.getString("descripcion"),
                                resultadosTabla.getString("estado")
                        );
            }

            this.conectionBD.cerrar();

        } catch(Exception e){
            System.out.println("Laconection fallo");
        }

        return  new Producto();
    }



    public  void EliminarProducto(int idProducto){
        this.conectionBD.conectar();
        consulta = "DELETE FROM "+this.nameTable+ " WHERE "+ this.primaryKey +" = " + idProducto;
        try {
            preparador = conectionBD.con.prepareStatement(consulta);
            preparador.executeUpdate();

            System.out.println("se ha eliminado");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.conectionBD.cerrar();
    }


    public void IngresarProducto(Producto objProducto){
        this.conectionBD.conectar();
        consulta = "INSERT INTO " + this.nameTable +" (productoid, categoriaid, stock, cosuni, preuni, unimed, descripcion, estado) VALUES ("+
                objProducto.productoId+","+
                objProducto.categoriaId+","+
                objProducto.stock+","+
                objProducto.costoUni+","+
                objProducto.precioUni+",'"+
                objProducto.unidadMedida+"','"+
                objProducto.description+"','"+
                objProducto.estado+"')";

        System.out.println(consulta);

        try{
            preparador = conectionBD.con.prepareStatement(consulta);
            preparador.executeUpdate();
            System.out.println("se inserto el registro");

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.conectionBD.cerrar();


    }

    public void ActualizarProducto(Producto objProducto){
        this.conectionBD.conectar();
        consulta = "UPDATE " + this.nameTable +" SET " +
                "categoriaid = " + objProducto.categoriaId + "," +
                "stock = " + objProducto.stock + "," +
                "cosuni = " + objProducto.costoUni + "," +
                "preuni = " + objProducto.precioUni + "," +
                "unimed = '" + objProducto.unidadMedida + "'," +
                "descripcion = '" + objProducto.description + "'," +
                "estado = '" + objProducto.estado + "' WHERE " +
                this.primaryKey + " = " + objProducto.productoId;
        try{
            preparador = conectionBD.con.prepareStatement(consulta);
            preparador.executeUpdate();
            System.out.println("se actualizo la consulta");

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.conectionBD.cerrar();


    }


















}
