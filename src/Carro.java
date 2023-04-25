import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Carro {
    private int cantOcupantes;   // Cantidad de ocupantes en el vehiculo
    private Date fechaIngreso;   // Fecha del ingreso del vehiculo
    private int row;             // Indica la fila del Carro
    private int col;             // Indica la columna del Carro
    private boolean destruido = false; // Indica si el carro fue golpeado en todas sus casillas
    private int cantGolpes = 0;  // Cantidad de veces que fue golpeado el carro
    private int puntajeDado;     // Puntaje dado al destruir el carro

    public Carro(){}
    public Carro(int puntajeDado, int cantOcupantes, String fechaIngreso,  int row, int col) throws ParseException {
        this.cantOcupantes = cantOcupantes;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        this.fechaIngreso = formato.parse(fechaIngreso);
        this.row = row;
        this.col = col;
        this.puntajeDado = puntajeDado;
    }

    //------ GETTER ------
    public int getCantOcupantes(){return cantOcupantes;}
    public Date getFechaIngreso(){ return fechaIngreso;}
    public int getRow() {return this.row;}
    public int getCol(){return this.col;}
    public int getCantGolpes(){return this.cantGolpes;}
    public boolean getDestruido(){return this.destruido;}
    public int getPuntajeDado(){return this.puntajeDado;}
    //------ SETTER ------
    public void setCantOcupantes(int cantOcupantes){this.cantOcupantes = cantOcupantes;}
    public void setFechaIngreso(Date fechaIngreso){this.fechaIngreso = fechaIngreso;}
    public void setRow(int row){this.row = row;}
    public void setCol(int col){this.col = col;}
    public void setCantGolpes(int cantGolpes){this.cantGolpes = cantGolpes;}
    public void setDestruido(boolean destruido){this.destruido = destruido;}
    public void setPuntajeDado(int puntaje){this.puntajeDado = puntaje;}

    //------ METHODS ------

    public String toString() {
        return "Carro{" +
                "cantOcupantes=" + cantOcupantes +
                ", fechaIngreso=" + fechaIngreso +
                ", row=" + row +
                ", col=" + col +
                ", destruido=" + destruido +
                ", cantGolpes=" + cantGolpes +
                ", puntajeDado=" + puntajeDado +
                '}';
    }

    public void mostrarDatos(){
        System.out.println("Carro" + "[Destruido = "+ this.destruido + "][pos = (" + this.col + "," + this.row+")]");
    }
    public void golpear(){
        this.cantGolpes++;
    }
}
