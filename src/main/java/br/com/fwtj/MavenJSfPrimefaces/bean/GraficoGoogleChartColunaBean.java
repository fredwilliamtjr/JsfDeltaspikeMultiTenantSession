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
public class GraficoGoogleChartColunaBean implements Serializable {

    private String dados = "";

    public String getDados() {
        return dados;
    }

    @PostConstruct
    private void init() {

        List<LinhaGoogleChartsUmaColuna> linhaGoogleChartsUmaColunaList = new ArrayList<>();
        linhaGoogleChartsUmaColunaList.add(new LinhaGoogleChartsUmaColuna("06h", "1234.56"));
        linhaGoogleChartsUmaColunaList.add(new LinhaGoogleChartsUmaColuna("07h", "4123.56"));
        linhaGoogleChartsUmaColunaList.add(new LinhaGoogleChartsUmaColuna("08h", "5123.56"));
        linhaGoogleChartsUmaColunaList.add(new LinhaGoogleChartsUmaColuna("09h", "7123.56"));
        linhaGoogleChartsUmaColunaList.add(new LinhaGoogleChartsUmaColuna("10h", "3123.56"));
        linhaGoogleChartsUmaColunaList.add(new LinhaGoogleChartsUmaColuna("11h", "5123.56"));
        linhaGoogleChartsUmaColunaList.add(new LinhaGoogleChartsUmaColuna("12h", "7193.56"));
        linhaGoogleChartsUmaColunaList.add(new LinhaGoogleChartsUmaColuna("13h", "2223.56"));
        linhaGoogleChartsUmaColunaList.add(new LinhaGoogleChartsUmaColuna("14h", "2623.56"));
        linhaGoogleChartsUmaColunaList.add(new LinhaGoogleChartsUmaColuna("15h", "2123.56"));
        linhaGoogleChartsUmaColunaList.add(new LinhaGoogleChartsUmaColuna("16h", "9193.56"));
        linhaGoogleChartsUmaColunaList.add(new LinhaGoogleChartsUmaColuna("17h", "3223.56"));
        linhaGoogleChartsUmaColunaList.add(new LinhaGoogleChartsUmaColuna("18h", "3523.56"));
        linhaGoogleChartsUmaColunaList.add(new LinhaGoogleChartsUmaColuna("19h", "1123.56"));
        linhaGoogleChartsUmaColunaList.add(new LinhaGoogleChartsUmaColuna("20h", "7193.56"));
        linhaGoogleChartsUmaColunaList.add(new LinhaGoogleChartsUmaColuna("21h", "4223.56"));
        linhaGoogleChartsUmaColunaList.add(new LinhaGoogleChartsUmaColuna("22h", "5523.56"));

        dados = GoogleChartsUtils.dadosGraficoUmaColuna("Hora", "Valor", linhaGoogleChartsUmaColunaList);

    }

    public void voltar() throws IOException {
        FacesUtil.redirect("/index");
        //FacesUtil.forward("/index.xhtml");
    }


}
