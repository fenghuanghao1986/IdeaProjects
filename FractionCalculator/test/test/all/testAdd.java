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
	*testcase1:分子是普通正数，分母也是普通正数
	*计算结果正常
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
	*testcase2:分子是0，分母为普通正数或负数
	*计算结果正常
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
	*testcase3:分子普通正数或负数，分母为0
	*因为分母为0是无效数字，所以无法计算结果
	*程序会显示错误：“Error! Denominator can't be zero.”(Exception1)
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
	*testcase4:分子是普通负数，分母是普通正数或分母是普通负数，分子是普通正数
	*计算结果正确
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
	*testcase5:第一个分子是超出下限的负数，分母是普通正数，第二个为普通负数
	*因为数据超出范围，所以结果不正常。-1001/1加上-1/4结果应该为-4005/4，但是junit却提示为0/1.
	*程序会显示错误：“Error! Data is out of range.”(Exception4)
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
	*testcase6:第一个分子是超出上限的正数，分母是普通正数，第二个为普通正数
	*因为数据超出范围，所以结果不正常。1001/1加上1/2结果应该为2003/2，但是junit却提示为0/1.
	*程序会显示错误：“Error! Data is out of range.”(Exception4)
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
	*testcase7:第二个分子是超出下限的负数，分母是普通正数，第一个为普通负数
	*因为数据超出范围，所以结果不正常。-1/4加上-2001/2结果应该为-4003/4，但是junit却提示为0/1.
	*程序会显示错误：“Error! Data is out of range.”(Exception4)
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
	*testcase8:第二个分子是超出上限的正数，分母是普通正数，第一个为普通正数
	*因为数据超出范围，所以结果不正常。1/2加上2000/1结果应该为4001/2，但是junit却提示为0/1.
	*程序会显示错误：“Error! Data is out of range.”(Exception4)
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
