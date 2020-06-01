package Model;

import java.util.Calendar;

public class Suscriptores {

	private String nombre;

	private String apellido;

	private long documento;

	private boolean sexo;

	private Calendar fechaNac;

	public Suscriptores() {
	}

	public Suscriptores(String nombre, String apellido, long documento, boolean sexo, Calendar fechaNac) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.sexo = sexo;
		this.fechaNac = fechaNac;
	}

	@Override
	public String toString() {
		return "Suscriptores{" + "nombre=" + nombre + ", apellido=" + apellido + ", documento=" + documento + ", sexo="
				+ sexo + ", fechaNac=" + fechaNac + '}';
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
	 * @return El valor de documento, es un dato de tipo long
	 */
	public long getDocumento() {
		return documento;
	}

	/**
	 * @param documento Que se seteara en documento
	 */
	public void setDocumento(long documento) {
		this.documento = documento;
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

	/**
	 * @return El valor de fechaNac, es un dato de tipo Calendar
	 */
	public Calendar getFechaNac() {
		return fechaNac;
	}

	/**
	 * @param fechaNac Que se seteara en fechaNac
	 */
	public void setFechaNac(Calendar fechaNac) {
		this.fechaNac = fechaNac;
	}


}
