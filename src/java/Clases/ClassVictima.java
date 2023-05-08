/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Conexion.Conexion;
import Interface.InVictima;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jeisson Lopez
 */
public class ClassVictima extends ClassUsuario implements InVictima {

    String Actividad_Economica;

    private static final Conexion con = Conexion.conectar();

    public ClassVictima(int id_usuario, String PrimerNombre, String SegundoNombre, String PrimerApellido, String SegundoApellido, String CorreoElectronico, Date FechaDeNacimiento, int id_TipoDeIdentificacion, long Numero_de_Identificacion, String Sexo, String Alias, String Contrasena, long N_Contacto, String Actividad_Economica) {
        super(id_usuario, PrimerNombre, SegundoNombre, PrimerApellido, SegundoApellido, CorreoElectronico, FechaDeNacimiento, id_TipoDeIdentificacion, Numero_de_Identificacion, Sexo, Alias, Contrasena, N_Contacto);
        this.Actividad_Economica = Actividad_Economica;
    }

    public ClassVictima() {
    }

    @Override
    public boolean RegistrarVictima(String PrimerNombre, String SegundoNombre, String PrimerApellido, String SegundoApellido, String CorreoElectronico, Date FechaDeNacimiento, int id_TipoDeIdentificacion, long Numero_de_Identificacion, String Sexo, String Alias, String Contrasena, long N_Contacto, String Actividad_Economica) {

        PreparedStatement ps, ps1;
        ResultSet res;
        int ID_Usuario = 0;
        try {
            ps = con.getConnection().prepareStatement("INSERT into usuario() VALUES(null,?,?,?,?,?,?,?,?,?,?,?,?); ");

            ps.setString(1, PrimerNombre);
            ps.setString(2, SegundoNombre);
            ps.setString(3, PrimerApellido);
            ps.setString(4, SegundoApellido);
            ps.setString(5, CorreoElectronico);
            ps.setDate(6, FechaDeNacimiento);
            ps.setInt(7, id_TipoDeIdentificacion);
            ps.setLong(8, Numero_de_Identificacion);
            ps.setString(9, Sexo);
            ps.setString(10, Alias);
            ps.setString(11, Contrasena);
            ps.setLong(12, N_Contacto);

            if (ps.executeUpdate() > 0) {
                con.cerrarConexion();

                try {
                    ps1 = con.getConnection().prepareStatement("SELECT usuario.ID_Usuario, usuario.PrimerNombre_Usuario\n"
                            + "from usuario\n"
                            + "where usuario.PrimerNombre_Usuario=?;");

                    ps1.setString(1, PrimerNombre);
                    res = ps1.executeQuery();
                    while (res.next()) {

                        ID_Usuario = res.getInt(1);

                    }

                    ps1 = con.getConnection().prepareStatement("insert into victima() values(null,?,?);");

                    ps1.setString(1, Actividad_Economica);
                    ps1.setInt(2, ID_Usuario);
                    if (ps1.executeUpdate() > 0) {
                        con.cerrarConexion();
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(ClassUsuario.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    con.cerrarConexion();
                }

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
    public ClassVictima ConsultarVictima(int ID_Usuario) {

        PreparedStatement ps;
        ResultSet res;
        ClassVictima Victima = null;

        try {
            ps = con.getConnection().prepareStatement("select usuario.*,victima.Actividad_Economica\n"
                    + "from victima \n"
                    + "inner join usuario \n"
                    + "on victima.FK_ID_Usuario_Victima=Usuario.ID_Usuario\n"
                    + "where usuario.ID_Usuario=?;");

            ps.setInt(1, ID_Usuario);
            res = ps.executeQuery();
            while (res.next()) {

                Victima = new ClassVictima(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getDate(7), res.getInt(8), res.getLong(9), res.getString(10), res.getString(11), res.getString(12), res.getLong(13), res.getString(14));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassUsuario.class
                    .getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }

        return Victima;

    }

    @Override
    public ClassVictima ModificarVictima(String PrimerNombre, String SegundoNombre, String PrimerApellido, String SegundoApellido, String CorreoElectronico, Date FechaDeNacimiento, int id_TipoDeIdentificacion, long Numero_de_Identificacion, String Sexo, String Alias, String Contrasena, long N_Contacto, String Actividad_Economica) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean EliminarVictima(int id_usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    

}
