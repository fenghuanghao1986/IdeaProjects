package test.all;

import com.calc.Fraction;

import junit.framework.TestCase;

public class testDivide extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	/**
	* testcase1:���ӷ�ĸ������ͨ����
	* ������72/2����27/3���Ϊ4/1
	*/
	public void testDivide1() {
		Fraction a = new Fraction();
		Fraction b = new Fraction();
		Fraction c = new Fraction();
		a.SetTop(72);
		a.SetBottom(2);
		b.SetTop(27);
		b.SetBottom(3);
		c = a.Divide(b);
		assertEquals(4, c.GetTop());
		assertEquals(1, c.GetBottom());
	}
	/**
	* testcase2:���ӷ�ĸ������ͨ����
	* ������-72/2����-27/3���Ϊ4/1
	*/
	public void testDivide2() {
		Fraction a = new Fraction();
		Fraction b = new Fraction();
		Fraction c = new Fraction();
		a.SetTop(-72);
		a.SetBottom(2);
		b.SetTop(-27);
		b.SetBottom(3);
		c = a.Divide(b);
		assertEquals(4, c.GetTop());
		assertEquals(1, c.GetBottom());
	}
	/**
	* testcase3:����Ϊ0����ĸΪ��ͨ����
	* ������0/2����27/3���Ϊ0������Ԥ�ڵķ�ĸ�������1����������
	*/
	public void testDivide3() {
		Fraction a = new Fraction();
		Fraction b = new Fraction();
		Fraction c = new Fraction();
		a.SetTop(0);
		a.SetBottom(2);
		b.SetTop(33);
		b.SetBottom(3);
		c = a.Divide(b);
		assertEquals(0, c.GetTop());
		assertEquals(1, c.GetBottom());
	}
	/**
	* testcase4:��Ч���룬��ĸΪ0
	* 72/2����0/3��
	* �������ʾ���󣺡�Error! Can't be divided by zero.��(Exception2)
	*/
	public void testDivide4() {
		Fraction a = new Fraction();
		Fraction b = new Fraction();
		Fraction c = new Fraction();
		a.SetTop(72);
		a.SetBottom(2);
		b.SetTop(0);
		b.SetBottom(3);
		c = a.Divide(b);
	}
	/**
	* testcase5:�����ǳ������޵���������ĸ����ͨ����
	* ��Ϊ���ݳ�����Χ�����Խ����������1005/5����9/3���Ӧ��Ϊ67/1������junitȴ��ʾΪ0/1.
	* �������ʾ���󣺡�Error! Data is out of range.��(Exception4)
	*/
	public void testDivide5() {
		Fraction a = new Fraction();
		Fraction b = new Fraction();
		Fraction c = new Fraction();
		a.SetTop(1005);
		a.SetBottom(5);
		b.SetTop(9);
		b.SetBottom(3);
		c = a.Divide(b);
		assertEquals(0, c.GetTop());
		assertEquals(1, c.GetBottom());
	}
	/**
	* testcase6:��������ͨ��������ĸ�ǳ������޵�����
	* ��Ϊ���ݳ�����Χ�����Խ����������9/3����1005/5���Ӧ��Ϊ1/67������junitȴ��ʾΪ1/0.
	* �������ʾ���󣺡�Error! Data is out of range.��(Exception4)
	*                ��Error! Can't be divided by zero.��(Exception2)����Ϊ��ĸ����Ϊ��0�Ĺ�ϵ��
	*/
	public void testDivide6() {
		Fraction a = new Fraction();
		Fraction b = new Fraction();
		Fraction c = new Fraction();
		a.SetTop(9);
		a.SetBottom(3);
		b.SetTop(1005);
		b.SetBottom(5);
		c = a.Divide(b);
		assertEquals(1, c.GetTop());
		assertEquals(0, c.GetBottom());
	}
	/**
	* testcase7:��������ͨ��������ĸ�ǳ������޵ĸ���
	* ��Ϊ���ݳ�����Χ�����Խ����������-9/3����-1005/5���Ӧ��Ϊ1/67������junitȴ��ʾΪ-1/0.
	* �������ʾ���󣺡�Error! Data is out of range.��(Exception4)
	*                ��Error! Can't be divided by zero.��(Exception2)����Ϊ��ĸ����Ϊ��0�Ĺ�ϵ��
	*/               
	public void testDivide7() {
		Fraction a = new Fraction();
		Fraction b = new Fraction();
		Fraction c = new Fraction();
		a.SetTop(-9);
		a.SetBottom(3);
		b.SetTop(-1005);
		b.SetBottom(5);
		c = a.Divide(b);
		assertEquals(-1, c.GetTop());
		assertEquals(0, c.GetBottom());
	}
	/**
	* testcase8:�����ǳ������޵ĸ�������ĸ����ͨ����
	* ��Ϊ���ݳ�����Χ�����Խ����������-1005/5����-9/3���Ӧ��Ϊ67/1������junitȴ��ʾΪ0/1.
	* �������ʾ���󣺡�Error! Data is out of range.��(Exception4)
	*/
	public void testDivide8() {
		Fraction a = new Fraction();
		Fraction b = new Fraction();
		Fraction c = new Fraction();
		a.SetTop(-1005);
		a.SetBottom(5);
		b.SetTop(-9);
		b.SetBottom(3);
		c = a.Divide(b);
		assertEquals(0, c.GetTop());
		assertEquals(1, c.GetBottom());
	}
}