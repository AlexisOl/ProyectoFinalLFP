/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sintactic_Analyzer;

import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author alexis
 */
public class Stack_Automata {
    // definicion de la pila
      private Stack pila = new Stack();
// se agreaga inicip y fin
    public Stack_Automata() {
        this.pila.push(Constantes_Sintacticas.FINALIZAR.name());
        this.pila.push(Constantes_Sintacticas.INICIAR);
    }

    // se determian los push o pops 
    public void Apilar(String caracteres, String tokens) {
        if (caracteres != null) {
            
            if (!caracteres.equals("Ɛ")) {
                this.pila.pop();
                switch (caracteres) {
                    case "ES":
                        pila.push(Constantes_Sintacticas.INICIAR);
                        pila.push(Constantes_Sintacticas.ESCRITURA);
                        break;
                    case "AS":
                        pila.push(Constantes_Sintacticas.INICIAR);
                        pila.push(Constantes_Sintacticas.ASIGNACION);
                        break;
                    case "RS":
                        pila.push(Constantes_Sintacticas.INICIAR);
                        pila.push(Constantes_Sintacticas.REPETIR);
                        break;
                    case "CS":
                        pila.push(Constantes_Sintacticas.INICIAR);
                        pila.push(Constantes_Sintacticas.CONDICINAL);
                        break;
                    case "$":
                        pila.push(Constantes_Sintacticas.EPCILONE);
                        break;
                    case "ESCRIBIR L FIN E":
                        pila.push(Constantes_Sintacticas.ESCRITURA);
                        pila.push("FIN");
                        pila.push(Constantes_Sintacticas.LEXEMA);
                        pila.push("ESCRIBIR");
                        break;
                    case "Literal":
                        pila.push("Literal");
                        break;
                    case "Numero":
                        pila.push("Numero");
                        break;
                    case "id":
                        pila.push("id");
                        break;
                    case "REPETIR H INICIAR E FIN R":
                        pila.push(Constantes_Sintacticas.REPETIR);
                        pila.push("FIN");
                        pila.push(Constantes_Sintacticas.ESCRITURA);
                        pila.push("INICIAR");
                        pila.push(Constantes_Sintacticas.TERMINALH);
                        pila.push("REPETIR");
                        break;
                    case "Si B ENTONCES E FIN C":
                        pila.push(Constantes_Sintacticas.CONDICINAL);
                        pila.push("FIN");
                        pila.push(Constantes_Sintacticas.ESCRITURA);
                        pila.push("ENTONCES");
                        pila.push(Constantes_Sintacticas.BOOLEAN);
                        pila.push("SI");
                        break;
                    case "VERDADERO":
                        pila.push("VERDADERO");
                        break;
                    case "FALSO":
                        pila.push("FALSO");
                        break;
                    case "TX’":
                        pila.push(Constantes_Sintacticas.PRODUCCIONXP);
                        pila.push(Constantes_Sintacticas.PRODUCCIONT);
                        break;
                    case "+TX’":
                        pila.push(Constantes_Sintacticas.PRODUCCIONXP);
                        pila.push(Constantes_Sintacticas.PRODUCCIONT);
                        pila.push("+");
                        break;
                    case "FT’":
                        pila.push(Constantes_Sintacticas.PRODUCCIONTP);
                        pila.push(Constantes_Sintacticas.PRODUCCIONF);
                        break;
                    case "*FT’":
                        pila.push(Constantes_Sintacticas.PRODUCCIONTP);
                        pila.push(Constantes_Sintacticas.PRODUCCIONF);
                        pila.push("*");
                        break;
                    case "(X)":
                        pila.push(")");
                        pila.push(Constantes_Sintacticas.PRODUCCIONX);
                        pila.push("(");
                        break;
                    case "id = X FIN A":
                        pila.push(Constantes_Sintacticas.ASIGNACION);
                        pila.push("FIN");
                        pila.push(Constantes_Sintacticas.PRODUCCIONX);
                        pila.push("=");
                        pila.push("id");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "UN ERROR EN LA MATRIX, este error nu lo pude manejar XD");
                        System.exit(0);
                        break;
                }

            } else {
                if (terminalExistenteEnPila(tokens)) {
                    while (comprobar(this.pila.peek())) {
                        this.pila.pop();
                    }
                } else {
                    if (this.pila.contains(Constantes_Sintacticas.PRODUCCIONXP)) {
                        while (!Constantes_Sintacticas.PRODUCCIONXP.equals(this.pila.peek())) {
                            this.pila.pop();
                        }
                    } else {
                      // ESTO en iniciar
                        while (!Constantes_Sintacticas.INICIAR.equals(this.pila.peek())) {
                            this.pila.pop();
                        }
                    }

                }

            }
        } else {
            //es un error 
        }

    }//--------------------------------------------------------------------------
// getter y setter
    public Stack getPila() {
        return pila;
    }

    public void setPila(Stack pila) {
        this.pila = pila;
    }
//--------------------------------------------------------------------------
    public boolean comprobar(Object ob) {
        boolean esEnum = false;
        Constantes_Sintacticas[] pro = Constantes_Sintacticas.values();
        for (Constantes_Sintacticas producciones : pro) {
            esEnum = producciones.equals(ob);
            if (esEnum) {
                break;
            }
        }

        return esEnum;
    }

    private boolean terminalExistenteEnPila(String tokenEvaluando) {
        return this.pila.contains(tokenEvaluando);
    }

}
