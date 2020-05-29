package Model;

import java.util.Calendar;

public class Clasificaciones {

    private int calificacion;

    private String descripcion;

    private Suscriptores suscriptor;

    private Calendar fecha;

    public Clasificaciones()
    {
    }

    public Clasificaciones(int calificacion, String descripcion, Suscriptores suscriptor, Calendar fecha)
    {
        this.calificacion = calificacion;
        this.descripcion = descripcion;
        this.suscriptor = suscriptor;
        this.fecha = fecha;
    }

    @Override
    public String toString()
    {
        return "Clasificaciones{" + "calificacion=" + calificacion + ", descripcion=" + descripcion + ", suscriptor=" + suscriptor + ", fecha=" + fecha + '}';
    }
    
    
}
