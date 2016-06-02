package model2;

import java.util.ArrayList;
import java.util.List;

public class Check {
	private Guard guards;
	private Critique parent;
	
	public Check(List<Predicate> pList, List<String> operators,Critique parent) {
		super();
		
		this.parent=parent;
	}

	public Check(){
		
		
	}
	
	public Critique getParent() {
		return parent;
	}
	public void setParent(Critique parent) {
		this.parent = parent;
	}
	
	
	public String toString(){
		String res = "check{\n";
		res+=this.getGuards().toString();
		res+="\n}\n";
		
		return res;
		
	}

	public Guard getGuards() {
		return guards;
	}

	public void setGuards(Guard guards) {
		this.guards = guards;
	}

}
