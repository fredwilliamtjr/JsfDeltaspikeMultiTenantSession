package br.com.fwtj.MavenJSfPrimefaces.util.googlecharts;

import java.util.List;

/**
 * Autor: Fred William Torno Junior
 * E-Mail: fredwilliam@gmail.com / fredwilliam@outlook.com
 * Site: www.fwtj.com.br
 * Telefone: (22) 9-8136-5786
 * Data: 21/04/2018
 * Hora: 12:55
 * Copyright©Fwtj Sistemas. Todos os direitos reservados.
 */
public class GoogleChartsUtils {

    private static String abreDados() {
        return "[";
    }

    private static String fechaDados() {
        return "]";
    }

    private static String separadorDados() {
        return ",";
    }

    private static String colunaDados(String nomeColula, String nomeValor) {
        return "[\"" + nomeColula + "\", \"" + nomeValor + "\", {role: \"style\"}]";
    }

    private static String linhaDados(String nomeLinha, String valorLinha) {
        return "[\"" + nomeLinha + "\", " + valorLinha + ", \"" + CorUtils.getCorRandonicaHex() + "\"]";
    }

    public static String dadosGraficoUmaColuna(String nomeColuna1, String nomeColuna2, List<LinhaGoogleChartsUmaColuna> listaLinhaGoogleChartsUmaColuna){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(abreDados());
        stringBuilder.append(colunaDados(nomeColuna1, nomeColuna2));
        stringBuilder.append(separadorDados());

        listaLinhaGoogleChartsUmaColuna.forEach(linhaGoogleChartsUmaColuna -> {
            stringBuilder.append(linhaDados(linhaGoogleChartsUmaColuna.getHora(), linhaGoogleChartsUmaColuna.getValor()));
            stringBuilder.append(separadorDados());
        });

        stringBuilder.append(fechaDados());
        String toString = stringBuilder.toString();

        return toString;
    }

}
