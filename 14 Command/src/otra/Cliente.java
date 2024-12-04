package otra;

import org.junit.jupiter.api.Test;

public class Cliente {

	@Test
	void test() {
		Facade facade=new Facade();
		Libro libro=new Libro();
		facade.grabar(libro);
		Socio socio=new Socio();
		facade.grabar(socio);
		if(socio instanceof Socio) {
			facade.borrarSocio(socio.id);
		}
	}
	
}
