package model.copy;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Threshold {
	String text;
	public Threshold(String text){
		this.text=text;
	}
	public Threshold() {
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String toString(){
		return text;
	}

}
