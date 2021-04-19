package entity.player;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import block.Block;
import entity.Animal;
import entity.Entity;

public interface Player extends Entity{

	//manage money
	public void incrementMoney(double moneyToAdd);
	public void decreaseMoney(double moneyToRemove);
	public double getMoney();
	
	//get inventory
	public Inventory getInventory();
	
	//get animal
	public Optional<Animal> nearestAnimal(List<Animal> animals);
}