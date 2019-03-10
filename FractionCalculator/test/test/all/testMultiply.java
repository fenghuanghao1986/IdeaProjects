package test.all;

import com.calc.Fraction;

import junit.framework.Assert;
import junit.framework.TestCase;

public class testMultiply extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/** 
	 * �������������ķ�ĸΪ��0,���Ӷ���[-1000,1000]������
	 */
	public void testMultiply1() {
		Fraction x = new Fraction();
		Assert.assertEquals(x.SetTop(222), true);
		Assert.assertEquals(x.SetBottom(0),false);
		Fraction y =  new Fraction();
		Assert.assertEquals(y.SetTop(43),true);
		Assert.assertEquals(y.SetBottom(0),false);
		Fraction z = y.Multiply(x);
	}
	
	/** 
	 * ���Ա������ķ��ӷ�ĸ����[-1000,1000]���ҷ���ֵ<0����ĸ��Ϊ0;
	 * �����ķ��ӷ�ĸ����[-1000,1000]���ҷ���ֵ>0����ĸ��Ϊ0������
	 */
	public void testMultiply2() {
		Fraction x = new Fraction();
		Assert.assertEquals(x.SetTop(-13), true);
		Assert.assertEquals(x.SetBottom(23), true);
		Fraction y = new Fraction();
		Assert.assertEquals(y.SetTop(47), true);
		Assert.assertEquals(y.SetBottom(35), true);
		Fraction z = x.Multiply(y);
		Assert.assertEquals(z.GetTop(), -611);
		Assert.assertEquals(z.GetBottom(), 805);
	}
	
	/** 
	 * ���Ա������ķ��ӷ�ĸ����[-1000,1000]���ҷ���ֵ>0����ĸ��Ϊ0��
	 * �����ķ��ӷ�ĸ����[-1000,1000]���ҷ���ֵ<0����ĸ��Ϊ0������
	 */
	public void testMultiply3() {
		Fraction x = new Fraction();
		Assert.assertEquals(x.SetTop(12), true);
		Assert.assertEquals(x.SetBottom(98), true);
		Fraction y = new Fraction();
		Assert.assertEquals(y.SetTop(-21), true);
		Assert.assertEquals(y.SetBottom(77), true);
		Fraction z = x.Multiply(y);
		Assert.assertEquals(z.GetTop(), -18);
		Assert.assertEquals(z.GetBottom(), 539);
	}
	
	/** 
	 * �������������ķ��Ӷ�=0����ĸ��[-1000,1000]�Ҳ�Ϊ0������
	 */
	public void testMultiply4() {
		Fraction x = new Fraction();
		Assert.assertEquals(x.SetTop(0), true);
		Assert.assertEquals(x.SetBottom(11), true);
		Fraction y = new Fraction();
		Assert.assertEquals(y.SetTop(0), true);
		Assert.assertEquals(y.SetBottom(19), true);
		Fraction z = x.Multiply(y);
		Assert.assertEquals(z.GetTop(), 0);
		Assert.assertEquals(z.GetBottom(), 1);
	}
	
	/** 
	 * ���Ա������ķ��ӷ�ĸ��<1000����ĸ��Ϊ0;
	 * �����ķ��ӷ�ĸ��>1000����ĸ��Ϊ0������
	 */
	public void testMultiply5() {
		Fraction x = new Fraction();
		Assert.assertEquals(x.SetTop(-1234), false);
		Assert.assertEquals(x.SetBottom(-4321), false);
		Fraction y = new Fraction();
		Assert.assertEquals(y.SetTop(1324), false);
		Assert.assertEquals(y.SetBottom(3214), false);
		Fraction z = x.Multiply(y);
	}
	
	/** 
	 * ���Ա������ķ��ӷ�ĸ��>1000����ĸ��Ϊ0;
	 * �����ķ��ӷ�ĸ��>1000����ĸ��Ϊ0������
	 */
	public void testMultiply7() {
		Fraction x = new Fraction();
		Assert.assertEquals(x.SetTop(1234), false);
		Assert.assertEquals(x.SetBottom(4321), false);
		Fraction y = new Fraction();
		Assert.assertEquals(y.SetTop(1324), false);
		Assert.assertEquals(y.SetBottom(3214), false);
		Fraction z = x.Multiply(y);
	}	
	
	/** 
	 * ���Ա������ķ��ӷ�ĸ��>1000����ĸ��Ϊ0;
	 * �����ķ��ӷ�ĸ��<1000����ĸ��Ϊ0������
	 */
	public void testMultiply8() {
		Fraction x = new Fraction();
		Assert.assertEquals(x.SetTop(1234), false);
		Assert.assertEquals(x.SetBottom(4321), false);
		Fraction y = new Fraction();
		Assert.assertEquals(y.SetTop(-1324), false);
		Assert.assertEquals(y.SetBottom(-3214), false);
		Fraction z = x.Multiply(y);
	}
}
