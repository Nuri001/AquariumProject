package utilities;

import java.awt.Color;
import java.lang.reflect.Field;

public class MyFunctions {
	 public static Color stringToColor(String value) {
		 value=value.toLowerCase();
	
		 System.out.println("stringToColor value=: "+value);
		    
		    if (value == null) {
		    	System.out.println("value == null");
		      return Color.black;
		    }
		    try {
		      // get color by hex or octal value
		      return Color.decode(value);
		    } catch (NumberFormatException nfe) {
		      // if we can't decode lets try to get it by name
		      try {
		        // try to get a color by name using reflection
		        final Field f = Color.class.getField(value);

		        return (Color) f.get(null);
		      } catch (Exception ce) {
		        // if we can't get any color return black
		        return Color.black;
		      }
		    }
		 
		 
		 
		 
	 }

}
