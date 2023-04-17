import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Carro {
    private int cantOcupantes; // Cantidad de ocupantes en el vehiculo
    private Date fechaIngreso; // Fecha del ingreso del vehiculo
    private int x;             // Indica la columna del Carro
    private int y;             // Indica la fila del Carro

    public Carro(){}
    public Carro(int cantOcupantes, String fechaIngreso,  int x, int y) throws ParseException {
        this.cantOcupantes = cantOcupantes;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        this.fechaIngreso = formato.parse(fechaIngreso);
        this.x = x;
        this.y = y;
    }
    //------ SETTER / GETTER ------
    //------ GETTER
    public int getCantOcupantes(){return cantOcupantes;}
    public Date getFechaIngreso(){ return fechaIngreso;}
    public int getX() {return x;}
    public int getY(){return y;}
    //------ SETTER
    public void setCantOcupantes(int cantOcupantes){this.cantOcupantes = cantOcupantes;}
    public void setFechaIngreso(Date fechaIngreso){this.fechaIngreso = fechaIngreso;}
    public void setX(int x){this.x = x;}
    public void setY(int y){this.y = y;}
    //------ METHODS ------
    public void mostrarDatos(){
        System.out.println("Carro[cantOcupantes = "+ this.cantOcupantes +"][fechaIngreso = "+ this.fechaIngreso + "][pos = (" + this.x + "," + this.y+")]");
    }
}
