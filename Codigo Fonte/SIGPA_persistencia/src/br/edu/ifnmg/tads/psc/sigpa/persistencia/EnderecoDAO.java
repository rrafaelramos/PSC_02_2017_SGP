/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.psc.sigpa.persistencia;

import br.edu.ifnmg.tads.psc.sigpa.aplicacao.Endereco;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.EnderecoRepositorio;
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
public class EnderecoDAO extends DAOGenerico<Endereco> implements EnderecoRepositorio {
    
    @Override
    protected String consultaAbrir() {
        return "select * from endereco where id = ?";
    }

    @Override
    protected String consultaInsert() {
        return "insert into endereco (rua, num, bairro, cidade, uf, cep) values(?,?,?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update endereco rua=?, num=?, bairro=?, cidade=?, uf=?, cep=?  where id = ?";
    }

    @Override
    protected String consultaDelete() {
        return "delete from endereco where id = ?";
    }

    @Override
    protected String consultaBuscar() {
        return "select * from endereco"; 
    }

    @Override
    protected void carregaParametros(Endereco obj, PreparedStatement consulta) {
        try {
            consulta.setString(1, obj.getRua());
            consulta.setInt(2, obj.getNumero());
            consulta.setString(3, obj.getBairro());
            consulta.setString(4, obj.getCidade());
            consulta.setString(5, obj.getUf());
            consulta.setString(6, obj.getCep().replace(".", "").replace("-", ""));            
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected String carregaParametrosBusca(Endereco obj){
        String sql = "";
        
        if(obj.getId() > 0)
            sql = this.filtrarPor(sql, "id", Long.toString( obj.getId() ));
        
        if(obj.getRua() != null && !obj.getRua().isEmpty())
            sql = this.filtrarPor(sql, "rua", obj.getRua());
        
        if(obj.getBairro() != null && !obj.getBairro().isEmpty())
            sql = this.filtrarPor(sql, "bairro", obj.getBairro());
        
        if(obj.getCidade() != null && !obj.getCidade().isEmpty())
            sql = this.filtrarPor(sql, "cidade", obj.getCidade());
        
        return sql;
    }

    @Override
    protected Endereco carregaObjeto(ResultSet dados) {
        try {
            Endereco obj = new Endereco();
            obj.setId(dados.getLong("id"));
            obj.setRua(dados.getString("rua"));
            obj.setNumero(dados.getInt("num"));
            obj.setBairro(dados.getString("bairro"));
            obj.setCidade(dados.getString("cidade"));
            obj.setUf(dados.getString("uf"));
            obj.setCep(dados.getString("cep").replace(".", "").replace("-", ""));
            
            
            return obj;
            
        } catch (SQLException | ViolacaoRegraNegocioException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    

}
