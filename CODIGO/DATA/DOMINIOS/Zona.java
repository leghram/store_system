package CODIGO.DATA.DOMINIOS;

public class Zona {
    public int zonaId;
    public String nombre, estado;

    public  Zona(int zonaId, String nombre, String estado){
        this.zonaId =zonaId;
        this.nombre = nombre;
        this.estado = estado;
    }

    public  Zona(){

    }
    public int getZonaId() {
        return zonaId;
    }

    public void setZonaId(int zonaId) {
        this.zonaId = zonaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
