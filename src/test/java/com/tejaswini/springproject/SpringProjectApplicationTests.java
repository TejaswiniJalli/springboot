package com.tejaswini.springproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tejaswini.springproject.dao.Submission;
import com.tejaswini.springproject.repository.SubRepository;
import com.tejaswini.springproject.service.SubService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class SpringProjectApplicationTests {


	@Autowired
	SubRepository submissionRepository= Mockito.mock(SubRepository.class);


	@ExtendWith(MockitoExtension.class)
	@Test
	void testPostSubmission(){
		var submission= Submission.builder()
				.id(1)
				.lead("vinay")
				.technology("java")
				.date("12/13/2022")
				.email("tj@gmail.com.com")
				.client("JPMC")
				.mobile("1234567890")
				.payRate(76)
				.implementation("deloite")
				.student("tejaswini")
				.recruiter("sai")
				.submitted(true)
				.vendor("nytho info")
				.build();

		System.out.println(submission);
		Assertions.assertNotNull(submissionRepository.save(submission));

	}

	@Test
	void testGetSubmissionById(){
		var submission= Submission.builder()
				.id(11)
				.lead("vinay")
				.technology("java")
				.date("12/13/2022")
				.email("tj@gmail.com.com")
				.client("JPMC")
				.mobile("1234567890")
				.payRate(76)
				.implementation("deloite")
				.student("tejaswini")
				.recruiter("sai")
				.submitted(true)
				.vendor("nytho info")
				.build();
		submissionRepository.save(submission);
		Submission savedSub=submissionRepository.findById(11).get();
		System.out.println(savedSub.getId());
		assertEquals(submission.getId(),savedSub.getId());


	}
	@Test
	void testDeleteSubmissionById(){
		var submission= Submission.builder()
				.id(11)
				.date("12/13/2022")
				.email("tj@gmail.com.com")
				.client("JPMC")
				.mobile("1234567890")
				.lead("vinay")
				.technology("java")
				.payRate(76)
				.implementation("deloite")
				.student("tejaswini")
				.recruiter("sai")
				.submitted(true)
				.vendor("nytho info")
				.build();
		Submission savedSub=submissionRepository.save(submission);
		submissionRepository.deleteById(11);
		Optional optional = submissionRepository.findById(submission.getId());
		assertEquals(Optional.empty(), optional);

	}

}