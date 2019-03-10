package test.all;

import com.calc.Fraction;

import junit.framework.Assert;
import junit.framework.TestCase;

public class testMinus extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	/** 
	 * 测试两个分数的分母为都0,分子都∈[-1000,1000]的用例
	 */
	public void testMinus1() {
		Fraction x = new Fraction();
		Assert.assertEquals(x.SetTop(483), true);
		Assert.assertEquals(x.SetBottom(0), false);	
		Fraction y = new Fraction();
		Assert.assertEquals(y.SetTop(-82), true);
		Assert.assertEquals(y.SetBottom(0), false);
		Fraction z = y.Minus(x);
	}

	/** 
	 * 测试被减数的分子分母都∈[-1000,1000]，且分数值<0，分母不为0;
	 * 减数的分子分母都∈[-1000,1000]，且分数值>0，分母不为0的用例
	 */
	public void testMinus2() {
		Fraction x = new Fraction();
		Assert.assertEquals(x.SetTop(-500), true);
		Assert.assertEquals(x.SetBottom(1000), true);
		Fraction y = new Fraction();
		Assert.assertEquals(y.SetTop(23), true);
		Assert.assertEquals(y.SetBottom(300), true);
		Fraction z = x.Minus(y);
		Assert.assertEquals(z.GetTop(), -173);
		Assert.assertEquals(z.GetBottom(), 300);
	}
	
	/** 
	 * 测试被减数的分子分母都∈[-1000,1000]，且分数值>0，分母不为0；
	 * 减数的分子分母都∈[-1000,1000]，且分数值<0，分母不为0的用例
	 */
	public void testMinus3() {
		Fraction x = new Fraction();
		Assert.assertEquals(x.SetTop(486), true);
		Assert.assertEquals(x.SetBottom(992), true);
		Fraction y = new Fraction();
		Assert.assertEquals(y.SetTop(-235), true);
		Assert.assertEquals(y.SetBottom(30), true);
		Fraction z = x.Minus(y);
		Assert.assertEquals(z.GetTop(), 12385);
		Assert.assertEquals(z.GetBottom(), 1488);
	}
	
	/** 
	 * 测试两个分数的分子都=0，分母∈[-1000,1000]且不为0的用例
	 */
	public void testMinus4() {
		Fraction x = new Fraction();
		Assert.assertEquals(x.SetTop(0), true);
		Assert.assertEquals(x.SetBottom(99), true);
		Fraction y = new Fraction();
		Assert.assertEquals(y.SetTop(0), true);
		Assert.assertEquals(y.SetBottom(-930), true);
		Fraction z = x.Minus(y);
		Assert.assertEquals(z.GetTop(), 0);
		Assert.assertEquals(z.GetBottom(), 1);
	}

	/** 
	 * 测试被减数的分子分母均<1000，分母不为0;
	 * 减数的分子分母均>1000，分母不为0的用例
	 */
	public void testMinus5() {
		Fraction x = new Fraction();
		Assert.assertEquals(x.SetTop(-10001), false);
		Assert.assertEquals(x.SetBottom(-9900), false);
		Fraction y = new Fraction();
		Assert.assertEquals(y.SetTop(8736), false);
		Assert.assertEquals(y.SetBottom(3930), false);
		Fraction z = x.Minus(y);
	}	

	/** 
	 * 测试被减数的分子分母均<1000，分母不为0;
	 * 减数的分子分母均<1000，分母不为0的用例
	 */
	public void testMinus6() {
		Fraction x = new Fraction();
		Assert.assertEquals(x.SetTop(-10001), false);
		Assert.assertEquals(x.SetBottom(-9900), false);
		Fraction y = new Fraction();
		Assert.assertEquals(y.SetTop(-8736), false);
		Assert.assertEquals(y.SetBottom(-3930), false);
		Fraction z = x.Minus(y);
	}	
	
	/** 
	 * 测试被减数的分子分母均>1000，分母不为0;
	 * 减数的分子分母均>1000，分母不为0的用例
	 */
	public void testMinus7() {
		Fraction x = new Fraction();
		Assert.assertEquals(x.SetTop(10001), false);
		Assert.assertEquals(x.SetBottom(9900), false);
		Fraction y = new Fraction();
		Assert.assertEquals(y.SetTop(8736), false);
		Assert.assertEquals(y.SetBottom(3930), false);
		Fraction z = x.Minus(y);
	}	
	
	/** 
	 * 测试被减数的分子分母均>1000，分母不为0;
	 * 减数的分子分母均<1000，分母不为0的用例
	 */
	public void testMinus8() {
		Fraction x = new Fraction();
		Assert.assertEquals(x.SetTop(10001), false);
		Assert.assertEquals(x.SetBottom(9900), false);
		Fraction y = new Fraction();
		Assert.assertEquals(y.SetTop(-8736), false);
		Assert.assertEquals(y.SetBottom(-3930), false);
		Fraction z = x.Minus(y);
	}		
}
