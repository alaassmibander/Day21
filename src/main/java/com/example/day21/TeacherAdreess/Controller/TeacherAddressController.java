package com.example.day21.TeacherAdreess.Controller;

import com.example.day21.TeacherAdreess.DTO.TeacherAddressDTO;
import com.example.day21.TeacherAdreess.Model.TeacherAddress;
import com.example.day21.TeacherAdreess.Service.TeacherAddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v3")
public class TeacherAddressController {
    private final TeacherAddressService teacherAddressService;

    @GetMapping("/teacher_address")
    public List<TeacherAddress> readTeacheraddress() {
        return teacherAddressService.getTeacherAddress();
    }

    @PostMapping("/teacher_address")
    public ResponseEntity createCustomers(@RequestBody @Valid TeacherAddressDTO teacherAddress) {

        teacherAddressService.addTeacherAddress(teacherAddress);
        return ResponseEntity.status(200).body("Added");
    }

    @PutMapping("/teacher_address/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @RequestBody @Valid TeacherAddressDTO TA_DTO) {
        teacherAddressService.editTeacherAddress(id, TA_DTO);
        return ResponseEntity.status(200).body("Updated");
    }

    @DeleteMapping("/teacher_address/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id) {

        teacherAddressService.deleteTeacherAddress(id);
        return ResponseEntity.status(200).body("Teacher address was deleted!");

    }


}

