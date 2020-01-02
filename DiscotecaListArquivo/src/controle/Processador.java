
package controle;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KAREN
 */
public class Processador {

    private static final HashMap comandos = new HashMap();

    static {
        comandos.put("1", "view.InterfaceInserirGravadora");
        comandos.put("2", "view.InterfaceExcluirGravadora");
        comandos.put("3", "view.InterfaceEditarGravadora");
        comandos.put("4", "view.InterfacePesquisarGravadora");
        comandos.put("5", "view.InterfaceInserirDisco");
        comandos.put("6", "view.InterfaceExcluirDisco");
        comandos.put("7", "view.InterfaceEditarDisco");
        comandos.put("8", "view.InterfacePesquisarDisco");
        comandos.put("9", "view.InterfaceSair");
    }

    public static void direcionar(String cmd) {
        String actionClass = (String) comandos.get(cmd);
        //Cria a instância da classe utilizando introspecção
        try {
            Class classe = Class.forName(actionClass);
            Comando comando = (Comando) classe.newInstance();
            comando.executar();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Processador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException iex) {
            Logger.getLogger(Processador.class.getName()).log(Level.SEVERE, null, iex);
        } catch (IllegalAccessException iaex) {
            Logger.getLogger(Processador.class.getName()).log(Level.SEVERE, null, iaex);
        }

    }
}

