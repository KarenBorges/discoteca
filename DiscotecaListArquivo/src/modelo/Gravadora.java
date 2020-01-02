package modelo;

import java.io.Serializable;


/**
 * Write a description of class Gravadora here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gravadora implements Serializable
{
    // instance variables - replace the example below with your own
    private String nome;
    private String cnpj;

     /**
     * Constructor for objects of class Gravadora
     */
    
    public Gravadora(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }
    
    public void setGravadora(Gravadora gravadora){
        this.nome = gravadora.nome;
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return ("Gravadora = " + nome + "\nCNPJ = " + cnpj);
    }

    @Override
    public boolean equals(Object obj) {
         if (obj == null) {
            return false; //nenhum objeto pode ser igual a null
        }
        if (obj instanceof Gravadora == false) { //uma pessoa só pode ser igual a outra pessoa
            return false;
        }
        Gravadora other = (Gravadora) obj;
        if (this.cnpj == null) //se não houver titulo não há como testar 
        {
            return false;
        } else {
            return (this.cnpj.equals(other.cnpj));
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.cnpj != null ? this.cnpj.hashCode() : 0);
        return hash;
    }
    
    
    
    


    
}
