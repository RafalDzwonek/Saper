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
 * Klasa zawierająca metody odpowiadające za konstrukcję menu i możliwość wyboru
 * poszczególnych opcji w tym menu.
 */
public class Menu {

    /**
     * @param n szerokość pola
     * @param m wysokość pola
     * @param isDiffSet sprawdza czy poziom trudności został wybrany.
     */
    Map Mapa;
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
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
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
                    pressAnyKeyToContinue();
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
        boolean exit;
        Controls controls = new Controls();
        if (!isDiffSet) {
            Mapa = new Map(16, 16);
        }
        Mapa.generateBombs(10);
        Mapa.setNumbers();
        Mapa.setBorders();
        do{
            Mapa.drawMap();
            System.out.println("Waiting for input:\n");            
            exit = controls.move(Mapa);
            if(Mapa.check()){
                Mapa.debugDrawMap();
                System.out.println("Congratulations. You won!");
                pressAnyKeyToContinue();
            }
        }while(exit);
    }

    public void Help() {
        System.out.println("This is game of saper\n"
                + "If you dont know the rules they are simple.\n"
                + "You have to reveal every point on map.\n"
                + "However there are bombs on map, if you reveal bomb, you lose.\n"
                + "Numbers on map tells you how many bomb are surrounding this cell.\n"
                + "To reveal cell type \"o <horizontal index> <vertical index>\"\n"
                + "For eg. \"o d 15\"\n"
                + "You can also mark cell. To mark cell use * instead of \"o\"\n"
                + "for eg. \"* c 10\"");
        System.out.println("");
    }

    public void Difficulty() {
        int diff;

        do {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Choose difficulty:\n1.Easy\n2.Normal\n3.Hard\n4.Custom");
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
                    Mapa = new Map(24, 24);
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

    /*
    Funkcja zatrzymująca program dopóki przeciwnik nie naciśnie Enter
     */
    public void pressAnyKeyToContinue() {
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }
    
    
    /*
    Prymitywna funkcja do czyszczenia ekranu
    */
    public void clearScr(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

}
