package com.language.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.language.dto.CheckErrorDto;
import com.language.service.LanguageServiceDemo;

@RestController
public class Test {

    @GetMapping(value = "/")
    public String getMethodName() {
        return "new SomeData()";
    }

    @GetMapping(value = "/language/list")
    public Map<Integer, String> getLanguageList() {

        return LanguageServiceDemo.languageSupported;
    }

    @GetMapping(value = "/language/{id}")
    public String getMethodName(@PathVariable int id) {
        return LanguageServiceDemo.languageSupported.get(id);
    }

    @PostMapping(value = "/language/test")
    public ResponseEntity<List<CheckErrorDto>> getMethodName(@RequestParam String text, @RequestParam int id) {
        // return new SomeData();
        Optional<List<CheckErrorDto>> testResult = LanguageServiceDemo.testString(text, id);
        if (testResult.isPresent()) {
            return new ResponseEntity<List<CheckErrorDto>>(testResult.get(), HttpStatus.OK);
        } else
            return new ResponseEntity<List<CheckErrorDto>>(HttpStatus.OK);
    }

}
