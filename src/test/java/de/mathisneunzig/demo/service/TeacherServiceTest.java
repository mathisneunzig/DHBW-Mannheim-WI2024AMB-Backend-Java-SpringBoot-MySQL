package de.mathisneunzig.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import de.mathisneunzig.demo.dto.RegistrationDTO;
import de.mathisneunzig.demo.entities.Teacher;
import de.mathisneunzig.demo.factories.AccountFactory;
import de.mathisneunzig.demo.repositories.TeacherRepository;

@ExtendWith(MockitoExtension.class)
class TeacherServiceTest {

    @Mock
    private TeacherRepository teacherRepository;

    @Mock
    private AccountFactory accountFactory;

    @InjectMocks
    private TeacherService teacherService;

    @Test
    void getAllDelegatesToRepository() {
        when(teacherRepository.findAll()).thenReturn(List.of(new Teacher()));
        assertEquals(1, teacherService.getAll().size());
    }

    @Test
    void createUsesFactoryAndRepositorySave() {
        RegistrationDTO dto = new RegistrationDTO("u", "l", "f", "a@b.c", "1", "p", "p", "s", "h", "z", "c", "co");
        Teacher mapped = new Teacher();
        Teacher saved = new Teacher();

        when(accountFactory.fromTeacherDTO(dto)).thenReturn(mapped);
        when(teacherRepository.save(mapped)).thenReturn(saved);

        Teacher result = teacherService.create(dto);

        assertEquals(saved, result);
        verify(accountFactory).fromTeacherDTO(dto);
        verify(teacherRepository).save(mapped);
    }
}
