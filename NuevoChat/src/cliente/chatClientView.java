
package cliente;

import java.net.*;


public class chatClientView extends javax.swing.JFrame {
    
    /**
     * variable tipo String el nombre de host de la maquina activa.
     */
    String nombreHostCliente;
    
    /**
     * variable tipo String que guarda la direccion IPv4 de la maquina del client de chat.
     */
    String direccionIpCliente;

    /**
     * creando un nuevo formulario
     */
    public chatClientView() {
        initComponents();
    }

    /**
     * ESTE METODO LLAMA AL CONSTRUTOR QUE INICIALIZA EL FORMULARIO 
     *NO MODIFICAR
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        btnCONNECT = new javax.swing.JButton();
        btnDISCONNECT = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblUserStatus = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtServerAddress = new javax.swing.JTextField();
        txtServerPort = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtChatArea = new javax.swing.JTextArea();
        txtChatMessage = new javax.swing.JTextField();
        btnSEND = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtUsersList = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNotificationArea = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        lblHostName = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblIpAddress = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("bigChat - Client Window");
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(690, 70));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel1.setText("USUARIO");

        btnCONNECT.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnCONNECT.setText("CONECTAR");
        btnCONNECT.setName("btnCONNECT"); // NOI18N

        btnDISCONNECT.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnDISCONNECT.setText("DESCONECTAR");
        btnDISCONNECT.setEnabled(false);
        btnDISCONNECT.setName("btnDISCONNECT"); // NOI18N

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("ESTADO");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        lblUserStatus.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lblUserStatus.setForeground(new java.awt.Color(255, 0, 0));
        lblUserStatus.setText("DESCONECTADO");

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel3.setText("SERVER");

        txtServerAddress.setText("127.0.0.1");

        txtServerPort.setModel(new javax.swing.SpinnerNumberModel(32565, 0, 65535, 1));

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel8.setText("PORT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUserStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtServerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addGap(4, 4, 4)
                        .addComponent(txtServerPort, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCONNECT, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDISCONNECT, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCONNECT)
                    .addComponent(btnDISCONNECT)
                    .addComponent(jLabel3)
                    .addComponent(txtServerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtServerPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblUserStatus))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        txtChatArea.setEditable(false);
        txtChatArea.setColumns(20);
        txtChatArea.setRows(5);
        jScrollPane3.setViewportView(txtChatArea);

        txtChatMessage.setEditable(false);

        btnSEND.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnSEND.setText("ENVIAR");
        btnSEND.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel7.setText("AREA DE CHAT");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtChatMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSEND, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtChatMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSEND)))
        );

        txtUsersList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(txtUsersList);

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("USUARIOS EN LINEA");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        txtNotificationArea.setEditable(false);
        txtNotificationArea.setColumns(20);
        txtNotificationArea.setRows(5);
        jScrollPane1.setViewportView(txtNotificationArea);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
        jLabel4.setText("NOMBRE DE HOST");

        lblHostName.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        lblHostName.setText("HOST LOCAL");

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 10)); // NOI18N
        jLabel6.setText("DIRECCION IP");

        lblIpAddress.setFont(new java.awt.Font("Roboto", 0, 10)); // NOI18N
        lblIpAddress.setText("255.255.255.255");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator3)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblHostName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblIpAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblHostName)
                    .addComponent(jLabel6)
                    .addComponent(lblIpAddress)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * este metodo  setLblNombreHost method recibe el nombre de host enviado por la label 
     * @param strText 
     */
    public void setLblNombreHost(String strText) {
        this.lblHostName.setText(strText);
    }

    /**
     * este metodo setLblDireccionIp recibe la direccion de la ip`de la label.
     * @param strText 
     */
    public void setLblDireccionIp(String strText) {
        this.lblIpAddress.setText(strText);
    }
    
    /**
     * este AgregarTextAreaNotificacion agrega texto al area de notificacion
     * @param strText 
     */
    public void AgregarTextAreaNotificacion(String strText){
        this.txtNotificationArea.append(strText + "\n");
    }
      
    /**
     * este getTextDeMensajeChat retorna el textoha sido ingresado del capo de mensaje de chat
     * @return 
     */
    public String getTextDeMensajeChat(){
        return txtChatMessage.getText();
    }
    
    /**
     * este metodo setupNetworkFields obtiene el nombre de host y la direccion IPv4 address de la
     * maquina del cliente desplegada los valores en orden.
     */
    public void setupNetworkFields(){
        
        InetAddress hostMaquina;        
        try{
            
            hostMaquina = InetAddress.getLocalHost();
            direccionIpCliente = hostMaquina.getHostAddress();
            nombreHostCliente = hostMaquina.getHostName();

            lblHostName.setText(nombreHostCliente );
            lblIpAddress.setText(direccionIpCliente );
            
        }catch(UnknownHostException uhe){
            txtNotificationArea.append("[ERROR]: ERROR AL OBTENER LA INFORMACION DE RED DEL HOST.\n");
            txtNotificationArea.append( uhe.toString() + "\n" );
        }        
    }
    
    /**
     * Este metodo getClienteNombreHost retorna el nombre de host de la maquina del cliente de chat

     */
    public String getClienteNombreHost(){
        return nombreHostCliente;
    }
    
    /**
     * Este metodo getClientDireccionIp retorna la direccion IP de la maquina del cleinte de chat.
   
     */
    public String getClientDireccionIp(){
        return direccionIpCliente;
    }

    // declaracion de variables 
    private javax.swing.JButton btnCONNECT;
    private javax.swing.JButton btnDISCONNECT;
    private javax.swing.JButton btnSEND;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblHostName;
    private javax.swing.JLabel lblIpAddress;
    private javax.swing.JLabel lblUserStatus;
    private javax.swing.JTextArea txtChatArea;
    private javax.swing.JTextField txtChatMessage;
    private javax.swing.JTextArea txtNotificationArea;
    private javax.swing.JTextField txtServerAddress;
    private javax.swing.JSpinner txtServerPort;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JList<String> txtUsersList;
    // fin de declaracion de variables 

    
    public javax.swing.JButton getButtonConnectReference(){
        return btnCONNECT;
    }
    
   
    public javax.swing.JButton getButtonDisconnectReference(){
        return btnDISCONNECT;
    }
    
    
    public javax.swing.JButton getButtonSendReference(){
        return btnSEND;
    }
    
    public javax.swing.JTextField getTxtServerAddress(){
        return txtServerAddress;
    }    
    
    
    public javax.swing.JTextField getTxtUserNameReference(){
        return txtUserName;
    }

    public javax.swing.JTextField getTxtChatMessageReference(){
        return txtChatMessage;
    }

  
    public javax.swing.JSpinner getTxtServerPort(){
        return txtServerPort;
    }
    
    public javax.swing.JTextArea getTxtChatAreaReference(){
        return txtChatArea;
    }
    
    
    public javax.swing.JTextArea getTxtNotificationAreaReference(){
        return txtNotificationArea;
    }
    
    public javax.swing.JList<String> getTxtUsersListReference(){
        return txtUsersList;
    }    
   
    public javax.swing.JLabel getLblUserStatus(){
        return lblUserStatus;
    }
    
   
    public javax.swing.JLabel getLblClientHostname(){
        return lblHostName;
    }
    
    public javax.swing.JLabel getLblClientIPAddress(){
        return lblIpAddress;
    }    
}
