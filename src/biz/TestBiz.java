package biz;

import dao.DaoFactory;
import dao.ITestBiz;
import dao.ITestDao;
import dao.TestDao;

public class TestBiz implements ITestBiz{
	
	private ITestDao dao;
	
	public String testBiz(String msg,Object result)throws Exception {
		
//		ITestDao dao = DaoFactory.getInstance();
		System.out.println("Hello,Spring");
		dao.testDao();
		
		try {
//			int i = 10/0;
		} catch (Exception e) {
			throw e;
		}
		return result.toString();
		
	}
	//某方法
	public ITestDao getDao() {
		return dao;
	}//
	public void setDao(ITestDao dao) {
		System.out.println("走的构造方法");
		this.dao = dao;
	}//

	public TestBiz() {}//无参数构造方法在使用Spring框架的时候需要设置无参数构造方法
	public TestBiz(ITestDao dao) {
		
		this.dao = dao;
		init();
	}//有参数构造方法
	
	public TestBiz(ITestDao dao,String msg){
		
		this.dao = dao;
		
	}//
	
	public TestBiz(String msg,ITestDao dao){
		
		this.dao = dao;
		
	}//重载后的构造方法与上一个构造方法不是同一个
	
	public TestBiz(ITestDao dao,int id) {
		
		this.dao = dao;
		
	}//
	
	//setter设值注入
	
	public void init(){
		
		dao.testDao();
	}
	//初始化
	
}
