package model;

public enum GuardOperator {
	AND,OR,XOR,EMPTY;
	public String toString(){
		switch (this) {
		case AND:
			return "AND";
		case OR:
			return "OR";
		case XOR:
			return "XOR";
		case EMPTY:
			return "";
			

		
		}
		return "";
	}

}
