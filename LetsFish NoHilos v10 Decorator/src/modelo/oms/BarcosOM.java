package modelo.oms;

import java.util.ArrayList;
import java.util.List;

import modelo.data.Barco;
import modelo.data.Coordenada;
import modelo.enums.TipoBarco;

public class BarcosOM {

    /**
     * Genera una lista de barcos con datos predefinidos.
     *
     * @param cantidadBarcos Número de barcos a generar.
     * @return Lista de barcos generados según los datos predefinidos.
     */
    public static List<Barco> getAll(int cantidadBarcos) {
        List<Barco> barcos = new ArrayList<>();

        // Datos predefinidos para las pruebas
        String[] nombres = { "Barco 1", "Barco 2", "Barco 3" };
        Coordenada[] posiciones = {
            new Coordenada(0, 0),
            new Coordenada(10, 10),
            new Coordenada(20, 20)
        };
        int[] capacidades = { 100, 200, 300 };
        int[] velocidades = { 5, 10, 15 };
        TipoBarco[] tipos = { TipoBarco.PALANGRE, TipoBarco.CERCO, TipoBarco.PALANGRE };

        for (int i = 0; i < cantidadBarcos; i++) {
            int index = i % nombres.length; // Rotar entre los datos predefinidos
            Barco barco = new Barco(
                nombres[index],
                posiciones[index],
                null, // Puerto base no especificado
                capacidades[index],
                velocidades[index],
                null, // Servicio satélite no especificado
                tipos[index],
                null // Mar no especificado
            );
            barcos.add(barco);
        }

        return barcos;
    }
}
