package ffib_backend.clubs.application.service;

import ffib_backend.clubs.application.port.in.UpdateClubUseCase;
import ffib_backend.clubs.application.port.out.ClubPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateClubService implements UpdateClubUseCase {

    private final ClubPersistencePort clubPersistencePort;
}
