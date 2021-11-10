/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Out_Functions;

import Helper.recolecccion;
import Objects.TokenObject;
import Sintactic_Analyzer.Constantes_Sintacticas;


/**
 *
 * @author alexis
 */
public class Escribir {
        private boolean recolectando = false;
    
        
        // recolecta datos en caso sea de escritura y tenga escribir
    public void recolectarEscribir(TokenObject token, Constantes_Sintacticas produccion, recolecccion tabla, Integer repiticiones){
        if (produccion.equals(Constantes_Sintacticas.ESCRITURA) && token.getToken().equalsIgnoreCase("ESCRIBIR")) {
            recolectando = true;
        }
      
    }

    
    
    // getters y setters
    public boolean isRecolectando() {
        return recolectando;
    }

    public void setRecolectando(boolean recolectando) {
        this.recolectando = recolectando;
    }
    
    
}
