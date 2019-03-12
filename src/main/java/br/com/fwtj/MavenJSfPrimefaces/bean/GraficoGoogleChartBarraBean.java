package br.com.fwtj.MavenJSfPrimefaces.bean;

import br.com.fwtj.MavenJSfPrimefaces.util.googlecharts.GoogleChartsUtils;
import br.com.fwtj.MavenJSfPrimefaces.util.googlecharts.LinhaGoogleChartsUmaColuna;
import br.com.fwtj.MavenJSfPrimefaces.util.jsf.FacesUtil;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Autor: Fred William Torno Junior
 * E-Mail: fredwilliam@gmail.com / fredwilliam@outlook.com
 * Site: www.fwtj.com.br
 * Telefone: (22) 9-8136-5786
 * Data: 20/04/2018
 * Hora: 15:23
 * Copyright©Fwtj Sistemas. Todos os direitos reservados.
 */
@Named
@ViewScoped
public class GraficoGoogleChartBarraBean implements Serializable {

    private String dados = "";

    public String getDados() {
        return dados;
    }

    @PostConstruct
    private void init() {

        List<LinhaGoogleChartsUmaColuna> linhaGoogleChartsUmaColunaList = new ArrayList<>();
        linhaGoogleChartsUmaColunaList.add(new LinhaGoogleChartsUmaColuna("11h", "123.56"));
        linhaGoogleChartsUmaColunaList.add(new LinhaGoogleChartsUmaColuna("12h", "193.56"));
        linhaGoogleChartsUmaColunaList.add(new LinhaGoogleChartsUmaColuna("13h", "223.56"));
        linhaGoogleChartsUmaColunaList.add(new LinhaGoogleChartsUmaColuna("14h", "23.56"));

        dados = GoogleChartsUtils.dadosGraficoUmaColuna("Hora", "Valor", linhaGoogleChartsUmaColunaList);
    }

    public void voltar() throws IOException {
        FacesUtil.redirect("/index");
        //FacesUtil.forward("/index.xhtml");
    }



}
