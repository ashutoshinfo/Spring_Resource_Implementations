package info.ashutosh.resource.inputStreamResource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

public class InputStreamResourceExample {

	public static void main(String[] args) {
		try {
			// Create an InputStream representing the resource
			InputStream inputStream = new FileInputStream("C:\\Users\\ashut\\Desktop\\Ongoing thoughts.txt");

			// Create an InputStreamResource from the InputStream
			Resource resource = new InputStreamResource(inputStream);

			// Access the resource's content
			if (resource.exists()) {
				System.out.println("Resource exists!");

				// Access the resource's content
				System.out.println("Resource content:\n" + readResourceContent(resource));
			} else {
				System.out.println("Resource does not exist!");
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error reading resource!");
		}
	}

	private static String readResourceContent(Resource resource) throws IOException {
//		byte[] bytes = new byte[(int) resource.contentLength()];
//		try (InputStream inputStream = resource.getInputStream()) {
//			inputStream.read(bytes);
//		}
//		return new String(bytes);

		Path filePath = resource.getFile().toPath();
		return Files.readString(filePath, StandardCharsets.UTF_8);
	}
}
