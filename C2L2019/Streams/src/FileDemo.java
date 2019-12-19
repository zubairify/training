import java.io.File;
import java.util.Date;

public class FileDemo {
	public static void main(String[] args) {
		File file = new File("/Volumes/KB/Demo");
		
		if(file.exists()) {
			System.out.println(file.getName());
			System.out.println(file.getPath());
			System.out.println(file.getParent());
			
			if(file.isFile()) {
				System.out.println(file.canWrite());
				System.out.println(file.canRead());
				System.out.println(file.length());
				System.out.println(new Date(file.lastModified()));
			
			} else {
				String[] content = file.list();
				System.out.println("Content of directory");
				for (int i = 0; i < content.length; i++) 
					System.out.println(content[i]);
			}
		} else {
			System.out.println("File does not exist");
		}
	}
}
