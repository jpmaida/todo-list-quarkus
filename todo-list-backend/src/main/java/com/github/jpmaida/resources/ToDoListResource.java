package com.github.jpmaida.resources;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.github.jpmaida.domain.ToDo;
import com.github.jpmaida.domain.ToDoList;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@RequestScoped
@Path("/api/todolist")
public class ToDoListResource {

    @Inject 
    private ToDoList toDoList;
    
    @ConfigProperty(name = "is.editable")
    private boolean isEditable;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ToDo> all(){
        return this.toDoList.getList();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ToDo one(@PathParam("id") Long id){
        return this.toDoList.getToDo(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public ToDo newToDo(ToDo toDo){
        return this.toDoList.add(toDo);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response edit(@PathParam("id") Long id, ToDo alteredToDo){
        if(isEditable) {
            ToDo olderToDo = this.toDoList.replace(id, alteredToDo);
            return Response.ok(olderToDo).build();
        } else {
            return Response.status(Status.BAD_REQUEST).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        this.toDoList.remove(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @Path("/envvars")
    public String printEnvVars(){
        return "TODO_LIST_EDITABLE: " + this.isEditable;
    }
}