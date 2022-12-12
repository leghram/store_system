package CODIGO.DATA.DOMINIOS;

public class Ventas {

    public int ventasId, usuarioId, clienteId, documentoId;
    public double importe, igv;
    public String fecha, estado;

    public  Ventas(int ventasId, int usuarioId, int clienteId, int documentoId, String fecha, double importe, double igv, String estado){
        this.ventasId = ventasId;
        this.usuarioId = usuarioId;
        this.clienteId =clienteId;
        this.documentoId = documentoId;
        this.importe = importe;
        this.igv = igv;
        this.fecha = fecha;
        this.estado = estado;
    }

    public  Ventas(){

    }

    public int getVentasId() {
        return ventasId;
    }

    public void setVentasId(int ventasId) {
        this.ventasId = ventasId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getDocumentoId() {
        return documentoId;
    }

    public void setDocumentoId(int documentoId) {
        this.documentoId = documentoId;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
