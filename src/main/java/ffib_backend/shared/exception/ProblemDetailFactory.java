package ffib_backend.shared.exception;

import java.time.Instant;
import java.util.UUID;
import org.springframework.http.ProblemDetail;

public final class ProblemDetailFactory {

  private ProblemDetailFactory() {}

  public static ProblemDetail fromBusinessException(BusinessException exception) {

    ProblemDetail problem = ProblemDetail.forStatus(exception.getErrorCode().getHttpStatus());

    problem.setTitle(exception.getErrorCode().getTitle());

    problem.setDetail(exception.getMessage());

    problem.setProperty("code", exception.getErrorCode().getCode());

    problem.setProperty("timestamp", Instant.now());

    problem.setProperty("traceId", UUID.randomUUID().toString());

    return problem;
  }

  public static ProblemDetail internalServerError() {

    ProblemDetail problem = ProblemDetail.forStatus(500);

    problem.setTitle("Internal Server Error");

    problem.setDetail("An unexpected error occurred.");

    problem.setProperty("code", "INTERNAL_SERVER_ERROR");

    problem.setProperty("timestamp", Instant.now());

    problem.setProperty("traceId", UUID.randomUUID().toString());

    return problem;
  }
}
