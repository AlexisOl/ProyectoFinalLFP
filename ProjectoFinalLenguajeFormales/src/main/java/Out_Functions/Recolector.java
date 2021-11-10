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
public class Recolector {
      private final recolecccion tabla = new recolecccion();
    private final SalidaSintactico recolector = new SalidaSintactico();
    
   

    public void recolectorFucionesSalida(Productions produccion, TokenObject token) {
        tabla.recolectarAsignacion(produccion, token);
        this.recolector.recolectar(token.getToken(), token, tabla);
        
    }

    public recolecccion getTabla() {
        return tabla;
    }

    public SalidaSintactico getRecolector() {
        return recolector;
    }
    
    
    

}
