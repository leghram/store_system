package CODIGO.DATA.DOMINIOS;

public class TipoCliente {
    public int tipoClienteId;
    public String nombre;

    public  TipoCliente(int tipoClienteId, String nombre){
        this.tipoClienteId = tipoClienteId;
        this.nombre = nombre;
    }

    public  TipoCliente(){

    }

    public int getTipoClienteId() {
        return tipoClienteId;
    }

    public void setTipoClienteId(int tipoClienteId) {
        this.tipoClienteId = tipoClienteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
