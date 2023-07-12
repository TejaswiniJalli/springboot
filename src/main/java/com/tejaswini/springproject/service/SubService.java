package com.tejaswini.springproject.service;

import com.tejaswini.springproject.dao.Submission;
import com.tejaswini.springproject.repository.SubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SubService {
    @Autowired
    private SubRepository subRepository;

    public Submission addSubmission(Submission submission) {
       return subRepository.save(submission);
    }

    public List<Submission> getAllSubmissions() {
        return subRepository.findAll();
    }

    public Submission getById(int id) {
        return subRepository.findById(id).get();
    }

    public void deleteSubmission(int id) {
        subRepository.deleteById(id);
    }

    public Submission updateSub(Integer id, Submission submissionDetails) {
        Submission submission = subRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        submission.setDate(submissionDetails.getDate());
        submission.setTechnology(submissionDetails.getTechnology());
        submission.setVendor(submissionDetails.getVendor());
        submission.setEmail(submissionDetails.getEmail());
        submission.setEmail(submissionDetails.getEmail());
        submission.setMobile(submission.getMobile());
        submission.setClient(submission.getClient());
        submission.setImplementation(submission.getImplementation());
        submission.setLead(submissionDetails.getLead());
        submission.setStudent(submissionDetails.getStudent());
        submission.setRecruiter(submissionDetails.getRecruiter());
        submission.setPayRate(submissionDetails.getPayRate());
        submission.setSubmitted(submissionDetails.getSubmitted());

        return submission;

    }
}
