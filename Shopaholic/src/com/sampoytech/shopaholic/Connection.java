package com.sampoytech.shopaholic;

import java.io.IOException;

public abstract class Connection 
{
	abstract Boolean delete(String id) throws IOException;
	abstract Object lister() throws IOException;
	abstract Object select(String id) throws IOException;
}
