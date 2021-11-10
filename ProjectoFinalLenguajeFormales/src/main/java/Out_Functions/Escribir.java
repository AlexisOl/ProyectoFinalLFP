/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Out_Functions;

import Helper.recolecccion;
import Objects.TokenObject;
import Sintactic_Analyzer.Productions;


/**
 *
 * @author alexis
 */
public class Escribir {
        private boolean recolectando = false;
    
    public void recolectarEscribir(TokenObject token, Productions produccion, recolecccion tabla, Integer repiticiones){
        if (produccion.equals(Productions.ESCRITURA) && token.getToken().equalsIgnoreCase("ESCRIBIR")) {
            recolectando = true;
        }
      
    }

    public boolean isRecolectando() {
        return recolectando;
    }

    public void setRecolectando(boolean recolectando) {
        this.recolectando = recolectando;
    }
    
    
}
