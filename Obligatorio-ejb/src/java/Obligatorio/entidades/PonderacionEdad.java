package Obligatorio.entidades;

public class PonderacionEdad {
    private int ponderacionEdadID;
    private Antecedente antecedente;
    private int edadDesde;
    private int edadHasta;
    private int ponderacion;

    public PonderacionEdad() {
    }

    public int getPonderacionEdadID() {
        return ponderacionEdadID;
    }

    public void setPonderacionEdadID(int ponderacionEdadID) {
        this.ponderacionEdadID = ponderacionEdadID;
    }

    public Antecedente getAntecedente() {
        return antecedente;
    }

    public void setAntecedente(Antecedente antecedente) {
        this.antecedente = antecedente;
    }

    public int getEdadDesde() {
        return edadDesde;
    }

    public void setEdadDesde(int edadDesde) {
        this.edadDesde = edadDesde;
    }

    public int getEdadHasta() {
        return edadHasta;
    }

    public void setEdadHasta(int edadHasta) {
        this.edadHasta = edadHasta;
    }

    public int getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(int ponderacion) {
        this.ponderacion = ponderacion;
    }
    
    
}
