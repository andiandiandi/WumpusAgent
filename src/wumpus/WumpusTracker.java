package wumpus;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import map.Tupel;
import utils.SpaceCalculator;

public class WumpusTracker {

	private ConcurrentLinkedQueue<Tupel> tracker = new ConcurrentLinkedQueue<Tupel>();

	public WumpusTracker() {

	}

	public void update(Tupel pos,int distance,List<Tupel> noWumpus) {

		List<Tupel> radar = SpaceCalculator.getTupel(pos, distance);
		System.out.println("player pos: " + "i: " + pos.getI() + "j: " + pos.getJ());
		System.out.println("distance: " + distance);
		if(tracker.isEmpty()){
			tracker.addAll(radar);
			
			System.out.println("radar");
			for(Tupel t : radar)
				System.out.println(String.format("(i:%d,j:%d)",t.getI(),t.getJ()));
			
			System.out.println("tracker");
			for(Tupel t : tracker)
				System.out.println(String.format("(i:%d,j:%d)",t.getI(),t.getJ()));
			
			for(Tupel t : tracker){
				if(!radar.contains(t) || noWumpus.contains(t))
					tracker.remove(t);
			}
			
			System.out.println("tracker nach delete");
			for(Tupel t : tracker)
				System.out.println(String.format("(i:%d,j:%d)",t.getI(),t.getJ()));
		
		}else{
		
		System.out.println("radar");
		for(Tupel t : radar)
			System.out.println(String.format("(i:%d,j:%d)",t.getI(),t.getJ()));
		
		System.out.println("tracker");
		for(Tupel t : tracker)
			System.out.println(String.format("(i:%d,j:%d)",t.getI(),t.getJ()));
		
		for(Tupel t : tracker){
			if(!radar.contains(t) || noWumpus.contains(t))
				tracker.remove(t);
		}
		
		System.out.println("tracker nach delete");
		for(Tupel t : tracker)
			System.out.println(String.format("(i:%d,j:%d)",t.getI(),t.getJ()));
		
		}
		
	}
	
	public ConcurrentLinkedQueue<Tupel> getTracker(){
		return tracker;
	}
	
	

}
