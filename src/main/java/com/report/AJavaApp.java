package com.report;
public class AJavaApp {

	public static void main(String[] args) {
		System.out.println("-- java app demo --");
		AJavaClass jCls = new AJavaClass();
		jCls.doSomething();
		AScalaClass sCls = new AScalaClass();
		sCls.doSomething();
	}

}