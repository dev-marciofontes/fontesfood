package br.com.marciofontes.restaurante.entity;

import javax.persistence.*;
import java.util.regex.Pattern;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    private String cpf;

    private String nome;

    private String cep;

    public Cliente() {
    }

    public Cliente(String cpf, String nome, String cep) {
        this.setCpf(cpf);
        this.setNome(nome);
        this.setCep(cep);
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        if (!validarCEP(cep)) {
            throw new NumberFormatException("CEP inválido. Deve conter apenas números.");
        }
        this.cep = cep;
    }

    public static boolean validarCEP(String cep) {
        return cep.matches("\\d+");
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
