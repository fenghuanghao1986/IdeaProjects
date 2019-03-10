package com.calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.exception.MyException;

/**
 * ʵ�ּ�������ܵ�����
 * @author ZYL
 */

public class Calculator {

	/** 
	 * �������룬�����������ֵ
	 * ע�⣺���뱣֤����Ϊ����
	 */
	private static int GetNum() throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		return Integer.valueOf(in.readLine());		
	}
	
	/**
	 * ���ָ����ֵ�����ж��Ƿ����Ҫ��
	 * @param m
	 * @param num
	 * @return ָ���Ƿ����Ҫ��
	 */
	public static boolean SetZ( int m, int num ) {
		try {
			if ( num < 0 )
				throw new MyException(3);		// �׳��쳣��ָ������Ϊ�Ǹ�����
			else 
				if ( num > 10 )
					throw new MyException(4); 
				else {
					m = num;
					return true;
				}
		} catch ( MyException e ) {
			System.err.println(e.GetMessage());
			return false;
		}
	}
	
	/**
	 * �������ķ���ֵ���������࣬�����������
	 * @throws IOException 
	 * @throws NumberFormatException  */
	private static boolean Run() throws NumberFormatException, IOException {
		Fraction x = new Fraction();
		Fraction y = new Fraction();
		Fraction z = new Fraction();
		System.out.print("Please input first fraction's mumerator (-1000 <= Integer <= 1000): ");
		x.SetTop( GetNum() );
		System.out.print("Please input first fraction's denominator (-1000 <= Integer <= 1000): ");
		x.SetBottom( GetNum() );
		x.Simplify();
		System.out.print("Please select operation(+ - * / ^): ");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char op = (char)in.read();
		if ( op != '^' ) {
			System.out.print("Please input first fraction's mumerator (-1000 <= Integer <= 1000): ");
			y.SetTop( GetNum() );
			System.out.print("Please input first fraction's denominator (-1000 <= Integer <= 1000): ");
			y.SetBottom( GetNum() );
			y.Simplify();
			x.Print();
			System.out.print(" "+op+" ");
			y.Print();
			System.out.print(" = ");
			if ( op == '+' ) 
				z = x.Add(y);
			if ( op == '-' )
				z = x.Minus(y);
			if ( op == '*' )
				z = x.Multiply(y);
			if ( op == '/' )
				z = x.Divide(y);
		} else {
			System.out.println("Please input a positive integer (0 <= Integer <= 10): ");
			int m = 0;
			SetZ( m, GetNum() );
			x.Print();
			System.out.print(" "+op+" "+m);
			System.out.print(" = ");
			z = x.Power(m);
		}
		z.Print();
		System.out.println();
		return true;
	}

	/**
	 * ������
	 * @param argv
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void main(String[] argv) throws NumberFormatException, IOException{
		boolean test = Run();
		System.out.println(test);
	}
}