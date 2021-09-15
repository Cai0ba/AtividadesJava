package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println("Hello World!");
        Scanner sc = new Scanner(System.in);

        int valor = sc.nextInt();
        if (valor <= 100){
            System.out.println("Viadão");
        }else{
            System.out.println("Machão");
        }


    }
}
