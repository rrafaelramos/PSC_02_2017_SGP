/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.psc.sigpa.aplicacao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class Venda implements Entidade{
    private long id;
    private Date data;
    private Cliente cliente;
    private BigDecimal valorVenda;

    public Venda() {
    }

    public Venda(long id, Date data, Cliente cliente, BigDecimal valorVenda) {
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

    public BigDecimal getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }
    
    private List<VendaItem> itens;
    
    public List<VendaItem> getItens() {
        return itens;
    }

    public void setItens(List<VendaItem> itens) {
        this.itens = itens;
    }
    
    public void addItem(VendaItem item){
        if(!this.itens.contains(item)){
            item.setVenda(this);
            itens.add(item);
            this.valorVenda = this.valorVenda.add(item.getValorTotal());
        }
    }
    
    public void removeItem(VendaItem item){
        if(this.itens.contains(item)){
            itens.remove(item);
            this.valorVenda = this.valorVenda.subtract(item.getValorTotal());
        }
    }

    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", data=" + data + ", cliente=" + cliente + ", valorVenda=" + valorVenda + '}';
    }
    
    
}
