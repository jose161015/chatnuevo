
package cliente;

import java.io.*;
import java.net.*;
import javax.swing.*;
import librerias.*;



public class chatClientModel{
    
    
    /**
     * Variable tipo String que almacena la direccion IPv4 del chat server.
     */
    private String serverDireccionIP;

    /**
     * variable tipo int que alberga el puerto de esccha del chat server .
     */
    private int serverPuerto;
    
    /**
     * variable tipo String que alberga el nombre del usuario.
     */
    private String strUserName;
    
    /**
     * variable tipo String que alberga la talla del usuario.
     */
    private int sizeUserName;    
    
    /**
     * objeto de tipo socket que hace la coneccion con el chat server.
     */
    private Socket clienteSocket;

    /**
     * objeto de tipo ObjectInputStream para leer los mensajes de  chat server.
     */
    private ObjectInputStream clienteStreamInput;

    /**
     * objeto de tipo ObjectOutputStream para escribir los mensajes al chat server.
     */
    private ObjectOutputStream clienteStreamOutput;    
    
    /**
     * objeto de JTextArea que hace referencia al origen del area de chat
     *
     */
    private JTextArea txtChatAreaRef;

    /**
     * objeto de JTextArea hace referencia al origen del area de notificaciones 
     */
    private JTextArea txtNotificationAreaRef;

    /**
     * objeto de  JList hace referencia la lista de usuario
     * 
     */
    private JList txtUserListaRef;

    /**
     * un objeto JButton hace referencia al boton conectar
     * 
     */
    private JButton btnConnRef;

    /**
     * objeto JButton hace referencia al boton desconectar
     * .
     */
    private JButton btnDisRef;

    /**
     * objeto JButton hace referencia al boton enviar.
     */
    private JButton btnSndRef;

    /**
     * objeto JLabel hace referencia al estatus .
     */
    private JLabel lblStatRef;

    /**
     * objeto JTextField hace referencia al campo de mensajes 
     * the GUI.
     */
    private JTextField txtChatMessageRef;

    /**
     * objeto JTextField hace referencia al campo donde se digita el nombre de usuario
     * GUI.
     */
    private JTextField txtUsernameRef;    

    /**
     * objeto LibSobreChat hace cambio de mensajes con el server.
     */
    private LibSobreChat msgEnvelope;
    
    /**
     * objeto chatClientThread obtiene la comunicacion cpon el chat server.
     */
    private chatClientThread masterThread;    

    /**
     * contructor predeterminado de la clase chatClientModel .
     * @param txtChatAreaReference A reference to the chat area from the GUI.
     * @param txtNotificationAreaReference A reference to the chat notification area
     * from the GUI.
     * @param txtUsersListReference A reference to the list of users from the GUI.
     * @param btnConnectReference A reference to the CONNECT button from the GUI.
     * @param btnDisconnectReference A reference to the DISCONNECT button from the GUI.
     * @param btnSendReference A reference to the SEND button from the GUI.
     * @param lblStatusReference A reference to the STATUS label from the GUI.
     * @param txtChatMessageReference A reference to the chat message field from the GUI.
     * @param txtUsernameReference A reference to the username field from the GUI.
     */
    public chatClientModel( JTextArea txtChatAreaReference, 
                       JTextArea txtNotificationAreaReference, 
                       JList txtUsersListReference,
                       JButton btnConnectReference,
                       JButton btnDisconnectReference,
                       JButton btnSendReference,
                       JLabel lblStatusReference,
                       JTextField txtChatMessageReference,
                       JTextField txtUsernameReference){
        
        this.strUserName = "";
        this.sizeUserName = 0;
               
        this.txtChatAreaRef = txtChatAreaReference;
        this.txtNotificationAreaRef = txtNotificationAreaReference;
        this.txtUserListaRef = txtUsersListReference;
        this.btnConnRef = btnConnectReference;
        this.btnDisRef = btnDisconnectReference;
        this.btnSndRef = btnSendReference;
        this.lblStatRef = lblStatusReference;
        this.txtChatMessageRef = txtChatMessageReference;
        this.txtUsernameRef = txtUsernameReference;
        
        this.clienteStreamInput = null;
        this.clienteStreamOutput = null;        
        
        //parametro determinado de la ip del server
        this.serverDireccionIP = "192.168.105.60";
        this.serverPuerto = 7526;
        
        this.msgEnvelope = new LibSobreChat();
    }

    /**
     * el setChatServerDireccionIP recibe la direccion IPv4 del chat server.
     * @param ip una String que representa la direccion IPv4 del chat server.
     */    
    public void setChatServerDireccionIP(String ip){
        this.serverDireccionIP = ip;
    }

    /**
     * el setChatServerPuerto recibe la TCP puerto de escucha del chat server.
     * @param port An integer representa la TCP puerto del chat server.
     */    
    public void setChatServerPuerto(int port){
        this.serverPuerto = port;
    }    

    /**
     * el metodo getStrUserName retorna el nombre de usurio.
     * @return una String que representa al nombre de usuario escrita por el usuario.
     */
    public String getStrUserName() {
        return strUserName;
    }

    /**
     * El metodo setStrUserName recibe el nombre de usuario .
     * @param strUserName A String que representa el nombre de usuario escrita por el usuario.
     */
    public void setStrUserName(String strUserName) {
        this.strUserName = strUserName.toUpperCase();
        this.sizeUserName = strUserName.length();
    }
    
    /**
     * el metodo isUsernameValidator valida los nombre de usuario .
     * @return TRUE si el usuario existesi ya existe retorna FALSE.
     */
    public boolean isUsernameValidator(){
        
        String patron;
        patron = "(\\w{4,15})";        
        return ( strUserName.matches(patron) ) ? true : false ;
        
    }
    
    /**
     * El metodo prepareConnectionLibSobreChat hace referencia a {@link LibSobreChat} tipo
     * de mensaje a la coneccion.
     */
    public void prepareConnectionLibSobreChat(){
        
        msgEnvelope.setEnvHeader(LibSobreChat.CONNECT_MSG );
        msgEnvelope.setEnvFrom(strUserName);
        msgEnvelope.setEnvBody("CONECTANDO");
        
    }
    
    /**
     * El metodo prepareDisconnectionLibSobreChat hace referencia a {@link LibSobreChat} da 
     * el tipo de mensaje cuando se esta desconectando.
     */
    public void prepareDisconnectionLibSobreChat(){
        
        msgEnvelope.setEnvHeader(LibSobreChat.DISCONNECT_MSG );
        msgEnvelope.setEnvFrom(strUserName);
        msgEnvelope.setEnvBody("DESCONECTANDO");
        
    }
    
    /**
     * El metodo prepareChatMessageLibSobreChat hace referencia a {@link LibSobreChat} el tipo de mensaje
     * regular chat mensajes del usuario.
     * @param msgBody A String representa los mensajes enviado por el usuario.
     */
    public void prepareChatMessageLibSobreChat(String msgBody){
        
        msgEnvelope.setEnvHeader(LibSobreChat.CHAT_MSG );
        msgEnvelope.setEnvFrom(strUserName);
        msgEnvelope.setEnvBody( msgBody );
    }
    
    /**
     * El metodo serverDireccionIpValidador valida la direccion IPv4 dada por el usuario.
     * @param direccionIp A String representa la direccion IPv4 para validar.
     * @return TRUE si la direccion IPv4 es valida.  de lo contrario retorna FALSE.
     */
    public boolean serverDireccionIpValidador(String direccionIp){
        
        ValidarDireccionesIp ipav;
        
        ipav = new ValidarDireccionesIp();    
        return ipav.validarIP(direccionIp );
    }
    
    /**
     * El metodo connectandoAlServer conecta con el chat server's en el puerto de escucha.
     * @throws SocketException si ocurre un problema cuando se habre el socket de coneccion.
     * @throws UnknownHostException si el server no responde a la comneccion
     * attempt.
     * @throws IOException si ocurre un problema cuando se envia el  output stream.
     */
    public void connectandoAlServer() throws SocketException, UnknownHostException, IOException{

        this.clienteSocket = new Socket( serverDireccionIP, serverPuerto );
        this.clienteStreamOutput = new ObjectOutputStream( clienteSocket.getOutputStream() );
        
    }
    
    /**
     * El metodo sendLibSobreChatMesajeAlServer envia una salida de {@link LibSobreChat} tipo
     * de mensaje alchat server.
     * @throws IOException si ocurre un problema cuando se ecribe al output stream.
     */
    public void sendLibSobreChatMesajeAlServer() throws IOException {
        
        this.clienteStreamOutput.writeObject( msgEnvelope );
        this.clienteStreamOutput.flush();
        this.clienteStreamOutput.reset();
        
    }
    
    /**
     * El metodo monitoringIncomingMessaging crea una instancia de monitoreo al hilo
     * cuando se obtien toda la comunicacion entre el chat client y el chat server.
     * @throws IOException si ocurre un problema cuando se inisializa el input stream.
     */
    public void monitoringIncomingMessaging() throws IOException {
        
        //crea una instancia de monitoreo de hilos
        masterThread = new chatClientThread(clienteSocket, clienteStreamInput,
                                                 clienteStreamOutput, txtChatAreaRef, 
                                                 txtNotificationAreaRef, txtUserListaRef,
                                                 btnConnRef, btnDisRef, btnSndRef, lblStatRef,
                                                 txtChatMessageRef, txtUsernameRef);
        masterThread.inicializaInputStream();        
        masterThread.start();
        
    }
    
}