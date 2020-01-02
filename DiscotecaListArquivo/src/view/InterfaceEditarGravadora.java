/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controle.Comando;

/**
 *
 * @author Karen
 */
public class InterfaceEditarGravadora implements Comando{

    @Override
    public void executar() {
        System.out.println("Editar Gravadora");
    }
    
}
