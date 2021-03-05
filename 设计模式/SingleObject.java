package 设计模式;

public class SingleObject {
	//创建SingleObject的一个对象
	private static SingleObject instance = new SingleObject();

	//构造函数为private，该类不会被实例化
	private SingleObject(){}

	//获取唯一可用的对象
	public static SingleObject getInstance() {
		return instance;
	}

	public void showMessage() {
		System.out.println("hello world");
	}
}
