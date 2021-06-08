package com.language.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "master_qa_rules")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MasterQARules implements Serializable {

	private static final long serialVersionUID = 6882035291972294431L;

	@Id
	@Column(unique = true)
	private Integer id;

	private String ruleName;

}
