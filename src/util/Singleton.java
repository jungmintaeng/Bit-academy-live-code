package util;

public class Singleton {
	private Singleton single = null;
	
	private Singleton() {
		
	}
	
	public Singleton getInstance() {
		synchronized (this){
			if(single == null) {
				single = new Singleton();
			}
		}
		return single;
	}
}
