
package view;

import controle.Comando;
import javax.swing.JOptionPane;
import modelo.Gravadora;
import modelo.GravadoraDAO;

/**
 *
 * @author Karen
 */
public class InterfaceInserirGravadora implements Comando{

    @Override
    public void executar() {
        String nome = null;
        String cnpj = null;
        
        GravadoraDAO dao = GravadoraDAO.getInstance();
        
        //Teste do nome da gravadora
        boolean ok = false;
        do {
            try {
                nome = JOptionPane.showInputDialog(null, "Informe o nome da gravadora");
                if (nome.equals("")) {
                    throw new CampoVazioException("Uma gravadora tem que ter nome");
                }
                ok = true;
            } catch (CampoVazioException cve) {
                JOptionPane.showMessageDialog(null, cve);
                ok = false;
            } catch (NullPointerException npe) {
                JOptionPane.showMessageDialog(null, "Não é possível cancelar!", "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        } while (ok != true);
        
        ok = false;
        do {
            try {
                cnpj = JOptionPane.showInputDialog(null, "Informe o CNPJ da gravadora");
                if (cnpj.equals("")) {
                    throw new CampoVazioException("Uma gravadora tem que ter CNPJ");
                }
                ok = true;
            } catch (CampoVazioException cve) {
                JOptionPane.showMessageDialog(null, cve);
                ok = false;
            } catch (NullPointerException npe) {
                JOptionPane.showMessageDialog(null, "Não é possível cancelar!", "Erro!", JOptionPane.ERROR_MESSAGE);
            }
        } while (ok != true);
        
        Gravadora g = new Gravadora(nome, cnpj);
        dao.inserir(g);
        InterfaceMenuPrincipal.exibir();
                
    }
    
    
}
