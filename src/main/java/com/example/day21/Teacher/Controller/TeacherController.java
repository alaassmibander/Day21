package com.example.day21.Teacher.Controller;

import com.example.day21.Teacher.Model.Teacher;
import com.example.day21.Teacher.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/")
@RequiredArgsConstructor

public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping("/teacher")
    public List<Teacher> readTeacher() {
        return teacherService.getTeacher();
    }

    @PostMapping("/teacher")
    public ResponseEntity createTeachers(@RequestBody @Valid Teacher Teacher) {

        teacherService.addTeacher(Teacher);
        return ResponseEntity.status(200).body("Added");
    }

    @PutMapping("/teacher/{id}")
    public ResponseEntity updateTeacher(@PathVariable int id, @RequestBody @Valid Teacher teacher) {
        teacherService.editTeacher(id, teacher);
        return ResponseEntity.status(200).body("Updated");
    }

    @DeleteMapping("/teacher/{id}")
    public ResponseEntity deleteMovies(@PathVariable Integer id) {

        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body("Teacher and address were deleted!");

    }


    @GetMapping("/teacher/{id}")
    public Teacher getTeacherById(@PathVariable Integer id) {
        return teacherService.getTeacherById(id);
    }
}

