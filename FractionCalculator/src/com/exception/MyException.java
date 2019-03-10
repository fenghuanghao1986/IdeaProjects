package com.exception;

/**
* �쳣�ඨ��
* @author ZYL
*/


/** 
 *  �Զ����쳣��
 */
public class MyException extends Exception {
	private int ErrID;				// �쳣����
	
	public MyException(int ID ) {
		ErrID = ID;
	}
	
	/**
	 * �����쳣���࣬�����쳣��Ϣ
	 * @return Exception_Message
	 */
	public String GetMessage() {
		switch( ErrID ) {
		case 1:
			return "Error! Denominator can't be zero.";
		case 2:
			return "Error! Can't be divided by zero.";
		case 3:
			return "Error! Power number can't be negative.";
		case 4:
			return "Error! Data is out of range.";
		}
		return "Sorry, Unkown Error.";
	}
}
