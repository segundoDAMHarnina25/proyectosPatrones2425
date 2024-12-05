package facadecommand;

import facadecommand.interfaces.FacadeCommand;
import facadecommand.repos.RepoLibro;
import facadecommand.repos.RepoPrestamo;
import facadecommand.repos.RepoSocio;

public class Facade {

	RepoLibro repoLibro;
	RepoSocio repoSocio;
	RepoPrestamo repoPrestamo;

	
	public Facade() {
		super();
		repoLibro = new RepoLibro();
	}

	public void grabar(FacadeCommand repo,Object object) {
		repo.grabar(object);
	}
	
	public void borrar(FacadeCommand repo,Object object) {
		repo.borrar(object);
	}

	public RepoLibro getRepoLibro() {
		return repoLibro;
	}

	public RepoSocio getRepoSocio() {
		return repoSocio;
	}

	public RepoPrestamo getRepoPrestamo() {
		return repoPrestamo;
	}

}
