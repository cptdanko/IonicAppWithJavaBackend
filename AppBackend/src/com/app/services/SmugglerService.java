package com.app.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.app.models.Smuggler;

@Path("smuggler")
public class SmugglerService {
	
	private Smuggler hondo = new Smuggler(1, "Hondo","Ohnaka");
	private Smuggler han = new Smuggler(2, "Han","Solo");
	
	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Smuggler> getAll() {
		List<Smuggler> smugglers = new ArrayList<Smuggler>();
		
		smugglers.add(hondo);
		smugglers.add(han);
		return smugglers;
	}
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getSmuggler(@PathParam("id") int id) {
		System.out.println("In the get smuggler function");
		if(id == 1){
			return "Weequay";
		} else {
			return "Human";
		}
	}
	@GET
	@Path("race/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String smugglerRace(@PathParam("id") int id) {
		System.out.println("In the get smuggler function");
		if(id == 1){
			return "Weequay";
		} else {
			return "Human";
		}
	}
	@POST
	@Path("new")
	public void addSmuggler(Smuggler smuggler) {
		System.out.println("name:"+smuggler.getName());
		System.out.println("last name:"+smuggler.getLastname());
		System.out.println("id:"+smuggler.getId());
		System.out.println("smuggler read to be added");
	}
	
}
