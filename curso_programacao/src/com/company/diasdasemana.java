package com.company;

import java.util.Scanner;

public class diasdasemana {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira um número!");
        int num = sc.nextInt();
        if (num == 1) {
            System.out.println("Domingo");
        } else
            if (num == 2) {
            System.out.println("Segunda");
        } else
            if (num == 3) {
            System.out.println("Terça");
        } else
            if (num == 4) {
            System.out.println("Quarta");
        } else
            if (num == 5) {
            System.out.println("Quinta");
        } else
            if (num == 6) {
            System.out.println("Senta");
        } else {
            System.out.println("Sábado");
        }
    }
}



