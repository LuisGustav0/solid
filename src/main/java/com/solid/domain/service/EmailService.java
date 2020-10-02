package com.solid.domain.service;

import lombok.Data;

@Data
public class EmailService {

    private String de;
    private String para;
    private String assunto;
    private String conteudo;

    public EmailService() {
        this.de = "contato@site.com.br";
        this.para = "";
        this.assunto = "";
        this.conteudo = "";
    }

    void enviar() {
        System.out.println("De: " + this.de);
        System.out.println("Para: " + this.para);
        System.out.println("Assunto: " + this.assunto);
        System.out.println("Conteudo: " + this.conteudo);
    }
}
