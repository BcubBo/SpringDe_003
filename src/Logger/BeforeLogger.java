package Logger;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.aop.MethodBeforeAdvice;

public class BeforeLogger implements MethodBeforeAdvice {
	private Logger logger = (Logger)LogManager.getLogger();
	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println(arg2+"\n"+arg0.getName()+"\n"+arg1[0]);
		logger.info("开始执行方法");
	}

}
