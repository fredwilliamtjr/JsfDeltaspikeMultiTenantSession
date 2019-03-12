package br.com.fwtj.MavenJSfPrimefaces.aplicativo;

import org.apache.deltaspike.jsf.api.config.JsfModuleConfig;
import org.apache.deltaspike.jsf.spi.scope.window.ClientWindowConfig;

import javax.enterprise.inject.Specializes;

@Specializes
public class ApplicationJsfModuleConfig extends JsfModuleConfig {

    @Override
    public ClientWindowConfig.ClientWindowRenderMode getDefaultWindowMode() {
        return ClientWindowConfig.ClientWindowRenderMode.NONE;
    }


}
