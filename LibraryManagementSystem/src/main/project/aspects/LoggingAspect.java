package edu.sjsu.cmpe275.project.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import edu.sjsu.cmpe275.project.dao.UserDaoImpl;
@Aspect
@Component
public class LoggingAspect {
	
	/** Logger to log the messages onto console */
	static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	@Before("execution(public * edu.sjsu.cmpe275.project.util.CustomMailSender.send*(..))")
	public void loggingBeforeSendMail(JoinPoint jp) {
		logger.info("Executing asynchronous :" + jp.getSignature().getName() );
	}
	

	@AfterReturning("execution(public * edu.sjsu.cmpe275.project.util.CustomMailSender.send*(..))") 
	public void loggingAfterSendMail(JoinPoint jp) {
	
		logger.error("Asynchronous mail sent successful through :" + jp.getSignature().getName() );
	}
	

	@Before("execution(public * edu.sjsu.cmpe275.project.controller.PatronController.*(..))")
	public void loggingBeforePatron(JoinPoint jp) {
		logger.info("PatronController Executing :" + jp.getSignature().getName() );
	}
	

	@AfterReturning("execution(public * edu.sjsu.cmpe275.project.controller.PatronController.*(..))") 
	public void loggingAfterPatron(JoinPoint jp) {
		logger.info("PatronController successful return after :" + jp.getSignature().getName() );
	}
	
	
	@Before("execution(public * edu.sjsu.cmpe275.project.controller.LibrarianController.*(..))")
	public void loggingBeforeLibrarian(JoinPoint jp) {
		logger.info("LibrarianController Executing :" + jp.getSignature().getName() );
	}
	
	
	@AfterReturning("execution(public * edu.sjsu.cmpe275.project.controller.LibrarianController.*(..))") 
	public void loggingAfterLibrarian(JoinPoint jp) {
		logger.info("LibrarianController successful return after :" + jp.getSignature().getName() );
	}
	

	@Before("execution(public * edu.sjsu.cmpe275.project.controller.LoginController.*(..))")
	public void loggingBeforeLogin(JoinPoint jp) {
		logger.info("LoginController Executing :" + jp.getSignature().getName() );
	}
	

	@AfterReturning("execution(public * edu.sjsu.cmpe275.project.controller.LoginController.*(..))") 
	public void loggingAfterLogin(JoinPoint jp) {
		logger.info("LoginController successful return after :" + jp.getSignature().getName() );
	}
		
}
