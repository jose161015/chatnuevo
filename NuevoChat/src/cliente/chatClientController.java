
package cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

public class chatClientController {
    
 

    /** 
     *hace referencia al objeto de la clase chatClienteModel.
     */    
    private chatClientModel model;

    /** 
     * hace referencia alobjeto chatCliente Vista
     */
    private chatClientView view;
    
    /** 
     * acciona el boton conectar.
     */
    private ActionListener actionListenerConectar;

    /** 
     * accion del boton desconectar.
     */
    private ActionListener actionListenerDesconectar;

    /** 
     * accion del boton enviar.
     */
    private ActionListener actionListenerEnviar;

    /** 
     * A String for storing temporary messages.
     */    
    private String strAnnounce;

    /**
     * Default constructor for the chatClientController class.
     * constructor para la clase chatClienteController y hace referencia 
     * a los objetos model y vista de chatClienteModel y chatClienteVista
     *
     */
    public chatClientController(chatClientModel model, chatClientView view) {
        this.model = model;
        this.view = view;
        this.view.AgregarTextAreaNotificacion("BIENVENIDO A LA SALA DE CHAT USAM...");
        this.strAnnounce = "";
    }
    
    /**
     * 
     * El metodo cleanStrAnnounce  limpia el contenido de la variable tipo String strAnnouce.
     */
    public void cleanStrAnnounce(){
        strAnnounce = "";
    }    
   
    /**
     * El metodo triggerButtonConnect is called when the user hits the CONNECT button
     * in order to connect to the chat server.
     */
    public void triggerButtonConnect(){
        actionListenerConectar = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                
                /* Escribe un intento de coneccion en el area de notificacion */
                view.AgregarTextAreaNotificacion("[INFO]: INICIA INTENTO DE CONEXION...");
                
                /* valida la direccion ip */
                if ( model.serverDireccionIpValidador( view.getTxtServerAddress().getText() ) ){
                    
                    /* RETRIEVE USERNAME */
                    /* Recibe u obtiene el nombre de usuario */
                    model.setStrUserName( view.getTxtUserNameReference().getText() );
                    view.getTxtUserNameReference().setText( model.getStrUserName() );

                    if ( model.isUsernameValidator() ){

                        view.getTxtUserNameReference().setEditable(false);

                        strAnnounce =  "[INFO]: USUARIO (- " + model.getStrUserName() + " -) ";
                        strAnnounce += "CONECTANDO DESDE LA MAQUINA (-- " + view.getClienteNombreHost() + " --) ";
                        strAnnounce += "CON IP (-- " + view.getClientDireccionIp() + " --).";
                        view.AgregarTextAreaNotificacion(strAnnounce);
                        cleanStrAnnounce();

                        /* Deshabilita el boton conectar y habilita el boton desconectar */
                        view.getButtonConnectReference().setEnabled(false);
                        view.getButtonDisconnectReference().setEnabled(true); 

                        /* CREATE CONNECTING MESSAGE ENVELOPE */
                         /* Crea una coneccion sobre el mensaje */
                        model.prepareConnectionLibSobreChat();

                        try{
                            //entrega al chat server la  IPv4 y el puerto
                            model.setChatServerDireccionIP( view.getTxtServerAddress().getText() );
                            model.setChatServerPuerto( Integer.parseInt( view.getTxtServerPort().getValue().toString() ) );
                            
                            /* coneccion al server */
                            model.connectandoAlServer();

                            /* SUBMIT LOGIN & REGISTER INTO SERVER */
                            model.sendLibSobreChatMesajeAlServer();                        

                            /* HANDLE CONTROL TO MASTER THREAD */
                            model.monitoringIncomingMessaging();

                            /* IF LOGIN IS NOT ALREADY IN USE */
                            view.getLblUserStatus().setText("CONECTADO");
                            view.getTxtChatAreaReference().append("BIENVENIDO  " + model.getStrUserName() + "\n");                        

                            /* ENABLE CHAT TEXT MESSAGE AND SEND BUTTON */
                            view.getTxtChatMessageReference().setEnabled(true);
                            view.getTxtChatMessageReference().setEditable(true);
                            view.getButtonSendReference().setEnabled(true);

                        }catch(SocketException e1){
                            view.AgregarTextAreaNotificacion("[ERROR] [CONNECCION ]: Problema al conectar con el servidor.\n");
                            view.AgregarTextAreaNotificacion(e1.toString());                                                
                        }catch(IOException e2){
                            view.AgregarTextAreaNotificacion("[ERROR] [CONNECCION ]: Problema al crear los flujos de entrada salida.\n");
                            view.AgregarTextAreaNotificacion(e2.toString());                                                
                        }

                    }else{
                        view.AgregarTextAreaNotificacion("[ERROR] [CONNECION ]: Nombre de Usuario es invalido.  Vuelva a intentar.\n");
                    }
                    
                }else{
                    view.AgregarTextAreaNotificacion("[ERROR] [CONNECCION ]: La direccion IP del servidor no es valida.  Vuelva a intentar con una ip valida.\n");
                }                                
            }
        };
        view.getButtonConnectReference().addActionListener(actionListenerConectar);
    }
    
    /**
     * The triggerButtonDisconnect method is called when the user hits the DISCONNECT
     * butto in order to disconnect from the chat server.
     */
    public void triggerButtonDisconnect(){        
        actionListenerDesconectar = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                
                view.AgregarTextAreaNotificacion("[INFO]: USTED HA PULSADO DISCONNECTAR...");
                
                /* STOP MONITORING INCOMING MESSAGES BY MASTER THREAD */
                try{
                    
                    /* SEND DISCONNECT MESSAGE TO SERVER */
                    model.prepareDisconnectionLibSobreChat();
                    model.sendLibSobreChatMesajeAlServer();                    
                    
                    /* CLEAN CHAT AREA & USERS LIST */
                    view.getLblUserStatus().setText("DESCONECTADO");
                    view.getTxtChatAreaReference().setText("");                    
                    
                    /* DISABLE CHAT TEXT MESSAGE AND SEND BUTTON */
                    view.getTxtChatMessageReference().setEnabled(false);
                    view.getTxtChatMessageReference().setEditable(false);
                    view.getButtonSendReference().setEnabled(false);                    

                    /* DISABLE DISCONNECT BUTTON AND ENABLE CONNECT */
                    view.getTxtUserNameReference().setEditable(true);
                    view.getButtonConnectReference().setEnabled(true);
                    view.getButtonDisconnectReference().setEnabled(false);
                
                }catch(IOException e){
                    view.AgregarTextAreaNotificacion("[ERROR] [DESCONECTAR]: Problema al desconectar del servidor." +e);
                    view.AgregarTextAreaNotificacion(e.toString());                                                
                }                                                
            }
        };
        view.getButtonDisconnectReference().addActionListener(actionListenerDesconectar);
    }
    
    /**
     * El metodo triggerButtonEntregar es llamado cuando el usuario hits el boton de entregar.
     */
    public void triggerButtonEntregar(){        
        
        actionListenerEnviar = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {                           
                                               
                try{
                    
                    /* PREPARE CHAT MESSAGE */
                    model.prepareChatMessageLibSobreChat( view.getTextDeMensajeChat() );
                    model.sendLibSobreChatMesajeAlServer();                                                           
                    
                    /* DISABLE CHAT TEXT MESSAGE AND SEND BUTTON */
                    view.getTxtChatMessageReference().setText("");
                
                }catch(IOException e){
                    view.AgregarTextAreaNotificacion("[ERROR] [GENERAL]: Problema al enviar mensaje " +
                                                   "de sala de chat al servidor.");
                    view.AgregarTextAreaNotificacion(e.toString());                                                
                }                 
            }
        };
        view.getButtonSendReference().addActionListener(actionListenerEnviar);
    }
    
}
