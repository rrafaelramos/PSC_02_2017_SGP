/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.psc.sigpa.persistencia;

import br.edu.ifnmg.tads.psc.sigpa.aplicacao.Cliente;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.ClienteRepositorio;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.Endereco;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.Sexo;
import br.edu.ifnmg.tads.psc.sigpa.aplicacao.ViolacaoRegraNegocioException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author petronio
 */
public class ClienteDAO extends DAOGenerico<Cliente> implements ClienteRepositorio {

    
    private EnderecoDAO endereco = new EnderecoDAO();
    
    @Override
    protected String consultaAbrir() {
        return "select * from clientes where id = ?";
    }

    @Override
    protected String consultaInsert() {
        return "insert into clientes (nome, cpf, rg, nascimento, sexo, email, endereco_fk, telefone, limite) values(?,?,?,?,?,?,?,?,?)";
    }

    @Override
    protected String consultaUpdate() {
        return "update clientes nome=?, cpf=?, rg=?, nascimento=?, sexo=?, email=?, endereco_fk=?, telefone=?, limite=? where id = ?";
    }

    @Override
    protected String consultaDelete() {
        return "delete from clientes where id = ?";
    }

    @Override
    protected String consultaBuscar() {
        return "select * from clientes "; 
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
    protected void carregaParametros(Cliente obj, PreparedStatement consulta) {
        
        try {
            consulta.setString(1, obj.getNome());
            consulta.setString(2, obj.getCpf().replace(".", "").replace("-", ""));
            consulta.setString(3, obj.getRg());
            consulta.setDate(4, new java.sql.Date(obj.getNascimento().getTime()));// Convertendo a data para sql
            consulta.setString(5, obj.getSexo().getValor());
            consulta.setString(6, obj.getEmail());
            consulta.setLong(7, buscarUltimo());
            consulta.setString(8,obj.getTelefone());
            consulta.setBigDecimal(9, obj.getLimite());
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected String carregaParametrosBusca(Cliente obj){
        String sql = "";
        
        if(obj.getId() > 0)
            sql = this.filtrarPor(sql, "id", Long.toString( obj.getId() ));
        
        if(obj.getNome() != null && !obj.getNome().isEmpty())
            sql = this.filtrarPor(sql, "nome", obj.getNome());
        
        if(obj.getCpf() != null && !obj.getCpf().isEmpty())
            sql = this.filtrarPor(sql, "cpf", obj.getCpf().replace(".", "").replace("-", ""));        
        
        return sql;
    }

    @Override
    protected Cliente carregaObjeto(ResultSet dados) {
        try {
            Cliente obj = new Cliente();
            obj.setId(dados.getLong(1));
            obj.setNome(dados.getString(2));
            obj.setCpf(dados.getString(3));
            obj.setRg(dados.getString(4));
            obj.setNascimento(dados.getDate(5));
            obj.setSexo(Sexo.parse(dados.getString(6)));
            obj.setEmail(dados.getString(7));
            obj.setEndereco(endereco.Abrir(dados.getInt(8)));
            obj.setTelefone(dados.getString(9));
            obj.setLimite(dados.getBigDecimal(10));
            
            return obj;
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ViolacaoRegraNegocioException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    
    
}
