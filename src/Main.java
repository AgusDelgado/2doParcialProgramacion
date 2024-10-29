import Model.Personas;
import Model.SistemaDeSalud;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Sistema de Salud Municipal(SSM)");

        SistemaDeSalud sistemaDeSalud = new SistemaDeSalud();
        List<Personas> personas = listaDePersonas();

        personas.forEach(sistemaDeSalud::registrarPersona);
        personas.forEach(sistemaDeSalud::testear);

        sistemaDeSalud.mostrarPersonas();
        sistemaDeSalud.mostrarTabla();

        sistemaDeSalud.exportarJSON();
    }

    public static List<Personas> listaDePersonas(){

        Personas persona1 = new Personas("Juan", "Perez", 30, "12345678", "La perla", "Programador");
        Personas persona2 = new Personas("Maria", "Gomez", 25, "87654321", "Puerto", "Diseñadora");
        //Carlos tendra dni repetido
        Personas persona3 = new Personas("Carlos", "Gonzalez", 40, "12345678", "Centro", "Medico");
        Personas persona4 = new Personas("Lucia", "Garcia", 35, "3958643", "Peralta Ramos Oeste", "Fonoadiologa");
        Personas persona5 = new Personas("Lucas", "Adrede", 21, "42567890", "La Perla", "Enfermera");
        Personas persona6 = new Personas("Mario", "Bros", 45, "18655491", "Peralta Ramos Oeste", "Plomero");

        return List.of(persona1, persona2, persona3, persona4, persona5, persona6);
    }
}
