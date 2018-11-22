
package cliente;

public class chatClient{
     
   
    
    /**
     * objeto de la clase ChatClienteVista.
     */
    private chatClientView view;

    /**
     * objeto de la clase ChatCliente model 
     */
    private chatClientModel model;

    /**
    * objeto de la clase ChatCliente Controller. 
     */
    private chatClientController controller;

    /**
     * constructor de la clase ChatCliente.
     */
    public chatClient() {
        this.view = new chatClientView();
        this.model = new chatClientModel(view.getTxtChatAreaReference(), 
                                    view.getTxtNotificationAreaReference(),
                                    view.getTxtUsersListReference(),
                                    view.getButtonConnectReference(),
                                    view.getButtonDisconnectReference(),
                                    view.getButtonSendReference(),
                                    view.getLblUserStatus(),
                                    view.getTxtChatMessageReference(),
                                    view.getTxtUserNameReference() );
        this.controller = new chatClientController(model, view);
    }
    
    /**
     * 
     * El metodo chatClienteStart inicialisa todas la instancias de la clase model vista
     * y controlador en ordenque carriendola aplicacion del chat
     *
     */
    public void chatClientStart(){
        
        view.setupNetworkFields();
        view.setVisible(true);
        controller.triggerButtonConnect();
        controller.triggerButtonDisconnect();
        controller.triggerButtonEntregar();
    }    
}