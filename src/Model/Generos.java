package Model;

public class Generos {

	private int id;

	private String descripcion;

	private static int CantidadTitulos;

	public Generos() {
	}

	public Generos(int id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Generos{" + "id=" + id + ", descripcion=" + descripcion + '}';
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the cantidadTitulos
	 */
	public static int getCantidadTitulos() {
		return CantidadTitulos;
	}

	/**
	 * @param cantidadTitulos the cantidadTitulos to set
	 */
	public static void setCantidadTitulos(int cantidadTitulos) {
		CantidadTitulos = cantidadTitulos;
	}

}
