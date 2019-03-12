package br.com.fwtj.MavenJSfPrimefaces.rest;

/**
 * Autor: Fred William Torno Junior
 * E-Mail: fredwilliam@gmail.com / fredwilliam@outlook.com
 * Site: www.fwtj.com.br
 * Telefone: (22) 9-8136-5786
 * Data: 10/04/2018
 * Hora: 13:57
 * Copyright©Fwtj Sistemas. Todos os direitos reservados.
 */
public class UrlRest {

    private String url;
    private String descricao;

    public UrlRest() {
    }

    public UrlRest(String url, String descricao) {
        this.url = url;
        this.descricao = descricao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
