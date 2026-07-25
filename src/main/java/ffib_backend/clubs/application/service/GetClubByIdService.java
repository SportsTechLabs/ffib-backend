package ffib_backend.clubs.application.service;

import ffib_backend.clubs.application.port.in.GetClubByIdUseCase;
import ffib_backend.clubs.application.port.out.ClubPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetClubByIdService implements GetClubByIdUseCase {

    private final ClubPersistencePort clubPersistencePort;
}
