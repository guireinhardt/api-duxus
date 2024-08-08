package br.com.duxusdesafio.dto;

import java.time.LocalDate;

public class TimeDto {

    private LocalDate data;
    private String nome;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
