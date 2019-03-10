package com.calc;

import com.exception.MyException;

/**
 * �����࣬��ʵ���˷�����+��-��*���º�^������
 * @author ZYL
 */

public class Fraction {
	private int top;			// ����
	private int bottom;			// ��ĸ

	/**
	 * ���캯����Ĭ�Ϸ�ĸΪ1
	 */
	public Fraction() {
		top = 0;
		bottom = 1;
	}

	/**
	 * �������Ĺ��캯�� 
	 * @param a
	 * @param b
	 */
	public Fraction(int a, int b) {
		top = a;
		bottom = b;
	}
	
//	/** ���ƹ��캯�� */
//	public Fraction(Fraction y) {
//		top = y.GetTop();
//		bottom = y.GetBottom();
//	}

	/**
	 * ��÷��ӵ�ֵ
	 */
	public int GetTop() {
		return top;
	}
	
	/**
	 *  ��÷�ĸ��ֵ 
	 */
	public int GetBottom() {
		return bottom;
	}
	
	/**
	 * ���÷���ֵ�����ж��Ƿ��������Ҫ��
	 * @param a
	 * @return �Ƿ�ɹ����÷���
	 */
	public boolean SetTop(int a) {
		try {
			if ( a < -1000 || a > 1000 ) {
				throw new MyException(4);			// ����Խ��
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
	 * ���÷�ĸ��ֵ �����ж��Ƿ��������Ҫ��
	 * @param b
	 * @return �Ƿ�ɹ����÷�ĸ
	 */
	public boolean SetBottom(int b) {
		try {
			if ( b < -1000 || b > 1000 ) {
				throw new MyException(4);				// ����Խ��
			} else {
				if ( b == 0 ) {
					throw new MyException(1);			// �׳��쳣����ĸ����Ϊ0
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
	 * շת��������������Լ��
	 * @param x
	 * @param y
	 * @return x��y�����Լ��
	 */
	private int GCD( int x, int y ) {
		if ( y % x != 0 )
			return GCD( y % x, x );
		else
			return x;
	}
	
	/** 
	 * �����Ļ���
	 * 1.���ӷ�ĸͬ�������Լ��
	 * 2.ȥ����ĸ�ĸ��� 
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
	 * ʵ�����������ļӷ�
	 * @param y
	 * @return �������ý��
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
	 * ʵ�����������ļ���
	 * @param y
	 * @return �������ý��
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
	 * ʵ�����������ĳ˷�
	 * @param y
	 * @return �������ý��
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
	 * ʵ�����������ĳ���
	 * ע���������Ϊ0
	 * @param y
	 * @return �������ý��
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
	 * ʵ�ַ�����������
	 * @param y
	 * @return �������ý��
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
	 * ��ӡ��������ֵ 
	 */
	public void Print() {
		if ( bottom == 1 )
			System.out.print(top);
		else
			System.out.print(top+"/"+bottom);
	}
}