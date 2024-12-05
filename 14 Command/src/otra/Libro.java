package otra;

public class Libro {
	IDLibro id;

	private Long getId() {
		return id.getId();
	}

	private void setId(Long id) throws Exception {
		this.id.setId(id);
	}
}
