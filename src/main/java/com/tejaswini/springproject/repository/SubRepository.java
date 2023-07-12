package com.tejaswini.springproject.repository;

import com.tejaswini.springproject.dao.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubRepository extends JpaRepository<Submission, Integer> {

}
