
package view;

import controle.Comando;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.*;
import modelo.Disco;
import modelo.DiscoDAO;
import modelo.Estilo;
import modelo.Gravadora;
import modelo.GravadoraDAO;
import modelo.Interprete;

/**
 *
 * @author Marcos Vinícius Saturno Ribeiro
 */
public class InterfaceInserirDisco implements Comando{

    public void executar() {

        //Essas variáveis armazenarão valores a serem informados para os objetos
        String artista = null;
        String titulo = null;
        int nroFaixas = 0;
        int ano = 0;
        Estilo opcaoEstilo = null;
        DiscoDAO dao = DiscoDAO.getInstance();
        GravadoraDAO gdao = GravadoraDAO.getInstance();
        Gravadora gravadora = null;
        boolean ok = false;

        //Teste do tiulo        
        do {
            try {
                titulo = JOptionPane.showInputDialog(null, "Informe o titulo do disco");
                if (titulo.equals("")) {
                    //throw pra ser pego pelo catch:
                    throw new CampoVazioException("Você não digitou nada!");
                }
                ok = true;
            } catch (CampoVazioException cve) {
                JOptionPane.showMessageDialog(null, cve.getMessage());
                ok = false;
            }
        } while (!ok);

        //Teste do artista       
        do {
            try {
                artista = JOptionPane.showInputDialog(null, "Informe o artista que produziu o disco: ");
                if (artista.equals("")) {
                    throw new CampoVazioException("Um disco não pode ficar sem artista!");
                }
                ok = true;
            } catch (CampoVazioException cve) {
                JOptionPane.showMessageDialog(null, cve.getMessage());
                ok = false;
            } catch (NullPointerException npe) {
                JOptionPane.showMessageDialog(null, "Não é possível cancelar!", "Erro!", JOptionPane.ERROR_MESSAGE);
                ok = false;                                
            }
        } while (!ok);

        //Teste do Estilo
        do {
            Object[] dados = Estilo.values();
            opcaoEstilo = (Estilo) JOptionPane.showInputDialog(
                    null,
                    "Estilo:\n",
                    "Escolha o estilo",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    dados,
                    Estilo.JAZZ);
            ok = true;

            if (opcaoEstilo == null) {
                    ok = false;
            }

        } while (!ok);


        //Teste da gravadora       
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
                gravadora = gdao.pesquisarGravadora(nome);
                ok = true;
            } else {
                ok = false;
            }
        } while (!ok);

        //Teste do nroFaixas       
        do {
            try {
                String inputNroFx = JOptionPane.showInputDialog(null, "Informe o numero de faixas do disco: ");
                if (inputNroFx.equals("")) {
                    throw new CampoVazioException("Sem faixas no disco?!");
                }              
                //Converte o valor digitado de string para Inteiro
                nroFaixas = Integer.parseInt(inputNroFx);
                if (nroFaixas == 0 | nroFaixas < 0) {
                    JOptionPane.showMessageDialog(null, "Numero de Faixas Incorreto", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
                ok = true;
            } catch (CampoVazioException cve) {
                JOptionPane.showMessageDialog(null, cve, "Muitas Faixas", JOptionPane.ERROR_MESSAGE);
                ok = false;
            } catch (NullPointerException npe) {
                JOptionPane.showMessageDialog(null, "Digite Algo...", "Input Error", JOptionPane.ERROR_MESSAGE);
                ok = false;
            } catch (NumberFormatException nfe) { // Para tratar o parseInt
                JOptionPane.showMessageDialog(null, nfe, "Conteúdo dos dados ", JOptionPane.ERROR_MESSAGE);
                ok = false;
            }

        } while (!ok);

        //Teste do ano       
        do {
            try {
                String inputNroAno = JOptionPane.showInputDialog(null, "Informe o ano de lançamento do disco: ");
                if (inputNroAno.equals("")) {
                    throw new CampoVazioException("Sem ano?!");
                }
                ano = Integer.parseInt(inputNroAno);
                int anoCorrente = (Calendar.getInstance()).get(Calendar.YEAR);
                System.out.println("Ano Corrente = " + anoCorrente);
                if (ano == 0 | ano < 0 | ano > anoCorrente ) {
                    JOptionPane.showMessageDialog(null, "Ano Incorreto", "ERRO", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    ok = true;
                }
            } catch (CampoVazioException cve) {
                JOptionPane.showMessageDialog(null, cve, "Valor Inválido", JOptionPane.ERROR_MESSAGE);
                ok = false;
            } catch (NullPointerException npe) {
                JOptionPane.showMessageDialog(null, "Digite o ano.", "Erro de Input", JOptionPane.ERROR_MESSAGE);
               ok = false;                                
            } catch (NumberFormatException nfe) { // Para tratar o parseInt
                JOptionPane.showMessageDialog(null, nfe, "Conteúdo dos dados ", JOptionPane.ERROR_MESSAGE);
                ok = false;
            }
        } while (!ok);

        //Estilo estiloEscolhido = Estilo.valueOf(opcaoEstilo);
        Interprete cantor = new Interprete(artista, opcaoEstilo);
        Disco novo = new Disco(titulo, cantor, gravadora, nroFaixas, ano);
        dao.inserir(novo);

        InterfaceMenuPrincipal.exibir();
    }
}
