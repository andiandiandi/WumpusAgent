package utils;

import java.util.ArrayList;
import java.util.List;

import map.Tupel;

public class SpaceCalculator {

	public static List<Tupel> getTupel(Tupel pos,int dis){
		
		List<Tupel> l = new ArrayList<Tupel>(dis*4);
		
		int a;
		int b;
		
		for(int i=0;i<dis;i++){
			
			if(i!=0){
				a = pos.getI()-(-i);
				b = pos.getJ()-(dis-i);
				add(l,a,b);
				a = pos.getI()-(-i);
				b = pos.getJ()- (-(dis-i));
				add(l,a,b);
			}else{
				a=pos.getI()-(dis-i);
				b=pos.getJ()-i;
				add(l,a,b);
				a=pos.getI()-(-(dis-i));
				b=pos.getJ()-i;
				add(l,a,b);
			}
			
			a=pos.getI()-i;
			b=pos.getJ()-(dis-i);
			add(l,a,b);
			a=pos.getI()-i;
			b=pos.getJ()-(-(dis-i));
			add(l,a,b);
	
		}
		
		
		
		return l;
		
	}
	
	public static List<Tupel> getTupelWithSelf(Tupel pos,int dis){
		List<Tupel> l = getTupel(pos, dis);
		l.add(pos);
		return l;
	}
	
	private static void add(List<Tupel> l,int a,int b){
		if(a > 0 && b > 0)
			l.add(new Tupel(a,b));
	}
	
	public static List<Tupel> getAllTupel(Tupel pos){
		List<Tupel> ret = (getTupel(pos,3));
		ret.addAll(getTupel(pos,2));
		ret.addAll(getTupel(pos,1));
		return ret;
	}
}
