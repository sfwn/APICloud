package test;

import java.io.File;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.git.entity.FileSources;
import com.git.service.IService;

public class TestClient {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		// --------------------------[上传]----------------------------

		FileSources fs = new FileSources();
		fs.setFileName("ajax");
		fs.setContentType("txt");
		//加载文件
		DataSource source = new FileDataSource(new File("d:\\ajax.txt"));
		fs.setHandler(new DataHandler(source));

		IService client = (IService) ctx.getBean("client");
		try {
			String result = client.upload(fs); // 此处不能传一个空对象,否则会出错
			System.out.println(result);
			System.out.println("结果：" + result);
		} catch (Exception e) {
			System.out.println("请选择文件！\n");
			System.out.println("抛出异常为" + e.getMessage());
		}
		// --------------------------【END】------------------------
	}
}
