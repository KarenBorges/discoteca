package modelo;

import java.io.Serializable;

/**
 * Write a description of class Disco here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Disco implements Serializable{
    // instance variables - replace the example below with your own

    private String titulo;
    private Interprete cantor;
    private Gravadora gravadora;
    private int nroFaixas;
    private int ano;

    public Disco(String titulo, Interprete cantor, Gravadora gravadora, int nroFaixas, int ano) {
        this.titulo = titulo;
        this.cantor = cantor;
        this.gravadora = gravadora;
        this.nroFaixas = nroFaixas;
        this.ano = ano;
    }
    
    public void setDisco(Disco outro) {
        this.titulo = outro.titulo;
        this.cantor = outro.cantor;
        this.gravadora = outro.gravadora;
        this.nroFaixas = outro.nroFaixas;
        this.ano = outro.ano;
    }

    public int getAno() {
        return ano;
    }

    public Interprete getCantor() {
        return cantor;
    }

    public Gravadora getGravadora() {
        return gravadora;
    }

    public int getNroFaixas() {
        return nroFaixas;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setCantor(Interprete cantor) {
        this.cantor = cantor;
    }

    public void setGravadora(Gravadora gravadora) {
        this.gravadora = gravadora;
    }

    public void setNroFaixas(int nroFaixas) {
        this.nroFaixas = nroFaixas;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        System.out.println("ok!");
        return titulo;
    }
    
     

    @Override
    public String toString() {
        return ("\nTítulo do disco: " + this.getTitulo() 
                + "\n" + cantor 
                + "\n" + gravadora 
                + "\nNumero de faixas: " + this.getNroFaixas()
                + "\nAno: " + this.getAno());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false; //nenhum objeto pode ser igual a null
        }
        if (obj instanceof Disco == false) { //uma pessoa só pode ser igual a outra pessoa
            return false;
        }
        Disco other = (Disco) obj;
        if (this.titulo == null) //se não houver titulo não há como testar 
        {
            return false;
        } else {
            return ((this.titulo.equals(other.titulo))
                    && (this.cantor.equals(other.cantor)));
        }
    } // fecha equals

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (this.titulo != null ? this.titulo.hashCode() : 0);
        hash = 19 * hash + (this.cantor != null ? this.cantor.hashCode() : 0);
        return hash;
    }

    
}
