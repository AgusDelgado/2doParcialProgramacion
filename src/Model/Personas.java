package Model;

public class Personas {

    //Atributos
    private String nombre;
    private String apellido;
    private Integer edad;
    private String dni;
    private String barrio;
    private String ocupacion;

    //Constructores
    public Personas(String nombre, String apellido, Integer edad, String dni, String barrio, String ocupacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
        this.barrio = barrio;
        this.ocupacion = ocupacion;
    }

    public Personas() {
    }

    // Setters y getters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    //Metodos

    public String toString() {
        return "Nombre: " + nombre + " Apellido: " + apellido + " Edad: " + edad +
                " DNI: " + dni + " Barrio: " + barrio + " Ocupacion: " + ocupacion + "\n";
    }
}
