package model.copy;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Fbool extends F {

	public Fbool(String text ,String card) {
		super(text,card);
	}
	public Fbool(){
		super();
	}

}
