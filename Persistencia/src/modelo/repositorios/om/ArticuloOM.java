package modelo.repositorios.om;

import java.util.ArrayList;
import java.util.List;
import modelo.dominio.Articulo;
import modelo.repositorios.Populable;

public class ArticuloOM implements Populable<Articulo>{
	public int cantidad=50;

    private static final String[] DESCRIPCIONES_FERRETERIA = {
        "Martillo de acero", "Destornillador plano", "Taladro inalámbrico", "Caja de clavos", 
        "Llave inglesa", "Cinta métrica", "Tornillos de acero", "Broca de taladro", 
        "Alicates multiusos", "Sierra manual", "Juego de llaves Allen", "Cinta aislante", 
        "Nivel de burbuja", "Papel de lija", "Tubería de PVC", "Junta de goma", 
        "Llave de tubo", "Cutter retráctil", "Escuadra metálica", "Mango de rodillo", 
        "Lijadora eléctrica", "Masilla para juntas", "Pistola de silicona", "Cerradura de seguridad", 
        "Candado de acero", "Bisagras de puerta", "Pletinas metálicas", "Perforadora de pared", 
        "Guantes de trabajo", "Gafas de protección", "Mascarilla antipolvo", "Tornillo de banco", 
        "Pala de jardinería", "Cepillo de alambre", "Esponja de acero", "Grapadora industrial", 
        "Mango de destornillador", "Broca de percusión", "Sargento de presión", "Alicate de presión", 
        "Juego de puntas de destornillador", "Tubo de silicona", "Cepillo para metal", 
        "Taladro percutor", "Cinta de embalar", "Grapas industriales", "Rodillo para pintura", 
        "Espátula metálica", "Tijeras de podar", "Tijeras multiusos", "Malla metálica"
    };

    private List<Articulo> createArticulos(int cantidad) {
        List<Articulo> articulos = new ArrayList<>();
        for (int i = 1; i <= cantidad; i++) {
            Long id = (long) i;
            String descripcion = DESCRIPCIONES_FERRETERIA[i % DESCRIPCIONES_FERRETERIA.length];
            float precio = 5.0f + (i % 10) * 1.5f; // Precios variados
            articulos.add(new Articulo(id, descripcion, precio));
        }
        return articulos;
    }

   	@Override
	public List<Articulo> getElementos() {
		return createArticulos(cantidad);
	}
}
