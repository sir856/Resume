package com.example.resume.service;

import com.example.resume.model.Resume;
import com.example.resume.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ResumeServiceImpl implements ResumeService {

    private final SequenceGeneratorService generator;

    private final ResumeRepository repository;

    @Autowired
    public ResumeServiceImpl(SequenceGeneratorService generator, ResumeRepository repository) {
        this.generator = generator;
        this.repository = repository;
    }


    @Override
    public Resume getById(int id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("No resume with given id: " + id));
    }

    @Override
    public List<Resume> getAll() {
        return repository.findAll();
    }

    @Override
    public Resume create(Resume resume) {
        if (Objects.isNull(resume.getBirthdate())) {
            throw new IllegalArgumentException("Birthdate is required");
        }
        if (Objects.isNull(resume.getLastName())) {
            throw new IllegalArgumentException("Last name is required");
        }
        if (Objects.isNull(resume.getName())) {
            throw new IllegalArgumentException("Name is required");
        }
        if (Objects.isNull(resume.getPatronymic())) {
            throw new IllegalArgumentException("Patronymic is required");
        }
        if (Objects.isNull(resume.getDescription())) {
            throw new IllegalArgumentException("Description is required");
        }

        resume.setId(generator.generateSequence(Resume.SEQUENCE_NAME));
        return repository.save(resume);
    }

    @Override
    public Resume modify(int id, Resume resumeMod) {
        Resume resume = getById(id);

        resume.setBirthdate(Objects.isNull(resumeMod.getBirthdate()) ? resume.getBirthdate() : resumeMod.getBirthdate());
        resume.setDescription(Objects.isNull(resumeMod.getDescription()) ? resume.getDescription() : resumeMod.getDescription());
        resume.setName(Objects.isNull(resumeMod.getName()) ? resume.getName() : resumeMod.getName());
        resume.setLastName(Objects.isNull(resumeMod.getLastName()) ? resume.getLastName() : resumeMod.getLastName());
        resume.setPatronymic(Objects.isNull(resumeMod.getPatronymic()) ? resume.getPatronymic() : resumeMod.getPatronymic());

        return repository.save(resume);
    }

    @Override
    public void delete(int id) {
        Resume resume = getById(id);
        repository.delete(resume);
    }
}
