import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Kromi extends Carro{
    private Date fechaFabricacion;
    private String marca;

    public Kromi(){}
    public Kromi(int cantOcupantes, String fechaIngreso, int row, int col, String fechaFabricacion, String marca) throws ParseException {
        super(10, cantOcupantes, fechaIngreso, row, col);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        this.fechaFabricacion = formato.parse(fechaFabricacion);
    }
    // ------ SETTER ------
    public void setMarca(String marca) {this.marca = marca;}
    public void setFechaFabricacion(String fechaFabricacion) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        this.fechaFabricacion = formato.parse(fechaFabricacion);
    }
    // ------ GETTER ------
    public Date getFechaFabricacion() {return fechaFabricacion;}
    public String getMarca() {return marca;}
    // ------ METHODS ------
    @Override
    public String toString() {
        return "Kromi{" +
                "fechaFabricacion=" + fechaFabricacion +
                ", marca='" + marca + '\'' +
                '}';
    }
    public void golpear(){
        super.golpear();
        if(super.getCantGolpes() == 3){
            super.setDestruido(true);
        }
    }
}