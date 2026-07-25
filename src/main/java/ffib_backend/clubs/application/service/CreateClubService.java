package ffib_backend.clubs.application.service;

import ffib_backend.clubs.application.port.in.CreateClubUseCase;
import ffib_backend.clubs.application.port.out.ClubPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateClubService implements CreateClubUseCase {

    private final ClubPersistencePort clubPersistencePort;
}
