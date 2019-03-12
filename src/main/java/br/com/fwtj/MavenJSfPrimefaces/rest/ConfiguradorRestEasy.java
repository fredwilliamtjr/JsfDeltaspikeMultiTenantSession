package br.com.fwtj.MavenJSfPrimefaces.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Autor: Fred William Torno Junior
 * E-Mail: fredwilliam@gmail.com / fredwilliam@outlook.com
 * Site: www.fwtj.com.br
 * Telefone: (22) 9-8136-5786
 * Data: 18/04/2018
 * Hora: 18:42
 * Copyright©Fwtj Sistemas. Todos os direitos reservados.
 */
@ApplicationPath("/api")
public class ConfiguradorRestEasy extends Application {

    private Set<Object> singletons = new HashSet<Object>();

    public ConfiguradorRestEasy() {
        singletons.add(new ControladorRestEasy());
        singletons.add(new FiltroSegurancaRestEasy());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

}
