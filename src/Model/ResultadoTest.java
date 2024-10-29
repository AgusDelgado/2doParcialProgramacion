package Model;

import java.util.List;

public class ResultadoTest {

    //Atributos
    private List<Personas> sanos;
    private List<CasoSospechoso> aislar;

    // Getters y setters
    public List<Personas> getSanos() {
        return sanos;
    }

    public void setSanos(List<Personas> sanos) {
        this.sanos = sanos;
    }

    public List<CasoSospechoso> getAislar() {
        return aislar;
    }

    public void setAislar(List<CasoSospechoso> aislar) {
        this.aislar = aislar;
    }
}