package ffib_backend.shared.exception;

import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(BusinessException.class)
  public ProblemDetail handleBusinessException(BusinessException exception) {

    return ProblemDetailFactory.fromBusinessException(exception);
  }

  @ExceptionHandler(Throwable.class)
  public ProblemDetail handleUnexpectedException(Throwable exception) {

    return ProblemDetailFactory.internalServerError();
  }
}
