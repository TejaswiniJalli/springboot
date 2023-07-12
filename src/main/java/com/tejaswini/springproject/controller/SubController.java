package com.tejaswini.springproject.controller;

import com.tejaswini.springproject.dao.Submission;
import com.tejaswini.springproject.service.SubService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/submissions")
public class SubController {
    @Autowired
    private SubService subService;
    @PostMapping
    public ResponseEntity<Submission> addSubmission(@Valid @RequestBody Submission submission){
        return ResponseEntity.status(HttpStatus.CREATED).body(subService.addSubmission(submission));

    }
    @GetMapping
    public  ResponseEntity<List<Submission>> getAllSubmissions(){
        return ResponseEntity.status(HttpStatus.OK).body(subService.getAllSubmissions());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Submission> getById(@PathVariable int id){

        return ResponseEntity.status(HttpStatus.OK).body(subService.getById(id));
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteSubmission(@PathVariable int id){
        subService.deleteSubmission(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted");

    }

    @PutMapping("/{id}")
    public  ResponseEntity<Submission> updateSub(@Valid @PathVariable("id") Integer id, @RequestBody Submission submission) {
        return ResponseEntity.status(HttpStatus.OK).body(subService.updateSub(id, submission));
    }
}
