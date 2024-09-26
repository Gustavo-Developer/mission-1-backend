package com.example;

import com.example.models.Run;
import com.example.services.FirebaseService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/corrida")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RunResource {

    @Inject
    FirebaseService firebaseService;

    private List<Run> runList = new ArrayList<>();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createRun(Run run, @HeaderParam("Authorization") String token) throws Exception {
        try {
            firebaseService.validateUser(token);  // Validar o token do usuário
            runList.add(run);
            return Response.ok(run).build();
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Token inválido").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRuns(@HeaderParam("Authorization") String token) throws Exception {
        try {
            firebaseService.validateUser(token);  // Validar o token do usuário
            return Response.ok(runList).build();
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Token inválido").build();
        }
    }
}
