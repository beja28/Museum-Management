package model;

public enum Estado {

	EXCELENTE, CORRECTO, DETERIORADO, DEPLORABLE;
	
	public static Estado parseToEstado(String state) {
		Estado parse = null;
		for(Estado e : Estado.values()) {
			if(e.toString().equalsIgnoreCase(state)) {
				parse = e;
			}
		}
		return parse;
	}
}
