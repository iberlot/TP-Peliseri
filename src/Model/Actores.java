package Model;

/**
 * @author iberlot
 *
 */
public class Actores implements Comparable<Actores> {

	/**
	 * Nombre del actor
	 */
	private String nombre;

	/**
	 * Apellido del actor
	 */
	private String apellido;

	/**
	 * Sexo del actor
	 */
	private boolean sexo;

	/**
	 * Constructor de objeto vasio
	 */
	public Actores() {
	}

	/**
	 * Constructor al que se le pasan los parametros del objeto
	 * 
	 * @param nombre
	 * @param apellido
	 * @param sexo
	 */
	public Actores(String nombre, String apellido, boolean sexo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Actor\n" + "Nombre = " + nombre + "\nApellido = " + apellido + "\nSexo = " + sexo + '\n';
	}

	/**
	 * @return El valor de nombre, es un dato de tipo String
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre Que se seteara en nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return El valor de apellido, es un dato de tipo String
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido Que se seteara en apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return El valor de sexo, es un dato de tipo boolean
	 */
	public boolean isSexo() {
		return sexo;
	}

	/**
	 * @param sexo Que se seteara en sexo
	 */
	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}

	public String apellidoNombre() {
		return apellido + nombre;
	}

	@Override
	public int compareTo(Actores a) {
		return apellidoNombre().compareTo(a.apellidoNombre());
	}

}
