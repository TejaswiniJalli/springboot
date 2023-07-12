package com.tejaswini.springproject.controller;

import com.tejaswini.springproject.dao.Submission;
import com.tejaswini.springproject.service.SubService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Submission addSubmission(@RequestBody Submission submission){
        return subService.addSubmission(submission);

    }
    @GetMapping
    public List<Submission> getAllSubmissions(){
        return subService.getAllSubmissions();
    }
    @GetMapping("/{id}")
    public Submission getById(@PathVariable int id){

        return subService.getById(id);
    }
    @DeleteMapping("/{id}")
    public String deleteSubmission(@PathVariable int id){
        subService.deleteSubmission(id);
        return "Deleted";

    }

    @PutMapping("/{id}")
    public Submission updateSub(@PathVariable("id") Integer id, @RequestBody Submission submission) {
        return subService.updateSub(id, submission);
    }
}
