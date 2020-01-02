
package view;

import controle.Comando;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.DiscoDAO;

/**
 *
 * @author Karen
 */
public class InterfacePesquisarDisco implements Comando{

    @Override
    public void executar() {
        DiscoDAO dao = DiscoDAO.getInstance();
        ArrayList lista = dao.getColecao();
        JOptionPane.showMessageDialog(null, lista);
        InterfaceMenuPrincipal.exibir();
    }
    
}
