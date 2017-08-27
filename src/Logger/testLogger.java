package Logger;





import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;



public class testLogger {
	Logger logger = (Logger)LogManager.getLogger();//log4j2.x
	//Logger logger = Logger.getLogger(TestBiz.class);//log4j1.x
	public void beforeLogger(JoinPoint jp) {
		System.out.println("=======================================");
		System.out.println(jp.getTarget()+"\n"+jp.getSignature().getName()+"\n"+jp.getArgs()[0]);
		logger.info("方法执行前");
	}
	
	public void afterReturningLogger(JoinPoint jp,Object result) {
		System.out.println("=======================================");
		logger.info("方法执行结束后");
		System.out.println(jp.getTarget()+"\n"+jp.getSignature().getName()+"\n"+jp.getArgs()[0]+
				" 返回:"+result);
		
		//String msg = (String)result;
		
		
	}//
	
	public Object around(ProceedingJoinPoint jp) {
		
		logger.info("开始执行方法, message, p0, p1, p2, p3, p4, p5, p6, p7");
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

		logger.info("方法执行完毕, message, p0, p1, p2, p3, p4, p5, p6, p7");
		return result;
		
		
		
		
	}
	//
	public void afterThrowing(JoinPoint jp,Exception e) {
		
		logger.info("方法执行出现异常:"+e.getMessage());
	}
	//后置异常
	
	public void after(JoinPoint jp) {
		//finally块的类似实现
		
		logger.info("始终执行的块");
		
		
	}
	
	
}
