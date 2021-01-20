package com.example.resume.repository;

import com.example.resume.model.Resume;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResumeRepository extends MongoRepository<Resume, Integer> {
}
