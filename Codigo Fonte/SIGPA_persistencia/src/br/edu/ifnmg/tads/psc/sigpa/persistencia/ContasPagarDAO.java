/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.psc.sigpa.persistencia;

import br.edu.ifnmg.tads.psc.sigpa.aplicacao.ContasPagar;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.ContasPagarRepositorio;
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
public class ContasPagarDAO extends DAOGenerico<ContasPagar> implements ContasPagarRepositorio {
    
    @Override
    protected String consultaAbrir() {
        return "select * from contasapagar where id = ?";
    }

    @Override
    protected String consultaInsert() {
        return "insert into contasapagar (descricao, valor, vencimento) values(?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update contasapagar descricao=?, valor=?, vencimento=?  where id = ?";
    }

    @Override
    protected String consultaDelete() {
        return "delete from contasapagar where id = ?";
    }

    @Override
    protected String consultaBuscar() {
        return "select * from contasapagar"; 
    }

    @Override
    protected void carregaParametros(ContasPagar obj, PreparedStatement consulta) {
        try {
            consulta.setString(1, obj.getDescricao());
            consulta.setFloat(2, obj.getValor());
            consulta.setDate(3, new java.sql.Date(obj.getVencimento().getTime()));
        } catch (SQLException ex) {
            Logger.getLogger(ContasPagarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected String carregaParametrosBusca(ContasPagar obj){
        String sql = "";
        
        if(obj.getId() > 0)
            sql = this.filtrarPor(sql, "id", Long.toString( obj.getId() ));
        
       // if(obj.getDescricao()!= null && !obj.getDescricao().isEmpty())
           // sql = this.filtrarPor(sql, "descricao", obj.getDescricao());
        
        return sql;
    }

    @Override
    protected ContasPagar carregaObjeto(ResultSet dados) {
        try {
            ContasPagar obj = new ContasPagar();
            obj.setId(dados.getLong(1));
            obj.setDescricao(dados.getString(2));
            obj.setValor(dados.getLong(3));
            obj.setVencimento(dados.getDate(4));

            return obj;
            
        } catch (SQLException | ViolacaoRegraNegocioException ex) {
            Logger.getLogger(ContasPagarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    
    

}
