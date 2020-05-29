package Model;

import java.util.Calendar;

public class Suscriptores {

    private String nombre;

    private String apellido;

    private long documento;

    private boolean sexo;

    private Calendar fechaNac;


    public Suscriptores()
    {
    }

    public Suscriptores(String nombre, String apellido, long documento, boolean sexo, Calendar fechaNac)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.sexo = sexo;
        this.fechaNac = fechaNac;
    }

    @Override
    public String toString()
    {
        return "Suscriptores{" + "nombre=" + nombre + ", apellido=" + apellido + ", documento=" + documento + ", sexo=" + sexo + ", fechaNac=" + fechaNac + '}';
    }
    
    
    
}
