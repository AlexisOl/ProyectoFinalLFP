/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lexical_analyzer;

/**
 *
 * @author alexis
 */
public class State_Matrix {
    // ingreso de la matriz
       private int[][] state_matrix = {
                        //0   1     2    3      4       5      6    7       8      9   10   11
  /*0*/  {3,   7,     1,   -1,   10,   11,   7,   5,     4,      3,   3,   9},
  /*1*/  {-1,  -1,    2,   -1,   -1,   -1,    -1,  -1,   -1,     8,   -1,   -1},
  /*2*/   {2,   2,     2,    2,    2,    2,      2,   2,   2,      2,    2,   2},
  /*3*/  {3,   3,    -1,   -1,    4,   -1,      3,   3,   -1,    -1,   3,   -1},
  /*4*/  {4,   4,     4,   4,    4,       4,     4,   4,   6,      4,   4,   4},
  /*5*/  {-1,   -1,     -1,    -1,    -1,      -1,      -1,   -1,   -1,     -1,   -1,    -1},
  /*6*/  {-1,   -1,     -1,    -1,    -1,      -1,      -1,   -1,   -1,     -1,   -1,    -1},
  /*7*/  {-1,   7,     -1,    -1,    -4,      -1,      -1,   -1,   -1,     -1,   -1,    -1},
       };

    

// getter y setter de la matriz 
    public int[][] getStateMatrix() {
        return state_matrix;
    }

    public void setStateMatrix(int[][] State_matrix) {
        this.state_matrix = State_matrix;
    }
}
