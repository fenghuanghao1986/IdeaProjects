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
	 * ���Է����ķ�ĸΪ0,���Ӷ���[-1000,1000]������
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
	 * ���Ե����ķ��ӷ�ĸ����[-1000,1000]���ҷ���ֵ<0����ĸ��Ϊ0;
	 * ָ�� = 0
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
	 * ���Ե����ķ��ӷ�ĸ����[-1000,1000]���ҷ���ֵ>0����ĸ��Ϊ0��
	 * ָ�� = 0
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
	 * ���Ե����ķ���=0����ĸ��[-1000,1000]�Ҳ�Ϊ0������
	 * ָ����(0,10)
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
	 * ���Ե����ķ��ӷ�ĸ��<-1000����ĸ��Ϊ0;
	 * ָ�� = 0������
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
	 * ���Ե����ķ��ӷ�ĸ����������> -1000����ĸ��Ϊ0;
	 * ָ�� < 0������
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
	 * ���Ե����ķ��ӷ�ĸ��>1000����ĸ��Ϊ0;
	 * ָ�� ��(0,10) ������
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
	 * ���Ե����ķ��ӷ�ĸ��Ϊ������<1000����ĸ��Ϊ0;
	 * ָ�� > 10������
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
	 * ���Ե����ķ��ӷ�ĸ��Ϊ������<1000����ĸ��Ϊ0;
	 * ָ��  < 10������
	 * ע�⣺���ӻ��ĸ����֮���ܴ󣬳���int��Χ��
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
