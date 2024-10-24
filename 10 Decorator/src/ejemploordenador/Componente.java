package ejemploordenador;

public abstract class Componente implements Ordenador {

	//El componente hereda de ordenador para que cada componente puede ser casteado
	@Override
	public abstract float calculateCost();

}
