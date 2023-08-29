package com.xadmin.SpringBootCrud.controller;

import com.xadmin.SpringBootCrud.bean.Subject;
import com.xadmin.SpringBootCrud.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectController {
	@Autowired
	private SubjectService subjectService;

	@RequestMapping("/student")
	public List<Subject> getAllSubjects()
	{
		return subjectService.getAllSubjects();
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/student")
	public void addSubject(@RequestBody Subject student)
	{
		subjectService.addSubject(student);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/student/{studentId}")
	public void updateSubject(@PathVariable Integer studentId, @RequestBody Subject student)
	{
		subjectService.updateSubject(studentId, student);
	}
	@RequestMapping(method = RequestMethod.DELETE, value="/student/{studentId}")
	public void DeleteSubject(@PathVariable Integer studentId)
	{
		subjectService.deleteSubject(studentId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/student/{studentId}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable Integer studentId) {
        Subject subject = subjectService.getSubjectById(studentId);
        if (subject != null) {
            return ResponseEntity.ok(subject);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	}
	


