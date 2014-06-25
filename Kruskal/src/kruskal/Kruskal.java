/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kruskal;

import java.util.Scanner;

/**
 *
 * @author komarov
 */
public class Kruskal {

    public static class Edge {

        int n1;
        int n2;
        int w;

        public Edge() {
            n1 = 0;
            n2 = 0;
            w = 0;
        }
    }
    static int nV;
    static int nE;
    static final int maxNodes = 100;
    static final int maxEdges = 20;
    static int[] nodes;
    static int last_n;
    /**
     * @param args the command line arguments
     */
    
    private static int getColor(int n){
        int c;
        if (nodes[n]<0)
            return nodes[last_n=n];
        c = getColor(nodes[n]);
        nodes[n] = last_n;
        return c;
    }
    
        public static void bubbleSort(Edge[] arr, int nE) {
            /*Внешний цикл каждый раз сокращает фрагмент массива, 
          так как внутренний цикл каждый раз ставит в конец
          фрагмента максимальный элемент*/   
            for(int i = nE ; i > 0 ; i--){
                for(int j = 0 ; j < i ; j++){
                    /*Сравниваем элементы попарно, 
                      если они имеют неправильный порядок, 
                      то меняем местами*/
                    if( arr[j].w > arr[j+1].w ){
                        int tmpW = arr[j].w;
                        int tmpN1 = arr[j].n1;
                        int tmpN2 = arr[j].n2;
                        arr[j].w = arr[j+1].w;
                        arr[j].n1 = arr[j+1].n1;
                        arr[j].n2 = arr[j+1].n2;
                        arr[j+1].w = tmpW;
                        arr[j+1].n1 = tmpN1;
                        arr[j+1].n2 = tmpN2;
                    }
                }
            }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Edge [] edges = new Edge[maxEdges];
        for (int j = 0; j < maxEdges; j++)
            edges[j] = new Edge();  
        nodes = new int[maxNodes];
        
        int i;
        // Считываем вход
        System.out.println("Ввведите входные данные в соответсвии с документацией в файле \"Help.txt\"");
            Scanner in = new Scanner(System.in);
            nV = in.nextInt();
            nE = in.nextInt();
            for(i = 0; i < nV; i++) nodes[i] = -1-i;

            for(i = 0; i < nE; i++){
                edges[i].n1 = in.nextInt(); 
                edges[i].n2 = in.nextInt();
                edges[i].w = in.nextInt();                            
            }

        // Алгоритм Краскала

        // Сортируем все ребра в порядке возрастания весов
            bubbleSort(edges, nE);
            
            System.out.println("Ребра минимального остового дерева по алгоритму Крускала");
            
            for(i = 0; i < nE; i++){ 
               int c2 = getColor(edges[i].n2);
               if ( getColor (edges[i].n1) != c2 ){ 
                  nodes [last_n] = edges[i].n2;
                  System.out.print(edges[i].n1);
                  System.out.print(" ");
                  System.out.print(edges[i].n2);
                  System.out.print(" ");
                  System.out.println(edges[i].w);
               }
            }
     }
    
}
