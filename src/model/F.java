package model;

import javax.xml.bind.annotation.XmlElement;

public class F extends Threshold{
	private String  card;
	public F(String text , String card) {
		super(text);
		this.card = card;
		// TODO Auto-generated constructor stub
	}
	public F(){
		super();
	}
	public String getCard() {
		return card;
	}
	@XmlElement
	public void setCard(String card) {
		this.card = card;
	}
}
