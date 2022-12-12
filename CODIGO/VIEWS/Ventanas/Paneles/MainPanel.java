package CODIGO.VIEWS.Ventanas.Paneles;

import CODIGO.DATA.DAO.*;
import CODIGO.DATA.DOMINIOS.*;
import CODIGO.VIEWS.Ventanas.Componentes.Boton;
import CODIGO.VIEWS.Ventanas.Componentes.Etiqueta;
import CODIGO.VIEWS.Ventanas.Componentes.RowData;


import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainPanel extends JPanel {

    CategoryDAO daoCategoria = new CategoryDAO();
    List<Category> listaCategorias;
    String[] listaContenidoCategoria = new String[5];

    ClienteDAO daoCliente = new ClienteDAO();
    List<Cliente> listaClientes;
    String[] listaContenidoCliente = new String[9];

    DetalleVentaDAO daoDetalleVenta = new DetalleVentaDAO();
    List<DetalleVenta> listaDetalleVentas;
    String[] listaContenidoDetalle = new String[6];

    DocumentoDAO daoDocumento = new DocumentoDAO();
    List<Documento> listaDocumentos;
    String[] listaContenidoDocumentos = new String[3];

    ProductoDAO daoProducto = new ProductoDAO();
    List<Producto> listaProductos;
    String[] listaContenidoProductos = new String[8];

    ProveedorDAO daoProveedor = new ProveedorDAO();
    List<Proveedor> listaProveedores;
    String[] listaContenidoProveedor = new String[8];

    TipoClienteDAO daoTipoCliente = new TipoClienteDAO();
    List<TipoCliente> listaTiposClientes;
    String[] listaContenidoTipoCliente = new String[2];

    UsuariosDAO daoUsuario = new UsuariosDAO();
    List<Usuario> listaUsuarios;
    String[] listaContenidoUsuario = new String[8];

    VentasDAO daoVentas = new VentasDAO();
    List<Ventas> listaVentas;
    String[] listaContenidoVentas = new String[8];

    ZonaDAO daoZona = new ZonaDAO();
    List<Zona> listaZonas;
    String[] listaContenidoZonas = new String[3];


    int inicioY;

    int posicion= 0;
    int anchoPanelTotal ;
    int anchoPanel;

    JButton[] listaOpciones = {
            new Boton("Ver Registros"),
            new Boton("Insertar"),
            new Boton("Actualizar"),
            new Boton("Eliminar")
    };

    public  MainPanel(int inicioX, int inicioY, int anchoX, int altoY, Color new_color){
        this.anchoPanelTotal = anchoX;
        setLayout(null);
        setBounds(inicioX,inicioY,anchoPanelTotal,altoY);
        setBackground(new_color);

    }


    public void generarOpcionesMenu(JPanel panel, int anchoTotal){
        posicion = 0;
        int anchoBoton = anchoTotal/4;
        for (int i =0; i < listaOpciones.length ; i++){
            listaOpciones[i].setBounds(posicion,0,anchoBoton,50);
            panel.add(listaOpciones[i]);
            posicion = posicion + anchoBoton;
        }
    }

    public void AgregarRegistrosPanel(JPanel areaPanel, String nombreEntidadTabla){
        //iniciamos en 50 porque los botones de ingresar / update /  update / delete ESTAN EN LA PARTE SUPERIOR
        inicioY = 50;
        anchoPanel = anchoPanelTotal;
        generarOpcionesMenu(areaPanel,anchoPanel);


        if(nombreEntidadTabla == "Categorias"){
            if (listaCategorias != null) {
                listaCategorias.clear();
            }
            listaCategorias = daoCategoria.GetAllElements();
            for(Category data: listaCategorias) {
                listaContenidoCategoria[0] = data.categoriaId +"";
                listaContenidoCategoria[1] = data.proveedorId +"";
                listaContenidoCategoria[2] = data.codCat +"";
                listaContenidoCategoria[3] = data.nombreCat +"";
                listaContenidoCategoria[4] = data.estado +"";
                RowData linea = new RowData(listaContenidoCategoria,inicioY,anchoPanel);
                areaPanel.add(linea);
                inicioY = inicioY + 50;
            }
        }
        else if(nombreEntidadTabla == "Clientes"){
            if (listaClientes != null) {
                listaClientes.clear();
            }
            listaClientes = daoCliente.GetAllElements();
            for(Cliente data: listaClientes) {
                listaContenidoCliente[0] = data.clienteId +"";
                listaContenidoCliente[1] = data.tipoClienteId +"";
                listaContenidoCliente[2] = data.zonaid +"";
                listaContenidoCliente[3] = data.ruc +"";
                listaContenidoCliente[4] = data.nombre +"";
                listaContenidoCliente[5] = data.direccion +"";
                listaContenidoCliente[6] = data.email +"";
                listaContenidoCliente[7] = data.celular +"";
                listaContenidoCliente[8] = data.estado +"";
                RowData linea = new RowData(listaContenidoCliente,inicioY,anchoPanel);
                areaPanel.add(linea);
                inicioY = inicioY + 50;
            }

        }
        else if(nombreEntidadTabla == "Detalle Venta"){
            if (listaDetalleVentas != null) {
                listaDetalleVentas.clear();
            }
            listaDetalleVentas = daoDetalleVenta.GetAllElements();
            for(DetalleVenta data: listaDetalleVentas) {
                listaContenidoDetalle[0] = data.detalleVentaId +"";
                listaContenidoDetalle[1] = data.ventaId +"";
                listaContenidoDetalle[2] = data.productoId +"";
                listaContenidoDetalle[3] = data.cantidad +"";
                listaContenidoDetalle[4] = data.costoUni +"";
                listaContenidoDetalle[5] = data.precioUni +"";
                RowData linea = new RowData(listaContenidoDetalle,inicioY,anchoPanel);
                areaPanel.add(linea);
                inicioY = inicioY + 50;
            }
        }
        else if(nombreEntidadTabla == "Documentos"){
            if (listaDocumentos != null) {
                listaDocumentos.clear();
            }
            listaDocumentos = daoDocumento.GetAllElements();
            for(Documento data: listaDocumentos) {
                listaContenidoDocumentos[0] = data.documentoId +"";
                listaContenidoDocumentos[1] = data.codigoDoc +"";
                listaContenidoDocumentos[2] = data.nombreDoc +"";
                RowData linea = new RowData(listaContenidoDocumentos,inicioY,anchoPanel);
                areaPanel.add(linea);
                inicioY = inicioY + 50;
            }
        }
        else if(nombreEntidadTabla == "Productos"){
            if (listaProductos != null){
                listaProductos.clear();
            }

            listaProductos = daoProducto.GetAllProducts();
            for(Producto data: listaProductos) {
                listaContenidoProductos[0] = data.productoId +"";
                listaContenidoProductos[1] = data.categoriaId +"";
                listaContenidoProductos[2] = data.stock +"";
                listaContenidoProductos[3] = data.costoUni +"";
                listaContenidoProductos[4] = data.precioUni +"";
                listaContenidoProductos[5] = data.unidadMedida +"";
                listaContenidoProductos[6] = data.description +"";
                listaContenidoProductos[7] = data.estado +"";
                RowData linea = new RowData(listaContenidoProductos,inicioY,anchoPanel);
                areaPanel.add(linea);
                inicioY = inicioY + 50;
            }
        }
        else if(nombreEntidadTabla == "Proveedores"){
            if (listaProveedores != null) {
                listaProveedores.clear();
            }
            listaProveedores = daoProveedor.GetAllElements();
            for(Proveedor data: listaProveedores) {
                listaContenidoProveedor[0] = data.proveeId +"";
                listaContenidoProveedor[1] = data.codigoProvee +"";
                listaContenidoProveedor[2] = data.nombreProvee +"";
                listaContenidoProveedor[3] = data.direccion +"";
                listaContenidoProveedor[4] = data.celular +"";
                listaContenidoProveedor[5] = data.ruc +"";
                listaContenidoProveedor[6] = data.email +"";
                listaContenidoProveedor[7] = data.estado +"";
                RowData linea = new RowData(listaContenidoProveedor,inicioY,anchoPanel);
                areaPanel.add(linea);
                inicioY = inicioY + 50;
            }
        }
        else if(nombreEntidadTabla == "Tipos Cliente"){
            if (listaTiposClientes != null) {
                listaTiposClientes.clear();
            }
            listaTiposClientes = daoTipoCliente.GetAllElements();
            for(TipoCliente data: listaTiposClientes) {
                listaContenidoTipoCliente[0] = data.tipoClienteId +"";
                listaContenidoTipoCliente[1] = data.nombre +"";
                RowData linea = new RowData(listaContenidoTipoCliente,inicioY,anchoPanel);
                areaPanel.add(linea);
                inicioY = inicioY + 50;
            }
        }
        else if(nombreEntidadTabla == "Usuarios"){
            if (listaUsuarios != null) {
                listaUsuarios.clear();
            }
            listaUsuarios = daoUsuario.GetAllElements();
            for(Usuario data: listaUsuarios) {
                listaContenidoUsuario[0] = data.usuarioId +"";
                listaContenidoUsuario[1] = data.codigoUsuario +"";
                listaContenidoUsuario[2] = data.nombre +"";
                listaContenidoUsuario[3] = data.apellido +"";
                listaContenidoUsuario[4] = data.fechaNac +"";
                listaContenidoUsuario[5] = data.dni +"";
                listaContenidoUsuario[6] = data.password +"";
                listaContenidoUsuario[7] = data.estado +"";
                RowData linea = new RowData(listaContenidoUsuario,inicioY,anchoPanel);
                areaPanel.add(linea);
                inicioY = inicioY + 50;
            }

        }
        else if(nombreEntidadTabla == "Ventas"){
            if (listaVentas != null) {
                listaVentas.clear();
            }
            listaVentas = daoVentas.GetAllElements();
            for(Ventas data: listaVentas) {
                listaContenidoVentas[0] = data.ventasId +"";
                listaContenidoVentas[1] = data.usuarioId +"";
                listaContenidoVentas[2] = data.clienteId +"";
                listaContenidoVentas[3] = data.documentoId +"";
                listaContenidoVentas[4] = data.fecha +"";
                listaContenidoVentas[5] = data.importe +"";
                listaContenidoVentas[6] = data.igv +"";
                listaContenidoVentas[7] = data.estado +"";
                RowData linea = new RowData(listaContenidoVentas,inicioY,anchoPanel);
                areaPanel.add(linea);
                inicioY = inicioY + 50;
            }
        }
        else if(nombreEntidadTabla == "Zonas"){
            if (listaZonas != null) {
                listaZonas.clear();
            }
            listaZonas = daoZona.GetAllElements();
            for(Zona data: listaZonas) {
                listaContenidoZonas[0] = data.zonaId +"";
                listaContenidoZonas[1] = data.nombre +"";
                listaContenidoZonas[2] = data.estado +"";
                RowData linea = new RowData(listaContenidoZonas,inicioY,anchoPanel);
                areaPanel.add(linea);
                inicioY = inicioY + 50;
            }
        }


/*

        String[] listaData = {"uno", "dos","tres", "cuatro", "cinco"};
        String[][] superlista = {{"uno", "dos","tres", "cuatro", "cinco"}, {"uno", "dos","tres", "cuatro", "cinco"},{"uno", "dos","tres", "cuatro", "cinco"}, {"uno", "dos","tres", "cuatro", "cinco"}, {"uno", "dos","tres", "cuatro", "cinco"}};




        for(int b =0 ; b < superlista.length ; b++){

            RowData linea = new RowData(superlista[b],inicioY,anchoPanel);
            areaPanel.add(linea);
            inicioY = inicioY + 50;
        }


 */

        System.out.println("tabla : " +nombreEntidadTabla);

    }





}
