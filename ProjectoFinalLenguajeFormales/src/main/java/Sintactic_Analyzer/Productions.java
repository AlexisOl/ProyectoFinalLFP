/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sintactic_Analyzer;

/**
 *
 * @author alexis
 */
public enum Productions {
     FINALIZAR("FINALIZAR"),
   INICIAR("ESCRIBIR, SI, REPETIR, O ID"),
   ESCRITURA("ESCRIBIR"),
   LEXEMA("LITERAL, ID, O NUMERO"),
   REPETIR("REPETIR"),
   TERMINALH("NUMERO O ID"),
   CONDICINAL("SI"),
   BOOLEAN("VERDADERO O FALSO"),
   PRODUCCIONX("NUMERO, ID, +, * (, ), O FIN"),
   PRODUCCIONXP("NUMERO, ID, +, * (, ), O FIN"),
   PRODUCCIONT("NUMERO, ID, +, * (, ), FIN"),
   PRODUCCIONTP("NUMERO, ID, +, * (, ), FIN"),
   PRODUCCIONF("NUMERO, ID, +, * (, ), O FIN"),
   ASIGNACION("ID"),
   EPCILONE("NUMERO, ID, +, * (, ), O FIN");
   
   private String espera;
   
   private Productions(String Espera){
       this.espera = Espera;
   }

    public String getEspera() {
        return espera;
    }

    public void setEspera(String espera) {
        this.espera = espera;
    }
   
}
