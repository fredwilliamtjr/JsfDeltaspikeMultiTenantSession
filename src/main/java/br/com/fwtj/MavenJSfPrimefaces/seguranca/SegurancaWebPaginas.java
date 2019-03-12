package br.com.fwtj.MavenJSfPrimefaces.seguranca;

import org.apache.deltaspike.core.api.config.view.ViewConfig;
import org.apache.deltaspike.jsf.api.config.view.Folder;
import org.apache.deltaspike.jsf.api.config.view.View;
import org.apache.deltaspike.security.api.authorization.Secured;

@Folder(name = "/")
@Secured(SegurancaWebControlador.class)
@View(navigation = View.NavigationMode.REDIRECT)
public class SegurancaWebPaginas implements ViewConfig {


    public class p404 extends SegurancaWebPaginas {
    }

    public class error extends SegurancaWebPaginas {
    }

    public class error2 extends SegurancaWebPaginas {
    }

    public class naologado extends SegurancaWebPaginas {
    }

    public class negado extends SegurancaWebPaginas {
    }

    public class login extends SegurancaWebPaginas {
    }

    public class index extends SegurancaWebPaginas {
    }

    public class graficoGoogleChartBarra extends SegurancaWebPaginas {
    }

    public class graficoGoogleChartColuna extends SegurancaWebPaginas {
    }

    public class graficoGoogleChartPizza extends SegurancaWebPaginas {
    }

    public class dadosUsuario extends SegurancaWebPaginas {
    }


}
