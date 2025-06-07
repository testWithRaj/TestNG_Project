package testng;

import org.testng.annotations.*;

public class annotations_example extends BaseClass {
	
	
	
	@Test(groups= {"sanity"})
	public void test1()
	{
		 System.out.println("Inside test case 1");
	}
	
	
	@Test(groups= {"sanity"})
	public void test2()
	{
		System.out.println("Inside test case 2");
	}

}
