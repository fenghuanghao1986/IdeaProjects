package com.calc;

import com.exception.MyException;

/**
 * 分数类，并实现了分数的+、-、*、÷和^操作。
 * @author ZYL
 */

public class Fraction {
	private int top;			// 分子
	private int bottom;			// 分母

	/**
	 * 构造函数，默认分母为1
	 */
	public Fraction() {
		top = 0;
		bottom = 1;
	}

	/**
	 * 带参数的构造函数 
	 * @param a
	 * @param b
	 */
	public Fraction(int a, int b) {
		top = a;
		bottom = b;
	}
	
//	/** 复制构造函数 */
//	public Fraction(Fraction y) {
//		top = y.GetTop();
//		bottom = y.GetBottom();
//	}

	/**
	 * 获得分子的值
	 */
	public int GetTop() {
		return top;
	}
	
	/**
	 *  获得分母的值 
	 */
	public int GetBottom() {
		return bottom;
	}
	
	/**
	 * 设置分子值，并判断是否符合输入要求
	 * @param a
	 * @return 是否成功设置分子
	 */
	public boolean SetTop(int a) {
		try {
			if ( a < -1000 || a > 1000 ) {
				throw new MyException(4);			// 数据越界
			} else {
				top = a;
				return true;
			}
		} catch ( MyException e ) {
			System.err.println( e.GetMessage() );
			return false;
		}
	}
	
	/**
	 * 设置分母的值 ，并判断是否符合输入要求
	 * @param b
	 * @return 是否成功设置分母
	 */
	public boolean SetBottom(int b) {
		try {
			if ( b < -1000 || b > 1000 ) {
				throw new MyException(4);				// 数据越界
			} else {
				if ( b == 0 ) {
					throw new MyException(1);			// 抛出异常，分母不能为0
				} else {
					bottom = b; 
					return true;
				}
			}
		} catch ( MyException e ) {
			System.err.println( e.GetMessage() );
			return false;
		}
	}
	
	/**
	 * 辗转相除求两数的最大公约数
	 * @param x
	 * @param y
	 * @return x和y的最大公约数
	 */
	private int GCD( int x, int y ) {
		if ( y % x != 0 )
			return GCD( y % x, x );
		else
			return x;
	}
	
	/** 
	 * 分数的化简
	 * 1.分子分母同除以最大公约数
	 * 2.去掉分母的负号 
	 */
	public void Simplify() {
		if (( top < 0 && bottom < 0 ) || ( top > 0 && bottom < 0 )) {
			top = top * -1;
			bottom = bottom * -1;
		}
		if ( top != 0 && top != 1 ) {
			int gcd = GCD( java.lang.Math.abs(top), java.lang.Math.abs(bottom) );
			top = top / gcd;
			bottom = bottom / gcd;
		}
		if ( top == 0 )
			bottom = 1;
	}

	/**
	 * 实现两个分数的加法
	 * @param y
	 * @return 计算所得结果
	 */
	public Fraction Add(Fraction y) {
		int newTop = top*y.GetBottom() + bottom*y.GetTop();
		int newBottom = bottom*y.GetBottom();
		int gcd = 1;
		if ( newTop != 0 )
			gcd = GCD( java.lang.Math.abs(newTop), java.lang.Math.abs(newBottom) );
		Fraction z = new Fraction( newTop/gcd, newBottom/gcd);
		z.Simplify();
		return z;
	}
	
	/**
	 * 实现两个分数的减法
	 * @param y
	 * @return 计算所得结果
	 */	public Fraction Minus(Fraction y) {
		int newTop = top*y.GetBottom() - bottom*y.GetTop();
		int newBottom = bottom*y.GetBottom();
		int gcd = 1;
		if ( newTop != 0 )
			gcd = GCD( java.lang.Math.abs(newTop), java.lang.Math.abs(newBottom) );
		Fraction z = new Fraction( newTop/gcd, newBottom/gcd);
		z.Simplify();
		return z;
	}
 
	/**
	 * 实现两个分数的乘法
	 * @param y
	 * @return 计算所得结果
	 */
	public Fraction Multiply(Fraction y) {
		int newTop = top*y.GetTop();
		int newBottom = bottom*y.GetBottom();
		int gcd = 1;
		if ( newTop != 0 )
			gcd = GCD( java.lang.Math.abs(newTop), java.lang.Math.abs(newBottom) );
		Fraction z = new Fraction( newTop/gcd, newBottom/gcd);
		z.Simplify();
		return z;
	}
	
	/**
	 * 实现两个分数的除法
	 * 注意除数不能为0
	 * @param y
	 * @return 计算所得结果
	 */
	public Fraction Divide(Fraction y) {
		int newTop = top*y.GetBottom();
		int newBottom = bottom*y.GetTop();
		int gcd = 1;
		if ( newTop != 0 )
			gcd = GCD( java.lang.Math.abs(newTop), java.lang.Math.abs(newBottom) );
		Fraction z = new Fraction( newTop/gcd, newBottom/gcd);
		try {
			if ( z.GetBottom() == 0 )
				throw new MyException(2);
			z.Simplify();
		} catch( MyException e ) {
			System.err.println(e.GetMessage());
		}
		return z;
	}
	
	/**
	 * 实现分数的幂运算
	 * @param y
	 * @return 计算所得结果
	 */
	public Fraction Power(int y) {
		int newTop = 1;
		int newBottom = 1;
		for ( int i = 0; i < y; i++ ) {
			newTop = newTop*top;
			newBottom = newBottom*bottom;
		}
		int gcd = 1;
		if ( newTop != 0 )
			gcd = GCD( java.lang.Math.abs(newTop), java.lang.Math.abs(newBottom) );
		Fraction z = new Fraction( newTop/gcd, newBottom/gcd);
		z.Simplify();
		return z;
	}
	
	/** 
	 * 打印出分数的值 
	 */
	public void Print() {
		if ( bottom == 1 )
			System.out.print(top);
		else
			System.out.print(top+"/"+bottom);
	}
}