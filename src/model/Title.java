package model;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Title {
	private String text;
	//private Fix parent;
	public Title(String text) {
		//super();
		this.text = text;
	}

	public Title(){
		
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String toString(){
		return this.text;
	}
}
