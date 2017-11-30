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
public class Caixa implements Entidade{
    private long id, entrada, saida, fechamento;
    private Date data;

    public Caixa() {
    }

    public Caixa(long id, long entrada, long saida, long fechamento, Date data) {
        this.id = id;
        this.entrada = entrada;
        this.saida = saida;
        this.fechamento = fechamento;
        this.data = data;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public long getEntrada() {
        return entrada;
    }

    public void setEntrada(long entrada) throws ViolacaoRegraNegocioException{
        if(entrada <= 0)
            throw new ViolacaoRegraNegocioException("o valor de entrada deve ser maior que: '0' (Zero)");
        this.entrada = entrada;
    }

    public long getSaida() {
        return saida;
    }

    public void setSaida(long saida) {
        this.saida = saida;
    }

    public long getFechamento() {
        return fechamento;
    }

    public void setFechamento(long fechamento) {
        this.fechamento = fechamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + (int) (this.entrada ^ (this.entrada >>> 32));
        hash = 97 * hash + (int) (this.saida ^ (this.saida >>> 32));
        hash = 97 * hash + (int) (this.fechamento ^ (this.fechamento >>> 32));
        hash = 97 * hash + Objects.hashCode(this.data);
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
        final Caixa other = (Caixa) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.entrada != other.entrada) {
            return false;
        }
        if (this.saida != other.saida) {
            return false;
        }
        if (this.fechamento != other.fechamento) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Caixa{" + "entrada=" + entrada + ", saida=" + saida + ", fechamento=" + fechamento + ", data=" + data + '}';
    }
    
    
}
