package model2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Evl2 {
	List<Context> contextList;

	public Evl2(List<Context> contextList) {
		super();
		this.contextList = contextList;
	}

	public Evl2() {
		this.contextList = new ArrayList<Context>();
	}

	public List<Context> getContextList() {
		return contextList;
	}
	public void addContext(Context context){
		this.contextList.add(context);
	}
	public void removeContext(Context c){
		
		
				this.contextList.remove(c);
				

	}
	public void setContextList(List<Context> contextList) {
		this.contextList = contextList;
	}
	public void setCheckToContainer(Context context,Container container, Check newCheck){
		for(Context c : this.getContextList()){
			if(c.equals(context)){
				Container crit = c.getContainer();
				if(crit.equals(container)){
					crit.setCheck(newCheck);
				}
			}
		}
	}
	public void addDotoFix(Context context , Container container , Fix fix , Do d){
		for(Context cont : this.getContextList()){
			if(cont.equals(context)){
				Container critTemp=cont.getContainer();
				if(critTemp.equals(container)){
					critTemp.addDotoFix(fix, d);
				}
			}
		}
	}
	public void removeTitleFromFix(Context context,Container container,Fix fix){
		for(Context c : this.getContextList()){
			if(c.equals(context)){
				if(c.getContainer().equals(container)){
					c.removeTitleFromFix(container, fix);
				}
			}
				
		}
	}
	public void removeDoFromFix(Context context,Container container,Fix fix,Do d){
		for(Context c : this.getContextList()){
			if(c.equals(context)){
				c.removeDoFromFix(fix, container, d);
			}
		}
	}
	public void removeCheck(Context context , Container container , Check check){
		for(Context c : this.getContextList()){
			if(c.equals(context)){
				c.removeCheck(container, check);
			}
		}
		
	}
	public void setContainer(Context context , Container container){
		for (Context c : this.getContextList()){
			if(c.equals(context)){
				c.setContainer(container);
			}
		}
	}
	public void removeContainer(Context context , Container container){
		for(Context c : this.getContextList()){
			if(c.equals(context)){
				c.removeContainer(container);
			}
		}
	}
	public void setCMessage(Context context , Container container , Message message){
		for(Context c : this.getContextList()){
			if (c.equals(context)) {
				c.setContainerMessage(container, message);
			}
		}
	}
	public void removeCMessage(Context context , Container container){
		for(Context c : this.getContextList()){
			if(c.equals(context)){
				c.removeContainerMessage(container);
			}
		}
	}
	public void addFix2C(Context cont , Container container , Fix f){
		for(Context c : this.getContextList()){
			if (c.equals(cont)) {
				c.addFix(container, f);
			}
		}
	}
	public void removeFixFromC(Context context , Container container , Fix fix){
		for(Context c : this.getContextList()){
			if(c.equals(context)){
				c.removeFix(container, fix);
			}
		}
	}
	public String toString(){
		String res="";
		for(Context c : this.getContextList()){
			res+=c.toString();
		}
		return res;
	}

}
