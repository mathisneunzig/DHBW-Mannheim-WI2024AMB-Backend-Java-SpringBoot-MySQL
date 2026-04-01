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
import de.mathisneunzig.demo.entities.User;
import de.mathisneunzig.demo.factories.AccountFactory;
import de.mathisneunzig.demo.repositories.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private AccountFactory accountFactory;

    @InjectMocks
    private UserService userService;

    @Test
    void getAllDelegatesToRepository() {
        when(userRepository.findAll()).thenReturn(List.of(new User(), new User()));
        assertEquals(2, userService.getAll().size());
    }

    @Test
    void createUsesFactoryAndRepositorySave() {
        RegistrationDTO dto = new RegistrationDTO("u", "l", "f", "a@b.c", "1", "p", "p", "s", "h", "z", "c", "co");
        User mapped = new User();
        User saved = new User();

        when(accountFactory.fromUserDTO(dto)).thenReturn(mapped);
        when(userRepository.save(mapped)).thenReturn(saved);

        User result = userService.create(dto);

        assertEquals(saved, result);
        verify(accountFactory).fromUserDTO(dto);
        verify(userRepository).save(mapped);
    }
}
