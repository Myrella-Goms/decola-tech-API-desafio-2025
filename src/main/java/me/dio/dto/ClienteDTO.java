package me.dio.dto;

public class ClienteDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String senha;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getAgencia_id() {
        return agencia_id;
    }

    public void setAgencia_id(Long agencia_id) {
        this.agencia_id = agencia_id;
    }


}