package util.jsf;

import java.lang.ProcessBuilder.Redirect;
import java.util.Iterator;

import javax.faces.FacesException;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import service.NegocioException;

public class JsfExceptionHandler extends ExceptionHandlerWrapper {
	
	private static Log log = LogFactory.getLog(JsfExceptionHandler.class);
	
	public ExceptionHandler wrapped;
		
		
	
	public JsfExceptionHandler(ExceptionHandler wrapped) {
		this.wrapped = wrapped;
	}
	
	
	

	@Override
	public ExceptionHandler getWrapped() {
		// TODO Auto-generated method stub
		return this.wrapped;
	}




	@Override
	public void handle() throws FacesException {
		// TODO Auto-generated method stub
		Iterator<ExceptionQueuedEvent> events = getUnhandledExceptionQueuedEvents().iterator();
		
		while (events.hasNext()) {
			ExceptionQueuedEvent event = events.next();
 			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();
 			
 			Throwable exception = context.getException();
 			
 			 boolean handled = false;
 			 NegocioException negocioException = getNegocioException(exception);
 			 
 			try {
 				if(exception instanceof ViewExpiredException) {
 					handled= true;
 	 				redirect("/");
 	 				
 	 			}else if (negocioException != null) {
 	 				handled = true;
 	 				FacesUtil.addErrorMessage(negocioException.getMessage());
 	 				
 	 			}else {
 	 				handled = true;
 	 				log.error("Erro de sistema" + exception.getMessage(), exception);
 	 				redirect("/Erro.xhtml");
 	 			}
				
			} finally {
				// TODO: handle finally clause
				if(handled) {
				events.remove();
				
				}
			}
 			
		}
		
		getWrapped().handle();
		
	}
	
	
	private NegocioException getNegocioException(Throwable exception) {
		if(exception instanceof NegocioException) {
			return  (NegocioException)exception;
		}else if (exception.getCause() != null ) {
			return getNegocioException(exception.getCause());
		}
		
		return null;
		
	}
	
 	private void redirect(String page) {
 		
 		try {
 			
 			FacesContext context = FacesContext.getCurrentInstance();
 	 		ExternalContext externalContext = context.getExternalContext();
 	 		String contextPath = externalContext.getRequestContextPath();
 	 		
 	 		externalContext.redirect(contextPath + page);
 	 		context.responseComplete();
 		}catch (Exception e) {
			// TODO: handle exception
 			throw new FacesException();
		}
 		
 		
 	}
	
	

}
