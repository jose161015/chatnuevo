
package cliente;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import librerias.*;



public class chatClientThread extends Thread {
    
    //MEMBER ATTRIBUTES DEFINITION
    
    /**
     * interruptor booleano que activa el ciclo infinito en el metodo run.
     */
    private boolean cicloInfinito;

    /**
     * objeto socket hase referencia a cliente socket de la clase ChatClienteModel
     */    
    private Socket hiloSocket;

    /**
     * objeto ObjectInputStream de lectura de la clase ChatClienteModel.
     */
    private ObjectInputStream streamEntrada;

    /**
     * objeto ObjectOutputStream de escritura ChatClienteModel.
     */
    private ObjectOutputStream streamSalida;
    
    /**
     * objeto JTextArea que hace referencia al cliente en el area del campo
     *.
     */
    private JTextArea txtChatAreaReferencia;

    /**
     * A JTextArea object to keep a reference to the chat client's notification area field 
     * from the GUI.
     */
    private JTextArea txtAreaNotificacionReferencia;    

    /**
     * objeto JList object mantiene la referencia de los clientes del chat en una lista
     */
    private JList txtListaUsuarioReferencia;

    /**
     * objeto JButton que hace la coneccion de un cliente en el chat
     */
    private JButton btnConectar;

    /**
     * objeto JButton desconecta al usuario de chat de la sala.
     */    
    private JButton btnDesconectar;

    /**
     * objeto JButton envia los mensajes del cliente de chat a la sala
     */
    private JButton btnEnviar;

    /**
     * onjeto JLabel el esttus del campo del cliente en el formulario.
     */
    private JLabel etiquetainicio;

    /**
     * objeto JTextField despliega los mensajes que el cliente chat envia.
     */
    private JTextField txtChatEntrada;

    /**
     * objeto JTextField mantiene el nombre del cliente del chat en el campo de texto.
     */
    private JTextField txtNombreUsuarioEntrada;

    /**
     * objeto {@link LibSobreChat} cambia los mensajes entre cliente de chat y el sever
     */    
    private LibSobreChat mensajeChat;

    /**
     * objeto {@link ChatListaUsuario} mantiene la lista de usuarios 
     */
    private ChatListaUsuario ListaDeUsuarioa;
    
    /**
     * constructor predeterminado de la clase chatClientThread.
     * @param s A chat client's socket reference object.
     * @param i A chat client's ObjectInputStream reference object.
     * @param o A chat client's ObjectOutputStream reference object.
     * @param txtTextArea1 A chat client's JTextArea reference object.
     * @param txtTextArea2 A chat client's JTextArea reference object.
     * @param txtUsersList A chat client's JList reference object.
     * @param btnConn1 A chat client's JButton reference object.
     * @param btnDis1 A chat client's JButton reference object.
     * @param btnSnd1 A chat client's JButton reference object.
     * @param lblStat1 A chat client's JLabel reference object.
     * @param txtChatInput1 A chat client's JTextField reference object.
     * @param txtUsernameInput1 A chat client's JTextField reference object.
     */
    public chatClientThread(Socket s, ObjectInputStream i, ObjectOutputStream o, 
                            JTextArea txtTextArea1, JTextArea txtTextArea2, JList txtUsersList,
                            JButton btnConn1, JButton btnDis1, JButton btnSnd1, JLabel lblStat1,
                            JTextField txtChatInput1, JTextField txtUsernameInput1){
        
        this.cicloInfinito = true;        
        this.hiloSocket = s;
        this.streamEntrada = i;
        this.streamSalida = o;        
        this.txtChatAreaReferencia = txtTextArea1;
        this.txtAreaNotificacionReferencia = txtTextArea2;
        this.txtListaUsuarioReferencia = txtUsersList;
        this.btnConectar = btnConn1;
        this.btnDesconectar = btnDis1;
        this.btnEnviar = btnSnd1;
        this.etiquetainicio = lblStat1;
        this.txtChatEntrada = txtChatInput1;
        this.txtNombreUsuarioEntrada = txtUsernameInput1;
    }
    
    /**
     * El metodo  inicializaInputStream inisializa el canal input stream channel asociado al socket del cliente 
     * @throws IOException si ocurre un problema inicializando  el input stream.
     */
    public void inicializaInputStream() throws IOException {
        streamEntrada = new ObjectInputStream( hiloSocket.getInputStream() );        
    }

    /**
     * RE ESCRIBIENDO EL METODO RUM QUE EJECUTA LOS MENSAJES EN UN CICLO 
     */
    public void run(){
                    
        try{
            
            //boolean EL CICLO ES VERDADERO O  = true;
            while( cicloInfinito ){
                
                mensajeChat = (LibSobreChat)streamEntrada.readObject();                
                switch( mensajeChat.getEnvHeader() ){
                    
                    case LibSobreChat.CONNECT_MSG_ACK:
                        
                        //CUANDO USUARIO ES ACEPTADO
                        txtAreaNotificacionReferencia.append("[INFO]: NOMBRE DE USUARIO ACEPTADO.\n");
                        break;
                        
                    case LibSobreChat.CONNECT_MSG_NACK:
                        
                        //CUANDO NOMBRE DE USUARIO YA ESTA EN USO
                        cicloInfinito = false;
                        txtChatAreaReferencia.append("[ERROR]: NOMBRE DE USUARIO YA ESTA EN USO.\n");                        
                        txtAreaNotificacionReferencia.append("[ERROR]: NOMBRE DE USUARIO ESTA ACTIVO.\n");                        
                        etiquetainicio.setText("DESCONECTADO");
                        btnConectar.setEnabled(true);
                        btnDesconectar.setEnabled(false);
                        btnEnviar.setEnabled(false);
                        txtChatEntrada.setText("");
                        txtNombreUsuarioEntrada.setEnabled(true);
                        txtNombreUsuarioEntrada.setEditable(true);
                        txtChatEntrada.setEnabled(false);
                        txtChatEntrada.setEditable(false);                        
                        cerrar();
                        break;
                        
                    case LibSobreChat.DISCONNECT_MSG_ACK:
                        
                        //DISCONNECT ACCEPTED
                        cicloInfinito = false;
                        limpiarListaUsuarios();
                        txtAreaNotificacionReferencia.append("[INFO]: SERVER ACEPTÒ DISCONECCION.\n");
                        cerrar();
                        break;
                        
                    case LibSobreChat.CHAT_MSG:
                        
                        //CHAT MENSAJES
                        txtChatAreaReferencia.append("[" + mensajeChat.getEnvFrom() + "]: " 
                                                  + mensajeChat.getEnvBody() + ".\n");
                        break;
                        
                    case LibSobreChat.SERVERBROADCAST_MSG:
                        
                        //BROADCAST MENSAJES DEL SERVIDOR
                        txtChatAreaReferencia.append("[ SERVER ]: " + mensajeChat.getEnvBody() + ".\n");
                        break;
                        
                    case LibSobreChat.HOMEALONE_MSG:
                        
                        //CUANDO EL CLIENTE ES EL PRIMERO EN CONECTARSE 
                        txtChatAreaReferencia.append("Tu eres la primera persona en la sala de chat, espera a que otros se conecten..\n");
                        break;
                        
                    case LibSobreChat.UPDTLISTOFUSERS_MSG:
                        
                        //ACTUALIZANDO LISTA DE USUARIOS
                        populateListOfUsers(mensajeChat.getEnvUsersList() );
                        break;
                        
                    case LibSobreChat.JOINING_MSG:
                        
                        //MENSAJE DE BIEN VENDIA
                        txtChatAreaReferencia.append("USUARIO " + mensajeChat.getEnvBody() + 
                                              " HA INICIADO SESIÓN EN LA SALA DE CHAT.\n");
                        break;
                        
                    case LibSobreChat.SERVERGOINGDOWN_MSG:
                        
                        //El server esta cayendo
                        cicloInfinito = false;
                        
                        //SEND GOING DOWN ACK BACK TO SERVER
                        mensajeChat.setEnvHeader(LibSobreChat.SERVERGOINGDOWN_MSG_ACK);
                        mensajeChat.setEnvBody("ACK");
                        streamSalida.writeObject(mensajeChat);
                        streamSalida.flush();
                        streamSalida.reset();
                        
                        txtAreaNotificacionReferencia.append("[INFO]: SERVER APAGADO.  ACK SENT BACK TO SERVER.\n");
                        
                        //limpia la lista de usuarios
                        limpiarListaUsuarios();
                        
                        txtChatAreaReferencia.append("[INFO]: SERVER APAGADO.  TU NO ESTAS CONECTADO.\n");                        
                        txtAreaNotificacionReferencia.append("[INFO]: SERVER CAIDO.  TU NO ESTAS  CONECTADO.\n");
                        
                        //UPDATE GUI
                        etiquetainicio.setText("DESCONECTADO");
                        btnConectar.setEnabled(true);
                        btnDesconectar.setEnabled(false);
                        btnEnviar.setEnabled(false);
                        txtChatEntrada.setText("");
                        txtNombreUsuarioEntrada.setEnabled(true);
                        txtNombreUsuarioEntrada.setEditable(true);
                        txtChatEntrada.setEnabled(false);
                        txtChatEntrada.setEditable(false);                                                
                        
                        //CIERRA LOS CANALES DE COMUNICACION
                        cerrar();                       
                        break;
                    
                    case LibSobreChat.ABANDON_MSG:
                        //cuando usuario abandona la sala de chat
                        txtChatAreaReferencia.append("USUARIO  [ " + mensajeChat.getEnvBody() + " ] HA ABANDONADO LA SALA DE CHAT.\n");                        
                        break;
                        
                    default:
                        break;
                }
                
                //reinicia los mensajes de chat
                mensajeChat.resetEnvelope();
                
            }            
            
        }catch(IOException e1){
                
                txtAreaNotificacionReferencia.append("ERROR: Problema al leer mensaje del servidor.\n");
                txtAreaNotificacionReferencia.append( e1.toString() + "\n");
                
        }catch(ClassNotFoundException e2){
            
                txtAreaNotificacionReferencia.append("ERROR: Problema al cerrar recursos de red.\n");
                txtAreaNotificacionReferencia.append( e2.toString() + "\n");
            
        }
        
    }
    
    /**
     * este metodo populateListOfUsers contiene la lista de usuarios de chat clientes 
     * vasados en los valores recibidos de chat server.
     * @param listOfUsers A {@link ChatListaUsuario} object representing the list of users.
     */
    public void populateListOfUsers(ChatListaUsuario listOfUsers){
        
        Vector v = new Vector();        
        this.ListaDeUsuarioa = listOfUsers;
        
        if ( listOfUsers != null ){
            for ( Map.Entry me : listOfUsers.getListaDeObjetosUserios().entrySet() ) {
                v.add( listOfUsers.getNombreUsuarioDeListaDeUsuario( new Integer( me.getKey().toString() ) ) );
            }
            this.txtListaUsuarioReferencia.setListData(v);
        }else{
            v.add("");
            this.txtListaUsuarioReferencia.setListData(v);
        }                
        
    }
    
    /**
     * El metodo limpiarListaUsuarios limpia la lista de objetos usuarios
 GUI.
     */
    public void limpiarListaUsuarios(){
        Vector v;
        v = new Vector();
        v.add("");
        this.txtListaUsuarioReferencia.setListData(v);
    }
    
    /**
     * El metodo cerrar cierra las entradas locales y las salidas de todos los canales stream 
 con el chat client's socket.
     * @throws IOException si ocurre un problema cunado se cierra los Streams.
     */
    public void cerrar() throws IOException{
        
        if ( streamSalida != null ) streamSalida.close();
        if ( streamEntrada != null ) streamEntrada.close();
        if ( hiloSocket != null ) hiloSocket.close();
    }
    
}
