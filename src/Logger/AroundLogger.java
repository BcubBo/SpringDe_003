package Logger;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class AroundLogger implements MethodInterceptor {
	private Logger logger = (Logger)LogManager.getLogger();
	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		logger.info("环绕方法执行前");
		System.out.println(arg0.getThis()+"\n"+arg0.getMethod()+"\n"+arg0.getArguments()[0]);
		Object result = arg0.proceed();
		//继续执行方法
		logger.info("环绕方法执行结束");
		return result;
	}

}
