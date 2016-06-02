package model2;

import java.util.ArrayList;
import java.util.List;

public class Guard {
	private List<Operation> operatorList ;
	public Guard(){
		this.operatorList = new ArrayList<Operation>();
	}
	public void addOperator(Operation op){
		
			this.operatorList.add(op);
			
		
	}
	public String toString(){
		String res="";
		for(Operation o : this.operatorList){
			res+=o.toString()+" ";
			
		}
		res+="\n";
		return res;
	
	}

}
