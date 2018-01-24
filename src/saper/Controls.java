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

    public boolean move(Map mapa) {
        Menu menu = new Menu();
        Scanner read = new Scanner(System.in);
        String cord;
        cord = read.nextLine();
        int x;
        int y;

        if (cord.charAt(0) == 'o') {
            if (cord.charAt(2) >= 'a' && cord.charAt(2) <= 'z') {
                if (Character.isDigit(cord.charAt(4))) {
                    if (cord.length() > 5) {
                        if (Character.isDigit(cord.charAt(5))) {
                            x = cord.charAt(2) - 'a' + 1;
                            y = Character.getNumericValue(cord.charAt(4)) * 10 + Character.getNumericValue(cord.charAt(5));
                            if(mapa.map[y][x]=='x'){
                                mapa.debugDrawMap();
                                System.out.println("Trafiłeś bombę przegrana!.");
                                menu.pressAnyKeyToContinue();
                                return false;
                            }
                            mapa.mask[y][x] = 1;
                            return true;
                        }
                    } else {
                        x = cord.charAt(2) - 'a' + 1;
                        y = Character.getNumericValue(cord.charAt(4));
                        if(mapa.map[y][x]=='x'){
                                mapa.debugDrawMap();
                                System.out.println("Trafiłeś bombę przegrana!.");
                                menu.pressAnyKeyToContinue();
                                return false;
                            }
                        mapa.mask[y][x] = 1;
                        return true;
                    }
                }
            }
        }

        if (cord.charAt(0) == '*') {
            if (cord.charAt(2) >= 'a' && cord.charAt(2) <= 'z') {
                if (Character.isDigit(cord.charAt(4))) {
                    if (cord.length() > 5) {
                        if (Character.isDigit(cord.charAt(5))) {
                            x = cord.charAt(2) - 'a' + 1;
                            y = Character.getNumericValue(cord.charAt(4)) * 10 + Character.getNumericValue(cord.charAt(5));
                            mapa.mask[y][x] = 2;
                            return true;
                        }
                    } else {
                        x = cord.charAt(2) - 'a' + 1;
                        y = Character.getNumericValue(cord.charAt(4));
                        
                        mapa.mask[y][x] = 2;
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
