import java.util.ArrayList;
import java.util.Arrays;

public class Tablero {
    private int cols = 15;
    private int rows = 15;
    private Carro[] carros = new Carro[18];
    private ArrayList<Huevo> huevos = new ArrayList<Huevo>();
    private String[][] matrix= new String[this.rows][this.cols];

    public Tablero(){
        for(int i=0; i<this.rows; i++){
            Arrays.fill(this.matrix[i], " ");
        }
    }
    //------ GETTER ------
    public int getCols() {return cols;}
    public int getRows() {return rows;}
    public Carro[] getCarros() {return carros;}
    public ArrayList<Huevo> getHuevos() {return huevos;}
    public String[][] getMatrix(){return this.matrix;}
    //------ SETTER ------
    public void setCols(int cols) {this.cols = cols;}
    public void setRows(int rows) {this.rows = rows;}
    public void setCarros(Carro[] carros) {this.carros = carros;}
    public void setHuevos(ArrayList<Huevo> huevos) {this.huevos = huevos;}

    //------ MOSTRAR TABLERO ------
    public void display(){
        for (String[] row: this.matrix) {
            for(String e: row){
                System.out.print("[" + e + "]");
            }
            System.out.print("\n");
        }
    }

}
