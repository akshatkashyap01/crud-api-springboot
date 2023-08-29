package com.xadmin.SpringBootCrud;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xadmin.SpringBootCrud.bean.Subject;
import com.xadmin.SpringBootCrud.controller.SubjectController;
import com.xadmin.SpringBootCrud.service.SubjectService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(SubjectController.class)
public class SpringBootCrudApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SubjectService subjectService;

    private List<Subject> subjects;

    @Before
    public void setup() {
        subjects = new ArrayList<>();
        subjects.add(new Subject(1, "John", "Doe", 18,"A"));
                subjects.add(new Subject(2, "Jane", "Smith", 17, "B"));
            }

            @Test
            public void testGetAllSubjects() throws Exception {
                when(subjectService.getAllSubjects()).thenReturn(subjects);
                mockMvc.perform(get("/student").header("Accept", "application/json"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));


            }

            @Test
            public void testAddSubject() throws Exception {
                Subject newSubject = new Subject(3, "Alice", "Johnson", 16, "A");

                mockMvc.perform(post("/student")
                        .content(asJsonString(newSubject))
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());

                verify(subjectService, times(1)).addSubject(Mockito.any(Subject.class));
            }

            @Test
            public void testUpdateSubject() throws Exception {
                Subject updatedSubject = new Subject(1, "John", "Doe", 19, "A+");

                mockMvc.perform(put("/student/{studentId}", updatedSubject.getStudentId())
                        .content(asJsonString(updatedSubject))
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());

                verify(subjectService, times(1)).updateSubject(eq(updatedSubject.getStudentId()), Mockito.any(Subject.class));
            }

            @Test
            public void testDeleteSubject() throws Exception {
                Integer studentId = 2;

                mockMvc.perform(delete("/student/{studentId}", studentId))
                        .andExpect(status().isOk());

                verify(subjectService, times(1)).deleteSubject(studentId);
            }

            // Helper method to convert objects to JSON
            private String asJsonString(final Object obj) {
                try {
                    return new ObjectMapper().writeValueAsString(obj);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

