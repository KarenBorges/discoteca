
package view;

import controle.Processador;
import javax.swing.JOptionPane;
import controle.GerenciadorArquivos;

/**
 *
 * @author karen
 */
public class InterfaceMenuPrincipal {
    
    public static void exibir(){
        //Teste do tiulo        
        boolean ok = true;
        do {
            try {
                String opcao = leitor("Escolha a opção:"
                        + "\n1 - Inserir Gravadora"
                        + "\n2 - Excluir Gravadora"
                        + "\n3 - Editar Gravadora"
                        + "\n4 - Pesquisar Gravadora"
                        + "\n5 - Inserir Disco"
                        + "\n6 - Excluir Disco"
                        + "\n7 - Editar Disco"
                        + "\n8 - Pesquisar Disco"
                        + "\n9 - Sair");
                Processador.direcionar (opcao);
                ok = true;
            } catch (CampoVazioException cve) {
                JOptionPane.showMessageDialog(null, cve);
                ok = false;
            } catch (NullPointerException npe) {
                int n = JOptionPane.showConfirmDialog(
                        null, "Deseja encerrar o programa?",
                        "Este título é editável...! blablabla",
                        JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    new InterfaceSair().executar();
                    ok = false;
                } else if (n == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(null, "Então digite algo...");
                    ok = true;
                }
            }
        } while (ok);
    }
    
    public static String leitor(String mensagem) throws CampoVazioException, NullPointerException{
        String dado=JOptionPane.showInputDialog(null, mensagem);
        if (dado.equals("")){
            throw new CampoVazioException("Você não preencheu o campo");
        }
        return dado;
    }
    
}
