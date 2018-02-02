/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.psc.sigpa.aplicacao;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Bruno
 */
public class Compra implements Entidade{
    private long id;
    private long valorTotal;
    private String descricao;
    private Fornecedor fornecedor;
    private Date dataCompra, previsaoChegada;

    public Compra() {
    }

    public Compra(long id, long valorTotal, String descricao, Date dataCompra, Date previsaoChegada, Funcionario funcionario, Fornecedor fornecedor) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.descricao = descricao;
        this.dataCompra = dataCompra;
        this.previsaoChegada = previsaoChegada;
        this.fornecedor = fornecedor;
    }
    
    
    
    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public long getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(long valorTotal) throws ViolacaoRegraNegocioException {
        if (valorTotal < 0)
            throw new ViolacaoRegraNegocioException("O Valor total deve ser maior ou igual a '0' (Zero)");
        this.valorTotal = valorTotal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Date getPrevisaoChegada() {
        return previsaoChegada;
    }

    public void setPrevisaoChegada(Date previsaoChegada) {
        this.previsaoChegada = previsaoChegada;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 47 * hash + (int) (this.valorTotal ^ (this.valorTotal >>> 32));
        hash = 47 * hash + Objects.hashCode(this.descricao);
        hash = 47 * hash + Objects.hashCode(this.dataCompra);
        hash = 47 * hash + Objects.hashCode(this.previsaoChegada);
        hash = 47 * hash + Objects.hashCode(this.fornecedor);
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
        final Compra other = (Compra) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.valorTotal != other.valorTotal) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.dataCompra, other.dataCompra)) {
            return false;
        }
        if (!Objects.equals(this.previsaoChegada, other.previsaoChegada)) {
            return false;
        }
        if (!Objects.equals(this.fornecedor, other.fornecedor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Compra{" + "id=" + id + ", valorTotal=" + valorTotal + ", descricao=" + descricao + ", dataCompra=" + dataCompra + ", previsaoChegada=" + previsaoChegada + ", fornecedor=" + fornecedor + '}';
    }
    
    
    
}
