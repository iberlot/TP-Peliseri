package Vista;

import java.io.IOException;
import java.util.Calendar;

import funciones.Fechas;

public class VCalificaciones implements iVistas {

	@Override
	public boolean crear() throws IOException {
		return funciones.Funciones.pedirBooleano("Desea dar de alta una nueva calificacion? ", "S", "N");
	}

	@Override
	public boolean eliminar() throws IOException {
		return funciones.Funciones.pedirBooleano("Desea eliminar la calificacion? ", "S", "N");
	}

	@Override
	public boolean modificar() throws IOException {
		return funciones.Funciones.pedirBooleano("Desea modificar la calificacion? ", "S", "N");
	}

	@Override
	public void mostrarElemento(String dato) {

		System.out.printf("Los datos de la calificacion son:\n%s\n", dato);
	}

	public void mostrarElemento(Calendar fecha, float duracion, String suscript, String descrip) {

		System.out.printf("Los datos de la calificacion son:\n");
		mostrarFecha(fecha);
		mostrarCalificacion(duracion);
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
		return funciones.Funciones.pedirEnteroPositivo("Ingrese la calificacion:",0,6);
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
		System.out.printf("La fecha es  es: %s\n", Fechas.fechaAString(dato,'/'));
		
	}

}
