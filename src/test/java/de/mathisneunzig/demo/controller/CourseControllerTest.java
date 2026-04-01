package de.mathisneunzig.demo.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import de.mathisneunzig.demo.entities.Course;
import de.mathisneunzig.demo.security.SecurityConfig;
import de.mathisneunzig.demo.service.CourseService;

/**
 * Lightweight web-layer tests.
 *
 * WebMvcTest starts only MVC infrastructure + the controller under test.
 */
@WebMvcTest(CourseController.class)
@Import(SecurityConfig.class)
@ActiveProfiles("test")
class CourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CourseService courseService;

    @Test
    void getAllReturnsCourses() throws Exception {
        Course c1 = new Course();
        c1.setId(UUID.randomUUID());
        c1.setTitle("Algorithms");

        when(courseService.getAll()).thenReturn(List.of(c1));

        mockMvc.perform(get("/courses"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].title").value("Algorithms"));
    }
}
