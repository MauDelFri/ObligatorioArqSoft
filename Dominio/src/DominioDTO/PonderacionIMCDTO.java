/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DominioDTO;

/**
 *
 * @author martinintroini
 */
public class PonderacionIMCDTO {
    private int PonderacionIMCID;
    private AntecedenteDTO antecedemte;
    private int edadDesde;
    private int edadHasta;
    private Double ponderacion;

    public int getPonderacionIMCID() {
        return PonderacionIMCID;
    }

    public void setPonderacionIMCID(int PonderacionIMCID) {
        this.PonderacionIMCID = PonderacionIMCID;
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
