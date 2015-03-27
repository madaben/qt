package nz.co.qt.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import nz.co.qt.domain.Challenge;
import nz.co.qt.domain.enumeration.GroupAge;

public class ChallengeVO implements Serializable {

	private static final long serialVersionUID = 2943568458233000694L;
	private final GroupAge[] groupAges = GroupAge.values();

	private Challenge challenge;
	private List<Long> categoriesIDs = new ArrayList<Long>();

	public Challenge getChallenge() {
		return challenge;
	}

	public void setChallenge(Challenge challenge) {
		this.challenge = challenge;
	}

	public GroupAge[] getGroupAges() {
		return groupAges;
	}

	public List<Long> getCategoriesIDs() {
		return categoriesIDs;
	}

	public void setCategoriesIDs(List<Long> categoriesIDs) {
		this.categoriesIDs = categoriesIDs;
	}
}
