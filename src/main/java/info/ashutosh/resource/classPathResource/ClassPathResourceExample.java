package info.ashutosh.resource.classPathResource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class ClassPathResourceExample {

	public static void main(String[] args) {
		try {
			// Create a ClassPathResource representing a resource in the classpath
			Resource resource = new ClassPathResource("data/sample.txt");

			// Check if the resource exists
			if (resource.exists()) {
				System.out.println("Resource exists!");

				// Access the resource's content
				System.out.println("Resource content:\n" + readResourceContent(resource));
			} else {
				System.out.println("Resource does not exist!");
			}
		} catch (IOException e) {
			System.out.println("Error reading resource!");
		}
	}

	private static String readResourceContent(Resource resource) throws IOException {
		Path filePath = resource.getFile().toPath();
		return Files.readString(filePath, StandardCharsets.UTF_8);
	}
}
