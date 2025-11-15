/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//En una palabra ingresada por teclado, encontrar usando la búsqueda binara, todas las letras
package fis.poo.ejercicioseda;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class Ejercicio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una palabra: ");
        String palabra = sc.nextLine().toLowerCase();
        
        char[] letrasP = palabra.toCharArray();
        Arrays.sort(letrasP);
        
        System.out.println("Letras ordenadas: " + String.valueOf(letrasP));
        
        System.out.println("Ingrese la letra a buscar: ");
        char letraB = sc.next().toLowerCase().charAt(0);
        
        int resultado = busquedaBinaria(letrasP, letraB);
        
        if(resultado == -1){
            System.out.println("La letra no se encuentra");
        }else{
            System.out.println("La letra se encuentra en las posiciones: ");
            mostrarPosiciones(letrasP, letraB);
        }
    }
    
    
    public static int busquedaBinaria(char[] arreglo, char letraO){
        int inicio = 0;
        int fin = arreglo.length - 1;
        
        while(inicio <= fin){
            int medio = (inicio+fin)/2;
            
            if(arreglo[medio] == letraO){
                return medio;
            }else if(arreglo[medio] < letraO){
                inicio = medio + 1;
            }else{
                fin = medio - 1;
            }
        }
        return -1;
    }
    
    public static void mostrarPosiciones(char[] arreglo, char letra) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == letra) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}

