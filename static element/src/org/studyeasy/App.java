package org.studyeasy;

import org.studyeasy.testrun.TestStatic;

public class App {

	public static void main(String[] args) {
		TestStatic obj1 = new TestStatic();
		System.out.println("obj1 current variable value:" +TestStatic.getStaticVariable());
		obj1.setStaticVariable(1);
		System.out.println("obj1 current variable value:" +TestStatic.getStaticVariable());
		
		TestStatic obj2 = new TestStatic();
		System.out.println("obj2 current variable value:" +TestStatic.getStaticVariable());
		obj2.setStaticVariable(24);
		System.out.println("obj2 current variable value:" +TestStatic.getStaticVariable());
		
		TestStatic obj3 = new TestStatic();
		System.out.println("obj3 current variable value:" +TestStatic.getStaticVariable());
	}

}
