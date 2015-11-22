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
public class AntecedenteDTO {
    private int antecedenteID;
    private String nombre;
    private int factorRiesgoAlto;
    private int factorRiesgoMedio;
    private int factorRiesgoBajo;

    public int getAntecedenteID() {
        return antecedenteID;
    }

    public void setAntecedenteID(int antecedenteID) {
        this.antecedenteID = antecedenteID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFactorRiesgoAlto() {
        return factorRiesgoAlto;
    }

    public void setFactorRiesgoAlto(int factorRiesgoAlto) {
        this.factorRiesgoAlto = factorRiesgoAlto;
    }

    public int getFactorRiesgoMedio() {
        return factorRiesgoMedio;
    }

    public void setFactorRiesgoMedio(int factorRiesgoMedio) {
        this.factorRiesgoMedio = factorRiesgoMedio;
    }

    public int getFactorRiesgoBajo() {
        return factorRiesgoBajo;
    }

    public void setFactorRiesgoBajo(int factorRiesgoBajo) {
        this.factorRiesgoBajo = factorRiesgoBajo;
    }
    
}
