package info.ashutosh.resource.byteArrayResource;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;

public class ByteArrayResourceExample {

    public static void main(String[] args) throws IOException {
        String content = "Hello, World!";
        byte[] bytes = content.getBytes();

        // Create a ByteArrayResource from the byte array
        Resource resource = new ByteArrayResource(bytes);

        // Access the resource's content
        if (resource.exists()) {
            System.out.println("Resource content:\n" + readResourceContent(resource));
        } else {
            System.out.println("Resource does not exist!");
        }
    }

    private static String readResourceContent(Resource resource) throws IOException {
        byte[] bytes = new byte[(int) resource.contentLength()];
        try (InputStream inputStream = resource.getInputStream()) {
            inputStream.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(bytes);
    }
}
