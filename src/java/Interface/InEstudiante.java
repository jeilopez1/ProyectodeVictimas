package Interface;

import Clases.ClassEstudiante;
import java.sql.Date;
import java.util.ArrayList;



/**
 *
 * @author Yeisson Lopez
 */
public interface InEstudiante {
    
    public boolean RegistrarEstudiante(String PrimerNombre, String SegundoNombre, String PrimerApellido, String SegundoApellido, String CorreoElectronico, Date FechaDeNacimiento, int id_TipoDeIdentificacion, long Numero_de_Identificacion, String Sexo, String Alias, String Contrasena, long N_Contacto, int UbicacionSemestral, String Especialidad);
    public ClassEstudiante ConsultarEstudiante(int ID_Usuario);
    public ArrayList<ClassEstudiante> ConsultarEstudiantes();
    public ClassEstudiante ModificarEstudiante(int ID_Usuario);
    public boolean EliminarEstudiante();
    
    
   
    
}
