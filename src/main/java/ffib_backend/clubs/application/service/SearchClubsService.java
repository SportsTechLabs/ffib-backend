package ffib_backend.clubs.application.service;

import ffib_backend.clubs.application.port.in.SearchClubsUseCase;
import ffib_backend.clubs.application.port.out.ClubPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchClubsService implements SearchClubsUseCase {

    private final ClubPersistencePort clubPersistencePort;
}
