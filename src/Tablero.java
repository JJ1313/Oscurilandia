import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class Tablero {
    private int cols = 15;
    private int rows = 15;
    private int cantCarros = 0;
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
    public void mostrarMatriz(){
        for (String[] row: this.matrix) {
            for(String e: row){
                System.out.print("[" + e + "]");
            }
            System.out.print("\n");
        }
    }
    public void crearCarro(String tipo){
        while(true){
            int row = (int) Math.floor(Math.random() * 15);
            int col = (int) Math.floor(Math.random() * 15);
            if(tipo.equals("T")){
                if(matrix[row][col].equals(" ")){
                    carros[cantCarros] = new Trupalla();
                    cantCarros++;
                    matrix[row][col] = "T";
                    break;
                }
            } else if (tipo.equals("K")) {
                if(row+2 > 14){
                    continue;
                }
                if(matrix[row][col].equals(" ") && matrix[row+1][col].equals(" ") && matrix[row+2][col].equals(" ")){
                    carros[cantCarros] = new Kromi();
                    cantCarros++;
                    matrix[row][col] = "K";
                    matrix[row+1][col] = "K";
                    matrix[row+2][col] = "K";
                    break;
                }
            } else if (tipo.equals("C")) {
                if(col+1 > 14){
                    continue;
                }
                if(matrix[row][col].equals(" ") && matrix[row][col+1].equals(" ")){
                    carros[cantCarros] = new Caguano();
                    cantCarros++;
                    matrix[row][col] = "C";
                    matrix[row][col+1] = "C";
                    break;
                }
            }
            else{
                System.out.println("Tipo vehiculo no valido!!!");
                break;
            }

        }
    }
    public void mostrarCarros(){
        for (Carro carro: carros) {
            carro.mostrarDatos();
        }
    }
    public void lanzarHuevo(){

    }

}
