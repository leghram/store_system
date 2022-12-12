package CODIGO.DATA.DOMINIOS;


public class Documento {
    public int documentoId, codigoDoc;
    public String nombreDoc;

    public Documento(int documentoId, int codigoDoc, String nombreDoc){
        this.documentoId = documentoId;
        this.codigoDoc = codigoDoc;
        this.nombreDoc = nombreDoc;
    }

    public  Documento(){

    }

    public int getDocumentoId() {
        return documentoId;
    }

    public void setDocumentoId(int documentoId) {
        this.documentoId = documentoId;
    }

    public int getCodigoDoc() {
        return codigoDoc;
    }

    public void setCodigoDoc(int codigoDoc) {
        this.codigoDoc = codigoDoc;
    }

    public String getNombreDoc() {
        return nombreDoc;
    }

    public void setNombreDoc(String nombreDoc) {
        this.nombreDoc = nombreDoc;
    }
}
