package factory;

import gui.AquaPanel;
import q3.*;

public class SwimmableFactory implements AbstractFactory{

	@Override
	public Swimmable create(String SwimmableType,AquaPanel panel) {
		  if ("Fish".equalsIgnoreCase(SwimmableType)) {
	            return new Fish(panel);
	        } else if ("Duck".equalsIgnoreCase(SwimmableType)) {
	            return new Jellyfish(panel);
	        }

	        return null;
	}

}
