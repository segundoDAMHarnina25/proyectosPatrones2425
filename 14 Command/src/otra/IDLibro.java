package otra;

public class IDLibro {
	Long id;

	public IDLibro(Long id) throws Exception {
		super();
		setId(id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) throws Exception {
		if(!(id>0&&id<40000)) throw new Exception();
		this.id = id;
	}
	
	
}
