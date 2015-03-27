package nz.co.qt.service;

import java.util.Collection;
import java.util.List;

import nz.co.qt.domain.Challenge;
import nz.co.qt.domain.ChallengeDetails;
import nz.co.qt.domain.ChallengeMetadata;
import nz.co.qt.vo.ChallengeVO;

import org.springframework.dao.DataAccessException;

/**
 */
public interface ChallengeService {

	Collection<ChallengeDetails> findChallengeDetails()
			throws DataAccessException;

	ChallengeDetails findChallengeDetailsById(Long id)
			throws DataAccessException;

	List<ChallengeDetails> findChallengeDetailsByDesc(String desc)
			throws DataAccessException;

	Challenge newChallenge(ChallengeVO challengeVO) throws DataAccessException;

	Challenge findChallengeById(Long id) throws DataAccessException;

	ChallengeDetails findChallengeDetailsByChallenge(Challenge challenge)
			throws DataAccessException;

	Challenge editChallengeVO(ChallengeVO challengeVO, Long challengeId)
			throws DataAccessException;

	ChallengeMetadata findChallengeMetadataByChallenge(Challenge challenge)
			throws DataAccessException;

}
