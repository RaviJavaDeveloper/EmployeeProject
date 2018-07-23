
package org.cytrion.models;


import javax.ws.rs.BadRequestException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.xml.bind.ValidationException;



@javax.ws.rs.ext.Provider
public class ValidationExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        Throwable badRequestException 
        = getBadRequestException(exception);
    if (badRequestException != null) {
        System.out.println("checked");
      return Response.status(Status.BAD_GATEWAY)
          .entity(badRequestException.getMessage())
          .build();
    }
    if (exception instanceof WebApplicationException) {
        System.out.println("web error");
      return ((WebApplicationException)exception)
          .getResponse();
    }
        System.out.println("server errror");
    return Response.serverError()
        .entity(exception.getMessage())
        .build();
  }

  private Throwable getBadRequestException(
      Throwable exception) {
    if (exception instanceof ValidationException) {
        System.out.println("ValidationException");
      return exception;
    }
    Throwable cause = exception.getCause();
    if (cause != null && cause != exception) {
        System.out.println("check cause");
      Throwable result = getBadRequestException(cause);
      if (result != null) {
          System.out.println("something");
        return result;
      }
    }
    if (exception instanceof IllegalArgumentException) {
        System.out.println("IAException");
      return exception;
    }
    if (exception instanceof BadRequestException) {
        System.out.println("BRException");
      return exception;
    }
      System.out.println("null");
    return null;
  }


}
