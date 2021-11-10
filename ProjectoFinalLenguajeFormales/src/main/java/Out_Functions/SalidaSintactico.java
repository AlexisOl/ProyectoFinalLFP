/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Out_Functions;

import Helper.recolecccion;
import Objects.TokenObject;

import java.util.ArrayList;

/**
 *
 * @author alexis
 */
public class SalidaSintactico {
    // variables a utilizar
    
    private String tokenGuia;
    private String cadea;
    private String documento;
    // bandera para errores
    private boolean error = false;
    
    // lista para las cadenas
    private ArrayList<String> cadenas = new ArrayList<>();
    
    
    
    
    // ingresp de variables sintacticas
    private int repetir;
    private String iniciarR;
    private String tokenSubGUIA;
    private String tokenACCION;

    // metodo de obtencion de dqatos 
    public void recolectar(String tipoToken, TokenObject token, recolecccion tabla) {
        // si no es error prosigue
        if (!tipoToken.equals("ERROR")) {
            if (tokenGuia == null) {
                // si es escribir
                if (tipoToken.equals("ESCRIBIR")) {
                    tokenGuia = tipoToken;
                    // si es repetir 
                    //si obtiene si 
                } else if (tipoToken.equals("SI")) {
                    tokenGuia = tipoToken;
                
                } else if (tipoToken.equals("REPETIR")) {
                    tokenGuia = tipoToken;
                }    
                

            } else {
                // si es escribir y tiene fin al cadena 
                if (tokenGuia.equals("ESCRIBIR")) {
                    if (tipoToken.equals("FIN")) {
                        // se resetea todo
                        documento += "\n" + cadea;
                        tokenGuia = null;
                        cadea = null;
                    } else {
                        // este quita las comillas para usar
                        cadea = quitarComillas(token, tabla);
                    }
                    
                    
                    
                    // en caso sea repetir 
                } else if (tokenGuia.equals("REPETIR")) {
                    // si tiene los valores necesarios
                    if (tipoToken.equals("Numero") || tipoToken.equals("id")) {
                        repetir = tabla.valorEnSimbolo(token.getLexema());
                    }
                    
                    // si tiene el inicio
                    if (tipoToken.equals("INICIAR")) {
                        iniciarR = "INICIAR";
                    }
                    // si es escibir, regresa la accion
                    if (iniciarR != null && tipoToken.equals("ESCRIBIR")) {
                        tokenACCION = "ESCRIBIR";
                    }
// obtiene literales
                    if (tipoToken.equals("Literal")) {
                        cadenas.add(quitarComillas(token, tabla));
                    }
                    // tipo fin
                    if (tipoToken.equals("FIN") && tokenACCION != null) {
                        tokenACCION = null;
                    } else if (tipoToken.equals("FIN") && tokenACCION == null) {
// ingreso y  reinicio de todo
                        Muetsra();
                      
                        cadenas.clear();
                        cadea = null;
                        tokenGuia = null;
                        tokenACCION = null;
                        tokenSubGUIA = null;
                    }
// varibles como boolenas
                } else if (tokenGuia.equals("SI")) {
                    if (tipoToken.equals("VERDADERO")) {
                        tokenSubGUIA = "VERDADERO";
                    }
                    if (tipoToken.equals("FALSO")) {
                        tokenSubGUIA = "FALSO";
                    }
                    if (tipoToken.equals("ESCRIBIR")) {
                        tokenACCION = "ESCRIBIR";
                    }
                    if (tipoToken.equals("Numero") || tipoToken.equals("Literal")) {
                        cadea = quitarComillas(token, tabla);
                    }
                    if (tipoToken.equals("FIN") && tokenACCION != null) {
                        tokenACCION = null;
                    } else if (tipoToken.equals("FIN") && tokenACCION == null) {
                        if (tokenSubGUIA.equals("VERDADERO")) {
                            documento += "\n" + cadea;
                        } 
// reinicio
                        cadea = null;
                        tokenGuia = null;
                        tokenACCION = null;
                        tokenSubGUIA = null;
                    }

                }

            }

        } else {
            // determinamos error
            error = true;
        }
    }

    
// quita las comillas para usarlas
    public String quitarComillas(TokenObject token, recolecccion tabla) {
        String salida = "";
        switch (token.getToken()) {
            case "id":
                salida += tabla.valorEnSimbolo(token.getLexema());
                break;
            case "Literal":
                salida += token.getLexema().replace("\"", "");
                break;
            default:
                salida += token.getLexema();
                break;
        }

        return salida;
    }

    
    public void Muetsra() {
        for (int i = 0; i < repetir; i++) {

            for (int j = 0; j < cadenas.size(); j++) {
                documento += "\n" + cadenas.get(j);
                System.out.println("REPETIR: " + cadenas.get(j));

            }

        }

    }
    public String getDocumento() {
        return documento;
    }
}
