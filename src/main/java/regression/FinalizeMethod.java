package regression;

public class FinalizeMethod {

	public void test1()
	{
		 System.out.println("we are in tset 1 method");
	}
	
	protected void finalize()
	   {
		   System.out.println("we are in Finalize method");
	   }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FinalizeMethod obj=new FinalizeMethod();
		obj.test1();
		obj=null;
		System.gc();
		System.out.println("End of Statement");

	}
	   

}
