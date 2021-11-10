/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archive;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTextArea;

/**
 *
 * @author alexis
 */
public class escritorArchive {
    
    
    public void saveArchive(JTextArea textarea, File file) throws IOException {
       File files = file;
       
       if (files.createNewFile()) {
       } else {
           files.delete();
           files.createNewFile();
       }
       String data = textarea.getText();
       FileWriter writer = new FileWriter(files, false);
       writer.write(data);
       writer.close();
        
        
    }
}
