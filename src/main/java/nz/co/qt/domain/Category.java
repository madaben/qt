package nz.co.qt.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
public class Category extends BaseEntity {

	private String Name;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "parent_category")
	private Category parentCategory;

	@OneToMany(mappedBy = "parentCategory")
	private Set<Category> subCategories = new HashSet<Category>();

	@ManyToMany(mappedBy = "categories")
	private List<ChallengeMetadata> employees = new ArrayList<ChallengeMetadata>();

	@Column(name = "name")
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	public Set<Category> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(Set<Category> subCategories) {
		this.subCategories = subCategories;
	}

	public List<ChallengeMetadata> getEmployees() {
		return employees;
	}

	public void setEmployees(List<ChallengeMetadata> employees) {
		this.employees = employees;
	}
}
