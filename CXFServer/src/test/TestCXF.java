package test;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import com.git.service.IService;
import com.git.service.impl.ServiceImpl;

public class TestCXF {

	public static void main(String[] args) {
		 JaxWsServerFactoryBean factoryBean=new JaxWsServerFactoryBean();
		 factoryBean.setAddress("http://localhost:9999/service");
		 factoryBean.setServiceClass(IService.class);
		 factoryBean.setServiceBean(new ServiceImpl());
		 //factoryBean.getInFaultInterceptors();
		 Server s=factoryBean.create();
		 System.out.println(s);
	}
}
