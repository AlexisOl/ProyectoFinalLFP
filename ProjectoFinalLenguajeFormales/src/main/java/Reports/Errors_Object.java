/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reports;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alexis
 */
public class Errors_Object {
    // ingreso de las listas
    private ArrayList<String> cadena = new ArrayList<>();
    private ArrayList<Character> Lexema = new ArrayList<>();
    private ArrayList<Integer> filas = new ArrayList<>();
    private ArrayList<Integer> columnas = new ArrayList<>();
    private JTable table;
        // filas y columnas temporales para el uso
    private int Fila_Temporal = 1;
    private int Columna_Temporal = 0;

    private String cadenaActual = "";
    // una bandera para determinar la existencia de errores
    private boolean existeErrores = false;

// asiganacion de valores a la tabla 
    public void IngresoTablaErrores(JTable tabla) {
        this.table = tabla;
        int indexTable = 0;
        DefaultTableModel modelo = new DefaultTableModel();
        this.table.setModel(modelo);
        modelo.addColumn("Lexema");
        modelo.addColumn("Lugar donde se encuentra la cadena");
        modelo.addColumn("Fila");
        modelo.addColumn("Columna");
        for (String cadena : cadena) {
            modelo.addRow(new Object[]{this.Lexema.get(indexTable), 
                                                                 cadena,    
                                                                 this.filas.get(indexTable),  
                                                                 this.columnas.get(indexTable)});
            indexTable++;
        }
    }

 // obtencion de valores de errores
    public void recopilador(char Caracter, int estado) {
        if (estado == -3) {
            this.Fila_Temporal++;
            this.Columna_Temporal = 0;
            this.cadenaActual = "";
        } else {
            if (estado == -1) {
                this.existeErrores = true;
                this.Columna_Temporal++;
                this.cadenaActual += Caracter;
                this.Lexema.add(Caracter);
                this.cadena.add(cadenaActual);
                this.filas.add(this.Fila_Temporal);
                this.columnas.add(this.Columna_Temporal);
                this.cadenaActual = "";
            } else {
                this.Columna_Temporal++;
                if (estado == -2) {
                    this.cadenaActual = "";
                } else {
                    this.cadenaActual += Caracter;
                }

            }
        }

    }
// getter para ver si hay errores
    public boolean isExisteErrores() {
        return existeErrores;
    }

}
