import java.text.ParseException;
import java.util.Scanner;
// Heinz G. Beckers Sandoval
public class Main {
    public static void main(String[] args) throws ParseException {
        // Cantidad de Carros
        int cantKromis = 3;    // Kromis
        int cantCaguano = 5;   // Caguanos
        int cantTrupalla = 10; // Trupallas

        Scanner in = new Scanner(System.in);
        String opcion;

        Tablero tablero = new Tablero(); // Inicia tablero del juego

        // ------ Agregan los vehiculos a la partida ------
        for(int i = 0; i<cantKromis; i++){
            tablero.crearCarro("K");
        }
        for(int i=0; i<cantCaguano; i++){
            tablero.crearCarro("C");
        }
        for(int i=0; i<cantTrupalla; i++){
            tablero.crearCarro("T");
        }
        tablero.mostrarMatriz();

        // ------ MAIN LOOP ------
        while(true){
            System.out.println("1: Lanzar huevo");
            System.out.println("2: Mostrar Carros");
            System.out.println("3: Mostrar Matriz");
            System.out.println("0: Terminar");

            opcion = in.nextLine();
            // --- Salir de loop principal ---
            if(opcion.equals("0")){
                break;
            }
            // --- Lanzar huevo ---
            else if(opcion.equals("1")){
                int col;
                int row;
                do{
                    System.out.println("Ingresa la posicion X: ");
                    col = Integer.parseInt(in.nextLine());
                    if(col >= tablero.getCols()  ||  col < 0){
                        System.out.println("Posicion 'x' NO valida");
                    }
                } while(col >= tablero.getCols()  ||  col < 0);
                do {
                    System.out.println("Ingresa la posicion Y: ");
                    row = Integer.parseInt(in.nextLine());
                    if(row >= tablero.getRows() || row < 0){
                        System.out.println("Posicion 'y' NO valida");
                    }
                } while(row >= tablero.getRows() || row < 0);
                tablero.lanzarHuevo(row, col);
                tablero.mostrarMatriz();
            }
            // --- Mostrar carros ---
            else if (opcion.equals("2")) {
                tablero.mostrarCarros();
            // --- Mostrar Matriz ---
            }else if (opcion.equals("3")){
                tablero.mostrarMatriz();
            }
            // --- Opcion no permitida ---
            else{
                System.out.println("Opcion no valida");
            }
        }
    }
}