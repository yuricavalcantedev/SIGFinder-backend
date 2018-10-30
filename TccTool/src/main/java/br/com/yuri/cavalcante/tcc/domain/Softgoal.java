package br.com.yuri.cavalcante.tcc.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Softgoal implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer fatherSoftGoalId;
	private String name;
	private String description;
	private boolean priority;
	private Integer nfrType;
	private Integer contributionType;
	private Integer contributionTypeCatalog;
	private Integer evaluationProcedure;
	
	@OneToMany(mappedBy = "id.softgoal", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Softgoal> softgoalList;
	
	public Softgoal() {
		
	}
	
	public Softgoal(Integer id, Integer fatherSoftGoalId, String name, String description, boolean priority,
			Integer nfrType, Integer contributionType, Integer contributionTypeCatalog, Integer evaluationProcedure,
			List<Softgoal> softgoalList) {
		super();
		this.id = id;
		this.fatherSoftGoalId = fatherSoftGoalId;
		this.name = name;
		this.description = description;
		this.priority = priority;
		this.nfrType = nfrType;
		this.contributionType = contributionType;
		this.contributionTypeCatalog = contributionTypeCatalog;
		this.evaluationProcedure = evaluationProcedure;
		this.softgoalList = softgoalList;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getFatherSoftGoalId() {
		return fatherSoftGoalId;
	}
	
	public void setFatherSoftGoalId(Integer fatherSoftGoalId) {
		this.fatherSoftGoalId = fatherSoftGoalId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean isPriority() {
		return priority;
	}
	
	public void setPriority(boolean priority) {
		this.priority = priority;
	}
	
	public Integer getNfrType() {
		return nfrType;
	}
	
	public void setNfrType(Integer nfrType) {
		this.nfrType = nfrType;
	}
	
	public Integer getContributionType() {
		return contributionType;
	}
	
	public void setContributionType(Integer contributionType) {
		this.contributionType = contributionType;
	}
	
	public Integer getContributionTypeCatalog() {
		return contributionTypeCatalog;
	}
	
	public void setContributionTypeCatalog(Integer contributionTypeCatalog) {
		this.contributionTypeCatalog = contributionTypeCatalog;
	}
	
	public Integer getEvaluationProcedure() {
		return evaluationProcedure;
	}
	
	public void setEvaluationProcedure(Integer evaluationProcedure) {
		this.evaluationProcedure = evaluationProcedure;
	}
	
	public List<Softgoal> getSoftgoalList() {
		return softgoalList;
	}
	
	public void setSoftgoalList(List<Softgoal> softgoalList) {
		this.softgoalList = softgoalList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Softgoal other = (Softgoal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}