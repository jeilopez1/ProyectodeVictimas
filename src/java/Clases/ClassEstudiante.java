/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Conexion.Conexion;
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
public class ClassEstudiante extends ClassUsuario implements Interface.InEstudiante {

    int UbicacionSemestral;
    String Especialidad;

    private static final Conexion con = Conexion.conectar();

    public ClassEstudiante(int id_usuario, String PrimerNombre, String SegundoNombre, String PrimerApellido, String SegundoApellido, String CorreoElectronico, Date FechaDeNacimiento, int id_TipoDeIdentificacion, long Numero_de_Identificacion, String Sexo, String Alias, String Contrasena, long N_Contacto, int UbicacionSemestral, String Especialidad) {
        super(id_usuario, PrimerNombre, SegundoNombre, PrimerApellido, SegundoApellido, CorreoElectronico, FechaDeNacimiento, id_TipoDeIdentificacion, Numero_de_Identificacion, Sexo, Alias, Contrasena, N_Contacto);
        this.UbicacionSemestral = UbicacionSemestral;
        this.Especialidad = Especialidad;
    }

    public ClassEstudiante() {
    }

    public int getUbicacionSemestral() {
        return UbicacionSemestral;
    }

    public void setUbicacionSemestral(int UbicacionSemestral) {
        this.UbicacionSemestral = UbicacionSemestral;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getPrimerNombre() {
        return PrimerNombre;
    }

    public void setPrimerNombre(String PrimerNombre) {
        this.PrimerNombre = PrimerNombre;
    }

    public String getSegundoNombre() {
        return SegundoNombre;
    }

    public void setSegundoNombre(String SegundoNombre) {
        this.SegundoNombre = SegundoNombre;
    }

    public String getPrimerApellido() {
        return PrimerApellido;
    }

    public void setPrimerApellido(String PrimerApellido) {
        this.PrimerApellido = PrimerApellido;
    }

    public String getSegundoApellido() {
        return SegundoApellido;
    }

    public void setSegundoApellido(String SegundoApellido) {
        this.SegundoApellido = SegundoApellido;
    }

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public void setCorreoElectronico(String CorreoElectronico) {
        this.CorreoElectronico = CorreoElectronico;
    }

    public Date getFechaDeNacimiento() {
        return FechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date FechaDeNacimiento) {
        this.FechaDeNacimiento = FechaDeNacimiento;
    }

    public int getId_TipoDeIdentificacion() {
        return id_TipoDeIdentificacion;
    }

    public void setId_TipoDeIdentificacion(int id_TipoDeIdentificacion) {
        this.id_TipoDeIdentificacion = id_TipoDeIdentificacion;
    }

    public long getNumero_de_Identificacion() {
        return Numero_de_Identificacion;
    }

    public void setNumero_de_Identificacion(long Numero_de_Identificacion) {
        this.Numero_de_Identificacion = Numero_de_Identificacion;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getAlias() {
        return Alias;
    }

    public void setAlias(String Alias) {
        this.Alias = Alias;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public long getN_Contacto() {
        return N_Contacto;
    }

    public void setN_Contacto(long N_Contacto) {
        this.N_Contacto = N_Contacto;
    }

    @Override
    public boolean RegistrarEstudiante(String PrimerNombre, String SegundoNombre, String PrimerApellido, String SegundoApellido, String CorreoElectronico, Date FechaDeNacimiento, int id_TipoDeIdentificacion, long Numero_de_Identificacion, String Sexo, String Alias, String Contrasena, long N_Contacto, int UbicacionSemestral, String Especialidad) {

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

                    ps1 = con.getConnection().prepareStatement("insert into estudiante() values(null,?,?,?);");

                    ps1.setInt(1, UbicacionSemestral);
                    ps1.setString(2, Especialidad);
                    ps1.setInt(3, ID_Usuario);
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

    public boolean EliminarEstudiante() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ClassEstudiante ModificarEstudiante(int ID_Usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ClassEstudiante ConsultarEstudiante(int ID_Usuario) {

        PreparedStatement ps;
        ResultSet res;
        ClassEstudiante estudiante = null;

        try {
            ps = con.getConnection().prepareStatement("select usuario.*,estudiante.UbicacionSemestral,estudiante.Especialidad\n"
                    + "from estudiante \n"
                    + "inner join usuario \n"
                    + "on estudiante.FK_ID_Usuario_Estudiante=Usuario.ID_Usuario\n"
                    + "where usuario.ID_Usuario=?;");
            ps.setInt(1, ID_Usuario);
            res = ps.executeQuery();
            while (res.next()) {

                estudiante = new ClassEstudiante(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getDate(7), res.getInt(8), res.getLong(9), res.getString(10), res.getString(11), res.getString(12), res.getLong(13), res.getInt(14), res.getString(15));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }

        return estudiante;

    }

    @Override
    public ArrayList<ClassEstudiante> ConsultarEstudiantes() {
        ArrayList<ClassEstudiante> array = new ArrayList<ClassEstudiante>();

        PreparedStatement ps;
        ResultSet res;
        ClassEstudiante e;
        try {
            ps = con.getConnection().prepareStatement("select \n"
                    + "usuario.primernombre_usuario, usuario.primerapellido_usuario, usuario.correoelectronico, estudiante.ubicacionsemestral, estudiante.especialidad\n"
                    + "from estudiante \n"
                    + "inner join \n"
                    + "usuario \n"
                    + "on FK_ID_Usuario_Estudiante = usuario.id_usuario; ");
            res = ps.executeQuery();
            while (res.next()) {

//                h = new ClassHistoria(res.getInt(1), res.getString(2), res.getNString(3), res.getString(4), res.getInt(5), res.getInt(6));
                e = new ClassEstudiante(0, res.getString(1), null, res.getString(2), null, res.getString(3), null, 0,0, null, null, null, 0, res.getInt(4), res.getString(5));
                array.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }

        return array;

    }
}
