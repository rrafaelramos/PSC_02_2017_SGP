/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.psc.sigpa.aplicacao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Bruno
 */
public class Cliente extends Pessoa implements Entidade{
    private BigDecimal limite;

    public Cliente(long id, String cpf, String rg, String nome, String email, String telefone, Sexo sexo, Date nascimento, Long endereco) {
        super(id, cpf, rg, nome, email, telefone, sexo, nascimento, endereco);
    }

    public Cliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     */
   


    
    public void setLimite(BigDecimal limite){
        this.limite = limite;
    }
        
    public BigDecimal getLimite() {
        return limite;
    }

    /* como comparar big deciaml
    public void setLimite(BigDecimal limite) throws ViolacaoRegraNegocioException{
        if (limite <0) {
        } else {
            throw new ViolacaoRegraNegocioException("O limite não pode ser menor Que '0' (Zero)");
        }
        this.limite = limite;
    }*/

    @Override
    public String toString() {
        return "Cliente{" + "limite=" + limite + '}';
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
        if (this.limite != other.limite) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.limite);
        return hash;
    }

    public void setLimite() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
