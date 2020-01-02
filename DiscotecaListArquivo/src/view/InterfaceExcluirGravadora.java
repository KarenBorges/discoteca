/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controle.Comando;
import javax.swing.JOptionPane;
import modelo.*;

/**
 *
 * @author Karen
 */
public class InterfaceExcluirGravadora implements Comando{

    @Override
    public void executar() {
        boolean ok = false;
        
        GravadoraDAO gdao = GravadoraDAO.getInstance();
        do {
            Object[] gravadoras = gdao.listaNomesGravadoras();
            String nome = (String) JOptionPane.showInputDialog(
                    null,
                    "Escolha o selo:\n",
                    "Gravadora",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    gravadoras,
                    "");

            if (nome!= null) {
                Gravadora gravadora = gdao.pesquisarGravadora(nome);
                gdao.excluir(gravadora);
                ok = true;
            } else {
                ok = false;
            }
        } while (!ok);
    }
    
}
