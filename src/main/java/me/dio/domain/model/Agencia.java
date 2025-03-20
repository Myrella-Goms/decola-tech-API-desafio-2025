package me.dio.domain.model;

import jakarta.persistence.*;
import java.util.List;

@Entity(name = "tab_agencia")
public class Agencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agencia")
    private Long id;
    @Column(name = "numero", nullable = false)
    private String numero;
    @Column(name = "unidade_agencia", nullable = false)
    private String unidade;
    @Column(name = "CEP_agencia", nullable = false)
    private String CEP;
    @Column(name = "cidade_agencia", nullable = false)
    private String cidade;
    @Column(name = "estado_agencia", nullable = false)
    private String estado;
    @Column(name = "status_agencia")
    private String status;
    @OneToMany(mappedBy = "agencia", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Cliente> clientes;
    @OneToMany(mappedBy = "agencia", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Funcionarios> funcionarios;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Funcionarios> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionarios> funcionarios) {
        this.funcionarios = funcionarios;
    }

}
