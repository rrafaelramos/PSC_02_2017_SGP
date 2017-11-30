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
public class Pessoa implements Entidade{
    private long id;
    private String cpf, rg, nome, email, telefone;
    private char sexo;
    private Date nascimento;
    private Endereco endereco;

    public Pessoa(long id, String cpf, String rg, String nome, String email, String telefone, char sexo, Date nascimento, Endereco endereco) {
        this.id = id;
        this.cpf = cpf;
        this.rg = rg;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.sexo = sexo;
        this.nascimento = nascimento;
        this.endereco = endereco;
    }

    public Pessoa() {
        endereco = new Endereco();
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws ViolacaoRegraNegocioException{
        if (cpf == null || cpf.isEmpty() || cpf.length() != 11)
            throw new ViolacaoRegraNegocioException("CPF inválido!");
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }
    
    // falta validar RG
    public void setRg(String rg) throws ViolacaoRegraNegocioException{
        if (rg == null || rg.isEmpty())
            throw new ViolacaoRegraNegocioException("Digite um RG");
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws ViolacaoRegraNegocioException{
        if (nome == null || nome.isEmpty() || nome.length()<3 || nome.length() > 200  )
            throw new ViolacaoRegraNegocioException("O Nome deve conter no mínimo 3 caracteres");
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    
    //falta validar email
    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) throws ViolacaoRegraNegocioException{
        if (sexo != 'm' && sexo!= 'M' && sexo!= 'f' && sexo!= 'F' )
            throw new ViolacaoRegraNegocioException("O Sexo deve ser do tipo M ou F");
        this.sexo = sexo;
    }

    public Date getNascimento() {
        return nascimento;
    }

    // falta validar o nascimento
    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) throws ViolacaoRegraNegocioException{
        if (endereco == null)
            throw new ViolacaoRegraNegocioException("Endereço de preenchimento obrigatório");
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", telefone=" + telefone + ", endereco=" + endereco + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 71 * hash + Objects.hashCode(this.cpf);
        hash = 71 * hash + Objects.hashCode(this.rg);
        hash = 71 * hash + Objects.hashCode(this.nome);
        hash = 71 * hash + Objects.hashCode(this.email);
        hash = 71 * hash + Objects.hashCode(this.telefone);
        hash = 71 * hash + this.sexo;
        hash = 71 * hash + Objects.hashCode(this.nascimento);
        hash = 71 * hash + Objects.hashCode(this.endereco);
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
        final Pessoa other = (Pessoa) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.sexo != other.sexo) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.rg, other.rg)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.nascimento, other.nascimento)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
