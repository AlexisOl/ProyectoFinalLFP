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
                    // determina los posibles valores segun lo que venga
                    case "ESCRIBIR":
                        // si es escribir ingresa iniciar y escritura
                        pila.push(Constantes_Sintacticas.INICIAR);
                        pila.push(Constantes_Sintacticas.ESCRITURA);
                        break;
                        
                         case "RS":
                        // en caso repetir 
                        pila.push(Constantes_Sintacticas.INICIAR);
                        pila.push(Constantes_Sintacticas.REPETIR);
                        break;
                    case "CS":
                        // si es booleano
                        pila.push(Constantes_Sintacticas.INICIAR);
                        pila.push(Constantes_Sintacticas.CONDICINAL);
                        break;
                    case "AS":
                        // si es asignacion
                        // ingresa iniciar y su posible asignacion
                        pila.push(Constantes_Sintacticas.INICIAR);
                        pila.push(Constantes_Sintacticas.ASIGNACION);
                        break;
               case "ESCRIBIR L FIN E":
                        // si viene escribir con un lexema 
                        pila.push(Constantes_Sintacticas.ESCRITURA);
                        pila.push("FIN");
                        pila.push(Constantes_Sintacticas.LEXEMA);
                        pila.push("ESCRIBIR");
                        break;
                    case "$":
                        // si se termina
                        pila.push(Constantes_Sintacticas.EPCILONE);
                        break;
                   
                    case "Literal":
                        // en caso de literal
                        pila.push("Literal");
                        break;
                    case "Numero":
                        //casp de numero
                        pila.push("Numero");
                        break;
                    case "id":
                        //caso de identifiacdor
                        pila.push("id");
                        break;
                        
                        // si viene repetir con alguna escritura
                    case "REPETIR H INICIAR E FIN R":
                        pila.push(Constantes_Sintacticas.REPETIR);
                        pila.push("FIN");
                        pila.push(Constantes_Sintacticas.ESCRITURA);
                        pila.push("INICIAR");
                        pila.push(Constantes_Sintacticas.TERMINALH);
                        pila.push("REPETIR");
                        break;
                        
                        // si viene alguna condicional boolena 
                    case "Si B ENTONCES E FIN C":
                        pila.push(Constantes_Sintacticas.CONDICINAL);
                        pila.push("FIN");
                        pila.push(Constantes_Sintacticas.ESCRITURA);
                        pila.push("ENTONCES");
                        pila.push(Constantes_Sintacticas.BOOLEAN);
                        pila.push("SI");
                        break;
                        
                        // tipos de condicionales verdadero o falso
                    case "VERDADERO":
                        pila.push("VERDADERO");
                        break;
                    case "FALSO":
                        pila.push("FALSO");
                        break;
                        
                        
                        // partes de la gramatica 
                    case "TX’":
                        pila.push(Constantes_Sintacticas.PRODUCCIONXP);
                        pila.push(Constantes_Sintacticas.PRODUCCIONT);
                        break;
                    case "+TX’":
                        // alguna suma 
                        pila.push(Constantes_Sintacticas.PRODUCCIONXP);
                        pila.push(Constantes_Sintacticas.PRODUCCIONT);
                        pila.push("+");
                        break;
                    case "FT’":
                        // alguna 
                        pila.push(Constantes_Sintacticas.PRODUCCIONTP);
                        pila.push(Constantes_Sintacticas.PRODUCCIONF);
                        break;
                    case "*FT’":
                        // alguna mutliplicacion
                        pila.push(Constantes_Sintacticas.PRODUCCIONTP);
                        pila.push(Constantes_Sintacticas.PRODUCCIONF);
                        pila.push("*");
                        break;
                        // un valor
                    case "(X)":
                        pila.push(")");
                        pila.push(Constantes_Sintacticas.PRODUCCIONX);
                        pila.push("(");
                        break;
                        // una asifnacion
                    case "id = X FIN A":
                        pila.push(Constantes_Sintacticas.ASIGNACION);
                        pila.push("FIN");
                        pila.push(Constantes_Sintacticas.PRODUCCIONX);
                        pila.push("=");
                        pila.push("id");
                        break;
                    default:
                        // sino error 
                        JOptionPane.showMessageDialog(null, "error");
                        System.exit(0);
                        break;
                }

            } else {
                // en el caso se epsilon
                // comrpueba valores y desapila 
           
                if (busquedaEnLaPila(tokens)) {
                    while (comprobar(this.pila.peek())) {
                        this.pila.pop();
                    }
                } else {
                    // si tuviera algo de la gramatica de x'
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
    // si existe el valor que se usa 
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
// si existe algo en la pila 
    private boolean busquedaEnLaPila(String tokenEvaluando) {
        return this.pila.contains(tokenEvaluando);
    }

}
