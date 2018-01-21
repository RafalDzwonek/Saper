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
     * @param isDiffSet sprawdza czy poziom trudności został wybrany.
     */
    int n;
    int m;
    boolean isDiffSet = false;

    /**
     * Metoda odpowiadająca za Menu gry.
     */
    public void startMenu() {
        int menu;
        boolean exit = true;
        System.out.println("Welcome!!!");

        do {
            System.out.println("1. Start \n2. Difficulty \n3. Help \n4. Exit");
            Scanner read = new Scanner(System.in);
            menu = read.nextInt();

            switch (menu) {
                case 1:
                    Start();
                    break;
                case 2:
                    Difficulty();
                    break;
                case 3:
                    Help();
                    break;
                case 4:
                    exit = false;
                    break;
                default:
                    System.out.println("Wrong number.");
                    break;
            }
        } while (exit);

    }

    public void Start() {

    }

    public void Help() {
        System.out.println("Help:");
        System.out.println("");
    }

    public void Difficulty() {
        int diff;
        Map Mapa;

        do {
            System.out.println("Choose difficulty:\n1.Easy\n2.Normal\n3.Hard\n4.Coustom");
            Scanner read = new Scanner(System.in);
            diff = read.nextInt();
            switch (diff) {
                case 1:
                    Mapa = new Map(8, 8);
                    isDiffSet = true;
                    break;
                case 2:
                    Mapa = new Map(16, 16);
                    isDiffSet = true;
                    break;
                case 3:
                    Mapa = new Map(30, 16);
                    isDiffSet = true;
                    break;
                case 4:
                    System.out.println("Type width of the map: ");
                    n = read.nextInt();
                    System.out.println("Type height of the map: ");
                    m = read.nextInt();
                    Mapa = new Map(n, m);
                    isDiffSet = true;
                    break;

                default:
                    System.out.println("Wrong number.");
                    break;
            }
        } while (!isDiffSet);
    }

}
