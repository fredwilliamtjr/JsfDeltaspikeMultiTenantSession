package br.com.fwtj.MavenJSfPrimefaces.bean;

import br.com.fwtj.MavenJSfPrimefaces.modelo.Configuracao;
import br.com.fwtj.MavenJSfPrimefaces.repositorio.ConfiguracaoRepository;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@ApplicationScoped
public class DadosSistemaBean {

    @Inject
    private Configuracao configuracao;

    @Inject
    private ConfiguracaoRepository configuracaoRepository;

    public Configuracao getConfiguracao() {
        return configuracao;
    }

    public void setConfiguracao(Configuracao configuracao) {
        this.configuracao = configuracao;
    }

    public void buscar() {
        List<Configuracao> configuracaoList = configuracaoRepository.findAll();
        if (configuracaoList.isEmpty()) {
            Configuracao configuracaoNova = new Configuracao();
            configuracaoNova.setNome("Sistema");
            Configuracao configuracaoSalva = configuracaoRepository.save(configuracaoNova);
            configuracao = configuracaoSalva;
        } else {
            configuracao = configuracaoList.get(0);
        }
    }

    public void imprimir() {
        System.out.println(configuracao);
    }
}
