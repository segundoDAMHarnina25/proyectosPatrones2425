package ejemploordenador;

public class OrdenadorBase implements Ordenador {
	// Pero aqui no existe la propiedad Ordenaador
	@Override
	public float calculateCost() {
		System.out.println("mio actual base");
		return 0;
	}

}
