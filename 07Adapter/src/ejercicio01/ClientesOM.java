package ejercicio01;

import java.util.List;

public class ClientesOM {
	
	public List<Cliente> getAll(){
		List<Cuenta> of = List.of(new Cuenta("1"),new Cuenta("2"),new Cuenta("3"));
		return List.of(new Cliente("Arturo",(byte) 18,of.get(0)),
				new Cliente("Vicente",(byte) 21,of.get(1)),
				new Cliente("Claudio",(byte) 22,of.get(2)));
		
	}

}
