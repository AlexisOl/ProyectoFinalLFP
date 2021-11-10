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
      private final Stack_Automata pila = new Stack_Automata();
    private final Matrix matriz = new Matrix();
    private Productions produccion;
    private final Terminal_Alphabet alfabeto = new Terminal_Alphabet();
    private TokenObject token;
    private ArrayList<TokenObject> Tokens = new ArrayList<>();
    private Sintactic_Errors errores = new Sintactic_Errors();
    private Recolector funciones = new Recolector();

    /**
     *logica del analisador sintactico con los tokens resividos del analisados lexico 
     * @param Tokens
     */
    public void analizar(ArrayList<TokenObject> Tokens) {
        this.Tokens = this.limpiarTokens(Tokens);
        int index = 0;
        while (!this.pila.getPila().empty() && index < this.Tokens.size()) {
            if (this.token == null) {
                this.token = this.Tokens.get(index);
                index++;
            }
            while (comprobar(this.pila.getPila().peek())) {
                this.produccion = (Productions) this.pila.getPila().peek();
                String valorMatriz = this.matriz.getMatriz()[this.alfabeto.getEstado(produccion)][this.alfabeto.getValorTernminal(this.token.getToken())];
                if (valorMatriz == null) {
                    String descripError = "El analizador sintactico esperba " + produccion.getEspera();
                    this.errores.camputrarErrorSintactico(token, descripError);
                    token = null;
                    break;
                } else {
                    this.pila.Apilar(valorMatriz, this.token.getToken());
                }

            }
            if (!comprobar(this.pila.getPila().peek()) && this.token != null) {
                if (token.getToken().equalsIgnoreCase((String) this.pila.getPila().peek())) {
                    this.funciones.recolectorFucionesSalida(produccion, token);
                    this.pila.getPila().pop();
                    this.token = null;
                } else {
                    String descripError = "El analizador sintactico esperba un token " + this.pila.getPila().peek();
                    this.errores.camputrarErrorSintactico(token, descripError);
                    this.token = null;
                }
            }

        }

    }

    /**
     * no toma en cuenta los comentarios y los caracteres especiales
     *
     * @param tokens
     * @return
     */
    private ArrayList<TokenObject> limpiarTokens(ArrayList<TokenObject> tokens) {
        ArrayList<TokenObject> tokensLimpios = new ArrayList<>();
        for (TokenObject token1 : tokens) {
            if (!token1.getToken().equalsIgnoreCase("Comentario") && !token1.getToken().equalsIgnoreCase("Especial")) {
                tokensLimpios.add(token1);
            }
        }
        return tokensLimpios;
    }

    public ArrayList<TokenObject> getTokens() {
        return Tokens;
    }

    public void setTokens(ArrayList<TokenObject> Tokens) {
        this.Tokens = Tokens;
    }

    /**
     * *
     * comprueba si el objeto ob es un enum
     *
     * @param ob
     * @return
     */
    private boolean comprobar(Object ob) {
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

}
