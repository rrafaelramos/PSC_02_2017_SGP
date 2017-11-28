/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.psc.sigpa.aplicacao;

import java.util.Date;

/**
 *
 * @author Bruno
 */
public class Cliente extends Pessoa implements Entidade{
    private long limiteCompra;
    
    public Cliente (){
    
    }
    
    
    public Cliente(long limiteCompra) {
        this.limiteCompra = limiteCompra;
    }

    public long getLimiteCompra() {
        return limiteCompra;
    }

    public void setLimiteCompra(long limiteCompra) throws ViolacaoRegraNegocioException{
        if (limiteCompra < 0)
            throw new ViolacaoRegraNegocioException("O limite não pode ser menor Que '0' (Zero)");
        this.limiteCompra = limiteCompra;
    }

    @Override
    public String toString() {
        return "Cliente{" + "limiteCompra=" + limiteCompra + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + (int) (this.limiteCompra ^ (this.limiteCompra >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.limiteCompra != other.limiteCompra) {
            return false;
        }
        return true;
    }
    
    
    
}
