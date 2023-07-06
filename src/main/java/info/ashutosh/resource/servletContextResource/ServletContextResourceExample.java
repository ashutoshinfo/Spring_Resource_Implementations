//package info.ashutosh.resource.servletContextResource;
//
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.ServletContextResource;
//
//import javax.servlet.ServletContext;
//import java.io.IOException;
//import java.io.InputStream;
//
//public class ServletContextResourceExample {
//
//	private ServletContext servletContext;
//
//	public ServletContextResourceExample(ServletContext servletContext) {
//		this.servletContext = servletContext;
//	}
//
//	public void readResourceContent(String resourcePath) throws IOException {
//		Resource resource = new ServletContextResource(servletContext, resourcePath);
//
//		// Check if the resource exists
//		if (resource.exists()) {
//			System.out.println("Resource exists!");
//
//			// Access the resource's content
//			try (InputStream inputStream = resource.getInputStream()) {
//				// Read the resource's content from the input stream
//				// ...
//			}
//		} else {
//			System.out.println("Resource does not exist!");
//		}
//	}
//}
