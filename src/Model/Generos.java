package Model;

public class Generos {

    private int id;

    private String descripcion;

    private static int CantidadTitulos;

    public Generos()
    {
    }

    public Generos(int id, String descripcion)
    {
        this.id = id;
        this.descripcion = descripcion;
    }

    @Override
    public String toString()
    {
        return "Generos{" + "id=" + id + ", descripcion=" + descripcion + '}';
    }
    
    
}
