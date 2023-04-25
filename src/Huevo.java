public class Huevo{
    int row;
    int col;
    int puntaje; // Puntaje obtenido al ser lanzado

    Huevo(){}
    Huevo(int row, int col, int puntaje){
        this.row = row;
        this.col = col;
        this.puntaje = puntaje;
    }
    // ------ SETTER ------
    public void setRow(int row) {this.row = row;}
    public void setCol(int col) {this.col = col;}
    public void setPuntaje(int puntaje) {this.puntaje = puntaje;}

    // ------ GETTER ------
    public int getRow() {return this.row;}
    public int getCol() {return this.col;}
    public int getPuntaje() {return puntaje;}

    // ------ METHODS ------

    @Override
    public String toString() {
        return "Huevo{" +
                "row=" + row +
                ", col=" + col +
                ", puntaje=" + puntaje +
                '}';
    }
}
