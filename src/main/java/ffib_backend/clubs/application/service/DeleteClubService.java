package ffib_backend.clubs.application.service;

import ffib_backend.clubs.application.port.in.DeleteClubUseCase;
import ffib_backend.clubs.application.port.out.ClubPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteClubService implements DeleteClubUseCase {

    private final ClubPersistencePort clubPersistencePort;
}
