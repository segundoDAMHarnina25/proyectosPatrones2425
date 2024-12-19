package modelo.oms;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import modelo.data.Cardumen;
import modelo.data.Coordenada;
import modelo.enums.EspeciePez;

public class CardumenOM {

    /**
     * Genera una lista de cardúmenes con datos predefinidos.
     *
     * @param dimension Dimensión del área donde se ubicarán los cardúmenes.
     * @param cantidadCardumenes Número de cardúmenes a generar.
     * @return Lista de cardúmenes generados según los datos predefinidos.
     */
    public static List<Cardumen> getAll(Dimension dimension, int cantidadCardumenes) {
        List<Cardumen> cardumenes = new ArrayList<>();

        // Datos predefinidos para las pruebas
        EspeciePez[] especies = { EspeciePez.ATUN, EspeciePez.SARDINA, EspeciePez.MERLUZA };
        int[] pesos = { 500, 100, 200 };
        double[] velocidadesRegeneracion = { 5.0, 2.0, 3.5 };
        Coordenada[] posiciones = {
            new Coordenada(10, 10),
            new Coordenada(20, 20),
            new Coordenada(30, 30)
        };

        // Generar los cardúmenes usando los datos predefinidos
        for (int i = 0; i < cantidadCardumenes; i++) {
            int index = i % especies.length; // Rotar entre los datos predefinidos
            Cardumen cardumen=new Cardumen.Builder(especies[index],pesos[index],dimension)
            			.posicion( posiciones[index])
            			.velocidadRegeneracion(velocidadesRegeneracion[index])
            			.build();
            cardumenes.add(cardumen);
        }

        return cardumenes;
    }
}

