package factory;

import gui.AquaPanel;

public interface AbstractFactory<T> {
	
	 T create(String SwimmableType,AquaPanel panel) ;

}
