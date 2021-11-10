/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lexical_analyzer;

import java.util.ArrayList;

/**
 *
 * @author alexis
 */
public class Alphabet {
    
    // Arraylist para los caracteres
     private ArrayList<Character> Signo_Agrupacion;
    private ArrayList<Character> Signo_Operador;
    private ArrayList<Character> Signo_Especial;
    private ArrayList<Character> variados;
    
    
    
    
    // algunos caracteres especiales, que no los puedo agrupar ya que representan alguna otra funcionalidad
    private String igual = "=";
    private char comillas = '"';
    private String Salto = "\n";
    private char diagonal = '/';
    private char guionMedio = '-';
    private char guionBajo = '_';
    private String tabulador = "\t";
// inicio
    public Alphabet() {
        this.defAlfabeto();
    }

    private void defAlfabeto() {
        defAgrupacion();
        defOperador();
        defPuntuacion();
        defCareacteresEspeciales();
    }
// ingreso de caractrese a las listas
    private void defAgrupacion() {
        Signo_Agrupacion = new ArrayList<>();
        this.Signo_Agrupacion.add('(');
        this.Signo_Agrupacion.add(')');
    }

 
    private void defOperador() {
        Signo_Operador = new ArrayList<>();
        this.Signo_Operador.add('+');
        this.Signo_Operador.add('%');
        this.Signo_Operador.add('*');
      
    }
   private void defPuntuacion() {
        variados = new ArrayList<>();
        this.variados.add('.');
        this.variados.add(':');
        this.variados.add('>');
        this.variados.add('<');
         this.variados.add(';');
        this.variados.add(',');
        this.variados.add('‘');
        this.variados.add('‘');
        this.variados.add('\'');

    }

    private void defCareacteresEspeciales() {
        this.Signo_Especial = new ArrayList<>();
        this.Signo_Especial.add('n');
          this.Signo_Especial.add('t');
        this.Signo_Especial.add('r');
        this.Signo_Especial.add('f');
    }

    public int alfabetoValueOf(int estadoActual, char caracter) {
        int valor = -1;
        if (Signo_Especial.contains(caracter)) {
            if (estadoActual == 3) {
                valor = 0;
            } else {
                valor = 9;
            }
        } else if (Character.isDigit(caracter)) {
            valor = 1;
        } else if (Character.compare(caracter, diagonal) == 0) {
            valor = 2;
        } else if (Signo_Agrupacion.contains(caracter)) {
            valor = 4;
        } else if (Signo_Operador.contains(caracter)) {
            valor = 5;
        } else if (variados.contains(caracter)) {
            valor = 3;
        } else if (Character.isSpaceChar(caracter) || Character.compare(caracter, tabulador.charAt(0)) == 0) {
            switch (estadoActual) {
                case 4:
                    valor = 4;
                    break;
                case 2:
                    valor = 2;
                    break;
                default:
                    valor = -2;
                    break;
            }
        } else if (Character.compare(caracter, this.Salto.charAt(0)) == 0) {
            valor = -3;
        } else if (Character.compare(caracter, guionMedio) == 0) {
            valor = 6;
        } else if (Character.compare(caracter, comillas) == 0) {
            valor = 8;
        } else if (Character.isLetter(caracter)) {
            valor = 0;
        } else if (Character.compare(caracter, guionBajo) == 0) {
            valor = 10;
        } else if (Character.compare(caracter, igual.charAt(0)) == 0) {
            valor = 11;
        }
        return valor;
    }

    
    
    //getters y setteres
    public ArrayList<Character> getAgrupacion() {
        return Signo_Agrupacion;
    }

    public void setAgrupacion(ArrayList<Character> agrupacion) {
        this.Signo_Agrupacion = agrupacion;
    }

    public ArrayList<Character> getOperador() {
        return Signo_Operador;
    }

    public void setOperador(ArrayList<Character> operador) {
        this.Signo_Operador = operador;
    }

    public ArrayList<Character> getCaracterEspecial() {
        return Signo_Especial;
    }

    public void setCaracterEspecial(ArrayList<Character> CaracterEspecial) {
        this.Signo_Especial = CaracterEspecial;
    }

    public ArrayList<Character> getVariados() {
        return variados;
    }

    public void setVariados(ArrayList<Character> variados) {
        this.variados = variados;
    }

    public String getIgual() {
        return igual;
    }

    public void setIgual(String igual) {
        this.igual = igual;
    }

    public char getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(char diagonal) {
        this.diagonal = diagonal;
    }

    public char getGuionMedio() {
        return guionMedio;
    }

    public void setGuionMedio(char guionMedio) {
        this.guionMedio = guionMedio;
    }

    public char getGuionBajo() {
        return guionBajo;
    }

    public void setGuionBajo(char guionBajo) {
        this.guionBajo = guionBajo;
    }

    public char getComillas() {
        return comillas;
    }

    public void setComillas(char comillas) {
        this.comillas = comillas;
    }

    public String getSalto() {
        return Salto;
    }

    public void setSalto(String Salto) {
        this.Salto = Salto;
    }

}
