/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Conexion.Conexion;
import Interface.InCaso;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jeisson Lopez
 */
public class ClassCaso implements InCaso {

    private int ID_Caso;
    String Observaciones;
    String EstadoCaso;
    Date FechaAsignacion;
    int Docente;
    String Estudiante;
    String Historia;
    private static final Conexion con = Conexion.conectar();

    public ClassCaso(int ID_Caso, String Observaciones, String EstadoCaso, Date FechaAsignacion, int Docente, String Estudiante, String Historia) {
        this.ID_Caso = ID_Caso;
        this.Observaciones = Observaciones;
        this.EstadoCaso = EstadoCaso;
        this.FechaAsignacion = FechaAsignacion;
        this.Docente = Docente;
        this.Estudiante = Estudiante;
        this.Historia = Historia;
    }

    public int getID_Caso() {
        return ID_Caso;
    }

    public void setID_Caso(int ID_Caso) {
        this.ID_Caso = ID_Caso;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public String getEstadoCaso() {
        return EstadoCaso;
    }

    public void setEstadoCaso(String EstadoCaso) {
        this.EstadoCaso = EstadoCaso;
    }

    public Date getFechaAsignacion() {
        return FechaAsignacion;
    }

    public void setFechaAsignacion(Date FechaAsignacion) {
        this.FechaAsignacion = FechaAsignacion;
    }

    public int getDocente() {
        return Docente;
    }

    public void setDocente(int Docente) {
        this.Docente = Docente;
    }

    public String getEstudiante() {
        return Estudiante;
    }

    public void setEstudiante(String Estudiante) {
        this.Estudiante = Estudiante;
    }

    public String getHistoria() {
        return Historia;
    }

    public void setHistoria(String Historia) {
        this.Historia = Historia;
    }

    public ClassCaso() {
    }

    @Override
    public ArrayList<ClassCaso> ConsultarCasoVictima(int id_victima) {

        ArrayList<ClassCaso> array = new ArrayList<ClassCaso>();

        PreparedStatement ps;
        ResultSet res;
        ClassCaso h, j;

        try {
            ps = con.getConnection().prepareStatement("select historia.Descripcion_Historia, (select usuario.primernombre_usuario \n"
                    + "from Usuario \n"
                    + "inner join estudiante \n"
                    + "on estudiante.FK_ID_Usuario_Estudiante =usuario.ID_Usuario \n"
                    + "inner JOIN caso \n"
                    + "on caso.FK_ID_Estudiante_Caso=Estudiante.ID_Estudiante) as nombre, Caso.Observaciones, Caso.Estado_Caso\n"
                    + "FROM  victima\n"
                    + "INNER JOIN historia\n"
                    + "on  Historia.FK_ID_Victima_Historia=Victima.ID_Victima\n"
                    + "INNER JOIN caso\n"
                    + "on  caso.FK_ID_Historia_Caso=historia.ID_Historia\n"
                    + "where Victima.ID_Victima=? ;");
            ps.setInt(1, id_victima);
            res = ps.executeQuery();
            while (res.next()) {

//                h = new ClassHistoria(res.getInt(1), res.getString(2), res.getNString(3), res.getString(4), res.getInt(5), res.getInt(6));
                h = new ClassCaso(0, res.getString(3), res.getString(4), null, 0, res.getString(2), res.getString(1));
                array.add(h);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }

        return array;
    }

    @Override
    public ArrayList<ClassCaso> ConsultarCasoEstudiante(int id_victima) {
        ArrayList<ClassCaso> array = new ArrayList<ClassCaso>();

        PreparedStatement ps;
        ResultSet res;
        ClassCaso h, j;

        try {
            ps = con.getConnection().prepareStatement("select historia.Descripcion_Historia,usuario.primernombre_usuario, Caso.Observaciones, Caso.Estado_Caso\n"
                    + "FROM  usuario\n"
                    + "INNER JOIN victima\n"
                    + "on  Victima.FK_ID_Usuario_Victima=Usuario.ID_Usuario\n"
                    + "INNER JOIN historia\n"
                    + "on  Historia.FK_ID_Victima_Historia=Victima.ID_Victima\n"
                    + "INNER JOIN caso\n"
                    + "ON caso.FK_ID_Historia_Caso=historia.ID_Historia\n"
                    + "WHERE caso.ID_Caso=?;");
            ps.setInt(1, id_victima);
            res = ps.executeQuery();
            while (res.next()) {

//                h = new ClassHistoria(res.getInt(1), res.getString(2), res.getNString(3), res.getString(4), res.getInt(5), res.getInt(6));
                h = new ClassCaso(0, res.getString(3), res.getString(4), null, 0, res.getString(2), res.getString(1));
                array.add(h);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }

        return array;
    }

}
