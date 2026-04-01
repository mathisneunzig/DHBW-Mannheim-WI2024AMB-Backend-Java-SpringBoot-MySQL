package de.mathisneunzig.demo.factories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
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
import de.mathisneunzig.demo.entities.Teacher;
import de.mathisneunzig.demo.repositories.TeacherRepository;

@ExtendWith(MockitoExtension.class)
class CourseFactoryTest {

    @Mock
    private TeacherRepository teacherRepository;

    @InjectMocks
    private CourseFactory courseFactory;

    @Test
    void fromDTOMapsFieldsAndResolvesTeacher() {
        UUID teacherId = UUID.randomUUID();
        Teacher teacher = new Teacher();
        teacher.setId(teacherId);

        when(teacherRepository.findById(teacherId)).thenReturn(Optional.of(teacher));

        CourseDTO dto = new CourseDTO("Spring", "Architecture", 5, CourseType.LECTURE, ExamType.WRITTEN_EXAM, teacherId);
        Course result = courseFactory.fromDTO(dto);

        assertEquals("Spring", result.getTitle());
        assertEquals("Architecture", result.getDescription());
        assertEquals(5, result.getEcts());
        assertEquals(CourseType.LECTURE, result.getCourseType());
        assertEquals(ExamType.WRITTEN_EXAM, result.getExamType());
        assertEquals(teacherId, result.getTeacher().getId());
    }
}
