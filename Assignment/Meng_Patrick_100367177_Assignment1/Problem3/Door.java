public class Door implements Lockable{
	private boolean isOpen;
	private int key;
	
	public Door() {
		isOpen = false;
		key = 0;
	}
	
	public void open() {
		isOpen = true;
	}
	
	public void close() {
		isOpen = false;
	}
	
	public boolean getState() {
		return isOpen;
	}
	
	public String toString() {
		if(isOpen)
			return "The door is open";
		else
			return "The door is closed";
	}

	@Override
	public void setKey(int k) {
		key = k;
	}

	@Override
	public void lock(int k) {
		if(k == key)
			isOpen = false;
	}

	@Override
	public void unlock(int k) {
		if(k == key)
			isOpen = true;
	}

	@Override
	public boolean isLocked() {
		return !isOpen;
	}

	
}
