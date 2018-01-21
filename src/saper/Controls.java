/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saper;

import java.util.Scanner;

/**
 *
 * @author Konrad
 * 
 * Klasa zawierająca metodę odpowiadająca za sterowanie w rozpoczętej już grze.
 */
public class Controls {
    public void move(int n, char m) {
        Scanner read = new Scanner(System.in);
        System.out.println("Enter row number:");
        n = read.nextInt();
        System.out.println("Enter column number:");
        m = read.next().trim().charAt(0);
}
}
