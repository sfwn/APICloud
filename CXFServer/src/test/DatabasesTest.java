package test;



import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.git.dao.impl.UserDao;
import com.git.entity.User;


public class DatabasesTest  //extends HibernateDaoSupport
{
	
	
     private  SessionFactory sessionFactory;
     
	 
   public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
    

   public void u(){
	   Session session = sessionFactory.openSession();

       Transaction transaction = session.beginTransaction();

      User user = new User();
       user.setUsername("admin");
		user.setPassword("111");
       session.save(user);

       transaction.commit();

       session.close();
   }


	public static void main(String[] args)
	{
	   /* ApplicationContext context = new ClassPathXmlApplicationContext(

                "cxf-servlet.xml");  

        SessionFactory factory = (SessionFactory) context   

                .getBean("sessionFactory");   //spring直接帮我们加载了hibernate.cgf.xml文件，让我们直接操作了sessionfactory。其实下面的事务管理我们也可以通过spring的来管理的。但是由于没写一个一个代理类所以就没写。

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        User user = (User) context.getBean("user");
        user.setUsername("admin");
		user.setPassword("111");
        session.save(user);

        transaction.commit();

        session.close();*/
		
		/* HashMap params = new HashMap();
  		 params.put("username", "admin");
  		 params.put("password", "111");
         User s =new UserDao().login(params);

        System.out.println(s.toString());*/
		/*User user = new User();
		 user.setUsername("admin");
			user.setPassword("111");
		new UserDao().reg(user);*/
		new DatabasesTest().u();
	}
}
