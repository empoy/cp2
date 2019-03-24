package pr1;

import java.io.IOException;

public abstract class Connection   
{
	abstract Boolean studetnWriter () throws IOException;
	abstract void studentReader() throws IOException;
	abstract Boolean delete(String id) throws IOException;
	abstract String select(String id) throws IOException;
	abstract void update(String id,int field,String value) throws IOException;
	
	
		
	
}
