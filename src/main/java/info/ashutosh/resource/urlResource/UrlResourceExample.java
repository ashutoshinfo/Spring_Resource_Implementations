package info.ashutosh.resource.urlResource;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.net.MalformedURLException;

public class UrlResourceExample {

	public static void main(String[] args) {
		try {
			// Create a UrlResource representing a file URL
			Resource resource = new UrlResource("file:/C:\\Users\\ashut\\Desktop\\Ongoing thoughts.txt");

			// Check if the resource exists
			if (resource.exists()) {
				System.out.println("Resource exists!");

				// Access the resource's content
				System.out.println("Resource content:\n" + readResourceContent(resource));
			} else {
				System.out.println("Resource does not exist!");
			}
		} catch (MalformedURLException e) {
			System.out.println("Invalid URL specified!");
		} catch (IOException e) {
			System.out.println("Error reading resource!");
		}
	}

	private static String readResourceContent(Resource resource) throws IOException {
		StringBuilder content = new StringBuilder();
		try (java.util.Scanner scanner = new java.util.Scanner(resource.getInputStream())) {
			while (scanner.hasNextLine()) {
				content.append(scanner.nextLine()).append("\n");
			}
		}
		return content.toString();
	}
}
