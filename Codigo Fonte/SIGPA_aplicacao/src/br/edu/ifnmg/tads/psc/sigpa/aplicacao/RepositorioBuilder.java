/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.psc.sigpa.aplicacao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author petronio
 */
public class RepositorioBuilder {
    
    private static InputStream arquivo;  // Representa o arquivo físico no disco
    private static Properties prop;      // Responsável por carregar as configurações dentro do arquivo
    
    
    static {
        try {
            arquivo = RepositorioBuilder.class.getResourceAsStream("/config.properties"); //new FileInputStream("config.properties");
            prop = new Properties();
            prop.load(arquivo);
            
        } catch (IOException ex) {
            
            Logger.getLogger(RepositorioBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private static ClienteRepositorio cliente;
    
    public static ClienteRepositorio getClienteRepositorio(){
        if(cliente == null){
            try {
                
                // Carrega a classe
                Class obj = Class.forName(prop.getProperty("ClienteRepositorio"));
                
                // Cria uma nova instância da classe
                cliente = (ClienteRepositorio)obj.newInstance();
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(RepositorioBuilder.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(RepositorioBuilder.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(RepositorioBuilder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cliente;
    }
    
    
    
    
    private static EnderecoRepositorio endereco;
    
    public static EnderecoRepositorio getEnderecoRepositorio() throws ClassNotFoundException{
        if(endereco == null){
                
                // Carrega a classe
                Class obj = Class.forName(prop.getProperty("EnderecoRepositorio"));
                
            try {
                // Cria uma nova instância da classe
                endereco = (EnderecoRepositorio)obj.newInstance();
            } catch (InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(RepositorioBuilder.class.getName()).log(Level.SEVERE, null, ex);
            }
                         
        }
        return endereco;
    }
    
     private static FuncionarioRepositorio funcionario;
    
    public static FuncionarioRepositorio getFuncionarioRepositorio() throws ClassNotFoundException{
        if(funcionario == null){
                
                // Carrega a classe
                Class obj = Class.forName(prop.getProperty("FuncionarioRepositorio"));
                
            try {
                // Cria uma nova instância da classe
                funcionario = (FuncionarioRepositorio)obj.newInstance();
            } catch (InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(RepositorioBuilder.class.getName()).log(Level.SEVERE, null, ex);
            }
                         
        }
        return funcionario;
    }
    
    private static FornecedorRepositorio fornecedor;
    
    public static FornecedorRepositorio getFornecedorRepositorio() throws ClassNotFoundException{
        if(fornecedor == null){
                
                // Carrega a classe
                Class obj = Class.forName(prop.getProperty("FornecedorRepositorio"));
                
            try {
                // Cria uma nova instância da classe
                fornecedor = (FornecedorRepositorio)obj.newInstance();
            } catch (InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(RepositorioBuilder.class.getName()).log(Level.SEVERE, null, ex);
            }
                         
        }
        return fornecedor;
    }
    
    
    
    private static ItemFinanceiroRepositorio itemFinanceiro;
    
    public static ItemFinanceiroRepositorio getItemFinanceiroRepositorio() throws ClassNotFoundException{
        if(itemFinanceiro == null){
                
                // Carrega a classe
                Class obj = Class.forName(prop.getProperty("ItemFinanceiroRepositorio"));
                
            try {
                // Cria uma nova instância da classe
                itemFinanceiro = (ItemFinanceiroRepositorio)obj.newInstance();
            } catch (InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(RepositorioBuilder.class.getName()).log(Level.SEVERE, null, ex);
            }
                         
        }
        return itemFinanceiro;
    }
    
    
    private static ContasPagarRepositorio contasPagar;
    
    public static ContasPagarRepositorio getContasPagarRepositorio() throws ClassNotFoundException{
        if(contasPagar == null){
                
                // Carrega a classe
                Class obj = Class.forName(prop.getProperty("ContasPagarRepositorio"));
                
            try {
                // Cria uma nova instância da classe
                contasPagar = (ContasPagarRepositorio)obj.newInstance();
            } catch (InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(RepositorioBuilder.class.getName()).log(Level.SEVERE, null, ex);
            }
                         
        }
        return contasPagar;
    }
    
    private static CompraRepositorio compra;
    
    public static CompraRepositorio getCompraRepositorio() throws ClassNotFoundException{
        if(compra == null){
                
                // Carrega a classe
                Class obj = Class.forName(prop.getProperty("CompraRepositorio"));
                
            try {
                // Cria uma nova instância da classe
                compra = (CompraRepositorio)obj.newInstance();
            } catch (InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(RepositorioBuilder.class.getName()).log(Level.SEVERE, null, ex);
            }
                         
        }
        return compra;
    }
    
    private static VendaRepositorio venda;
    
    public static VendaRepositorio getVendaRepositorio() throws ClassNotFoundException{
        if(venda == null){
                
                // Carrega a classe
                Class obj = Class.forName(prop.getProperty("VendaRepositorio"));
                
            try {
                // Cria uma nova instância da classe
                venda = (VendaRepositorio)obj.newInstance();
            } catch (InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(RepositorioBuilder.class.getName()).log(Level.SEVERE, null, ex);
            }
                         
        }
        return venda;
    }
    
    
    
   /* private static ProdutoRepositorio produto;
    
    public static ProdutoRepositorio getProdutoRepositorio(){
        if(produto == null){
            try {
                
                // Carrega a classe
                Class obj = Class.forName(prop.getProperty("ProdutoRepositorio"));
                
                // Cria uma nova instância da classe
                produto = (ProdutoRepositorio)obj.newInstance();
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(RepositorioBuilder.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(RepositorioBuilder.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(RepositorioBuilder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return produto;
    }*/

    
    
}
