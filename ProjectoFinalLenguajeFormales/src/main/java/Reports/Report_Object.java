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
public class Report_Object {
    // ingresp de listas para el uso
 
    private ArrayList<TokenObject> Tokens = new ArrayList<>();
    
    // ingreso de errores por si hay
    private Errors_Object reporteErrores;
    private String lexema = "";
    private int fila = 1;
    private int columna = 0;
    //----------------------------------
    private JTable tabla;
    // tabla
    
    // valores temporales
       private ArrayList<String> TokenAnalisis = new ArrayList<>();
        private int FirstState = 0;
        private int contador = 0;

       public Report_Object() {
        this.listarTokens();
    }

// ingreso a la tabla 
    public void enlistarReporte(JTable tabla) {
        this.tabla = tabla;
        int index = 0;
        DefaultTableModel modelo = new DefaultTableModel();
        this.tabla.setModel(modelo);
        modelo.addColumn("Token");
        modelo.addColumn("Lexema");
        modelo.addColumn("Fila");
        modelo.addColumn("Columna");
        for (TokenObject token : this.Tokens) {
            modelo.addRow(new Object[]{this.nombreParaListado(token.getToken()),    
                                                                token.getLexema(), 
                                                                token.getFila(), 
                                                                token.getColumna()});
            index++;
        }
    }
   // se ingresa en la lista lo que tiene que analizar
    private void listarTokens() {
         this.TokenAnalisis.add("id");
        this.TokenAnalisis.add("Numero");
        this.TokenAnalisis.add("Reservada");
        this.TokenAnalisis.add("Literal");
        this.TokenAnalisis.add("Comentario");
        this.TokenAnalisis.add("Literal");
        this.TokenAnalisis.add("Especial");
        this.TokenAnalisis.add("Igual");
        this.TokenAnalisis.add("Agrupacion");
        this.TokenAnalisis.add("Operador");
        this.TokenAnalisis.add("Error");

    }
  // determinacion de lo que vendria en el reporte 
    public void recopilarReporte(char caracter, int estado, int lengt) {
        
        //estp se determina segun el valor del estado 
        switch (estado) {
            case -3:
                if (!"".equals(lexema) && !this.noAceptable(caracter, this.FirstState)) {
                    TokenObject tokens = new TokenObject(nombreToken(this.FirstState, lexema), lexema, fila, columna);
                    Tokens.add(tokens);
                }
                this.fila++;
                this.columna = 0;
                this.lexema = "";
                break;
            case -2:
                if (!"".equals(lexema) && !this.noAceptable(caracter, this.FirstState)) {
                    TokenObject tokens = new TokenObject(nombreToken(this.FirstState, lexema), lexema, fila, columna);
                    Tokens.add(tokens);
                }
                this.columna++;
                this.lexema = "";
                break;
            case -4:
                if (!"".equals(lexema) && !this.noAceptable(caracter, this.FirstState)) {
                    TokenObject tokens = new TokenObject(nombreToken(this.FirstState, lexema), lexema, fila, columna);
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
                if (!this.noAceptable(caracter, this.FirstState)) {
                    TokenObject tokens1 = new TokenObject(nombreToken(10, caracter + ""), caracter + "", fila, columna);
                    Tokens.add(tokens1);
                    this.columna++;
                    this.lexema = "";
                }
                break;
            default:
                this.columna++;
                this.lexema += "" + caracter;
                if (this.contador == lengt - 1 && !this.noAceptable(caracter, estado)) {
                    TokenObject tokens = new TokenObject(nombreToken(estado, lexema), lexema, fila, columna);
                    Tokens.add(tokens);
                }

                break;
        }
        this.contador++;
        this.FirstState = estado;
    }

    
    // en caso esto no sea validon 
    private boolean noAceptable(char caracter, int estado) {
        boolean NosePuede = false;
        if (estado == 4 || estado == 1) {
            this.reporteErrores.recopilador(caracter, -1);
            NosePuede = true;
        }

        return NosePuede;
    }
// tipos de nombre del token en el analisis 
    private String nombreToken(int estado, String lexema) {
        String token = "";
        switch (estado) {
            case 2:
                token = TokenAnalisis.get(4);
                break;
            case 3:
                token = TokenAnalisis.get(0);
                break;
            case 6:
                token = TokenAnalisis.get(5);
                break;
            case 7:
                token = TokenAnalisis.get(1);
                break;
            case 8:
                token = TokenAnalisis.get(6);
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
                token = TokenAnalisis.get(10);
                break;
        }

        return token;
    }

 

   
// ingreso de los nombres y categoria 
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
    // algun tipo de palabra especial
     public void pabrasReservadas() {
        for (TokenObject token : this.Tokens) {
            for (Tipos value : Tipos.values()) {
                // si si cumple lo regresa
                if (token.getLexema().equals(value.name())) {
                    token.setToken(value.name());
                }
            }
        }
    }
// ingreso de ggeters y setters
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
