package nz.co.qt.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Challenge")
public class Challenge extends BaseEntity {

	@OneToOne(mappedBy = "challenge", cascade = CascadeType.ALL)
	private ChallengeDetails challengeDetails;

	@OneToOne(mappedBy = "challenge", cascade = CascadeType.ALL)
	private ChallengeMetadata challengeMetadata;

	private String Name;

	// private Owner
	// private ChallenegeStatus

	public ChallengeDetails getChallengeDetails() {
		return challengeDetails;
	}

	public void setChallengeDetails(ChallengeDetails challengeDetails) {
		this.challengeDetails = challengeDetails;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public ChallengeMetadata getChallengeMetadata() {
		return challengeMetadata;
	}

	public void setChallengeMetadata(ChallengeMetadata challengeMetadata) {
		this.challengeMetadata = challengeMetadata;
	}
}
