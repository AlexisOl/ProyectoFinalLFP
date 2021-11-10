/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sintactic_Analyzer;

import Helper.Sintactic_Errors;
import Objects.TokenObject;
import Out_Functions.Recolector;
import Sintactic_Analyzer.Matrix.*;

import java.util.ArrayList;

/**
 *
 * @author alexis
 */
public class SintacticAnalyzer {
    // ingreso de pila
      private final Stack_Automata pila = new Stack_Automata();
      // matriz de forma sintactica
    private final Matrix matriz = new Matrix();
    // las constantes
    private Constantes_Sintacticas produccion;
    // alfabeto de forma sintactica
    private final Terminal_Alphabet alfabeto = new Terminal_Alphabet();
    // lista y objeto de token 
    private TokenObject token;
    private ArrayList<TokenObject> Tokens = new ArrayList<>();
    // ayudadores, reportes y obtencion de funciones
    private Sintactic_Errors errores = new Sintactic_Errors();
    private Recolector funciones = new Recolector();

   // analizador sintactico
    
    
    public void analizar(ArrayList<TokenObject> Tokens) {
        // resetea al momento del uso 
        this.Tokens = this.limpiarTokens(Tokens);
        int index = 0;
        // mientras sea menor al tam. y este vacia 
        while (!this.pila.getPila().empty() && index < this.Tokens.size()) {
            if (this.token == null) {
                this.token = this.Tokens.get(index);
                // para el incremento
                index++;
            }
            
            // mientras tenga un pico 
            while (exist(this.pila.getPila().peek())) {
                // castea el valor
                this.produccion = (Constantes_Sintacticas) this.pila.getPila().peek();
                
                // se obtiene el nuevo valor de la matriz para desplazarse
                String valorMatriz = this.matriz.getMatriz()[this.alfabeto.getEstado(produccion)][this.alfabeto.getValorTernminal(this.token.getToken())];
                // si es nulo es porque hay error
                if (valorMatriz == null) {
                    
                    String descripError = "El analizador deberia tener " + produccion.getCaracteres();
                    this.errores.camputrarErrorSintactico(token, descripError);
                    token = null;
                    break;
                } else {
                    // sino lo almacena
                    this.pila.Apilar(valorMatriz, this.token.getToken());
                }

            }
            
            if (!exist(this.pila.getPila().peek()) && this.token != null) {
                // si no hay nada en el pico y ademas el token es distino a nulo
                // entonces almacena el token y lo entrega al recolenctor de salida y se elimina el del pico
                
                if (token.getToken().equalsIgnoreCase((String) this.pila.getPila().peek())) {
                    this.funciones.recolectorFucionesSalida(produccion, token);
                    this.pila.getPila().pop();
                    this.token = null;
                } else {
                    // sino alerta error 
                    String descripError = "El analizador sintactico deberia tener " + this.pila.getPila().peek();
                    this.errores.camputrarErrorSintactico(token, descripError);
                    this.token = null;
                }
            }

        }

    }
//comprueba si es un comentario o algun caso especial
    private ArrayList<TokenObject> limpiarTokens(ArrayList<TokenObject> tokens) {
        ArrayList<TokenObject> listadeTokens = new ArrayList<>();
        for (TokenObject token : tokens) {
            if (token.getToken().equalsIgnoreCase("Comentario") && token.getToken().equalsIgnoreCase("Especial")) {
                // token especial
            } else {
                listadeTokens.add(token);
            }
        }
        return listadeTokens;
    }

  

  // DETERMINA existencia de las constentes
    private boolean exist(Object ob) {
        boolean esEnum = false;
        Constantes_Sintacticas[] constantes = Constantes_Sintacticas.values();
        // ciclo para comprobar existencia
        for (Constantes_Sintacticas producciones : constantes) {
            esEnum = producciones.equals(ob);
            if (esEnum) {
                break;
            }
        }

        return esEnum;
    }

    
    // getters 
    public Sintactic_Errors getErrores() {
        return errores;
    }

    public void setErrores(Sintactic_Errors errores) {
        this.errores = errores;
    }

    public Recolector getFunciones() {
        return funciones;
    }
  public ArrayList<TokenObject> getTokens() {
        return Tokens;
    }

    public void setTokens(ArrayList<TokenObject> Tokens) {
        this.Tokens = Tokens;
    }
}
