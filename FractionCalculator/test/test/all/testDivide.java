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
	* testcase1:分子分母都是普通正数
	* 正常。72/2除以27/3结果为4/1
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
	* testcase2:分子分母都是普通负数
	* 正常。-72/2除以-27/3结果为4/1
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
	* testcase3:分子为0，分母为普通正数
	* 正常。0/2除以27/3结果为0。但是预期的分母必须等于1，否则会出错
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
	* testcase4:无效输入，分母为0
	* 72/2除以0/3。
	* 程序会显示错误：“Error! Can't be divided by zero.”(Exception2)
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
	* testcase5:分子是超出上限的正数，分母是普通正数
	* 因为数据超出范围，所以结果不正常。1005/5除以9/3结果应该为67/1，但是junit却提示为0/1.
	* 程序会显示错误：“Error! Data is out of range.”(Exception4)
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
	* testcase6:分子是普通正数，分母是超出上限的正数
	* 因为数据超出范围，所以结果不正常。9/3除以1005/5结果应该为1/67，但是junit却提示为1/0.
	* 程序会显示错误：“Error! Data is out of range.”(Exception4)
	*                “Error! Can't be divided by zero.”(Exception2)（因为分母被认为是0的关系）
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
	* testcase7:分子是普通负数，分母是超出下限的负数
	* 因为数据超出范围，所以结果不正常。-9/3除以-1005/5结果应该为1/67，但是junit却提示为-1/0.
	* 程序会显示错误：“Error! Data is out of range.”(Exception4)
	*                “Error! Can't be divided by zero.”(Exception2)（因为分母被认为是0的关系）
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
	* testcase8:分子是超出下限的负数，分母是普通负数
	* 因为数据超出范围，所以结果不正常。-1005/5除以-9/3结果应该为67/1，但是junit却提示为0/1.
	* 程序会显示错误：“Error! Data is out of range.”(Exception4)
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