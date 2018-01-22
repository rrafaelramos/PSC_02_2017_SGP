/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.psc.sigpa.persistencia;

import br.edu.ifnmg.tads.psc.sigpa.aplicacao.Fornecedor;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.FornecedorRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author petronio
 */
public class FornecedorDAO extends DAOGenerico<Fornecedor> implements FornecedorRepositorio {

    
    private EnderecoDAO endereco = new EnderecoDAO();
    
    @Override
    protected String consultaAbrir() {
        return "select * from fornecedores where id = ?";
    }

    @Override
    protected String consultaInsert() {
        return "insert into fornecedores (cnpj, endereco_fk, telefone, email, nome, representante) values(?,?,?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update fornecedores cnpj=?, endereco_fk=?, telefone=?, email=?, nome=?, representante=? where id = ?";
    }

    @Override
    protected String consultaDelete() {
        return "delete from fornecedores where id = ?";
    }

    @Override
    protected String consultaBuscar() {
        return "select * from fornecedores"; 
    }
    
    public String  pegaID (){
        
        return "select max(id) from endereco";
    }
    
    public long buscarUltimo() throws SQLException{
              
                String pegaid = pegaID ();
        
                PreparedStatement consultaid = BD.getConexao().prepareStatement(pegaid);
        
                ResultSet retorno = consultaid.executeQuery();
                
                retorno.next();
                    
                long id = retorno.getLong(1);
                return id;        
    }

    @Override
    protected void carregaParametros(Fornecedor obj, PreparedStatement consulta) {
        
        try {
            consulta.setString(1, obj.getCnpj().replace(".", "").replace("-", ""));
            consulta.setLong(2, buscarUltimo());
            consulta.setString(3, obj.getTelefone());
            consulta.setString(4, obj.getEmail());
            consulta.setString(5, obj.getNome());
            consulta.setString(6, obj.getRepresentante());
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected String carregaParametrosBusca(Fornecedor obj){
        String sql = "";
        
        if(obj.getId() > 0)
            sql = this.filtrarPor(sql, "id", Long.toString( obj.getId() ));
        
        if(obj.getNome() != null && !obj.getNome().isEmpty())
            sql = this.filtrarPor(sql, "nome", obj.getNome());
        
        if(obj.getCnpj()!= null && !obj.getCnpj().isEmpty())
            sql = this.filtrarPor(sql, "cnpj", obj.getCnpj().replace(".", "").replace("-", ""));        
        
        return sql;
    }

    @Override
    protected Fornecedor carregaObjeto(ResultSet dados) {
        try {
            Fornecedor obj = new Fornecedor();
            obj.setId(dados.getLong(1));
            obj.setCnpj(dados.getString(2));
            obj.setEndereco(endereco.Abrir(dados.getInt(3)));
            obj.setTelefone(dados.getString(4));
            obj.setEmail(dados.getString(5));
            obj.setNome(dados.getString(6));
            obj.setEmail(dados.getString(7));
            obj.setRepresentante(dados.getString(8));
            
            
            return obj;
            
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
}
