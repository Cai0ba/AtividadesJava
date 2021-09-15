package com.company;

import java.util.Scanner;

public class diadaseman2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira um número");
        int num = sc.nextInt();
        String dia;
        if (num == 1) {
            dia = "domingo";
        } else if (num == 2) {
            dia = "Segunda";
        } else if (num == 3) {
            dia = "Terça";
        } else if (num == 4) {
            dia = "Quarta";
        } else if (num == 5) {
            dia = "Quinta";
        } else if (num == 2) {
            dia = "SEXTA";
        } else if (num == 3) {
            dia = "Sábado";
        }else{
            dia = "Valor inválido";
    }
        System.out.println("O dia da semana é: " + dia);
    }


}

