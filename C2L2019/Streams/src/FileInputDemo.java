import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputDemo {
	public static void main(String[] args) {
		String path = "/Volumes/KB/Demo/Song.txt";
		FileInputStream istream = null;
		int c = 0;

		try {
			istream = new FileInputStream(path);
			
			byte[] bar = new byte[istream.available()];
			istream.read(bar);
			String str = new String(bar);
			System.out.println(str);
			
//			while (true) {
//				c = istream.read();
//				if (c == -1) // EOF
//					break;
//				System.out.print((char)c);
//			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(istream != null)
					istream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
