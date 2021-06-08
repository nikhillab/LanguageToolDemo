package com.language.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "master_qa_issue_type")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class MasterQAIssueType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5390778214723008184L;

	@Id
	private UUID id;

	private String issueString;

	@Column(name = "master_qa_rules_id")
	private int masterQARulesId;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "master_qa_rules_id", nullable = false, insertable = false, updatable = false)
	private MasterQARules masterQARules;

	@PrePersist
	private void onCreate() {
		id = UUID.randomUUID();
	}
}
