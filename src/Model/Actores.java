package Model;

public class Actores {

	private String nombre;

	private String apellido;

	private boolean sexo;

	public Actores() {
	}

	public Actores(String nombre, String apellido, boolean sexo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Actores{" + "nombre=" + nombre + ", apellido=" + apellido + ", sexo=" + sexo + '}';
	}

}
