package com.app.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.app.models.Smuggler;

@Path("smuggler")
public class SmugglerServiceImpl implements SmugglerService{
	
	private Smuggler hondo = new Smuggler(1, "Hondo","Ohnaka");
	private Smuggler han = new Smuggler(2, "Han","Solo");
	private List<Smuggler> smugglerStore = new ArrayList<Smuggler>(Arrays.asList(han, hondo));
	
	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Smuggler> getAll() {
		List<Smuggler> smugglers = new ArrayList<Smuggler>();
		for(Smuggler smuggler: smugglerStore) {
			smugglers.add(smuggler);
		}
		
		return smugglers;
		
	}
	
	@GET
	@Path("race/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String smugglerRace(@PathParam("id") int id) {
		if(id == 1){
			return "Weequay";
		} else if(id == 2){
			return "Human";
		} else {
			return "Unknown";
		}
	}
	@POST
	@Path("new")
	public Smuggler addSmuggler(Smuggler smuggler) {
		Random rand = new Random();
		smuggler.setId(rand.nextInt(100));
		smugglerStore.add(smuggler);
		return smuggler;
	}
}
