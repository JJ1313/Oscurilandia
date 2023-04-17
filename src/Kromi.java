import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Kromi extends Carro{
    private Date fechaFabricacion;
    private String marca;

    public Kromi(){}
    public Kromi(int cantOcupantes, String fechaIngreso, int x, int y, String fechaFabricacion, String marca) throws ParseException {
        super(cantOcupantes, fechaIngreso, x, y);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        this.fechaFabricacion = formato.parse(fechaFabricacion);
    }
    public void ubicar(){

    }
}