import java.text.ParseException;

public class Caguano extends Carro{
    private int rango;
    private String colorConfeti;

    Caguano(){}
    Caguano(int cantOcupantes, String fechaIngreso, int row, int col, int rango, String color) throws ParseException {
        super(7, cantOcupantes, fechaIngreso, row, col);
        this.rango = rango;
        this.colorConfeti = color;
    }
    // ------ SETTER ------
    public void setRango(int rango) {this.rango = rango;}
    public void setColorConfeti(String colorConfeti) {this.colorConfeti = colorConfeti;}

    // ------ GETTER ------
    public int getRango() {return rango;}
    public String getColorConfeti() {return colorConfeti;}

    // ------ METHODS ------

    @Override
    public String toString() {
        return "Caguano{" +
                "rango=" + rango +
                ", colorConfeti='" + colorConfeti + '\'' +
                '}';
    }

    public void golpear(){
        super.golpear();
        if(super.getCantGolpes() == 2){
            super.setDestruido(true);
        }
    }
}
