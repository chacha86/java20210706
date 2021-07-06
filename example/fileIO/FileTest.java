package example.fileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class FileTest {

	public static void main(String[] args) {

		try {
			FileWriter fw = new FileWriter("c:/test/out.txt");
			fw.write("안녕하세요~~~");
			fw.close();

		} catch (Exception e) {
			System.out.println("파일 출력중 에러 발생");
		}

		try {
			FileReader fr = new FileReader("c:/test/out.txt");
			BufferedReader br = new BufferedReader(fr);
			String str = br.readLine();			
			
			System.out.println(str);
			
		} catch(Exception e) {
			System.out.println("파일 입력중 에러");
		}

	}

}
