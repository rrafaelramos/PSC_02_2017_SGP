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
public class Venda implements Entidade{
    private long id;
    private Date data;
    private Cliente cliente;
    private long valorVenda;

    public Venda() {
        
    }

    public Venda(long id, Date data, Cliente cliente, long valorVenda) {
        this.id = id;
        this.data = data;
        this.cliente = cliente;
        this.valorVenda = valorVenda;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public long getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(long valorVenda) {
        this.valorVenda = valorVenda;
    }

    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", data=" + data + ", cliente=" + cliente + ", valorVenda=" + valorVenda + '}';
    }
    
    
}
