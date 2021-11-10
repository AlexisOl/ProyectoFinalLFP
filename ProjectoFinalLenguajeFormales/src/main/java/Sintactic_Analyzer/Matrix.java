/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sintactic_Analyzer;

/**
 *
 * @author alexis
 */
public class Matrix {
    
    private String matriz[][] = new String[13][16];

    public Matrix() {
        this.inicilizarProducciones();
    }
    
// matriz del automata de pila 
    private void inicilizarProducciones() {
        this.matriz[0][0] = "ES";
        this.matriz[0][4] = "AS";
        this.matriz[0][5] = "RS";
        this.matriz[0][7] = "CS";
        this.matriz[0][15] = "Ɛ";
        this.matriz[1][0] = "ESCRIBIR L FIN E";
        this.matriz[1][1] = "Ɛ";
        this.matriz[1][4] = "Ɛ";
        this.matriz[1][5] = "Ɛ";
        this.matriz[1][7] = "Ɛ";
        this.matriz[1][15] = "Ɛ";
        this.matriz[2][2] = "Literal";
        this.matriz[2][3] = "Numero";
        this.matriz[2][4] = "id";
        this.matriz[3][0] = "Ɛ";
        this.matriz[3][4] = "Ɛ";
        this.matriz[3][5] = "REPETIR H INICIAR E FIN R";
        this.matriz[3][7] = "Ɛ";
        this.matriz[3][15] = "Ɛ";
        this.matriz[3][15] = "Ɛ";
        this.matriz[4][3] = "Numero";
        this.matriz[4][4] = "id";
        this.matriz[5][0] = "Ɛ";
        this.matriz[5][4] = "Ɛ";
        this.matriz[5][5] = "Ɛ";
        this.matriz[5][7] = "Si B ENTONCES E FIN C";
        this.matriz[5][15] = "Ɛ";
        this.matriz[6][9] = "VERDADERO";
        this.matriz[6][10] = "FALSO";
        this.matriz[7][3] = "TX’";
        this.matriz[7][4] = "TX’";
        this.matriz[7][13] = "TX’";
        this.matriz[8][1] = "Ɛ";
        this.matriz[8][11] = "+TX’";
        this.matriz[8][14] = "Ɛ";
        this.matriz[8][15] = "Ɛ";
        this.matriz[9][3] = "FT’";
        this.matriz[9][4] = "FT’";
        this.matriz[9][13] = "FT’";
        this.matriz[10][1] = "Ɛ";
        this.matriz[10][11] = "Ɛ";
        this.matriz[10][12] = "*FT’";
        this.matriz[10][14] = "Ɛ";
        this.matriz[10][15] = "Ɛ";
        this.matriz[11][3] = "Numero";
        this.matriz[11][4] = "id";
        this.matriz[11][13] = "(X)";
        this.matriz[12][0] = "Ɛ";
        this.matriz[12][4] = "id = X FIN A";
        this.matriz[12][5] = "Ɛ";
        this.matriz[12][6] = "Ɛ";
        this.matriz[12][15] = "Ɛ";

    }

    public String[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(String[][] matriz) {
        this.matriz = matriz;
    }
    
    
}
