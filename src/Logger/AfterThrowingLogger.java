package Logger;

import java.io.IOException;
import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class AfterThrowingLogger implements ThrowsAdvice {
	//自定义
	
	public void afterThrowing(Method arg0,Object[] arg1,Object arg2,IOException e)throws Throwable{
		
		System.out.println("自定义的异常方法");
		
		
		
	}
	//
	
	public void afterThrowing(Method arg0,Object[] arg1,Object arg2,RuntimeException e)throws Throwable{
		System.out.println("自定义的异常重载方法");
		//自定义
		
		
	}
	
	

}
