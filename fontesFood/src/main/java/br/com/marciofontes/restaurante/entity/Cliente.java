package br.com.marciofontes.restaurante.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    private String cpf;

    private String nome;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Endereco> enderecoList = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(String cpf, String nome) {
        this.setCpf(cpf);
        this.setNome(nome);
    }

    public void addEndereco(Endereco endereco) {
        endereco.setCliente(this);
        this.enderecoList.add(endereco);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (!validarCPF(cpf)) {
            throw new NumberFormatException("CPF inválido. Deve conter apenas números.");
        }

        this.cpf = cpf;
    }

    public static boolean validarCPF(String cpf) {
        return cpf.matches("\\d+");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (!validarNome(nome)) {
            throw new IllegalArgumentException("Nome inválido. Deve conter apenas letras e acentos.");
        }

        this.nome = nome;
    }

    public static boolean validarNome(String nome) {
        return Pattern.matches("[\\p{L} .'-]+", nome);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", enderecoList=" + enderecoList +
                '}';
    }
}
