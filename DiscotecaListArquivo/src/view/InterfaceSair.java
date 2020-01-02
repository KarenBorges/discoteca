
package view;

import controle.Comando;
import javax.swing.JOptionPane;

/**
 *
 * @author karen
 */
public class InterfaceSair implements Comando {

    @Override
    public void executar() {
        JOptionPane.showMessageDialog(null, "Saindo...");
        Principal.encerrar();
    }
    
}
