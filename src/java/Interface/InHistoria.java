/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Clases.ClassHistoria;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Jeisson Lopez
 */
public interface InHistoria {

    public boolean RegistrarHistoria(String Descripcion_Historia, Date FechaDelSuceso, int ID_Victima);

    public ArrayList<ClassHistoria> ConsultarTodo(int id_UsuarioConectado);
    
    public int ConsultarIDVictima(int id_usuario);
}
