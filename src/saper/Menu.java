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
 */
public class Menu {
        /**
        * @param n szerokość pola
        * @param m wysokość pola
        */
        int n;
        int m;
    /**
     * Metoda odpowiadająca za Menu gry.
     */
    public Menu() {
        int menu;
        System.out.println("Welcome!!!");
        System.out.println("Type 1 to start, 2 to select difficulty, 3 to  , 4 for help. ");
        Scanner read = new Scanner(System.in);
        menu = read.nextInt();

        switch (menu){
            case '1': Start();
                break;
            case '2': Difficulty();
                break;
            case '3':
                break;
            case '4': Help();
                break;
        }
        
        

        }
    public void Start() {
    
}
    public void Help() {
            System.out.println("Help:");
            System.out.println("");
}
    public void Difficulty() {
        String difficulty;
        Scanner read = new Scanner(System.in);
        difficulty = read.next();
        Map Mapa = new Map(n,m);
        switch (difficulty){
            case "easy": Mapa = new Map(8,8);
                    break;
            case "normal": Mapa = new Map(16,16);
                    break;
            case "hard": Mapa = new Map(30,16);
                    break;
            case "custom": 
                    System.out.println("Type width of the map: ");
                    n = read.nextInt();
                    System.out.println("Type height of the map: ");
                    m = read.nextInt();
                    Mapa = new Map(n,m);
                    break;
    }
}
    
 
}