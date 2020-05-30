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

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the sexo
	 */
	public boolean isSexo() {
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}

	
}
