/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Clases.ClassUsuario;
import java.sql.Date;


/**
 *
 * @author Jeisson Lopez
 */
public interface InUsuario {
    public boolean RegistrarUsuario( String PrimerNombre, String SegundoNombre, String PrimerApellido, String SegundoApellido, String CorreoElectronico, Date FechaDeNacimiento, int id_TipoDeIdentificacion, long Numero_de_Identificacion, String Sexo, String Alias, String Contrasena, long N_Contacto);
    public ClassUsuario ConsultarUsuario(int id_usuario, String alias, String nombre, String apellido, Integer cedula, String constraseña);
    public ClassUsuario ModificarUsuario( String PrimerNombre, String SegundoNombre, String PrimerApellido, String SegundoApellido, String CorreoElectronico, Date FechaDeNacimiento, int id_TipoDeIdentificacion, long Numero_de_Identificacion, String Sexo, String Alias, String Contrasena, long N_Contacto);
    public boolean EliminarUsuario(int id_usuario);
    
    public ClassUsuario IniciarSesion(String alias, String constraseña);
}
