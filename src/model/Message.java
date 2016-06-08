package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	private String text;

	public Message(String text) {
		super();
		this.text = text;
	}
	public Message() {
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String toString(){
		return "message : \""+text+"\" \n";
	}

}
