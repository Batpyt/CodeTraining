package 反射;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Fanshe {
	public static void main(String[] args) throws Exception {
		//获取TestClass类的class对象
		Class<?> testClass = Class.forName("反射.TestClass");
		//创建TestClass实例
		TestClass testObject = (TestClass) testClass.newInstance();
		//获取class类中的方法
		Method[] methods = testClass.getDeclaredMethods();
		for(Method method : methods) {
			System.out.println(method);
		}
		testObject.publicMethod("你爷爷");
		testObject.Print();
		//获取指定方法并调用
		Method publicMethod = testClass.getDeclaredMethod("publicMethod", String.class);
		publicMethod.invoke(testObject, "Me");

		//获取指定参数
		Field field = testClass.getDeclaredField("value");
		//取消私有参数安全检查，并更改
		field.setAccessible(true);
		field.set(testObject, "You");

		//获取私有方法
		Method privateMethod = testClass.getDeclaredMethod("privateMethod");

		//取消私有方法的检查
		privateMethod.setAccessible(true);
		privateMethod.invoke(testObject);
	}
}
