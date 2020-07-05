package com.pack.exc;

public class MyException extends RuntimeException{
String msg;

public MyException() {
	super();
}

public MyException(String msg) {
	super();
	this.msg = msg;
}

public String getMsg() {
	return msg;
}

public void setMsg(String msg) {
	this.msg = msg;
}

}
