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
public class Map {

    public char[][] map;

    /**
     * Standardowy konstruktor klasy Map. Tablica jest powiększona o 2 w każdą
     * strone aby umieścić ramkę
     *
     * @param n szerokość pola
     * @param m wysokość pola
     */
    Map(int n, int m) {
        map = new char[n + 3][m + 3];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = 'a';
            }
        }
    }

    public void drawMap() {
        for (int i = 0; i < map.length; i++) {
            System.out.println("");
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
            }
        }
    }

    /**
     * Ta metoda uzupełnia tablicę o ramkę.
     */
    public void setBorders() {
        map[0][0] = '+';
        map[0][map[0].length-1] = '+';
        map[map.length-1][0] = '+';
        map[map.length-1][map[0].length-1] = '+';

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
