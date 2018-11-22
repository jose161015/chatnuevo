
package librerias;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarDireccionesIp{
    
    //IP ADDRESS definision de patrones constantes
    private static final String IPADDRESS_PATTERN =
		"^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";    

  

    /**
     *Un objeto de patrón para hacer referencia al patrón definido.
     */      
    private Pattern pattern;
    
    /**
     * Un objeto matcher para validar el patrón.
     */  
    private Matcher matcher;

    /**
     * Método constructor predeterminado para  Configura el patrón.
     * atributo de miembro.
     */
    public ValidarDireccionesIp(){
	  pattern = Pattern.compile( IPADDRESS_PATTERN );
    }
   
    /**
    * El método validarIP valida una dirección IP contra el patrón definido.
    * @param ip Una cadena que representa la dirección IP a validar.
    * @return Un valor booleano de VERDADERO si el parámetro ip coincide con el patrón.
    * De lo contrario devuelve FALSO.
    */
    public boolean validarIP( String ip ){
	
        matcher = pattern.matcher(ip);
	return matcher.matches();
    }
}
