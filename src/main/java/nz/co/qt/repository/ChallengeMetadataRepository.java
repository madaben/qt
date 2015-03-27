package nz.co.qt.repository;

import nz.co.qt.domain.Challenge;
import nz.co.qt.domain.ChallengeMetadata;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChallengeMetadataRepository extends
		JpaRepository<ChallengeMetadata, Long> {

	ChallengeMetadata findByChallenge(Challenge challenge);
}
