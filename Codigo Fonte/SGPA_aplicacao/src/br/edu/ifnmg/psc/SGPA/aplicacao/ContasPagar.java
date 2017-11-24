/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.SGPA.aplicacao;

import java.util.Date;
import java.util.Objects;


/**
 *
 * @author Bruno
 */
public class ContasPagar implements Entidade{
    private long id;
    private String descricao;
    private long valor;
    private Date vencimento;

    public ContasPagar() {
    }

    public ContasPagar(int id, String descricao, long valor, Date vencimento) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.vencimento = vencimento;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) throws ViolacaoRegraNegocioException{
        if(valor <= 0)
            throw new ViolacaoRegraNegocioException("O valor deve ser maior que '0' (Zero)");
        this.valor = valor;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    @Override
    public String toString() {
        return "ContasPagar{" + "descricao=" + descricao + ", valor=" + valor + ", vencimento=" + vencimento + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + Objects.hashCode(this.descricao);
        hash = 97 * hash + (int) (this.valor ^ (this.valor >>> 32));
        hash = 97 * hash + Objects.hashCode(this.vencimento);
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
        final ContasPagar other = (ContasPagar) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.valor != other.valor) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.vencimento, other.vencimento)) {
            return false;
        }
        return true;
    }
    
    
}
