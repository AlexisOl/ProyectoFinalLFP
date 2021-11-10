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
        this.pila.push(Productions.FINALIZAR.name());
        this.pila.push(Productions.INICIAR);
    }

    // se determian los push o pops 
    public void Apilar(String caracteres, String tokens) {
        if (caracteres != null) {
            
            if (!caracteres.equals("Ɛ")) {
                this.pila.pop();
                switch (caracteres) {
                    case "ES":
                        pila.push(Productions.INICIAR);
                        pila.push(Productions.ESCRITURA);
                        break;
                    case "AS":
                        pila.push(Productions.INICIAR);
                        pila.push(Productions.ASIGNACION);
                        break;
                    case "RS":
                        pila.push(Productions.INICIAR);
                        pila.push(Productions.REPETIR);
                        break;
                    case "CS":
                        pila.push(Productions.INICIAR);
                        pila.push(Productions.CONDICINAL);
                        break;
                    case "$":
                        pila.push(Productions.EPCILONE);
                        break;
                    case "ESCRIBIR L FIN E":
                        pila.push(Productions.ESCRITURA);
                        pila.push("FIN");
                        pila.push(Productions.LEXEMA);
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
                        pila.push(Productions.REPETIR);
                        pila.push("FIN");
                        pila.push(Productions.ESCRITURA);
                        pila.push("INICIAR");
                        pila.push(Productions.TERMINALH);
                        pila.push("REPETIR");
                        break;
                    case "Si B ENTONCES E FIN C":
                        pila.push(Productions.CONDICINAL);
                        pila.push("FIN");
                        pila.push(Productions.ESCRITURA);
                        pila.push("ENTONCES");
                        pila.push(Productions.BOOLEAN);
                        pila.push("SI");
                        break;
                    case "VERDADERO":
                        pila.push("VERDADERO");
                        break;
                    case "FALSO":
                        pila.push("FALSO");
                        break;
                    case "TX’":
                        pila.push(Productions.PRODUCCIONXP);
                        pila.push(Productions.PRODUCCIONT);
                        break;
                    case "+TX’":
                        pila.push(Productions.PRODUCCIONXP);
                        pila.push(Productions.PRODUCCIONT);
                        pila.push("+");
                        break;
                    case "FT’":
                        pila.push(Productions.PRODUCCIONTP);
                        pila.push(Productions.PRODUCCIONF);
                        break;
                    case "*FT’":
                        pila.push(Productions.PRODUCCIONTP);
                        pila.push(Productions.PRODUCCIONF);
                        pila.push("*");
                        break;
                    case "(X)":
                        pila.push(")");
                        pila.push(Productions.PRODUCCIONX);
                        pila.push("(");
                        break;
                    case "id = X FIN A":
                        pila.push(Productions.ASIGNACION);
                        pila.push("FIN");
                        pila.push(Productions.PRODUCCIONX);
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
                    if (this.pila.contains(Productions.PRODUCCIONXP)) {
                        while (!Productions.PRODUCCIONXP.equals(this.pila.peek())) {
                            this.pila.pop();
                        }
                    } else {
                      // ESTO en iniciar
                        while (!Productions.INICIAR.equals(this.pila.peek())) {
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
        Productions[] pro = Productions.values();
        for (Productions producciones : pro) {
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
