package CODIGO.DATA.DOMINIOS;

public class Proveedor {
    public int proveeId;
    public String codigoProvee, nombreProvee, direccion, celular, ruc, email, estado;

    public  Proveedor(int proveeId, String codigoProvee, String nombreProvee, String direccion, String celular, String ruc, String email, String estado){
        this.proveeId = proveeId;
        this.codigoProvee = codigoProvee;
        this.nombreProvee= nombreProvee;
        this.direccion = direccion;
        this.celular = celular;
        this.ruc = ruc;
        this.email = email;
        this.estado  = estado;
    }

    public Proveedor(){

    }


    public int getProveeId() {
        return proveeId;
    }

    public void setProveeId(int proveeId) {
        this.proveeId = proveeId;
    }

    public String getCodigoProvee() {
        return codigoProvee;
    }

    public void setCodigoProvee(String codigoProvee) {
        this.codigoProvee = codigoProvee;
    }

    public String getNombreProvee() {
        return nombreProvee;
    }

    public void setNombreProvee(String nombreProvee) {
        this.nombreProvee = nombreProvee;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
