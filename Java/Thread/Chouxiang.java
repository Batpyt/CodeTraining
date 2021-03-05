package Java.Thread;

public abstract class Chouxiang {
	public static void main(String[] args) {
		//System.out.println(n(3));

		char a = 'a';
		char b = 'b';
		char c = 'c';
		System.out.println(a - c);
		System.out.println(Thread.currentThread().getName());
	}

	public static int n(int i) {
		i += 1;
		return i++;
	}
}
