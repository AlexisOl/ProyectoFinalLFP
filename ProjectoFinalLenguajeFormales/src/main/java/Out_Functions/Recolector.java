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
public class Recolector {
      private final recolecccion tabla = new recolecccion();
    private final SalidaSintactico recolector = new SalidaSintactico();
    
   
// obtiebe las variables de salida
    public void recolectorFucionesSalida(Constantes_Sintacticas produccion, TokenObject token) {
        tabla.recolectarAsignacion(produccion, token);
        this.recolector.recolectar(token.getToken(), token, tabla);
        
    }
// getter y setter
    public recolecccion getTabla() {
        return tabla;
    }

    public SalidaSintactico getRecolector() {
        return recolector;
    }
    
    
    

}
