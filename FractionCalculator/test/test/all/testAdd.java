package test.all;

import com.calc.Fraction;

import junit.framework.TestCase;

public class testAdd extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	*testcase1:��������ͨ��������ĸҲ����ͨ����
	*����������
	*/

	public void testAdd1() {
		Fraction a = new Fraction();
		Fraction b = new Fraction();
		Fraction c = new Fraction();
		a.SetTop(1);
		a.SetBottom(2);
		b.SetTop(2);
		b.SetBottom(5);
		c = a.Add(b);
		assertEquals(c.GetTop(), 9);
		assertEquals(c.GetBottom(),10);
	}
	
	
	/**
	*testcase2:������0����ĸΪ��ͨ��������
	*����������
	*/

	public void testAdd2() {
		Fraction a = new Fraction(0,1);
		Fraction b = new Fraction(0,-1);
		Fraction c = new Fraction();
		a.SetTop(0);
		a.SetBottom(1);
		b.SetTop(0);
		b.SetBottom(-1);
		c = a.Add(b);
		assertEquals(c.GetTop(), 0);
		assertEquals(c.GetBottom(),1);
	}
	
	
	/**
	*testcase3:������ͨ������������ĸΪ0
	*��Ϊ��ĸΪ0����Ч���֣������޷�������
	*�������ʾ���󣺡�Error! Denominator can't be zero.��(Exception1)
	*/

	public void testAdd3() {
		Fraction a = new Fraction();
		Fraction b = new Fraction();
		Fraction c = new Fraction();
		a.SetTop(10);
		a.SetBottom(0);
		b.SetTop(1);
		b.SetBottom(0);
		c = a.Add(b);
//		assertEquals(c.GetTop(), 1002);
//		assertEquals(c.GetBottom(),1);
	}
	
	
	/**
	*testcase4:��������ͨ��������ĸ����ͨ�������ĸ����ͨ��������������ͨ����
	*��������ȷ
	*/
	public void testAdd4() {
		Fraction a = new Fraction();
		Fraction b = new Fraction();
		Fraction c = new Fraction();
		a.SetTop(-10);
		a.SetBottom(1);
		b.SetTop(1);
		b.SetBottom(-2);
		c = a.Add(b);
		assertEquals(c.GetTop(), -21);
		assertEquals(c.GetBottom(),2);
	}
	
	
	/**
	*testcase5:��һ�������ǳ������޵ĸ�������ĸ����ͨ�������ڶ���Ϊ��ͨ����
	*��Ϊ���ݳ�����Χ�����Խ����������-1001/1����-1/4���Ӧ��Ϊ-4005/4������junitȴ��ʾΪ0/1.
	*�������ʾ���󣺡�Error! Data is out of range.��(Exception4)
	*/
	public void testAdd5() {
		Fraction a = new Fraction();
		Fraction b = new Fraction();
		Fraction c = new Fraction();
		a.SetTop(-1001);
		a.SetBottom(1);
		b.SetTop(-1);
		b.SetBottom(4);
		c = a.Add(b);
		assertEquals(c.GetTop(), -1);
		assertEquals(c.GetBottom(),4);
	}
	
	
	/**
	*testcase6:��һ�������ǳ������޵���������ĸ����ͨ�������ڶ���Ϊ��ͨ����
	*��Ϊ���ݳ�����Χ�����Խ����������1001/1����1/2���Ӧ��Ϊ2003/2������junitȴ��ʾΪ0/1.
	*�������ʾ���󣺡�Error! Data is out of range.��(Exception4)
	*/
	public void testAdd6() {
		Fraction a = new Fraction();
		Fraction b = new Fraction();
		Fraction c = new Fraction();
		a.SetTop(1001);
		a.SetBottom(1);
		b.SetTop(1);
		b.SetBottom(2);
		c = a.Add(b);
		assertEquals(c.GetTop(), 1);
		assertEquals(c.GetBottom(),2);
	}
	
	
	/**
	*testcase7:�ڶ��������ǳ������޵ĸ�������ĸ����ͨ��������һ��Ϊ��ͨ����
	*��Ϊ���ݳ�����Χ�����Խ����������-1/4����-2001/2���Ӧ��Ϊ-4003/4������junitȴ��ʾΪ0/1.
	*�������ʾ���󣺡�Error! Data is out of range.��(Exception4)
	*/
	public void testAdd7() {
		Fraction a = new Fraction();
		Fraction b = new Fraction();
		Fraction c = new Fraction();
		a.SetTop(-1);
		a.SetBottom(4);
		b.SetTop(-2001);
		b.SetBottom(2);
		c = a.Add(b);
		assertEquals(c.GetTop(), -1);
		assertEquals(c.GetBottom(),4);
	}

	
	/**
	*testcase8:�ڶ��������ǳ������޵���������ĸ����ͨ��������һ��Ϊ��ͨ����
	*��Ϊ���ݳ�����Χ�����Խ����������1/2����2000/1���Ӧ��Ϊ4001/2������junitȴ��ʾΪ0/1.
	*�������ʾ���󣺡�Error! Data is out of range.��(Exception4)
	*/
	public void testAdd8() {
		Fraction a = new Fraction();
		Fraction b = new Fraction();
		Fraction c = new Fraction();
		a.SetTop(1);
		a.SetBottom(2);
		b.SetTop(2000);
		b.SetBottom(1);
		c = a.Add(b);
		assertEquals(c.GetTop(), 1);
		assertEquals(c.GetBottom(),2);
	}
}
