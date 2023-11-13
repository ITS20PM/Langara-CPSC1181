public interface Lockable {
	
	void setKey(int k);
	
	void lock(int k);
	
	void unlock(int k);
	
	boolean isLocked();
}
