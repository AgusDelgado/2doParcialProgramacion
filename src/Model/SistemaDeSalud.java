package Model;

import Excepciones.DniEnUsoException;
import Excepciones.NoHayKitsException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class  SistemaDeSalud {

    //Atributos
    private Integer kitsDisponibles = 3;
    private List<Personas> personasRegistradas = new ArrayList<>();
    private Map<String, Registro> tabla = new java.util.HashMap<>();
    private int contadorDeKits = 1;

    //Metodos
    /**
     * Registra una persona en el sistema si hay kits disponibles.
     * Si el DNI ya está registrado, lanza una excepción.
     * Si no hay kits disponibles, incrementa el número de kits y reintenta el registro.
     *
     * @param persona La persona a registrar.
     */
    public void registrarPersona(Personas persona) {
        try {
            if (kitsDisponibles > 0) {
                System.out.println("Hay kits disponibles ");
                if (existeDocumento(persona.getDni())) {
                    throw new DniEnUsoException("La persona ya fue registrada");
                }
                personasRegistradas.addLast(persona);
                kitsDisponibles--;
            } else {
                throw new NoHayKitsException("No hay kits disponibles");
            }
        } catch (NoHayKitsException e) {
            System.out.println(e.getMessage());
            incrementarKits(5);
            registrarPersona(persona);
        } catch (DniEnUsoException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Verifica si un DNI ya está registrado en el sistema.
     *
     * @param dni El DNI a verificar.
     * @return true si el DNI ya está registrado, false en caso contrario.
     */
    private boolean existeDocumento(String dni) {
        for (Personas persona : personasRegistradas) {
            if (persona.getDni().equals(dni)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Incrementa el número de kits disponibles.
     *
     * @param nuevos El número de nuevos kits a añadir.
     */
    public void incrementarKits(Integer nuevos) {
        kitsDisponibles += nuevos;
    }

    /**
     * Muestra todas las personas registradas en el sistema.
     */
    public void mostrarPersonas() {
        for (Personas persona : personasRegistradas) {
            System.out.println(persona.toString());
        }
    }

    /**
     * Realiza un test a una persona y guarda el resultado en la tabla.
     *
     * @param persona La persona a testear.
     */
    public void testear(Personas persona) {
        String kitId = "Kit-" + contadorDeKits++; //
        tabla.put(kitId, new Registro(persona.getDni(), (int) (Math.random() * 4) + 36));
    }

    /**
     * Muestra todos los registros de tests realizados.
     */
    public void mostrarTabla() {
        for (Map.Entry<String, Registro> entry : tabla.entrySet()) {
            System.out.println("Kit: " + entry.getKey() + " DNI: " + entry.getValue().getDni() + " Temperatura: " + entry.getValue().getTemperatura());
        }
    }

    /**
     * Busca una persona registrada por su DNI.
     *
     * @param dni El DNI de la persona a buscar.
     * @return La persona encontrada, o null si no se encuentra.
     */
    private Personas buscarPersonaPorDni(String dni) {
        for (Personas persona : personasRegistradas) {
            if (persona.getDni().equals(dni)) {
                return persona;
            }
        }
        return null;
    }

    /**
     * Exporta los resultados de los tests a un archivo JSON.
     * Las personas con temperatura menor a 38 se consideran sanas.
     * Las personas con temperatura mayor o igual a 38 se consideran casos sospechosos y se deben aislar.
     */
    public void exportarJSON() {
        List<Personas> sanos = new ArrayList<>();
        List<CasoSospechoso> aislar = new ArrayList<>();

        for (String key : tabla.keySet()) {
            Registro registro = tabla.get(key);
            if (registro.getTemperatura() < 38) {
                sanos.add(buscarPersonaPorDni(registro.getDni()));
            } else {
                aislar.add(new CasoSospechoso(key, registro.getTemperatura(), buscarPersonaPorDni(registro.getDni()).getBarrio()));
            }
        }

        ResultadoTest resultadoTest = new ResultadoTest();
        resultadoTest.setSanos(sanos);
        resultadoTest.setAislar(aislar);

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("resultadoTest.json"), resultadoTest);
            System.out.println("Exportación exitosa");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}


