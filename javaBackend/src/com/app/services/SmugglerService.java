package com.app.services;

import java.util.List;

import com.app.models.Smuggler;

public interface SmugglerService {
	
	public List<Smuggler> getAll();
	
	public String smugglerRace(int id);
	
	public Smuggler addSmuggler(Smuggler smuggler);
}
