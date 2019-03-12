package br.com.fwtj.MavenJSfPrimefaces.rest;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Autor: Fred William Torno Junior
 * E-Mail: fredwilliam@gmail.com / fredwilliam@outlook.com
 * Site: www.fwtj.com.br
 * Telefone: (22) 9-8136-5786
 * Data: 18/04/2018
 * Hora: 18:43
 * Copyright©Fwtj Sistemas. Todos os direitos reservados.
 */
@Path("/")
public class ControladorRestEasy {

    @PermitAll
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response raiz() {
        return Response.ok().entity(new RespostaRest("OK")).build();
    }

    @DenyAll
    @GET
    @Path("/teste1")
    @Produces(MediaType.APPLICATION_JSON)
    public Response teste1() {
        return Response.ok().entity(new RespostaRest("teste1")).build();
    }

    @RolesAllowed("REST")
    @GET
    @Path("/teste2")
    @Produces(MediaType.APPLICATION_JSON)
    public Response teste2() {
        return Response.ok().entity(new RespostaRest("teste2")).build();
    }

    @GET
    @Path("/teste3")
    @Produces(MediaType.APPLICATION_JSON)
    public Response teste3() {
        return Response.ok().entity(new RespostaRest("teste2")).build();
    }


}
