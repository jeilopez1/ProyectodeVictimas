/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Clases.ClassCaso;
import Clases.ClassVictima;
import java.sql.Date;

/**
 *
 * @author Jeisson Lopez
 */
public interface InVictima {
    public boolean RegistrarVictima( String PrimerNombre, String SegundoNombre, String PrimerApellido, String SegundoApellido, String CorreoElectronico, Date FechaDeNacimiento, int id_TipoDeIdentificacion, long Numero_de_Identificacion, String Sexo, String Alias, String Contrasena, long N_Contacto, String Actividad_Economica);
    public ClassVictima ConsultarVictima( int ID_Victima);
    
    public ClassVictima ModificarVictima(String PrimerNombre, String SegundoNombre, String PrimerApellido, String SegundoApellido, String CorreoElectronico, Date FechaDeNacimiento, int id_TipoDeIdentificacion, long Numero_de_Identificacion, String Sexo, String Alias, String Contrasena, long N_Contacto, String Actividad_Economica);
    public boolean EliminarVictima(int id_usuario);
    
    
}
