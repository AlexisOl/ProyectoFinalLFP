/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;


import Objects.TokenObject;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author alexis
 */
public class Sintactic_Errors {
    // errores del analizador sintactico
    // lista de tipo token 
    private final ArrayList<TokenObject> Tokens = new ArrayList<>();
    
    public void camputrarErrorSintactico(TokenObject token, String descipcion){
        token.setInformacion(descipcion);
        this.Tokens.add(token);
        
    }
    // notifica los errores sintacticos en el textArea
    public void ErroresSIntacticoMensaje(JTextArea area){
        area.setText("");
        for (TokenObject Token : Tokens) {
            area.append("ERROR SINTACTICO LEXEMA: "+ Token.getLexema());
            area.append("  POSICION Fila , Columna "+ Token.getFila()+", "+ Token.getColumna()+"\n");
            area.append("DESCRIPCION "+ Token.getInformacion()+"\n\n");
        }
    }

    public boolean hayError() {
        return !this.Tokens.isEmpty();
    }

}
