package Vista;

import java.io.IOException;
import java.util.Calendar;

import funciones.Fechas;

public class VCalificaciones implements iVistas {

	@Override
	public boolean crear() throws IOException {
		return funciones.Funciones.pedirBooleano("Desea dar de alta una nueva calificacion? S/N ", "S", "N");
	}

	@Override
	public boolean eliminar() throws IOException {
		return funciones.Funciones.pedirBooleano("Desea eliminar la calificacion? S/N ", "S", "N");
	}

	@Override
	public boolean modificar() throws IOException {
		return funciones.Funciones.pedirBooleano("Desea modificar la calificacion? S/N ", "S", "N");
	}

	@Override
	public void mostrarElemento(String dato) {

		System.out.printf("Los datos de la calificacion son:\n%s\n", dato);
	}

	public void mostrarElemento(Calendar fecha, float calificacion, String suscript, String descrip) {

		System.out.printf("Los datos de la calificacion son:\n");
		mostrarFecha(fecha);
		mostrarCalificacion(calificacion);
		mostrarSuscriptor(suscript);
		mostrarDescripcion(descrip);

	}

	public String pedirDescripcion() {
		return funciones.Funciones.pedirString("Ingrese la Descripcion:");
	}

	public void mostrarDescripcion(String dato) {
		System.out.printf("La Descripcion es: %s\n", dato);

	}

	public int pedirCalificacion() {
		try {
			int c = funciones.Funciones.pedirEnteroPositivo("Ingrese la calificacion:");
			if (c > 5 || c < 0) {
				throw new Exception();
			}
			return c;
		} catch (Exception e) {
			System.out.println("Recuerde que la calificacion debe ser un entero entre 0 y 5");
			pedirCalificacion();
		}
		return 0;
	}

	public void mostrarCalificacion(float dato) {
		System.out.printf("La Calificaciones: %s\n", dato);

	}

	public String pedirSuscriptor() {
		return funciones.Funciones.pedirString("Ingrese el Suscriptor:");
	}

	public void mostrarSuscriptor(String dato) {
		System.out.printf("El Suscriptor es: %s\n", dato);

	}

	public Calendar pedirFecha() {
		return funciones.Funciones.pedirFecha("Ingrese el Fecha:");
	}

	public void mostrarFecha(Calendar dato) {
		System.out.printf("La fecha es  es: %s\n", Fechas.fechaAString(dato, '/'));

	}

}
