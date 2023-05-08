/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Clases.ClassCaso;
import java.util.ArrayList;

/**
 *
 * @author Jeisson Lopez
 */
public interface InCaso {
    public ArrayList<ClassCaso> ConsultarCasoVictima(int id_victima);
    public ArrayList<ClassCaso> ConsultarCasoEstudiante(int id_victima);
    
}
