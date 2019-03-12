package br.com.fwtj.MavenJSfPrimefaces.aplicativo;

import org.apache.deltaspike.core.api.config.ConfigProperty;
import org.apache.deltaspike.core.api.projectstage.ProjectStage;
import org.apache.deltaspike.core.api.resourceloader.InjectableResource;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.*;

@Named
public class ApplicationResources implements Serializable {

    //ApplicationResources

    @Inject
    @InjectableResource(location = "/qualquercoisa.txt")
    private InputStream is;

    public String getVersao() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            return br.readLine();
        }
    }

    @Inject
    private ProjectStage projectStage;

    public ProjectStage getProjectStage() {
        return projectStage;
    }

    @Inject
    @ConfigProperty(name = "br.com.fwtj.nomeProjeto")
    private String nomeProjeto;

    public String getNomeProjeto() {
        return nomeProjeto;
    }

}
