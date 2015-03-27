package nz.co.qt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Challenge_Details")
public class ChallengeDetails extends BaseEntity {

	private static final long serialVersionUID = -1983183253029181219L;

	@Column(name = "Description")
	private String description;

	@Column(name = "More_info")
	private String moreInfo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "challenge_ID", nullable = false)
	private Challenge challenge;

	public Challenge getChallenge() {
		return challenge;
	}

	public void setChallenge(Challenge challenge) {
		this.challenge = challenge;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMoreInfo() {
		return moreInfo;
	}

	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@Column(name = "duration")
	private Integer duration;

}
