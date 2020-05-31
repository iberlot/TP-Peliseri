package Vista;

import java.io.IOException;
import java.util.Calendar;

public class VCalendario implements iVistas {

	@Override
	public boolean crear() throws IOException {
		return funciones.Funciones.pedirBooleano("Desea dar de alta un nueva calendario? ", "S", "N");
	}

	@Override
	public boolean eliminar() throws IOException {
		return funciones.Funciones.pedirBooleano("Desea eliminar el calendario? ", "S", "N");
	}

	@Override
	public boolean modificar() throws IOException {
		return funciones.Funciones.pedirBooleano("Desea modificar el calendario? ", "S", "N");
	}

	@Override
	public void mostrarElemento(String dato) {

		System.out.printf("Los datos del calendario son:\n%s\n", dato);
	}

	public void mostrarElemento(int semPago, int id, Calendar fPago, float monto, String publi) {

		System.out.printf("Los datos del calendario son:\n");
		mostrarSemPago(semPago);
		mostrarID(id);
		mostrarFPago(fPago);
		mostrarMonto(monto);
		mostrarPubli(publi);
	}


	public String pedirPubli() {
		return funciones.Funciones.pedirString("Ingrese la publicacion:");
	}
	private void mostrarPubli(String dato) {
		System.out.printf("LA publicacion es: %s\n", dato);
		
	}

	public float pedirMonto() {
		return funciones.Funciones.pedirFloat("Indrese el monto:");
	}
	private void mostrarMonto(float dato) {
		System.out.printf("El monte ess de es: %f\n", dato);
		
	}

	public Calendar pedirFPago() {
		return funciones.Funciones.pedirFecha("Ingrese la fecha :");
	}
	
	private void mostrarFPago(Calendar dato) {
		System.out.printf("la feca es: %s\n", dato);
		
	}

	public int pedirID() {
		return funciones.Funciones.pedirEnteroPositivo("Ingrese el id:");
	}
	private void mostrarID(int dato) {
		System.out.printf("El id es: %s\n", dato);
		
	}

	public int pedirSemPago() {
		return funciones.Funciones.pedirEnteroPositivo("Ingrese la semana de pago:");
	}
	private void mostrarSemPago(int dato) {
		System.out.printf("La semana de pago es: %s\n", dato);
		
	}

}
