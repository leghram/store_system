package CODIGO.DATA.DOMINIOS;

public class Cliente {

    public int clienteId, tipoClienteId, zonaid;
    public String ruc, nombre, direccion, email, celular, estado;

    public  Cliente(int clienteId, int tipoClienteId, int zonaId, String ruc, String nombre, String direccion, String email, String celular, String estado){
        this.clienteId = clienteId;
        this.tipoClienteId = tipoClienteId;
        this.zonaid = zonaId;
        this.ruc = ruc;
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.celular = celular;
        this.estado = estado;
    }

    public Cliente(){

    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getTipoClienteId() {
        return tipoClienteId;
    }

    public void setTipoClienteId(int tipoClienteId) {
        this.tipoClienteId = tipoClienteId;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
