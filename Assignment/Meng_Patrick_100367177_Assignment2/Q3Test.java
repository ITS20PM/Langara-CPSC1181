package thread;



public class Test {

	public static void main(String[] args) {
		//create a shareddata object called sd 
		SharedData sd = new SharedData();
		//create MyThread object named t1 and outputting the meaning on the console
		MyThread t1 = new MyThread(sd,1,"T-1");//setter
		//start the thread object t1
		t1.start();
		//create MyThread object named t2 and outputting the meaning on the console
		MyThread t2 = new MyThread(sd,0,"T-2");//getter
		//start the thread object t2
		t2.start();
		
		/*Explanation: the program is used to test that the order 
		 * of t1 and t2 execution is random and is not consistent
		 * with the order of the line-by-line code*/
		
		/*Output:
		 *Creating : T-1
		 *Starting T-1
		 *Creating : T-2
		 *Starting T-2
		 *Running : T-1
		 *Running : T-2
		 *Set 1
		 *get 1, 1
		 *Set 2
		 *get 2, 1
		 *Set 3
		 *get 3, 2
		 ***/
		
	}

}
