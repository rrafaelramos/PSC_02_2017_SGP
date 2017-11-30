/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.psc.sigpa.aplicacao;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author Bruno
 */
public class Cliente extends Pessoa implements Entidade{
    private BigDecimal limiteCompra;
    
    public Cliente (){
    
    }
    
    
    public Cliente(BigDecimal limiteCompra) {
        this.limiteCompra = limiteCompra;
    }

    public BigDecimal getLimiteCompra() {
        return limiteCompra;
    }

    /* como comparar big deciaml
    public void setLimiteCompra(BigDecimal limiteCompra) throws ViolacaoRegraNegocioException{
        if (limiteCompra <0) {
        } else {
            throw new ViolacaoRegraNegocioException("O limite não pode ser menor Que '0' (Zero)");
        }
        this.limiteCompra = limiteCompra;
    }*/

    @Override
    public String toString() {
        return "Cliente{" + "limiteCompra=" + limiteCompra + '}';
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.limiteCompra);
        return hash;
    }
    
    
    
}
