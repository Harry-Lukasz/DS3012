package ListPkg;


public class List 
{

	public List(){}
	public void sayHelloOne()
	{
		System.out.println("Hello, I'm One!");
	}



	public static void main( String [] args )
	{
		SecondList L2 = new SecondList() ;

		L2.sayHelloTwo();
  	}
}
