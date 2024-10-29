package Model;

public class CasoSospechoso {

    //Atributos
    private String kit;
    private int temperatura;
    private String barrio;

    // Constructor, getters y setters
    public CasoSospechoso(String kit, int temperatura, String barrio) {
        this.kit = kit;
        this.temperatura = temperatura;
        this.barrio = barrio;
    }

    public String getKit() {
        return kit;
    }

    public void setKit(String kit) {
        this.kit = kit;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }
}