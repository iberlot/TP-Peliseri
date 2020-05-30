package Vista;

import java.io.IOException;
import java.util.Calendar;

import funciones.Fechas;

public class VPublicaciones implements iVistas {

	@Override
	public boolean crear() throws IOException {
		return funciones.Funciones.pedirBooleano("Desea dar de alta una nueva publicacion? ", "S", "N");
	}

	@Override
	public boolean eliminar() throws IOException {
		return funciones.Funciones.pedirBooleano("Desea eliminar la publicacion? ", "S", "N");
	}

	@Override
	public boolean modificar() throws IOException {
		return funciones.Funciones.pedirBooleano("Desea modificar la publicacion? ", "S", "N");
	}

	@Override
	public void mostrarElemento(String dato) {

		System.out.printf("Los datos de la publicacion son:\n%s\n", dato);
	}

	public void mostrarElemento(int codigo, String nombre, String empresa, Calendar fPubli, String genero,
			String sinopsis) {

		System.out.printf("Los datos de la publicacion son:\n");
		mostrarCodigo(codigo);
		mostrarNombre(nombre);
		mostrarEmpresa(empresa);
		mostrarFechaPubli(fPubli);
		mostrarGenero(genero);
		mostrarSinopsis(sinopsis);

	}

	private void mostrarSinopsis(String sinopsis) {
		System.out.printf("la sinopsis es: %s\n", sinopsis);

	}

	public String pedirSinopsis() {
		return funciones.Funciones.pedirString("Ingrese la sinopsis: ");
	}

	// XXX esto creo que no va aca
	private void mostrarGenero(String genero) {
		System.out.printf("El generos es es: %s\n", genero);

	}

	// XXX esto creo que no va aca
	public String pedirGenero() {
		return funciones.Funciones.pedirString("Ingrese el genero: ");
	}

	private void mostrarEmpresa(String empresa) {
		System.out.printf("la empresa es: %s\n", empresa);

	}

	public String pedirEmpresa() {
		return funciones.Funciones.pedirString("Ingrese la empresa: ");
	}

	private void mostrarFechaPubli(Calendar fPubli) {
		System.out.printf("La fecha de publicaion es: %s\n", Fechas.fechaAString(fPubli, '/'));

	}

	public Calendar pedirFechaPubli() {
		return funciones.Funciones.pedirFecha("Ingrese la fecha de publicacion:");
	}

	private void mostrarNombre(String nombre) {
		System.out.printf("El nombre de la publicacion es: %s\n", nombre);

	}

	public String pedirNombre() {
		return funciones.Funciones.pedirString("Ingrese el nombre de la publicacion: ");
	}

	private void mostrarCodigo(int codigo) {
		System.out.printf("la codiga es: %s\n", codigo);

	}

	public int pedirCodigo() {
		return funciones.Funciones.pedirEnteroPositivo("Inferese el codigo de lapublicacion.: ");
	}

}
