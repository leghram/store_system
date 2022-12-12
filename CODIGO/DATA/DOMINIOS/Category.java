package CODIGO.DATA.DOMINIOS;

public class Category {

    public int categoriaId, proveedorId;
    public String codCat,  nombreCat, estado;

    public  Category(){

    }

    public  Category(int categoriaId, int proveedorId, String codCat, String nombreCat, String estado){
        this.categoriaId = categoriaId;
        this.proveedorId = proveedorId;
        this.codCat = codCat;
        this.nombreCat = nombreCat;
        this.estado = estado;
    }


    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public int getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(int proveedorId) {
        this.proveedorId = proveedorId;
    }

    public String getCodCat() {
        return codCat;
    }

    public void setCodCat(String codCat) {
        this.codCat = codCat;
    }

    public String getNombreCat() {
        return nombreCat;
    }

    public void setNombreCat(String nombreCat) {
        this.nombreCat = nombreCat;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }






}
