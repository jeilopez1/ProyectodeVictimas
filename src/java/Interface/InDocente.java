/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Clases.ClassDocente;
import java.sql.Date;

/**
 *
 * @author Jeisson Lopez
 */
public interface InDocente {
    
    public boolean RegistrarDocente(String PrimerNombre, String SegundoNombre, String PrimerApellido, String SegundoApellido, String CorreoElectronico, Date FechaDeNacimiento, int id_TipoDeIdentificacion, long Numero_de_Identificacion, String Sexo, String Alias, String Contrasena, long N_Contacto, String Especializacion);
    public ClassDocente ConsultarDocente(int ID_Usuario);
    public ClassDocente ModificarDocente(String PrimerNombre, String SegundoNombre, String PrimerApellido, String SegundoApellido, String CorreoElectronico, Date FechaDeNacimiento, int id_TipoDeIdentificacion, long Numero_de_Identificacion, String Sexo, String Alias, String Contrasena, long N_Contacto, String Especializacion);
    public boolean EliminarDocente(int id_usuario);
    
}
