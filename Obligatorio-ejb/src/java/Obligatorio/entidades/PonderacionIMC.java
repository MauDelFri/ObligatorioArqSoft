package Obligatorio.entidades;

public class PonderacionIMC {
    private int ponderacionIMCID;
    private Antecedente antecedente;
    private double imcDesde;
    private double imcHasta;
    private int ponderacion;

    public int getPonderacionIMCID() {
        return ponderacionIMCID;
    }

    public void setPonderacionIMCID(int ponderacionIMCID) {
        this.ponderacionIMCID = ponderacionIMCID;
    }

    public Antecedente getAntecedente() {
        return antecedente;
    }

    public void setAntecedente(Antecedente antecedente) {
        this.antecedente = antecedente;
    }

    public double getIMCDesde() {
        return imcDesde;
    }

    public void setIMCDesde(double IMCDesde) {
        this.imcDesde = IMCDesde;
    }

    public double getIMCHasta() {
        return imcHasta;
    }

    public void setIMCHasta(double IMCHasta) {
        this.imcHasta = IMCHasta;
    }

    public int getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(int ponderacion) {
        this.ponderacion = ponderacion;
    }

    public PonderacionIMC() {
    }
}
