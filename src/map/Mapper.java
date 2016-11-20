package map;

import java.util.LinkedList;
import java.util.List;

import utils.SpaceCalculator;

public class Mapper {

	private List<Tupel> map = new LinkedList<Tupel>();
	private List<Tupel> noWumpus = new LinkedList<Tupel>();
	private List<Tupel> noTrap = new LinkedList<Tupel>();
	private List<Tupel> potentialTrap = new LinkedList<Tupel>();
	
	public Mapper() {
	
	}
	
	public void addToMap(Tupel pos){
		if(!map.contains(pos)){
			map.add(pos);
		}
		if(!noTrap.contains(pos))
			noTrap.add(pos);
	}
	
	public void addToPTrap(Tupel pos){
		List<Tupel> found = SpaceCalculator.getTupel(pos,1);
		
		for(Tupel t : found)
			if(!potentialTrap.contains(t))
				potentialTrap.add(t);
		
	}
	
	public void addToNoWumpus(Tupel pos){
		
		List<Tupel> found = SpaceCalculator.getAllTupel(pos);
		
		for(Tupel t : found)
			if(!noWumpus.contains(t))
				noWumpus.add(t);
		
	}
	
	public void addToNoTrap(Tupel pos){
		List<Tupel> found = SpaceCalculator.getTupel(pos,1);
		System.out.println("player pos");
		pos.print();
		for(Tupel t : found){
			System.out.println("tupel in no trap");
			t.print();
			if(!noTrap.contains(t))
				noTrap.add(t);
		}

		
		potentialTrap.removeAll(noTrap);
		
	}
	
	public List<Tupel> getNoWumpus(){
		return noWumpus;
	}
	
	public List<Tupel> getPotentialTraps(){
		return potentialTrap;
	}
	
	
}
