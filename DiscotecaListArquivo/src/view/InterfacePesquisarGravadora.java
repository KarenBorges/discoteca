
package view;

import controle.Comando;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.GravadoraDAO;

/**
 *
 * @author Karen
 */
public class InterfacePesquisarGravadora implements Comando {

    @Override
    public void executar() {
        GravadoraDAO dao = GravadoraDAO.getInstance();
        ArrayList lista = dao.getColecao();
        JOptionPane.showMessageDialog(null, lista);
        InterfaceMenuPrincipal.exibir();
    }

}
