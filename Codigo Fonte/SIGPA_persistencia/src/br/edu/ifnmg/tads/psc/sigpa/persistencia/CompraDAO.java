/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.psc.sigpa.persistencia;

import br.edu.ifnmg.tads.psc.sigpa.aplicacao.Compra;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.CompraRepositorio;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.ViolacaoRegraNegocioException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author petronio
 */
public class CompraDAO extends DAOGenerico<Compra> implements CompraRepositorio {

    
    @Override
    protected String consultaAbrir() {
        return "select * from compra where id = ?";
    }

    @Override
    protected String consultaInsert() {
        return "insert into compra (total, descricao, datacompra, previsao, fornecedor_fk) values(?,?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update compra total=?, descricao=?, datacompra=?, previsao=?, fornecedor_fk=? where id = ?";
    }

    @Override
    protected String consultaDelete() {
        return "delete from compra where id=?";
    }

    @Override
    protected String consultaBuscar() {
        return "select * from compra"; 
    }
    

    @Override
    protected void carregaParametros(Compra obj, PreparedStatement consulta) {
        
        try {
            consulta.setLong(1, obj.getValorTotal());
            consulta.setString(2, obj.getDescricao());
            consulta.setDate(3, new java.sql.Date(obj.getDataCompra().getTime()));
            consulta.setDate(4, new java.sql.Date(obj.getPrevisaoChegada().getTime()));
            consulta.setLong(5, obj.getFornecedor());
        } catch (SQLException ex) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected String carregaParametrosBusca(Compra obj){
        String sql = "";
        
        if(obj.getId() > 0)
            sql = this.filtrarPor(sql, "id", Long.toString( obj.getId()));
        
        if(obj.getDescricao()!= null && !obj.getDescricao().isEmpty())
            sql = this.filtrarPor(sql, "descricao", obj.getDescricao());        
        
        return sql;
    }

    @Override
    protected Compra carregaObjeto(ResultSet dados) {
        try {
            Compra obj = new Compra();
            obj.setId(dados.getLong(1));
            obj.setValorTotal(dados.getLong(2));
            obj.setDescricao(dados.getString(3));
            obj.setDataCompra(dados.getDate(4));
            obj.setPrevisaoChegada(dados.getDate(5));
            obj.setFornecedor(dados.getLong(6));
            
            return obj;
            
        } catch (SQLException ex) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ViolacaoRegraNegocioException ex) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
