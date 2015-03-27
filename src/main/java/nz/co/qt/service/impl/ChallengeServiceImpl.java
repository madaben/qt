package nz.co.qt.service.impl;

import java.util.Collection;
import java.util.List;

import nz.co.qt.domain.Category;
import nz.co.qt.domain.Challenge;
import nz.co.qt.domain.ChallengeDetails;
import nz.co.qt.domain.ChallengeMetadata;
import nz.co.qt.repository.CategoryRepository;
import nz.co.qt.repository.ChallengeMetadataRepository;
import nz.co.qt.repository.DataChallengeDetailsRepository;
import nz.co.qt.repository.DataChallengeRepository;
import nz.co.qt.service.ChallengeService;
import nz.co.qt.vo.ChallengeVO;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 */
@Service
public class ChallengeServiceImpl implements ChallengeService {

	@Autowired
	private DataChallengeDetailsRepository dataChallengeDetailsRepository;
	@Autowired
	private DataChallengeRepository dataChallengeRepository;
	@Autowired
	private ChallengeMetadataRepository challengeMetadataRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	@Transactional(readOnly = true)
	public Collection<ChallengeDetails> findChallengeDetails()
			throws DataAccessException {
		return dataChallengeDetailsRepository.findChallengeDetails();
	}

	@Override
	@Transactional(readOnly = true)
	public ChallengeDetails findChallengeDetailsById(Long id)
			throws DataAccessException {
		return dataChallengeDetailsRepository.findById(id);
	}

	@Override
	@Transactional
	public Challenge newChallenge(ChallengeVO challengeVO)
			throws DataAccessException {
		Challenge challenge = dataChallengeRepository.save(challengeVO
				.getChallenge());
		challenge.getChallengeMetadata().setChallenge(challenge);
		challenge.setChallengeDetails(challengeVO.getChallenge()
				.getChallengeDetails());
		challenge.getChallengeDetails().setChallenge(challenge);
		List<Category> categories = categoryRepository.findAll(challengeVO
				.getCategoriesIDs());
		challenge.getChallengeMetadata().setCategories(categories);
		return challenge;

	}

	@Override
	@Transactional
	public List<ChallengeDetails> findChallengeDetailsByDesc(String desc)
			throws DataAccessException {
		return dataChallengeDetailsRepository.findByDescriptionLike("%" + desc
				+ "%");
	}

	@Override
	@Transactional(readOnly = true)
	public Challenge findChallengeById(Long id) throws DataAccessException {
		Challenge challenge = dataChallengeRepository.findById(id);
		Hibernate.initialize(challenge.getChallengeMetadata().getCategories());
		return challenge;
	}

	@Override
	@Transactional(readOnly = true)
	public ChallengeDetails findChallengeDetailsByChallenge(Challenge challenge)
			throws DataAccessException {
		return dataChallengeDetailsRepository.findByChallenge(challenge);
	}

	@Override
	@Transactional
	public Challenge editChallengeVO(ChallengeVO challengeVO, Long challengeId)
			throws DataAccessException {
		Challenge challenge = findChallengeById(challengeId);
		ChallengeDetails challengeDetails = findChallengeDetailsByChallenge(challenge);
		challenge.setName(challengeVO.getChallenge().getName());
		challengeDetails.setDescription(challengeVO.getChallenge()
				.getChallengeDetails().getDescription());
		challengeDetails.setMoreInfo(challengeVO.getChallenge()
				.getChallengeDetails().getMoreInfo());

		ChallengeMetadata challengeMetadata = findChallengeMetadataByChallenge(challenge);
		challengeMetadata.setGroupAge(challengeVO.getChallenge()
				.getChallengeMetadata().getGroupAge());
		List<Category> categories = categoryRepository.findAll(challengeVO
				.getCategoriesIDs());
		challenge.getChallengeMetadata().setCategories(categories);
		return challenge;
	}

	@Override
	@Transactional(readOnly = true)
	public ChallengeMetadata findChallengeMetadataByChallenge(
			Challenge challenge) throws DataAccessException {
		return challengeMetadataRepository.findByChallenge(challenge);
	}
}
