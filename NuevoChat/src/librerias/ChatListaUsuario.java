
package librerias;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;


public class ChatListaUsuario implements java.io.Serializable{
    
  

    /**
     * hace un hashmap de la lista de usuarios almacenada
     */      
    private Map<Integer,String> listaUsuariosConectados;
    
    /**
     * metodo constructor no toma parametros
     */
    public ChatListaUsuario(){
        this.listaUsuariosConectados = new HashMap<>();
    }

    /**
     * El metodos agregaUsuarioAListaDeUsuarios agregauna nueva clavede usuario a la lista de usuarios
     * @param id The (int) 
     * @param name The (String).
     */
    public synchronized void agregaUsuarioAListaDeUsuarios(int id, String name){
        this.listaUsuariosConectados.put(id, name);
    }

    /**
     * El metodo removerUsuarioDeListaDeUsuario remueve la clave de un susario de la lsitas de usuario.
     * @param id The (int) id.
     */
    public synchronized void removerUsuarioDeListaDeUsuario(int id){
        this.listaUsuariosConectados.remove(id);
    }
    
    /**
     * El metodo getListaDeUsuarioSize retorna el tamañode la lista de usuarios.
     * @return .
     */
    public synchronized int getListaDeUsuarioSize(){
        return this.listaUsuariosConectados.size();
    }
    
    /**
     * El metodo getNombreUsuarioDeListaDeUsuario retrona el nombre de usuario de la llave en referencia conjunto de claves.
     * @param clave The (int) .
     * @return Returns a String .
     */
    public synchronized String getNombreUsuarioDeListaDeUsuario(int clave){
        return this.listaUsuariosConectados.get(clave);
    }
    
    /**
     * EL metodo getListaDeObjetosUserios retrona la referencia de listas de objetos de usuarios
     * @return Returns a HashMap<Ingeter,String>.
     */    
    public synchronized Map<Integer,String> getListaDeObjetosUserios(){
        return this.listaUsuariosConectados;
    }
    
    /**
     * El método usernameInUsersList garantiza que un nombre de usuario ya no está almacenado
     * en la lista de usuarios, por lo que los nombres de usuario no se repiten.
     * @param BuscarNombreUsuario The (String) haciendo referencia al nombre de usuario para buscar en
     * La lista de usuarios.
     * @return Returns verdadero es que el nombre de usuario ya está presente en la lista de lo contrario
     * devuelve falso.
     */
    public synchronized boolean NombreDeUsuariosEnLista(String BuscarNombreUsuario){
        
        boolean funciona = false;
        String compararNombres;        

        if ( this.listaUsuariosConectados.size() > 0 ){           
            Iterator entradas = listaUsuariosConectados.entrySet().iterator();            
            while ( entradas.hasNext() ) {
                Map.Entry entry = (Map.Entry) entradas.next();
                compararNombres = entry.getValue().toString();
                if ( compararNombres.equals(BuscarNombreUsuario) ){
                    funciona = true;
                    
                }
            }
        }                       
        return funciona;
    }
    
    /**
     * Este metodo limpiará la lista de usuarios. Limpiar el contenido de la lista de usuarios.
     */
    public void limpiarListaUsuarios(){
        this.listaUsuariosConectados.clear();
    }
    
}