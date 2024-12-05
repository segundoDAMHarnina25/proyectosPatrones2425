package facadecommand;

import org.junit.jupiter.api.Test;

import facadecommand.commands.FacadeCommandLibro;
import facadecommand.commands.FacadeCommandSocio;
import facadecommand.modelo.Libro;
import facadecommand.modelo.Socio;

public class Cliente {

	@Test
	void test() {
		Facade facade=new Facade();
		Libro libro=new Libro();
		Socio socio=new Socio();
		Long id = 0L;
		//como evitar esto
		facade.grabar(new FacadeCommandLibro(facade),libro);
		facade.borrar(new FacadeCommandLibro(facade), id);
		facade.grabar(new FacadeCommandSocio(facade), socio);
	}
	
}
