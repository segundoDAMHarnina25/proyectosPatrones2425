package ejercicio01;

public class Persona {
	private int id;
	private String nombre;
	private String appellidos;
	//optionals
	private String phone;
	private String color="rojo";
	
	public Persona(int id, String nombre, String appellidos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.appellidos = appellidos;
	}
	
	
	public Persona(int id, String nombre, String appellidos, String phone) {
		this(id, nombre, appellidos);
		this.phone = phone;
	}


	public Persona(int id, String nombre, String appellidos, String phone, String color) {
		this(id,nombre,appellidos,phone);
		this.color = color;
	}


	private int getId() {
		return id;
	}
	private void setId(int id) {
		this.id = id;
	}
	private String getNombre() {
		return nombre;
	}
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	private String getAppellidos() {
		return appellidos;
	}
	private void setAppellidos(String appellidos) {
		this.appellidos = appellidos;
	}
	private String getPhone() {
		return phone;
	}
	void setPhone(String phone) {
		this.phone = phone;
	}
	private String getColor() {
		return color;
	}
	private void setColor(String color) {
		this.color = color;
	}
	
}
