package br.com.fwtj.MavenJSfPrimefaces.rest;

/**
 * Autor: Fred William Torno Junior
 * E-Mail: fredwilliam@gmail.com / fredwilliam@outlook.com
 * Site: www.fwtj.com.br
 * Telefone: (22) 9-8136-5786
 * Data: 10/04/2018
 * Hora: 10:19
 * Copyright©Fwtj Sistemas. Todos os direitos reservados.
 */
public class RespostaRest {

    public String resposta;

    public RespostaRest() {
    }

    public RespostaRest(String resposta) {
        this.resposta = resposta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}
