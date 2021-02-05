package Java.Thread;

public class A {

	class Inner {
		public String  v1 = "Fake News";
		public String v2 = "Go ahead";
	}

	private static String GetVal() {
		try {
			return Inner.class.newInstance().v1;
		} catch (Exception e) {
			try {
				return Inner.class.getDeclaredConstructor(A.class).newInstance((A)null).v2;
			} catch (Exception ee) {
				ee.printStackTrace();
				return "Fake News, Go ahead";
			}
		}
	}
	public static void main(String[] args) {
		int i = 2147483647;
		long ii = i;
		long j = ii + 2;
		System.out.println((double) j / 2);
		//System.out.println(GetVal());
	}
}
