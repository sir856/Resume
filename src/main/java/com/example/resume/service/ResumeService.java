package com.example.resume.service;

import com.example.resume.model.Resume;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ResumeService {
    Resume getById(int id);
    List<Resume> getAll();
    Resume create(Resume resume);
    Resume modify(int id, Resume resumeMod);
    void delete(int id);
}
