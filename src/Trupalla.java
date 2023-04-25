import java.text.ParseException;

public class Trupalla extends Carro{
    private int nivelArmadura;
    private String nombreControlador;

    Trupalla(){}
    Trupalla(int cantOcupantes, String fechaIngreso,  int row, int col, int armadura, String nombreControlador) throws ParseException {
        super(0, cantOcupantes, fechaIngreso, row, col);
        this.nivelArmadura = armadura;
        this.nombreControlador = nombreControlador;
    }

    // ------ SETTER ------
    public void setNivelArmadura(int nivelArmadura) {this.nivelArmadura = nivelArmadura;}
    public void setNombreControlador(String nombreControlador) {this.nombreControlador = nombreControlador;}

    // ------ GETTER ------
    public int getNivelArmadura() {return nivelArmadura;}
    public String getNombreControlador() {return nombreControlador;}

    // ------ METHODS ------

    @Override
    public String toString() {
        return "Trupalla{" +
                "nivelArmadura=" + nivelArmadura +
                ", nombreControlador='" + nombreControlador + '\'' +
                '}';
    }

    public void golper(){
        super.golpear();
        super.setDestruido(true);
    }
}
