package Grouping;

import org.testng.annotations.Test;

public class RegressionGroup {
	@Test(groups="Regression")
	public void m1()
	{
		System.out.println("This is Regression group m1 method");
	}
	@Test(groups="Regression")
	public void m2()
	{
		System.out.println("This is Regression group m2 method");	
	}
	@Test(groups="Regression")
	public void m3()
	{
		System.out.println("This is Regression group m3 method");
	}
	

}
