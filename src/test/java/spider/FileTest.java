package spider;

import java.io.File;

public class FileTest {
	public static void main(String[] args) {
		String PictureUrl="D:"+File.separator+"book-img";
		File file=new File(PictureUrl); 
		System.out.println(file.exists());
	}

}
