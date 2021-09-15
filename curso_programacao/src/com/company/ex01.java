package com.company;

import java.util.Scanner;

public class ex01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero = sc.nextInt();
       int ant = numero - 1;
       int suc = numero + 1;
        System.out.println("Seu antecessor e sucessor são: " + ant + " e " + suc );

    }
}
