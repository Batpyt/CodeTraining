package 反射;

public class TestClass {
	private String value;
	public TestClass() {
		value = "Typ";
	}

	public void publicMethod(String s) {
		System.out.println("batman: " + s);
	}

	private void privateMethod() {
		System.out.println("I am "+value);
	}

	public void Print() {
		System.out.println("pppppppppppppppppppppp");
	}
}
