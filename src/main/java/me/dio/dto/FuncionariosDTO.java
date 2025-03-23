package me.dio.dto;

import java.util.Date;

public class FuncionariosDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private Date aniversario;
    private String cargo;
    private String salario;
    private Long agencia_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getAniversario() {
        return aniversario;
    }

    public void setAniversario(Date aniversario) {
        this.aniversario = aniversario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public Long getAgencia_id() {
        return agencia_id;
    }

    public void setAgencia_id(Long agencia_id) {
        this.agencia_id = agencia_id;
    }

}
