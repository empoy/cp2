package com.sampoytech.shopaholic;

import java.util.ArrayList;

public abstract class Connection {
	abstract Boolean delete(String id);
	abstract Boolean update(Object obj);
	abstract Boolean adder(Object obj);
	abstract ArrayList<Object> lister();
	abstract Object select(String id);
	abstract Boolean update(User obj) ;
}
