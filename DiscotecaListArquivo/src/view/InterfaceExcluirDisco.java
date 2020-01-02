/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controle.Comando;
import javax.swing.JOptionPane;
import modelo.Disco;
import modelo.DiscoDAO;

/**
 *
 * @author Karen
 */
public class InterfaceExcluirDisco implements Comando{

    @Override
    public void executar() {
        boolean ok = false;
        
        DiscoDAO ddao = DiscoDAO.getInstance();
        do {
            Object[] discos = ddao.listaTitulosDiscos();
            String nome = (String) JOptionPane.showInputDialog(
                    null,
                    "Escolha qual disco deseja excluir:\n",
                    "Disco",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    discos,
                    "");

            if (nome!= null) {
                Disco disco = ddao.pesquisarDisco(nome);
                ddao.excluir(disco);
                ok = true;
            } else {
                ok = false;
            }
        } while (!ok);
    }
    
}
