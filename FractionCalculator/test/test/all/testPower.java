package test.all;

import com.calc.*;
import junit.framework.Assert;
import junit.framework.TestCase;

public class testPower extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/** 
	 * 测试分数的分母为0,分子都∈[-1000,1000]的用例
	 */
	public void testPower1() {
		Fraction x = new Fraction();
		Assert.assertEquals(x.SetTop(222), true);
		Assert.assertEquals(x.SetBottom(0), false);	
		int m = 0;
		Assert.assertEquals(Calculator.SetZ(m,2), true);
		Fraction z = x.Power(m);
	}

	/** 
	 * 测试底数的分子分母都∈[-1000,1000]，且分数值<0，分母不为0;
	 * 指数 = 0
	 */
	public void testPower2() {
		Fraction x = new Fraction();
		Assert.assertEquals(x.SetTop(-13), true);
		Assert.assertEquals(x.SetBottom(23), true);
		int m = 0;
		Assert.assertEquals(Calculator.SetZ(m,0), true);
		Fraction z = x.Power(m);
		Assert.assertEquals(z.GetTop(), 1);
		Assert.assertEquals(z.GetBottom(), 1);
	}
	
	/** 
	 * 测试底数的分子分母都∈[-1000,1000]，且分数值>0，分母不为0；
	 * 指数 = 0
	 */
	public void testPower3() {
		Fraction x = new Fraction();
		Assert.assertEquals(x.SetTop(12), true);
		Assert.assertEquals(x.SetBottom(28), true);
		int m = 0;
		Assert.assertEquals(Calculator.SetZ(m,0), true);
		Fraction z = x.Power(m);
		Assert.assertEquals(z.GetTop(), 1);
		Assert.assertEquals(z.GetBottom(), 1);
	}
	
	/** 
	 * 测试底数的分子=0，分母∈[-1000,1000]且不为0的用例
	 * 指数∈(0,10)
	 */
	public void testPower4() {
		Fraction x = new Fraction();
		Assert.assertEquals(x.SetTop(0), true);
		Assert.assertEquals(x.SetBottom(11), true);
		int m = 2;
		Assert.assertEquals(Calculator.SetZ(m,2), true);
		Fraction z = x.Power(m);
		Assert.assertEquals(z.GetTop(), 0);
		Assert.assertEquals(z.GetBottom(), 1);
	}

	/** 
	 * 测试底数的分子分母均<-1000，分母不为0;
	 * 指数 = 0的用例
	 */
	public void testPower5() {
		Fraction x = new Fraction();
		Assert.assertEquals(x.SetTop(-1234), false);
		Assert.assertEquals(x.SetBottom(-4321), false);
		int m = 0;
		Assert.assertEquals(Calculator.SetZ(m,0), true);
		Fraction z = x.Power(m);
	}	

	/** 
	 * 测试底数的分子分母均负数，且> -1000，分母不为0;
	 * 指数 < 0的用例
	 */
	public void testPower6() {
		Fraction x = new Fraction();
		Assert.assertEquals(x.SetTop(-123), true);
		Assert.assertEquals(x.SetBottom(-432), true);
		int m = 0;
		Assert.assertEquals(Calculator.SetZ(m,-1), false);
		Fraction z = x.Power(m);
	}	
	
	/** 
	 * 测试底数的分子分母均>1000，分母不为0;
	 * 指数 ∈(0,10) 的用例
	 */
	public void testPower7() {
		Fraction x = new Fraction();
		Assert.assertEquals(x.SetTop(1234), false);
		Assert.assertEquals(x.SetBottom(4321), false);
		int m = 0;
		Assert.assertEquals(Calculator.SetZ(m,2), true);
		Fraction z = x.Power(m);
	}	
	
	/** 
	 * 测试底数的分子分母均为正数且<1000，分母不为0;
	 * 指数 > 10的用例
	 */
	public void testPower8() {
		Fraction x = new Fraction();
		Assert.assertEquals(x.SetTop(123), true);
		Assert.assertEquals(x.SetBottom(432), true);
		int m = 0;
		Assert.assertEquals(Calculator.SetZ(m,12), false);
		Fraction z = x.Power(m);
	}
	
	/** 
	 * 测试底数的分子分母均为正数且<1000，分母不为0;
	 * 指数  < 10的用例
	 * 注意：分子或分母求幂之后会很大，超过int范围。
	 */
	public void testPower9() {
		Fraction x = new Fraction();
		Assert.assertEquals(x.SetTop(10), true);
		Assert.assertEquals(x.SetBottom(11), true);
		int m = 0;
		Assert.assertEquals(Calculator.SetZ(m,10), true);
		Fraction z = x.Power(m);
		Assert.assertEquals((long)z.GetTop(), 10000000000L);
		Assert.assertEquals((long)z.GetBottom(), 25937424601L);
	}
}
