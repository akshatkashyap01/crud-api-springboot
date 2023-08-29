package com.xadmin.SpringBootCrud.service;

import com.xadmin.SpringBootCrud.bean.Subject;
import com.xadmin.SpringBootCrud.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepo;

    public List<Subject> getAllSubjects() {
        return subjectRepo.findAll();
    }

    public void addSubject(Subject subject) {
        subjectRepo.save(subject);
    }

    public void updateSubject(Integer studentId, Subject subject) {
        subject.setStudentId(studentId);
        subjectRepo.save(subject);
    }

    public void deleteSubject(Integer studentId) {
        subjectRepo.deleteById(studentId);
    }
    public Subject getSubjectById(Integer studentId) {
        Optional<Subject> optionalSubject = subjectRepo.findById(studentId);
        return optionalSubject.orElse(null);
    }
}
