/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saper;

import java.util.Random;

/**
 *
 * @author Rafał Dzwonek
 */
/**
 *
 * @author rafal
 *
 * Klasa zawierająca tablice posiadającą mapę i funkcje do zarządzania nią. W
 * klasie znajduje się również maska która określa które elementy mają być
 * wyświetlone.
 *
 * Wartości maski 0 - ukryte pole 1 - odkryte pole 2 - oznaczone pole
 */
public class Map {

    public char[][] map;
    public int[][] mask;

    /**
     * Standardowy konstruktor klasy Map. Tablica jest powiększona o 2 w każdą
     * strone aby umieścić ramkę
     *
     * @param n szerokość pola
     * @param m wysokość pola
     */
    public Map(int n, int m) {
        map = new char[n + 2][m + 2];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = 'a';
            }
        }
        mask = new int[n + 2][m + 2];
        for (int i = 0; i < mask[0].length; i++) {
            mask[0][i] = 1;
            mask[mask.length - 1][i] = 1;
        }
        for (int i = 0; i < mask.length; i++) {
            mask[i][0] = 1;
            mask[i][mask[0].length - 1] = 1;
        }
    }

    /**
     * Narzędzie do debugowania. Wypisuję maskę.
     */
    public void debugDrawMask() {
        for (int i = 0; i < mask.length; i++) {
            System.out.println("");
            for (int j = 0; j < mask[i].length; j++) {
                System.out.print(mask[i][j]);
            }
        }
    }

    /**
     * Narzędzie do debugowania. Wypisuje mapę bez maski.
     */
    public void debugDrawMap() {
        for (int i = 0; i < map.length; i++) {
            System.out.println("");
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
            }
        }
    }

    /**
     * Rysuje mapę z nałożoną maską
     */
    public void drawMap() {
        char letter = 'a';
        System.out.print(" ");
        for (int i = 0; i < map.length - 2; i++) {
            System.out.print(letter);
            letter++;
        }
        for (int i = 0; i < map.length; i++) {
            System.out.println("");
            if (i == 0) {
                System.out.print("  ");
            } else if (i < 10) {
                System.out.print(" " + i);
            } else if (i < map.length - 1) {
                System.out.print(i);
            } else {
                System.out.print("  ");
            }
            for (int j = 0; j < map[i].length; j++) {
                if (mask[i][j] == 0) {
                    System.out.print(" ");
                }
                if (mask[i][j] == 1) {
                    System.out.print(map[i][j]);
                }
                if (mask[i][j] == 2) {
                    System.out.print("*");
                }
            }
        }
    }

    /**
     * Ta metoda uzupełnia tablicę o ramkę.
     */
    public void setBorders() {
        map[0][0] = '+';
        map[0][map[0].length - 1] = '+';
        map[map.length - 1][0] = '+';
        map[map.length - 1][map[0].length - 1] = '+';

        for (int i = 1; i < map[i].length - 1; i++) {
            map[0][i] = '-';
            map[map.length - 1][i] = '-';
        }
        for (int i = 1; i < map.length - 1; i++) {
            map[i][0] = '|';
            map[i][map[0].length - 1] = '|';
        }
    }

    /**
     * Ta metoda generuje bomby na mapie
     *
     * @param chance Określa szansę na wystąpienie bomby
     */
    public void generateBombs(int chance) {
        Random rand = new Random();
        int rng;
        for (int i = 2; i < map.length - 1; i++) {
            for (int j = 2; j < map[i].length - 1; j++) {
                rng = rand.nextInt(101);
                if (rng <= chance) {
                    map[i][j] = 'x';
                }
            }
        }
    }

    /**
     * Ta metoda uzupełnia tablicę w liczby które wskazują ilość bomb w
     * otoczeniu
     */
    public void setNumbers() {
        int counter;
        for (int i = 1; i < map.length - 1; i++) {
            for (int j = 1; j < map[i].length - 1; j++) {
                if (map[i][j] != 'x') {
                    counter = 0;
                    if (map[i - 1][j - 1] == 'x') {
                        counter++;
                    }
                    if (map[i - 1][j] == 'x') {
                        counter++;
                    }
                    if (map[i - 1][j + 1] == 'x') {
                        counter++;
                    }
                    if (map[i][j - 1] == 'x') {
                        counter++;
                    }
                    if (map[i][j + 1] == 'x') {
                        counter++;
                    }
                    if (map[i + 1][j - 1] == 'x') {
                        counter++;
                    }
                    if (map[i + 1][j] == 'x') {
                        counter++;
                    }
                    if (map[i + 1][j + 1] == 'x') {
                        counter++;
                    }

                    map[i][j] = Character.forDigit(counter, 10);
                }
            }
        }
    }

}
