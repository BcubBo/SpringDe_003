package Logger;





import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class testLogger {
	//定义公共切点
	@Pointcut("execution(public * biz..*(..))")
	public void pointcut() {}
	//<aop:poingcut id="pointcut()"....>
	//定义的方式
	
	
	Logger logger = (Logger)LogManager.getLogger();//log4j2.x
	//Logger logger = Logger.getLogger(TestBiz.class);//log4j1.x
	
	@Before("pointcut()")
	public void beforeLogger(JoinPoint jp) {
		System.out.println("=======================================");
		System.out.println(jp.getTarget()+"\n"+jp.getSignature().getName()+"\n"+jp.getArgs()[0]);
		logger.debug("方法执行前");
	}
	@AfterReturning(pointcut="pointcut()",
			returning="result")
	//注解声明
	public void afterReturningLogger(JoinPoint jp,Object result) {
		System.out.println("=======================================");
		logger.debug("方法执行结束后");
		System.out.println(jp.getTarget()+"\n"+jp.getSignature().getName()+"\n"+jp.getArgs()[0]+
				" 返回:"+result);
		
		//String msg = (String)result;
		
		
	}//
	@Around("pointcut()")
	public Object around(ProceedingJoinPoint jp) {
		
		logger.debug("开始执行方法使用注解的方式进行环绕注入方法切面");
		boolean canExec = false;
		//返回Object对象
		//set canExec
		String input = (String)jp.getArgs()[0];
		//获取返回值
		if(input.equals("XXX")) {
			
			canExec = true;
		}
		Object result = null;
		try {
			if(canExec) {
				
				result = jp.proceed();	
			}else {
				result="业务方法的返回值不符合要求";
			}
			
		} catch (Throwable e) {
			e.printStackTrace();
		}

		logger.info("方法执行完毕环绕方法");
		return result;
		
		
		
		
	}
	//
	@AfterThrowing(pointcut="pointcut()",
			throwing="e")
	public void afterThrowing(JoinPoint jp,Exception e) {
		
		logger.debug("方法执行出现异常:"+e.getMessage());
	}
	//后置异常
	
	public void after(JoinPoint jp) {
		//finally块的类似实现
		
		logger.debug("始终执行的块");
		
		
	}
	
	
}
