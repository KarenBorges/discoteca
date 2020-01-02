
package view;

import controle.GerenciadorArquivos;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.DiscoDAO;
import modelo.GravadoraDAO;

/**
 *
 * @author KAREN
 */
public class Principal {

    private static String arquivoDiscos;
    private static String arquivoGravadoras;
    private static DiscoDAO dadosDisco;
    private static GravadoraDAO dadosGravadora;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList colecao = null;

        while (true) {
            try {
                arquivoDiscos = leitor("Informe o nome do arquivo com os dados dos Discos");
                if (GerenciadorArquivos.existeArquivo(arquivoDiscos)) { // So cria se o arquivo nao existir
                    colecao = (ArrayList) GerenciadorArquivos.abrirArquivo(arquivoDiscos);
                    dadosDisco = new DiscoDAO(colecao); // objeto contendo a colecao de discos
                } else {
                    GerenciadorArquivos.criarArquivo(arquivoDiscos);
                    dadosDisco = new DiscoDAO(new ArrayList());
                }
                break;
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possÌvel abrir o arquivo");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (CampoVazioException cve) {
                JOptionPane.showMessageDialog(null, cve.getMessage());
            } catch (NullPointerException npe) {
                JOptionPane.showMessageDialog(null, "Encerrando o programa ...");
                System.exit(0);
            }
        }

        while (true) {
            try {
                arquivoGravadoras = leitor("Informe o nome do arquivo com os dados das Gravadoras");
                if (GerenciadorArquivos.existeArquivo(arquivoGravadoras)) { // So cria se o arquivo nao existir
                    colecao = (ArrayList) GerenciadorArquivos.abrirArquivo(arquivoGravadoras);
                    dadosGravadora = new GravadoraDAO(colecao); // objeto contendo a colecao de gravadoras
                } else {
                    GerenciadorArquivos.criarArquivo(arquivoGravadoras);
                    dadosGravadora = new GravadoraDAO(new ArrayList());
                }
                break;
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possÌvel abrir o arquivo");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (CampoVazioException cve) {
                JOptionPane.showMessageDialog(null, cve.getMessage());
            } catch (NullPointerException npe) {
                JOptionPane.showMessageDialog(null, "Encerrando o programa ...");
                System.exit(0);
            }
        }

        InterfaceMenuPrincipal.exibir();

    }

    public static void encerrar() {
        JOptionPane.showMessageDialog(null, "Encerrando o programa ...");
        try {
            GerenciadorArquivos.salvarArquivo(dadosDisco.getColecao(), arquivoDiscos);
        } catch (IOException ioex) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar os dados de disco");
            ioex.printStackTrace(); // Para ajudar a debugar
        }

        try {
            GerenciadorArquivos.salvarArquivo(dadosGravadora.getColecao(), arquivoGravadoras);
        } catch (IOException ioex) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar os dados de gravadora ");
            ioex.printStackTrace(); // Para ajudar a debugar
        }

        System.exit(0);
    }

    public static String leitor(String mensagem) throws CampoVazioException, NullPointerException {
        String dado = JOptionPane.showInputDialog(null, mensagem);
        if (dado.equals("")) {
            throw new CampoVazioException("Você não preencheu o campo");
        }
        return dado;
    }
}
