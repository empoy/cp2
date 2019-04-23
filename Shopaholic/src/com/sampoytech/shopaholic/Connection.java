package com.sampoytech.shopaholic;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public abstract class Connection 
{
	abstract Boolean delete(String id) throws IOException;
	abstract Object lister() throws IOException;
	abstract Object select(String id) throws IOException;
}
