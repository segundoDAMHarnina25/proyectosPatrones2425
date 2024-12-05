package otra;

public class Facade {
	RepoLibro repoLibro;
	RepoSocio repoSocio;

	public void grabar(Libro libro) {
		repoLibro.grabar(libro);
	}

	public void grabar(Socio socio) {
		repoSocio.grabar(socio);
	}

	public void grabar(Prestamo prestamo) {

	}

	public void borrar(IDLibro idLibro) {

	}

	public void borrarSocio(Long idSocio) {

	}
}
