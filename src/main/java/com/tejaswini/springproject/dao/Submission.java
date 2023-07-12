package com.tejaswini.springproject.dao;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Submission{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String date;
        private String technology;
        private String vendor;
        private String email;
        private String mobile;
        private String client;
        private String implementation;
        private String lead;
        private String student;
        private String recruiter;
        private long payRate;
        private Boolean submitted;


}

