package facadecommand.commands;

import facadecommand.Facade;
import facadecommand.interfaces.FacadeCommand;
import facadecommand.modelo.Socio;
import facadecommand.repos.RepoSocio;

public class FacadeCommandSocio implements FacadeCommand<Socio,Long>{

	RepoSocio repoSocio;
	
	
	public FacadeCommandSocio(Facade facade) {
		super();
		repoSocio=facade.getRepoSocio();
	}

	@Override
	public void grabar(Socio t) {
		repoSocio.grabar(t);
		
	}

	@Override
	public void borrar(Long s) {
		repoSocio.borrar(s);
		
	}

}
