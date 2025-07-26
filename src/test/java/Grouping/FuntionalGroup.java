package Grouping;

import org.testng.annotations.Test;

public class FuntionalGroup {
	@Test(groups="Function")
	public void m1()
	{
		System.out.println("This is Functional group m1 method");
	}
	@Test(groups="Function")
	public void m2()
	{
		System.out.println("This is Functional group m2 method");	
	}
	@Test(groups="Function")
	public void m3()
	{
		System.out.println("This is Functional group m3 method");
	}
	

}
