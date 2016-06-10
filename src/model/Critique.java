package model;



public class Critique extends Container{
	public Critique(String Name) {
		super(Name);
		this.type="critique";
	}

	public String toString(){
		String res="critique "+name+"{\n";
		if(this.check!=null)
			res+="\t\t"+check.toString();
		if(this.message!=null)
			res+="\t\t"+message.toString();
		for(Fix f : this.getFixList()){
			res+="\t\t"+f.toString();
		}
		res +="\n\t}"; 
		return res;
	}
	
	
	

}
