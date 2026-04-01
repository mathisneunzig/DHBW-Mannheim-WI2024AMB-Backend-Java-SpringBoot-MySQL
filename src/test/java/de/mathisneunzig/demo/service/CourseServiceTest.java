package de.mathisneunzig.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import de.mathisneunzig.demo.dto.CourseDTO;
import de.mathisneunzig.demo.entities.Course;
import de.mathisneunzig.demo.entities.CourseType;
import de.mathisneunzig.demo.entities.ExamType;
import de.mathisneunzig.demo.factories.CourseFactory;
import de.mathisneunzig.demo.repositories.CourseRepository;

@ExtendWith(MockitoExtension.class)
class CourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    @Mock
    private CourseFactory courseFactory;

    @InjectMocks
    private CourseService courseService;

    @Test
    void getAllDelegatesToRepository() {
        when(courseRepository.findAll()).thenReturn(List.of(new Course(), new Course(), new Course()));
        assertEquals(3, courseService.getAll().size());
    }

    @Test
    void createUsesFactoryAndRepositorySave() {
        CourseDTO dto = new CourseDTO("T", "D", 5, CourseType.SEMINAR, ExamType.PRESENTATION, UUID.randomUUID());
        Course mapped = new Course();
        Course saved = new Course();

        when(courseFactory.fromDTO(dto)).thenReturn(mapped);
        when(courseRepository.save(mapped)).thenReturn(saved);

        Course result = courseService.create(dto);

        assertEquals(saved, result);
        verify(courseFactory).fromDTO(dto);
        verify(courseRepository).save(mapped);
    }
}
