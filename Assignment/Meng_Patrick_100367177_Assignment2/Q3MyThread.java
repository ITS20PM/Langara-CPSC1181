package thread;

//implement the runnable interface that
public class MyThread implements Runnable {
	//create attributes for the MyThread object
	private SharedData sd ;
	private int code;
	private String name;
	
	/*create the constructor of the mythread object that 
	initializes each attributes for the mythread object*/
	public MyThread (SharedData sd, int code, String name) {
		this.sd = sd;
		this.code = code;
		this.name = name;
		//output the name of the thread object to the console
		System.out.println("Creating : " + name);
	}
	
	//run the thread
	public void run() {
		int s;
		System.out.println("Running : " + name);
		for (int i=1 ; i <= 3 ;i++) {
			//this is a setter (code = 1)
			if (code == 1) {
				/*set the SharedData to value i*/
				System.out.println("Set " + i);
				sd.setSharedData(i);
				s = i * 100;
			} //this is a getter (code != 1)
			else {
				/*get the SharedData*/
				System.out.print("get " + i + ", ");
				System.out.println(sd.getSharedData());
				s = 50 ;
			}
			//try catch statement
			try {
				Thread.sleep(s);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
	//starting the thread object
	public void start() {
		//output the instruction on the console
		System.out.println("Starting " + name );
		//construct a thread object using the current object's attributes
		Thread theThread = new Thread(this);
		/*start the thread to execute and the jvm invokes 
		 * the run method from the runnable interface*/
		theThread.start();
	}
}
