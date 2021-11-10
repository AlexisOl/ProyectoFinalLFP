/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author alexis
 * 
 * Objeto de token el cual recibira la informacion que necesitamos
 */
public class TokenObject {
      private String Token;
    private String lexema;
    private int fila;
    private int columna;
    
    
    // descripcion de lo que sucede
    private String Informacion;
// constructor
    public TokenObject(String Token, String lexema, int fila, int columna) {
        this.Token = Token;
        this.lexema = lexema;
        this.fila = fila;
        this.columna = columna;
    }

    
    // getters y setters
    public String getToken() {
        return Token;
    }

    public void setToken(String Token) {
        this.Token = Token;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getInformacion() {
        return Informacion;
    }

    public void setInformacion(String Informacion) {
        this.Informacion = Informacion;
    }
    
    
}
