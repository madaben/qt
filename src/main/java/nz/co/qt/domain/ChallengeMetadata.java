package nz.co.qt.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "challenge_metadata")
public class ChallengeMetadata extends BaseEntity {

	@Column(name = "group_age")
	private String groupAge;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "challenge_metadata_category", joinColumns = { @JoinColumn(name = "metadata_category_id") }, inverseJoinColumns = { @JoinColumn(name = "category_id") })
	private List<Category> categories = new ArrayList<Category>();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "challenge_ID", nullable = false)
	private Challenge challenge;

	public String getGroupAge() {
		return groupAge;
	}

	public void setGroupAge(String groupAge) {
		this.groupAge = groupAge;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Challenge getChallenge() {
		return challenge;
	}

	public void setChallenge(Challenge challenge) {
		this.challenge = challenge;
	}

	@Transient
	public List<Long> getCategoriesIDs() {
		if (categories == null) {
			return null;
		}
		List<Long> ids = new ArrayList<Long>();
		for (Category category : categories) {
			ids.add(category.getId());
		}
		return ids;
	}
}
