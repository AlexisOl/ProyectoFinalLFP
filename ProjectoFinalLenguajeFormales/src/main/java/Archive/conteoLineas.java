/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archive;

import javax.swing.JTextArea;

/**
 *
 * @author alexis
 */
public class conteoLineas {
    
    public void contarLineas(JTextArea textarea, JTextArea textActual){     
    textActual.setText("");
    textarea.setCaretPosition(0);
      int cantidad_columnas = textarea.getLineCount();
        for (int i = 0; i <cantidad_columnas; i++) {
                textActual.append(Integer.toString(i+1) + " \n");
        }
        textActual.setCaretPosition(0);
        textActual.setAutoscrolls(false);
    }
    
}
