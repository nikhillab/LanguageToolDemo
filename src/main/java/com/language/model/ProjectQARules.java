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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "project_qa_rules")
@AllArgsConstructor
public class ProjectQARules implements Serializable {

	private static final long serialVersionUID = -2045758284504967973L;

	@Id
	private UUID id;

	@Column(name = "project_id")
	private UUID projectId;

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
