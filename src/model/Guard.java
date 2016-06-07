package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

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
	public List<Operation> getOperatorList() {
		return operatorList;
	}
	@XmlElementWrapper(name = "OperationList")
	@XmlElement(name = "Op")
	public void setOperatorList(List<Operation> operatorList) {
		this.operatorList = operatorList;
	}

}
