/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Conexion.Conexion;
import Interface.InHistoria;
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
public class ClassHistoria implements InHistoria {

    String Descripcion_Historia;
    Date FechaDelSuceso;

    private static final String SQL_INSERT = "INSERT INTO Historia () VALUES (null,?,?,?)";
    private static final String SQL_Consultartodo = "select historia.Descripcion_Historia, historia.FechaDelSuceso, historia.FechaDeRegistroDeHistoria FROM  Historia\n"
            + "INNER JOIN victima\n"
            + "on  victima.Id_Victima=Historia.FK_ID_Victima_Historia\n"
            + "INNER JOIN usuario\n"
            + "ON usuario.ID_Usuario=victima.FK_ID_Usuario_Victima\n"
            + "where usuario.id_usuario=?;";
    private static final Conexion con = Conexion.conectar();

    public ClassHistoria() {
    }

    public String getDescripcion_Historia() {
        return Descripcion_Historia;
    }

    public void setDescripcion_Historia(String Descripcion_Historia) {
        this.Descripcion_Historia = Descripcion_Historia;
    }

    public Date getFechaDelSuceso() {
        return FechaDelSuceso;
    }

    public void setFechaDelSuceso(Date FechaDelSuceso) {
        this.FechaDelSuceso = FechaDelSuceso;
    }

    public ClassHistoria(String Descripcion_Historia, Date FechaDelSuceso) {
        this.Descripcion_Historia = Descripcion_Historia;
        this.FechaDelSuceso = FechaDelSuceso;
    }

    @Override
    public ArrayList<ClassHistoria> ConsultarTodo(int id_victima) {
        ArrayList<ClassHistoria> array = new ArrayList<ClassHistoria>();

        PreparedStatement ps;
        ResultSet res;
        ClassHistoria h;
        try {
            ps = con.getConnection().prepareStatement(SQL_Consultartodo);
            ps.setInt(1, id_victima);
            res = ps.executeQuery();
            while (res.next()) {

//                h = new ClassHistoria(res.getInt(1), res.getString(2), res.getNString(3), res.getString(4), res.getInt(5), res.getInt(6));
                h = new ClassHistoria(res.getString(1), res.getDate(2));
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
    public String toString() {
        return "ClassHistoria{" + "Descripcion_Historia=" + Descripcion_Historia + ", FechaDelSuceso=" + FechaDelSuceso + '}';
    }

    @Override
    public boolean RegistrarHistoria(String Descripcion_Historia, Date FechaDelSuceso, int id_victima) {

        PreparedStatement ps;
        try {
            ps = con.getConnection().prepareStatement("INSERT into historia() VALUES(null,?,?,now(),?,?);");

            ps.setString(1, Descripcion_Historia);
            ps.setDate(2, FechaDelSuceso);
            ps.setInt(3, 1);
            ps.setInt(4, id_victima);

            if (ps.executeUpdate() > 0) {
                con.cerrarConexion();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }

        return false;

    }

    @Override
    public int ConsultarIDVictima(int id_usuario) {
        
        PreparedStatement ps;
        ResultSet res;
        ClassVictima Victima = null;
         int x=0;
        try {
            ps = con.getConnection().prepareStatement("select usuario.*,victima.Actividad_Economica,victima.ID_victima\n"
                    + "from victima \n"
                    + "inner join usuario \n"
                    + "on victima.FK_ID_Usuario_Victima=Usuario.ID_Usuario\n"
                    + "where usuario.ID_Usuario=?;");

                       
            ps.setInt(1, id_usuario);
            res = ps.executeQuery();
            while (res.next()) {

                Victima = new ClassVictima(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getDate(7), res.getInt(8), res.getLong(9), res.getString(10), res.getString(11), res.getString(12), res.getLong(13), res.getString(14));
                 x=res.getInt(15);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        
        return x;
    }

}
