package model.copy;



public class Critique extends Container{
	public Critique(String Name, Context Parent) {
		super(Name, Parent);
		this.type="critique";
	}

	public String toString(){
		String res="critique "+name+"{\n";
		if(this.check!=null)
			res+=check.toString();
		if(this.message!=null)
			res+=message.toString();
		for(Fix f : this.getFixList()){
			res+=f.toString();
		}
		return res;
	}
	
	
	

}
