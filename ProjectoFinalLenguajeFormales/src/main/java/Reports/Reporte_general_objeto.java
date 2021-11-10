/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reports;


import Objects.Tipos;
import Objects.TokenObject;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alexis
 */
public class Reporte_general_objeto {
    // ingresp de listas para el uso
    private ArrayList<String> listaToken = new ArrayList<>();
    private ArrayList<TokenObject> Tokens = new ArrayList<>();
    
    // ingreso de errores por si hay
    private Errors_Object reporteErrores;
    private String lexema = "";
    private int fila = 1;
    private int columna = 0;
    private JTable tabla;
    private int estadoAnterio = 0;
    private int contador = 0;

    public Reporte_general_objeto() {
        this.listarTokens();
    }

    /**
     * Imprime en el JTable los reportes recopilados
     *
     * @param tabla
     */
    public void enlistarReporte(JTable tabla) {
        this.tabla = tabla;
        int index = 0;
        DefaultTableModel modelo = new DefaultTableModel();
        this.tabla.setModel(modelo);
        modelo.addColumn("NOMBRE TOKEN");
        modelo.addColumn("LEXEMA");
        modelo.addColumn("FILA");
        modelo.addColumn("COLUMNA");
        for (TokenObject token : this.Tokens) {
            modelo.addRow(new Object[]{this.nombreParaListado(token.getToken()), token.getLexema(), token.getFila(), token.getColumna()});
            index++;
        }
    }

    /**
     * Recopila reportes, de fila , columna, y sus respectivos tokens
     *
     * @param caracter
     * @param estado
     * @param lengt
     */
    public void recopilarReporte(char caracter, int estado, int lengt) {
        switch (estado) {
            case -3:
                if (!"".equals(lexema) && !this.esNoAceptcion(caracter, this.estadoAnterio)) {
                    TokenObject tokens = new TokenObject(nombreToken(this.estadoAnterio, lexema), lexema, fila, columna);
                    Tokens.add(tokens);
                }
                this.fila++;
                this.columna = 0;
                this.lexema = "";
                break;
            case -2:
                if (!"".equals(lexema) && !this.esNoAceptcion(caracter, this.estadoAnterio)) {
                    TokenObject tokens = new TokenObject(nombreToken(this.estadoAnterio, lexema), lexema, fila, columna);
                    Tokens.add(tokens);
                }
                this.columna++;
                this.lexema = "";
                break;
            case -4:
                if (!"".equals(lexema) && !this.esNoAceptcion(caracter, this.estadoAnterio)) {
                    TokenObject tokens = new TokenObject(nombreToken(this.estadoAnterio, lexema), lexema, fila, columna);
                    Tokens.add(tokens);
                    this.columna++;
                    this.lexema = "";
                    TokenObject tokens1 = new TokenObject(nombreToken(10, caracter + ""), caracter + "", fila, columna);
                    Tokens.add(tokens1);
                    this.columna++;
                    this.lexema = "";
                }
                break;
            case 10:
                if (!this.esNoAceptcion(caracter, this.estadoAnterio)) {
                    TokenObject tokens1 = new TokenObject(nombreToken(10, caracter + ""), caracter + "", fila, columna);
                    Tokens.add(tokens1);
                    this.columna++;
                    this.lexema = "";
                }
                break;
            default:
                this.columna++;
                this.lexema += "" + caracter;
                if (this.contador == lengt - 1 && !this.esNoAceptcion(caracter, estado)) {
                    TokenObject tokens = new TokenObject(nombreToken(estado, lexema), lexema, fila, columna);
                    Tokens.add(tokens);
                }

                break;
        }
        this.contador++;
        this.estadoAnterio = estado;
    }

    private boolean esNoAceptcion(char caracter, int estado) {
        boolean esNoAceptacion = false;
        if (estado == 4 || estado == 1) {
            this.reporteErrores.recopilador(caracter, -1);
            esNoAceptacion = true;
        }

        return esNoAceptacion;
    }

    /**
     *
     * @param estado
     * @return
     */
    private String nombreToken(int estado, String lexema) {
        String token = "";
        switch (estado) {
            case 2:
                token = listaToken.get(4);
                break;
            case 3:
                token = listaToken.get(0);
                break;
            case 6:
                token = listaToken.get(5);
                break;
            case 7:
                token = listaToken.get(1);
                break;
            case 8:
                token = listaToken.get(6);
                break;
            case 9:
                token = lexema;
                break;
            case 10:
                token = lexema;
                break;
            case 11:
                token = lexema;
                break;
            default:
                token = listaToken.get(10);
                break;
        }

        return token;
    }

    /**
     * nombre de los token a identificar
     */
    private void listarTokens() {
        this.listaToken.add("id");
        this.listaToken.add("Numero");
        this.listaToken.add("Reservada");
        this.listaToken.add("Literal");
        this.listaToken.add("Comentario");
        this.listaToken.add("Literal");
        this.listaToken.add("Especial");
        this.listaToken.add("Igual");
        this.listaToken.add("Agrupacion");
        this.listaToken.add("Operador");
        this.listaToken.add("Error");

    }

    public void pabrasReservadas() {
        for (TokenObject token : this.Tokens) {
            for (Tipos value : Tipos.values()) {
                if (token.getLexema().equals(value.name())) {
                    token.setToken(value.name());
                }
            }
        }
    }

    public String nombreParaListado(String tipoToken) {
        switch (tipoToken) {
            case "id":
                tipoToken = "IDENTIFICADOR";
                break;
            case "ESCRIBIR":
                tipoToken = "RESERVADA";
                break;
            case "FIN":
                tipoToken = "RESERVADA";
                break;
            case "REPETIR":
                tipoToken = "RESERVADA";
                break;
            case "INICIAR":
                tipoToken = "RESERVADA";
                break;
            case "SI":
                tipoToken = "RESERVADA";
                break;
            case "VERDADERO":
                tipoToken = "RESERVADA";
                break;
            case "FALSO":
                tipoToken = "RESERVADA";
                break;
            case "ENTONCES":
                tipoToken = "RESERVADA";
                break;
            case "=":
                tipoToken = "IGUAL";
                break;
            case "+":
                tipoToken = "OPERADOR";
                break;
            case "*":
                tipoToken = "OPERADOR";
                break;
            case "(":
                tipoToken = "AGRUPACION";
                break;
            case ")":
                tipoToken = "AGRUPACION";
                break;
        }

        return tipoToken;
    }

    public Errors_Object getReporteErrores() {
        return reporteErrores;
    }

    public void setReporteErrores(Errors_Object reporteErrores) {
        this.reporteErrores = reporteErrores;
    }

    public ArrayList<TokenObject> getTokens() {
        return Tokens;
    }

    public void setTokens(ArrayList<TokenObject> Tokens) {
        this.Tokens = Tokens;
    }
}
