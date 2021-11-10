/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lexical_analyzer;



import Objects.TokenObject;
import Reports.Errors_Object;
import Reports.Reporte_general_objeto;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author alexis
 */
public class LexicalAnalyzer {
    // Reportes de los objetos
    private Errors_Object reporteErrores = new Errors_Object();
    private Reporte_general_objeto reporte = new Reporte_general_objeto();
   
    

// constante del salto de linea
    public static final String SALTO_DE_LINEA = "\n";
// llamo a los atributos que usaremos
    
    private final State_Matrix States = new State_Matrix();
    private ArrayList<String> lexemas = new ArrayList<>();
    private final Alphabet alfabeto = new Alphabet();
    private final JTextArea cadena;
    private String texto;
    
    
    
    // variables de movimiento temporal 
    private int posicion = 0;
    private int estadoEnUso;
    private String palabra = "";
    

    public LexicalAnalyzer(JTextArea cadena) {
        this.reporte.setReporteErrores(reporteErrores);
        this.cadena = cadena;
    }
// ANALISIS LEXICO
    public void analisis() {
        // se limpian caracteres
        this.lexemas.clear();
        texto = cadena.getText();
        this.estadoEnUso = 0;
        //inicip de variable temporal
        
        char temporal;
        // esto hasta que ;la posicion se a mayor que el texto
        while (posicion < texto.length()) {
            temporal = texto.charAt(posicion);
            //sigue el siguiente estado que tendra el caracter, en base al que ya tiene
            // y en base al que obtiene del siguiente
            int estadoTemporal = getSiguienteEstado(estadoEnUso, alfabeto.alfabetoValueOf(estadoEnUso, temporal));
            // se notifica
            reporteErrores.recopilador(temporal, estadoTemporal);
            
            
            //
            this.reporte.recopilarReporte(temporal, estadoTemporal, texto.length());
            if (estadoTemporal == 10) {
                estadoTemporal = 0;
            }
            // se modifica el estado de uso
            this.estadoEnUso = estadoTemporal;
            if (!siguinteToken(estadoEnUso, temporal) || Comienzo(estadoEnUso)) {
                estadoEnUso = 0;
            }
            // aumento de las posiciones
            posicion++;
        }
        this.reporte.pabrasReservadas();
        this.cadena.setText(this.cadena.getText());
    }

 
   
// determina el siguiente estado 
    // en caso este entre el rango optimo de movimiento
    // sino devuelve los otros posbles resultados de error 
    public  int getSiguienteEstado(int estadoActual, int caracter) {
        int resultado = -1;
        if (caracter >= 0 && caracter <= 11) {
            resultado = States.getStateMatrix()[estadoActual][caracter];
        } else if (caracter == -2) {
            resultado = -2;
        } else if (caracter == -3) {
            resultado = -3;
        } else if (caracter == -4) {
            resultado = -4;
        }
        return resultado;
    }
    
    // este metodo para controlar
      public  boolean siguinteToken(int estadoUso, char caracter) {
          
        boolean seguir = true;
        if (Character.isSpaceChar(caracter)) {
            // si es espacio, continua en otro estado
            seguir = estadoUso == 4 || estadoUso == 2;
            // comparo si es salto de linea
        } else if (Character.compare(caracter, this.SALTO_DE_LINEA.charAt(0)) == 0) {
            // se acaba el seguimiento
            seguir = false;
        }
        // si
        if (estadoUso == 10 || estadoUso == -4) {
            seguir = false;
        }
        return seguir;
    }

    
    // metodo para determiar el comiezo de la cadena, esto en caso de un estado que no sea aceptable
    private boolean Comienzo(int estadoActual) {
        boolean inciar = false;
        if (estadoActual == -1 || estadoActual == -2 || estadoActual == -3) {
            inciar = true;
        }

        return inciar;
    }
    
    

    
    //getters
    public Errors_Object getReporteErrores() {
        return reporteErrores;
    }

    public Reporte_general_objeto getReporte() {
        return reporte;
    }
}
