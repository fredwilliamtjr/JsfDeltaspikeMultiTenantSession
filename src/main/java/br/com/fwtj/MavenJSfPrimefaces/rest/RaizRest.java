package br.com.fwtj.MavenJSfPrimefaces.rest;

import java.util.ArrayList;
import java.util.List;

/**
 * Autor: Fred William Torno Junior
 * E-Mail: fredwilliam@gmail.com / fredwilliam@outlook.com
 * Site: www.fwtj.com.br
 * Telefone: (22) 9-8136-5786
 * Data: 10/04/2018
 * Hora: 13:56
 * Copyright©Fwtj Sistemas. Todos os direitos reservados.
 */
public class RaizRest {

    private String nome;
    private String urlBase;
    private List<UrlRest> urls = new ArrayList<>();

    public RaizRest() {
    }

    public RaizRest(String nome, String urlBase) {
        this.nome = nome;
        this.urlBase = urlBase;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrlBase() {
        return urlBase;
    }

    public void setUrlBase(String urlBase) {
        this.urlBase = urlBase;
    }

    public List<UrlRest> getUrls() {
        return urls;
    }

    public void setUrls(List<UrlRest> urls) {
        this.urls = urls;
    }

    @Override
    public String toString() {
        return "RaizRest{" +
                "nome='" + nome + '\'' +
                ", urlBase='" + urlBase + '\'' +
                ", urls=" + urls +
                '}';
    }
}
