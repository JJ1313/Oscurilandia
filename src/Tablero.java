import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;

public class Tablero {
    private int cols = 15;
    private int rows = 15;
    private int cantCarros = 0; // Indica la cantidad de carros presentes en el tablero

    private Carro[] carros = new Carro[18];
    private String[] conductores = {"Many", "Alma", "Luna", "Chica", "Lizzy"};
    private String[] colores = {"Verde", "Morado", "Amarillo", "Negro"};
    private ArrayList<Huevo> huevos = new ArrayList<Huevo>();

    private String[][] matrix= new String[this.rows][this.cols];

    public Tablero(){
        for(int i=0; i<this.rows; i++){
            Arrays.fill(this.matrix[i], " ");
        }
    }
    //------ GETTER ------
    public int getCols() {return this.cols;}
    public int getRows() {return this.rows;}
    public int getCantCarros(){return this.cantCarros;}
    public Carro[] getCarros() {return carros;}
    public String[] getConductores(){return this.conductores;}
    public String[] getColores(){return this.colores;}
    public ArrayList<Huevo> getHuevos() {return huevos;}
    public String[][] getMatrix(){return this.matrix;}

    // ------ SETTER ------
    public void setCols(int cols) {this.cols = cols;}
    public void setRows(int rows) {this.rows = rows;}
    public void serCantCarros(int cant){this.cantCarros = cant;}

    // ------ METHODS ------

    // Mostrar tablero
    public void mostrarMatriz(){
        System.out.print("  |");
        for(int i = 0; i<this.cols; i++){
            if(i<10){
                System.out.print("0");
            }
            System.out.print(i + "|");
        }
        System.out.println();
        for (int i=0; i<this.rows; i++) {
            if(i<10){
                System.out.print("0");
            }
            System.out.print(i);
            for(int j=0; j<this.cols; j++){
                System.out.print("[" + this.matrix[i][j] + "]");
            }
            System.out.print("\n");
        }
        System.out.println("Puntaje = " + calcularPuntaje());
    }

    public void crearCarro(String tipo) throws ParseException {
        while(true){
            int row = (int) Math.floor(Math.random() * 15);
            int col = (int) Math.floor(Math.random() * 15);
            // Datos para crear un Carro
            int cantOcupantes = (int) Math.floor(Math.random() * 4) + 1;
            String fechaIngreso = "15/12/1995";

            // Si tipo carro es TRUPALLA
            if(tipo.equals("T")){
                // Cuando la posicion no es valida
                if(!matrix[row][col].equals(" ")){
                    continue; // Siguiente iteracion de while
                }
                // Datos para crear carro Trupalla
                int armadura = (int) Math.floor(Math.random() * 5) + 1;
                int indexName = (int) Math.floor(Math.random() * conductores.length);
                // Crea Trupalla y anota en matriz
                carros[cantCarros] = new Trupalla(cantOcupantes, fechaIngreso, row, col, armadura, conductores[indexName]);
                cantCarros++;
                matrix[row][col] = "T";
                break;
            }

            // Si tipo carro es KROMI
            else if (tipo.equals("K")) {
                // Cuando la posicion no es valida
                if(row+2 > 14 || !matrix[row][col].equals(" ") || !matrix[row+1][col].equals(" ") || !matrix[row+2][col].equals(" ")){
                    continue;
                }
                // Datos para crear carro Kromi
                String fechaFabricacion = "13/06/2015";
                String marca = "Dog";
                // Crea Kromi y anota en matriz
                carros[cantCarros] = new Kromi(cantOcupantes, fechaIngreso, row, col, fechaFabricacion, marca);
                cantCarros++;
                matrix[row][col] = "K";
                matrix[row+1][col] = "K";
                matrix[row+2][col] = "K";
                break;
            }

            // Si tipo carro es CAGUANO
            else if (tipo.equals("C")) {
                // Cuando la posicion no es valida
                if(col+1 > 14 || !matrix[row][col].equals(" ") || !matrix[row][col+1].equals(" ") ){
                    continue;
                }
                // Datos para crear carro Caguano
                int rango = (int) Math.floor(Math.random() * 10);
                int indexColor = (int) Math.floor(Math.random() * colores.length);
                // Crea Caguano y anota en matriz
                carros[cantCarros] = new Caguano(cantOcupantes, fechaIngreso, row, col, rango, colores[indexColor]);
                cantCarros++;
                matrix[row][col] = "C";
                matrix[row][col+1] = "C";
                break;
            }
            // Tipo dado incorrecto
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

    private int calcularPuntaje(){
        int puntaje = 0;
        // Puntaje dado por los huevos lanzados
        for (Huevo h : huevos) {
            puntaje += h.getPuntaje();
        }
        // Puntaje dados por carros destruidos
        for(Carro c: carros){
            if(c.getDestruido()){
                puntaje += c.getPuntajeDado();
            }
        }
        return puntaje;
    }

    public void lanzarHuevo(int row, int col){
        // Si lanza sobre Kromi
        if(matrix[row][col].equals("K")){
            // Busco el carro impactado
            for(Carro c: carros){
                int difRow = row - c.getRow();
                if(c.getCol() == col & 0 <= difRow && difRow < 3){ // Encuentro carro
                    c.golpear();
                    break;
                }
            }
            huevos.add(new Huevo(row, col, 3));
        }
        // Si lanza sobre Caguano
        else if(matrix[row][col].equals("C")){
            // Busco el carro impactado
            for (Carro c: carros){
                int difCol = col - c.getCol();
                if(c.getRow() == row &&  0 <= difCol && difCol < 2){ // Encuentro carro
                    c.golpear();
                    break;
                }
            }
            huevos.add(new Huevo(row, col, 2));
        }
        // Si lanza sobre Trupalla
        else if(matrix[row][col].equals("T")){
            // Busco carro impactado
            for(Carro c : carros){
                if(c.getCol() == col && c.getRow() == row){
                    c.golpear();
                    break;
                }
            }
            huevos.add(new Huevo(row, col, 1));
        }
        // Lanzamiento falla
        else{
            huevos.add(new Huevo(row, col,0));
        }
        matrix[row][col] = "H";
    }
}
