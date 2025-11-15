/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
//Ingresar una frase y aplicando un algoritmo de ordenamiento, 
//ordenar alfabéticamente cada una de las letras de la frase, excluyendo los espacios.
package fis.poo.ejercicioseda;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Alex
 */
public class EjerciciosEDA {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese una frase: ");
        String frase = sc.nextLine();
        
        ArrayList<Character> letras = new ArrayList<>();
        for(int i = 0; i < frase.length(); i++){
            char c = frase.charAt(i);
            if(Character.isLetter(c)){
                letras.add(c);
            }
        }
        if (letras.isEmpty()) {
            System.out.println("No se encontraron letras");
            return;
        }
        
        char[] arrL = new char[letras.size()];
        for(int i = 0; i < letras.size(); i++){
            arrL[i] = Character.toLowerCase(letras.get(i));
        }
        
        for (int i = 0; i < arrL.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arrL.length; j++) {
                if (arrL[j] < arrL[minIndex]) {
                    minIndex = j;
                }
            }
            char temp = arrL[i];
            arrL[i] = arrL[minIndex];
            arrL[minIndex] = temp;
        }
        
        StringBuilder resultado = new StringBuilder();
        for (char c : arrL) resultado.append(c);

        System.out.println("Letras ordenadas: " + resultado.toString());
    }
}
