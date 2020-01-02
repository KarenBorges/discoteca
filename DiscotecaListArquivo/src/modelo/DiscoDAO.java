
package modelo;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * DiscoDAO.java
 *
 * Created on 16 de Outubro de 2006, 21:34
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author kborges
 */
public class DiscoDAO implements OperacoesDAO{
    
    private ArrayList colecao;
    private static DiscoDAO discos = null;
    
    /**
     * Cria uma nova instancia de DiscoDAO
     * Cria a colecao de objetos
     */
    public DiscoDAO(ArrayList colecao) {
        this.colecao = colecao;
        discos = this;
    }
    
    /**
     * @return a instância de DiscoDAO 
     */
    public static DiscoDAO getInstance(){
        return discos;
    }
    
    /**
     * Insere um Disco na colecao
     * @param obj contem o disco que sera inserido
     */
    public void inserir(Object obj) {
        getColecao().add(obj);
    }
    
    /**
     * Exclui um Disco da colecao
     * @param obj contem o disco que sera excluido
     */
    public void excluir(Object obj) {
        getColecao().remove(obj);
    }
    
    /**
     * Remove o objeto antigo e acrescenta um novo objeto contendo as novas informacoes
     * @param newObj contem o disco com as novas informacoes
     * @throws ClassCastException ocorre quando e feito cast para o tipo de objeto incorreto
     */
    public void editar(Object newObj) throws ClassCastException{
        Disco newDisc = (Disco) newObj;
        Disco oldDisc = pesquisarDisco(newDisc.getTitulo());
        oldDisc.setDisco(newDisc);
    }
    
    /**
     * Busca na cole��o todos os discos de um determinado int�rprete
     * @param key cont�m a String com o nome do int�rprete
     * @return uma cole��o contendo todos os discos encontrados
     ** @throws ClassCastException ocorre quando � feito cast para o tipo de objeto incorreto
     */
    public ArrayList pesquisar(Object key) throws ClassCastException {
        ArrayList retValue = new ArrayList();
        String procura = (String) key;
        Iterator it = getColecao().iterator();
        while(it.hasNext()){ //verifica se h� um pr�ximo objeto
            Disco disc = (Disco) it.next();
            if (disc.getCantor().equals(procura)){
                retValue.add(disc); //adiciona o objeto na colecao de retorno
            }
        }
        return retValue;
    }
    
    /**
     * Busca na cole��o um determinado disco
     * @param tituloProcura cont�m o nome do disco
     * @return o disco (caso exista) ou null (caso contr�rio)
     */
    public Disco pesquisarDisco(String tituloProcura){
        Disco retValue = null;
        Iterator it = getColecao().iterator();
        while(it.hasNext()){ //verifica se h� um pr�ximo objeto
            Disco disco = (Disco) it.next();
            if (disco.getTitulo().equals(tituloProcura)){
                retValue = disco;
            }
        }
        return retValue;
    }
    
    public String[] listaTitulosDiscos(){
         String[] discos = new String[colecao.size()];
         for (int i=0; i< colecao.size(); i++){
             discos[i] = ((Disco) colecao.get(i)).getTitulo();
         }
         return discos;
    }


    public ArrayList getColecao() {
        return colecao;
    }
}
