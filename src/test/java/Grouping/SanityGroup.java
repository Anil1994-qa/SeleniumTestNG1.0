package Grouping;

import org.testng.annotations.Test;

public class SanityGroup {
@Test(groups="sanity")
public void m1()
{
	System.out.println("This is sanity group m1 method");
}
@Test(groups="sanity")
public void m2()
{
	System.out.println("This is sanity group m2 method");
}
@Test(groups="sanity")
public void m3()
{
	System.out.println("This is sanity group m3 method");
}
}
