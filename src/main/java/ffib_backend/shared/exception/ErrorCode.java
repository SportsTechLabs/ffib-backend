package ffib_backend.shared.exception;

import org.springframework.http.HttpStatus;

public interface ErrorCode {

  String getCode();

  String getTitle();

  HttpStatus getHttpStatus();
}
