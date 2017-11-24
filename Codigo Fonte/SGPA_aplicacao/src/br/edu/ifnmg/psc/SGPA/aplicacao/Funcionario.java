/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.psc.SGPA.aplicacao;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Bruno
 */
public class Funcionario extends Pessoa implements Entidade{
    private String password, userName, cargo;
    private long salario; 
    private int tipo;
    private Date dataAdmissao;

    public Funcionario(String password, String userName, String cargo, long salario, int tipo, Date dataAdmissao) {
        this.password = password;
        this.userName = userName;
        this.cargo = cargo;
        this.salario = salario;
        this.tipo = tipo;
        this.dataAdmissao = dataAdmissao;
    }

    public Funcionario() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public long getSalario() {
        return salario;
    }

    public void setSalario(long salario) {
        this.salario = salario;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.password);
        hash = 79 * hash + Objects.hashCode(this.userName);
        hash = 79 * hash + Objects.hashCode(this.cargo);
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
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        if (!Objects.equals(this.cargo, other.cargo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "password=" + password + ", userName=" + userName + ", cargo=" + cargo + ", salario=" + salario + ", tipo=" + tipo + ", dataAdmissao=" + dataAdmissao + '}';
    }
    
    
}
