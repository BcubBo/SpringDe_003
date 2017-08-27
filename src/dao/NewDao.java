package dao;

import org.springframework.stereotype.Repository;

@Repository("testDao")
//等同于xml中的:<bean id="testDao" class=""/>
public class NewDao implements ITestDao {

	@Override
	public void testDao() {
		System.out.println("new implements class NewDao");
	}
}
