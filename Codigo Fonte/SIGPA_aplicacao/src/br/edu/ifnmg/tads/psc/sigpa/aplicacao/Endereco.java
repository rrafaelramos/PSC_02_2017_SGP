/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.psc.sigpa.aplicacao;

/**
 *
 * @author Rafael
 */
public class Endereco implements Entidade{
    long id;
    private String rua, bairro, cidade, complemento, uf, cep;
    private int numero;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) throws ViolacaoRegraNegocioException{
        if(rua == null || rua.isEmpty())
            throw new ViolacaoRegraNegocioException("O campo 'Rua' não pode estar vazio!");
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) throws ViolacaoRegraNegocioException{
        if(bairro == null || bairro.isEmpty())
            throw new ViolacaoRegraNegocioException("O campo 'Bairro' não pode estar vazio!");
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) throws ViolacaoRegraNegocioException{
        if(cidade == null || cidade.isEmpty())
            throw new ViolacaoRegraNegocioException("O campo 'Cidade' não pode estar vazio!");
        this.cidade = cidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getUf(){
        return uf;
    }

    public void setUf(String uf) throws ViolacaoRegraNegocioException{
        if (uf.length() != 2) 
            throw new ViolacaoRegraNegocioException("UF deve conter 2 Caracteres");
        this.uf = uf;
    }

    public int getNumero(){
        return numero;
    }

    public void setNumero(int numero)  throws ViolacaoRegraNegocioException{
        if (numero <= 0)
            throw new ViolacaoRegraNegocioException("Número Inválido");
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Endereco{" + "id=" + id + ", rua=" + rua + ", bairro=" + bairro + ", cidade=" + cidade + ", complemento=" + complemento + ", uf=" + uf + ", numero=" + numero + '}';
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep){
        this.cep = cep;
    }
}
