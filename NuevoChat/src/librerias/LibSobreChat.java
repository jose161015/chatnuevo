
package librerias;

public class LibSobreChat implements java.io.Serializable{
    
    

    /**
     * * Un encabezado de este tipo significa que es un mensaje de control no válido.
     */    
    public static final int INVALID_MSG = 0;
    
    /**
     * Un encabezado de este tipo significa que es un mensaje de conexión que proviene de un chat.
     * cliente.
     */    
    public static final int CONNECT_MSG = 1;    
    
    /**
     * Un encabezado de este tipo significa que el servidor de chat reconocerá la conexión.
     * intento desde el cliente de chat.
     */        
    public static final int CONNECT_MSG_ACK = 10;

    /**
     * Un encabezado de este tipo significa que el nombre de usuario ya está siendo usado por otro
     * usuario del cliente de chat.
     */      
    public static final int CONNECT_MSG_NACK = 100;

    /**
     *Un encabezado de este tipo significa que un usuario de chat está dispuesto a desconectarse de
     * El servidor de chat.

     */      
    public static final int DISCONNECT_MSG = 2;

    /**
    * Un encabezado de este tipo significa que el servidor de chat reconocerá la desconexión
     * Mensaje del usuario del cliente de chat.
     */      
    public static final int DISCONNECT_MSG_ACK = 20;
    
    /**
     * Un encabezado de este tipo significa que es un mensaje de chat regular de un cliente de chat
     * y debe ser enviado a todos los usuarios conectados.

     */      
    public static final int CHAT_MSG = 3;

    /**
     *Un encabezado de este tipo significa que el servidor de chat está enviando un mensaje a todos los conectados
     * Usuarios de clientes de chat.
     */      
    public static final int SERVERBROADCAST_MSG = 4;

    /**
     * Un encabezado de este tipo significa que el usuario del cliente de chat es el primero en conectarse
     * al servidor de chat.

     */  
    public static final int HOMEALONE_MSG = 5;

    /**
     * Un encabezado de este tipo significa que una solicitud para actualizar la lista de usuarios
     * ha sido enviado.
     */  
    public static final int UPDTLISTOFUSERS_MSG = 6;

    /**
     * Un encabezado de este tipo significa que un nuevo usuario cliente se ha unido a la sala de chat.
     */      
    public static final int JOINING_MSG = 7;

    /**
     * Un encabezado de este tipo significa que el servidor de chat está desactivado.
     */  
    public static final int SERVERGOINGDOWN_MSG = 8;

    /**
     *Un encabezado de este tipo significa que el cliente de chat reconoce que el servidor va
     * mensaje hacia abajo.
     */  
    public static final int SERVERGOINGDOWN_MSG_ACK = 80;

    /**
     * Un encabezado de este tipo significa que un usuario del cliente de chat ha abandonado la sala de chat.
     */  
    public static final int ABANDON_MSG = 9;
    
   // ATRIBUTOS DE LOS MIEMBROS

    /**
     * An integer representing the control header of the chat envelope.
     */
    private int envHeader;

    /**
     * Una cadena que representa el remitente del sobre de chat.

     */
    private String envFrom;

    /**
     * Una cadena que representa el cuerpo del sobre de chat.
     */
    private String envBody;

    /**
     * Un tipo de objeto {@link ChatListaUsuario} que tiene una lista de usuarios.
     */
    private ChatListaUsuario envList;
    
    /**
     * constructor predeterminado de la clase chatEnvelope.

     * 
     */
    public LibSobreChat(int eHeader, String eFrom, String eBody, ChatListaUsuario eList){
        this.envHeader = eHeader;
        this.envFrom = eFrom;
        this.envBody = eBody;
        this.envList = eList;
    }
    
    /**
     * Otro constructor para la clase chatEnvelope. No toma parámetros y
     * establece todos sus atributos de miembro a sus valores predeterminados.
     */
    public LibSobreChat(){
        this.envHeader = 0;
        this.envFrom = "";
        this.envBody = "";
        this.envList = null;
    }    

    
    /** 
     * El método setEnvHeader establece el valor del atributo de miembro del encabezado de control
     * para el sobre de chat.
     * @param envHeader Un entero que representa un encabezado de mensaje de control para el
     * Sobre del chat.
     */
    public void setEnvHeader(int envHeader) {
        this.envHeader = envHeader;
    }

    
/**
     * El método setEnvFrom establece el valor del atributo de miembro remitente de
     * El sobre del chat.
     * @param envFrom Una cadena que representa el remitente para el sobre de chat.
     */

    public void setEnvFrom(String envFrom) {
        this.envFrom = envFrom;
    }    

    
/**
     * El método setEnvBody establece el valor del atributo de miembro del cuerpo de
     * Sobre del chat.
     * @param envBody Una cadena que representa el cuerpo del sobre de chat.
     */
    public void setEnvBody(String envBody) {
        this.envBody = envBody;
    }
    
    
     /**
     * El método setEnvList establece el valor de la lista de atributo de miembro de usuarios
     * del sobre del chat.
     * @param envList Un objeto {@link ChatListaUsuario} que representa una lista de usuarios.
     * para el sobre de chat.
     */
    public synchronized void setEnvList(ChatListaUsuario envList){
        this.envList = envList;
    }

    
/**
     * El método getEnvHeader devuelve el valor del encabezado del mensaje de control
     * del sobre del chat.
     * @return Un entero que representa un mensaje de cabecera de control del chat
     * sobre.
     */
    public int getEnvHeader() {
        return envHeader;
    }

    

    /**
     * El método getEnvFrom devuelve el valor del remitente sobre el chat.
     * @return Una cadena que representa el remitente del chat.
     */
    public String getEnvFrom() {
        return envFrom;
    }

    
    /**
     * El método getEnvBody devuelve el valor del cuerpo del sobre del chat.
     * @return Una cadena que representa el cuerpo del sobre del chat.
     */
    public String getEnvBody() {
        return envBody;
    }
    
    
    /**
     * La lista getEnvUsers devuelve la lista de usuarios establecida en el sobre del chat.
     * @return Un objeto {@link ChatListaUsuario} que representa una lista de usuarios del
     * Sobre del chat.
     */
    public synchronized ChatListaUsuario getEnvUsersList(){
        return envList;
    }
    
    
    /**
     * El método resetEnvelope restablece el valor de los atributos de miembro de
     * Envolvente de chat a sus valores predeterminados.
     */
    public void resetEnvelope(){
        this.setEnvHeader(0);
        this.setEnvFrom("");
        this.setEnvBody("");
        this.envList = null;
    }
    
}
