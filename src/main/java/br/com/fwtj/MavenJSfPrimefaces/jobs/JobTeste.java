package br.com.fwtj.MavenJSfPrimefaces.jobs;

import br.com.fwtj.MavenJSfPrimefaces.modelo.Configuracao;
import br.com.fwtj.MavenJSfPrimefaces.repositorio.ConfiguracaoRepository;
import org.apache.deltaspike.scheduler.api.Scheduled;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

//@Scheduled(cronExpression = "0 0/2 * * * ?")
public class JobTeste implements org.quartz.Job, Serializable {

    @Inject
    private ConfiguracaoRepository configuracaoRepository;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("JobTeste");
        List<Configuracao> all = configuracaoRepository.findAll();
        System.out.println(all);
    }
}
