package com.question.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.question.dao.CompanyRepository;
import com.question.model.Company;

@RestController
public class CompanyController {

	private CompanyRepository companyRepository;

	@GetMapping("/company/{companyId}")
	public ResponseEntity<Company> getCompanyById(@PathVariable Long companyId) {

		Optional<Company> findById = companyRepository.findById(companyId);
		if (findById.isPresent()) {
			return new ResponseEntity<Company>(findById.get(), HttpStatus.OK);
		}

		return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);

	}

	@GetMapping("/companys")
	public ResponseEntity<Iterable<Company>> getCompanyList() {
		return new ResponseEntity<Iterable<Company>>(companyRepository.findAll(), HttpStatus.OK);

	}

	@PostMapping("/company")
	public ResponseEntity<Company> createCompany(@RequestBody Company company) {

		Company save = companyRepository.save(company);
		return new ResponseEntity<Company>(save, HttpStatus.CREATED);

	}

	@PutMapping("/company")
	public ResponseEntity<Company> updateCompany(@RequestBody Company company) {

		boolean findById = companyRepository.existsById(company.getCompanyId());

		if (findById) {
			Company save = companyRepository.save(company);
			return new ResponseEntity<Company>(save, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	@DeleteMapping("/company/{companyId}")
	public ResponseEntity<Company> deleteCompany(@PathVariable Long companyId) {

		boolean findById = companyRepository.existsById(companyId);
		if (findById) {
			companyRepository.deleteById(companyId);
			return new ResponseEntity<>(HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

	public CompanyController(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

}
