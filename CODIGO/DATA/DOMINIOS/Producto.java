package CODIGO.DATA.DOMINIOS;

public class Producto{

    public int productoId, categoriaId, stock;
    public double costoUni, precioUni;
    public String unidadMedida, description,estado;

    public  Producto(){
        System.out.println("No hay productos");
    }

    public  Producto(int productoId, int  categoriaId, int   stock, double costoUni, double precioUni, String unidadMedida, String description, String estado){
        this.productoId = productoId;
        this.categoriaId = categoriaId;
        this.stock = stock;
        this.costoUni = costoUni;
        this.precioUni = precioUni;
        this.unidadMedida = unidadMedida;
        this.description = description;
        this.estado = estado;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getCostoUni() {
        return costoUni;
    }

    public void setCostoUni(double costoUni) {
        this.costoUni = costoUni;
    }

    public double getPrecioUni() {
        return precioUni;
    }

    public void setPrecioUni(double precioUni) {
        this.precioUni = precioUni;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
