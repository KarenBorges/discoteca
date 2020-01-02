
package modelo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Karen
 */
public class GravadoraDAO implements OperacoesDAO{
    
    private ArrayList colecao;
    private static GravadoraDAO gravadoras = null;

    /**
     * Cria uma nova instancia de GravadoraDAO
     * Cria a colecao de objetos
     */
    public GravadoraDAO(ArrayList colecao) {
        this.colecao = colecao;
        gravadoras = this;
    }
    
    /**
     * @return a instância de GravadoraDAO 
     */
    public static GravadoraDAO getInstance(){
        return gravadoras;
    }
    
    /**
     * Insere uma Gravadora na colecao
     * @param obj contem a gravadora que sera inserida
     */
    public void inserir(Object obj) {
        getColecao().add(obj);
    }
    
    /**
     * Exclui uma Gravadora da colecao
     * @param obj contem a gravadra que sera excluida
     */
    public void excluir(Object obj) {
        getColecao().remove(obj);
    }
    
    /**
     * Remove o objeto antigo e acrescenta um novo objeto contendo as novas informacoes
     * @param newObj contem a gravadora com as novas informacoes
     * @throws ClassCastException ocorre quando e feito cast para o tipo de objeto incorreto
     */
    public void editar(Object newObj) throws ClassCastException{
        Gravadora newGrav = (Gravadora) newObj;
        Gravadora oldGrav = pesquisarGravadora(newGrav.getCnpj());
        oldGrav.setGravadora(newGrav);
    }
    
    /**
     * Ainda sem finalidade
     */
    public ArrayList pesquisar(Object key){
        return null;
    }
    
    /**
     * Busca na colecao�uma determinada Gravadora
     * @param nomejProcura contem o nome da gravadora
     * @return a gravadora (caso exista) ou null (caso contrario)
     */
    public Gravadora pesquisarGravadora(String nomeProcura){
        Gravadora retValue = null;
        Iterator it = getColecao().iterator();
        while(it.hasNext()){ //verifica se h� um pr�ximo objeto
            Gravadora grav = (Gravadora) it.next();
            if (grav.getNome().equals(nomeProcura)){
                retValue = grav;
            }
        }
        return retValue;
    }
    
    public String[] listaNomesGravadoras(){
         String[] gravadoras = new String[colecao.size()];
         for (int i=0; i< colecao.size(); i++){
             gravadoras[i] = ((Gravadora) colecao.get(i)).getNome();
         }
         return gravadoras;
    }

    public ArrayList getColecao() {
        return colecao;
    }
}
