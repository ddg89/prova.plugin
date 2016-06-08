package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Fint extends F {

	public Fint(String text ,String card) {
		super(text,card);
	}
	public Fint(){
		super();
	}

}
