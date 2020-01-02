package modelo;

import java.util.ArrayList;
/*
 * OperacoesDAO.java
 *
 * Created on 16 de Outubro de 2006, 21:21
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author kborges
 */
public interface OperacoesDAO {
    
    public void inserir (Object obj);
    
    public void excluir (Object obj);
    
    public void editar (Object newObj);
    
    public ArrayList pesquisar(Object key);
    
}
