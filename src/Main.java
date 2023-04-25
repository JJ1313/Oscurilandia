public class Main {
    public static void main(String[] args) {
        int cantKromis = 3;
        int cantCaguano = 5;
        int cantTrupalla = 10;
        Tablero tablero = new Tablero();
        for(int i = 0; i<cantKromis; i++){
            tablero.crearCarro("K");
        }
        for(int i=0; i<cantCaguano; i++){
            tablero.crearCarro("C");
        }
        for(int i=0; i<cantTrupalla; i++){
            tablero.crearCarro("T");
        }
        tablero.mostrarCarros();
        tablero.mostrarMatriz();
    }
}