package nz.co.qt.repository;

import java.util.List;

import nz.co.qt.domain.Challenge;
import nz.co.qt.domain.ChallengeDetails;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 */

public interface DataChallengeDetailsRepository extends
		JpaRepository<ChallengeDetails, Long> {

	ChallengeDetails findById(Long id) throws DataAccessException;

	@Query("SELECT challengeDetails FROM ChallengeDetails challengeDetails")
	List<ChallengeDetails> findChallengeDetails() throws DataAccessException;

	@Query("SELECT challengeDetails FROM ChallengeDetails challengeDetails where challengeDetails.description like :desc ")
	List<ChallengeDetails> findByDescriptionLike(@Param("desc") String desc)
			throws DataAccessException;

	ChallengeDetails findByChallenge(Challenge challenge);
}
