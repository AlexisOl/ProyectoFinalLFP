/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archive;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author alexis
 */
public class cargaArchive {
    
    
    public void Carga(File file, JTextArea textArea, JTextArea textarea2) throws FileNotFoundException, IOException{
    FileReader reader = new FileReader(file);
    BufferedReader bf = new BufferedReader(reader);
    String line;
    
    while ((line = bf.readLine())!=null) {
       textArea.append(line+"\n");
    }
    conteoLineas contador = new conteoLineas();
    contador.contarLineas(textArea, textarea2);
    }

 
    
    
}
