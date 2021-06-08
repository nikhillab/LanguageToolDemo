package com.language.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "key_locale_value_qa_issues")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class KeyLocaleValueQAIssues implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1511177174775157820L;

	/*
	 * Id ProjectID (Denormalization, but kept to easily serve queries to fetch QA
	 * issues for a given project) Is_ignored (Users can ignore certain qa issues)
	 * Key_locale_value_id (Key locale value for which the issue was raised)
	 * Master_QA_Issue_Type_ID (Master issue type
	 */

	@Id
	private UUID id;

	private UUID projectId;

	private boolean isIgnored;

	private UUID keyLocalValueId;

	@Column(name = "master_qa_issue_type_id")
	private UUID masterQAIssueTypeId;

	@JsonIgnore
	@OneToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "master_qa_issue_type_id", nullable = false, insertable = false, updatable = false)
	private MasterQAIssueType masterQAIssueType;

	@PrePersist
	private void onCreate() {
		id = UUID.randomUUID();
	}
}
