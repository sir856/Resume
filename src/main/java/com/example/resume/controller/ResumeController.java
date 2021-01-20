package com.example.resume.controller;

import com.example.resume.model.Resume;
import com.example.resume.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/resume")
public class ResumeController {
    private final ResumeService resumeService;

    @Autowired
    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping("/create")
    public Resume create(@RequestBody Resume resume) {
        return resumeService.create(resume);
    }

    @GetMapping("/get")
    public List<Resume> getAll() {
        return resumeService.getAll();
    }

    @GetMapping("/get/{id}")
    public Resume getById(@PathVariable("id") int id) {
        return resumeService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") int id) {
        resumeService.delete(id);
    }

    @PutMapping("modify/{id}")
    public Resume modify(@PathVariable("id") int id, @RequestBody Resume resume) {
        return resumeService.modify(id, resume);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgumentException(Exception ex) {

        Map<String, String> body = new HashMap<>();
        body.put("message", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
