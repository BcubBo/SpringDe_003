package Logger;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.aop.AfterReturningAdvice;

public class AfterLogger implements AfterReturningAdvice {
	private Logger logger = (Logger)LogManager.getLogger();
	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		
		logger.info("方法执行完毕");
		System.out.println(arg3+"\n"+arg1.getName()+"\n"+arg2[0]+"\n"+"后置增强获得返回值:"+arg0);
	}

}
