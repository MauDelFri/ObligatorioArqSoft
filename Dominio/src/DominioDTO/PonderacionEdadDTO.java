package DominioDTO;

public class PonderacionEdadDTO {

    private int PonderacionEdadID;
    private AntecedenteDTO antecedemte;
    private int edadDesde;
    private int edadHasta;
    private Double ponderacion;

    public int getPonderacionEdadID() {
        return PonderacionEdadID;
    }

    public void setPonderacionEdadID(int PonderacionEdadID) {
        this.PonderacionEdadID = PonderacionEdadID;
    }

    public AntecedenteDTO getAntecedemte() {
        return antecedemte;
    }

    public void setAntecedemte(AntecedenteDTO antecedemte) {
        this.antecedemte = antecedemte;
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

    public Double getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(Double ponderacion) {
        this.ponderacion = ponderacion;
    }
}
