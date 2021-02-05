package Java.Thread;

import java.util.*;

public class Demo {
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<>();
		String str = "没人比我更懂java";
		StrObject obj = new StrObject("没人比我更懂java");
		map.put("str", str);
		map.put("obj", obj);

		str = "真的没人比我更懂java";
		System.out.printf(map.get("str").toString()+"; ");

		StrObject new_obj = (StrObject) map.get("obj");
		new_obj.setStr("真的没人比我更懂java");
		System.out.printf(map.get("obj").toString()+"; ");

		String s = new String(new char[] {'没','人','比','我','更','懂','j','a','v','a'});
		String si = "没人比我更懂java";
		System.out.println(s == si);
		System.out.println(s.intern() == "没人比我更懂java");
		System.out.println(s == si.intern());
	}
	static class StrObject{
		String str;
		public StrObject(String str){
			this.str = str;
		}
		public void setStr(String str){
			this.str = str;
		}
		@Override
		public String toString() {
			return str;
		}
	}
}
