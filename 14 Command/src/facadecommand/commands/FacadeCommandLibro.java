package facadecommand.commands;

import facadecommand.Facade;
import facadecommand.interfaces.FacadeCommand;
import facadecommand.modelo.Libro;
import facadecommand.repos.RepoLibro;

public class FacadeCommandLibro implements FacadeCommand<Libro,Long>{

	RepoLibro repoLibro;
	
	public FacadeCommandLibro(Facade facade){
		super();
		this.repoLibro = facade.getRepoLibro();
	}
	
	@Override
	public void grabar(Libro libro) {
		repoLibro.grabar(libro);
	}
	
	@Override
	public void borrar(Long id) {
		repoLibro.borrar(id);
	}
}
