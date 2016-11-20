package runner;

import de.fh.connection.wumpus.AgentAction;
import de.fh.connection.wumpus.AgentPercept;
import map.Mapper;
import map.Tupel;
import wumpus.WumpusTracker;

public class Runner {

	private AgentAction nextAction;
	private AgentPercept percept;
	
	private WumpusTracker tracker = new WumpusTracker();
	private Mapper mapper = new Mapper();

	private Tupel pos = new Tupel(1, 1);
	
	private boolean turnleft = false;
	private boolean turnright = false;
	int count = -1;
	
	public Runner() {

	}

	public void update(AgentPercept percept) {
		this.percept = percept;

		//Fallen
		if (this.percept.isBreeze())
			mapper.addToPTrap(pos);
		else
			mapper.addToNoTrap(pos);

		
		
		//Wumpus
		if(this.percept.getWumpusStenchRadar()[0][1] == 0)
			mapper.addToNoWumpus(pos);
		else
			tracker.update(pos,this.percept.getWumpusStenchRadar()[0][1],mapper.getNoWumpus());
		
		
		//debug
		System.out.println("traps");
		for(Tupel t : mapper.getPotentialTraps())
			t.print();
		
		System.out.println("wumpus position");
		for(Tupel t : tracker.getTracker())
			t.print();
		
		mapper.addToMap(pos);
		
	}

	public AgentAction getNextAction() {

		count++;	
		
		if(count==1){
			turnright=true;
			turnleft=false;
			nextAction = AgentAction.TURN_RIGHT;
			return nextAction;
		}else if(count==3){
			turnleft=true;
			turnright=false;
			nextAction = AgentAction.TURN_LEFT;
			count=-1;
			return nextAction;
		}else{
			nextAction = AgentAction.GO_FORWARD;
			if(count==2)
				pos = new Tupel(pos.getI(),pos.getJ()+1);
			if(count==0)
				pos = new Tupel(pos.getI()+1,pos.getJ());
			
		}
		
		
		return nextAction;
	}

}
