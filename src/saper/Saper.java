/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saper;

/**
 *
 * @author rafal
 */
public class Saper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map mapa = new Map(10,10);
        mapa.setBorders();
        mapa.generateBombs(25);
        mapa.setNumbers();
        mapa.drawMap();
        System.out.println("\n\n\n\n");
        mapa.drawMap();
        mapa.mask[1][1]=1;
        System.out.println("\n\n\n");
        mapa.drawMap();
    }
    
}
