/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sintactic_Analyzer;

/**
 *
 * @author alexis
 */
public enum Constantes_Sintacticas {
    
    // tipo de constantes sintacticas
     FINALIZAR("FINALIZAR"),
   REPETIR("REPETIR"),
   TERMINALH("NUMERO O ID"),
   CONDICINAL("SI"),
   INICIAR("ESCRIBIR, SI, REPETIR, O ID"),
   ESCRITURA("ESCRIBIR"),
   LEXEMA("LITERAL, ID, O NUMERO"),
   BOOLEAN("VERDADERO O FALSO"),
   PRODUCCIONX("NUMERO, ID, +, * (, ), O FIN"),
   PRODUCCIONXP("NUMERO, ID, +, * (, ), O FIN"),
   PRODUCCIONT("NUMERO, ID, +, * (, ), FIN"),
   PRODUCCIONTP("NUMERO, ID, +, * (, ), FIN"),
   PRODUCCIONF("NUMERO, ID, +, * (, ), O FIN"),
   ASIGNACION("ID"),
   EPCILONE("NUMERO, ID, +, * (, ), O FIN");
   
   private String caracteres;
   
  

    public String getCaracteres() {
        return caracteres;
    }

    public void setCaracteres(String caracteres) {
        this.caracteres = caracteres;
    }
    
    // constructor
    private Constantes_Sintacticas(String caracteres){
       this.caracteres = caracteres;
   }
}
