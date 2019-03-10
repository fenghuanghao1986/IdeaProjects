package com.exception;

/**
* 异常类定义
* @author ZYL
*/


/** 
 *  自定义异常类
 */
public class MyException extends Exception {
	private int ErrID;				// 异常种类
	
	public MyException(int ID ) {
		ErrID = ID;
	}
	
	/**
	 * 根据异常种类，返回异常信息
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
