package DominioDTO;

public class AntecedenteDTO {

    private Long antecedenteID;
    private String nombre;
    private short factorRiesgoAlto;
    private short factorRiesgoMedio;
    private short factorRiesgoBajo;

    public Long getAntecedenteID() {
        return antecedenteID;
    }

    public void setAntecedenteID(Long antecedenteID) {
        this.antecedenteID = antecedenteID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public short getFactorRiesgoAlto() {
        return factorRiesgoAlto;
    }

    public void setFactorRiesgoAlto(short factorRiesgoAlto) {
        this.factorRiesgoAlto = factorRiesgoAlto;
    }

    public short getFactorRiesgoMedio() {
        return factorRiesgoMedio;
    }

    public void setFactorRiesgoMedio(short factorRiesgoMedio) {
        this.factorRiesgoMedio = factorRiesgoMedio;
    }

    public short getFactorRiesgoBajo() {
        return factorRiesgoBajo;
    }

    public void setFactorRiesgoBajo(short factorRiesgoBajo) {
        this.factorRiesgoBajo = factorRiesgoBajo;
    }

}
