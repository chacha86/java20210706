package example.test;

public class Test1 {

	public static void main(String[] args) {

		String str = "aaa.bbb.ccc.ddd";
		
		String[] strArr = str.split("\\.");
		
		for(int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
		}
		
	}

}
