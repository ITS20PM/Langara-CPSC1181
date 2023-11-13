public class Class2 extends Class1 {
	
	public Class2() {
		super(); 
		ic = new InnerClass2();
	}
	
	public static void main(String[] args) {
		Class2 ic = new Class2();
		ic.displayStrings();
	}
	
	class InnerClass2 extends InnerClass1{
		@Override
		public String getAnotherString() {
			return "InnerClass2: getAnotherString invoked";
		}
	}
	
	//EX 1 b) the output of Class 2:
	//InnerClass1: getString invoked.
	//InnerClass2: getAnotherString invoked.
	
}
