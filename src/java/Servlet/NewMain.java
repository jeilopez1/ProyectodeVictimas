/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Clases.ClassCaso;
import Clases.ClassHistoria;
import Interface.InCaso;
import Interface.InHistoria;
import java.util.ArrayList;

/**
 *
 * @author Jeison
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        InHistoria historia = new ClassHistoria();
        int x = 4;
        int y = historia.ConsultarIDVictima(x);
        System.out.println(y);
        InCaso Caso = new ClassCaso();
        ArrayList<ClassCaso> k = Caso.ConsultarCasoEstudiante(y);
        for (int i = 0; i < k.size(); i++) {
            System.out.println(" <tr><td> " + k.get(i).getHistoria() + "</td> "
                    + "<td>" + k.get(i).getEstudiante() + "</td>"
                    + "<td>" + k.get(i).getObservaciones() + "</td>"
                    + "<td>" + k.get(i).getEstadoCaso() + "</td>" + "</tr>");
        }
    }

}
