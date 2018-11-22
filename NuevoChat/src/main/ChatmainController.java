
package main;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import server.chatServer;
import cliente.chatClient;

public class ChatmainController{
    
    private ChatvistaLauncher gui;
    private ActionListener accionEscucharStarServer;
    private ActionListener accionEscucharStarCliente;

    public ChatmainController(ChatvistaLauncher gui) {
        this.gui = gui;
    }

    public void activadorBtnStarServer(){
        accionEscucharStarServer = new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent) {
                gui.getReferenceBtnLaunchServer().setEnabled(false);
                new chatServer().chatServerStart();
            }
        };
        gui.getReferenceBtnLaunchServer().addActionListener(accionEscucharStarServer);
    }
    
    public void activadorBtnStarCliente(){
        accionEscucharStarCliente = new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent) {
                new chatClient().chatClientStart();
            }
        };
        gui.getReferenceBtnLaunchClient().addActionListener(accionEscucharStarCliente);
    }
    
    
}
