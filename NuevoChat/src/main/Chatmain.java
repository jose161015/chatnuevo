package main;




public class Chatmain implements Runnable{
    

// atributos de miembros implementando el patrón de diseño MVC
    private ChatvistaLauncher vista;
    private ChatmainController controlador;
    
    public Chatmain(){
        vista = new ChatvistaLauncher();
        controlador = new ChatmainController(vista);
    }
    
    @Override
    public void run(){
        vista.setVisible(true);
        controlador.activadorBtnStarServer();
        controlador.activadorBtnStarCliente();
    }
    
    public static void main(String[] args){
        new Chatmain().run();
    }
}
