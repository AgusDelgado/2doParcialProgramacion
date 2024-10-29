package Model;

public class Registro {

    //Atributos
    private String dni;
    private Integer temperatura;

    // Setters y getters
    public Registro(String dni, int i) {
        this.dni = dni;
        this.temperatura = i;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Integer temperatura) {
        this.temperatura = temperatura;
    }
}
