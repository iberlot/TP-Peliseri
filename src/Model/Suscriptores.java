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
	 * @return the documento
	 */
	public long getDocumento() {
		return documento;
	}

	/**
	 * @param documento the documento to set
	 */
	public void setDocumento(long documento) {
		this.documento = documento;
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

	/**
	 * @return the fechaNac
	 */
	public Calendar getFechaNac() {
		return fechaNac;
	}

	/**
	 * @param fechaNac the fechaNac to set
	 */
	public void setFechaNac(Calendar fechaNac) {
		this.fechaNac = fechaNac;
	}

}
