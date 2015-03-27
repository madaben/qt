package nz.co.qt.repository;

import nz.co.qt.domain.Challenge;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataChallengeRepository extends JpaRepository<Challenge, Long> {

	Challenge findById(Long id) throws DataAccessException;
}
