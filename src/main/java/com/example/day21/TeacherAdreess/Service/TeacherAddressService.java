package com.example.day21.TeacherAdreess.Service;

import com.example.day21.Teacher.Model.Teacher;
import com.example.day21.Teacher.Repository.TeacherRepo;
import com.example.day21.TeacherAdreess.DTO.TeacherAddressDTO;
import com.example.day21.TeacherAdreess.Model.TeacherAddress;
import com.example.day21.TeacherAdreess.Repository.TeacherAddressRepo;
import com.example.day21.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherAddressService {
    private final TeacherAddressRepo teacherAddressRepo;
    private final TeacherRepo teacherRepo;

    public List<TeacherAddress> getTeacherAddress() {
        return teacherAddressRepo.findAll();
    }
    public void addTeacherAddress(TeacherAddressDTO cdDTO) {
        Teacher teacher = teacherRepo.findTeacherById(cdDTO.getTeacher_id());
        if (teacher == null) {
            throw new ApiException("No teacher found! ");
        }
        TeacherAddress teacherAddress = new TeacherAddress(null,cdDTO.getArea(),cdDTO.getStreet(), cdDTO.getBuildingNumber(), teacher);
        teacherAddressRepo.save(teacherAddress);
    }
    public void editTeacherAddress(Integer id, TeacherAddressDTO TA_DTO) {
        Teacher teacher = teacherRepo.findTeacherById(id);
        if (teacher == null) {
            throw new ApiException("No teacher found! ");
        }
        TeacherAddress teacherAddress = teacherAddressRepo.findTeacherAddressById(id);
        if (teacherAddress == null) {
            throw new ApiException("No address found for the teacher");
        }
        teacherAddress.setArea(TA_DTO.getArea());
        teacherAddress.setStreet(TA_DTO.getStreet());
        teacherAddress.setBuildingNumber(TA_DTO.getBuildingNumber());

        teacherAddressRepo.save(teacherAddress);
    }
    public void deleteTeacherAddress(Integer id) {
        Teacher teacher = teacherRepo.findTeacherById(id);
        if (teacher == null) {
            throw new ApiException("No teacher found! ");
        }
        TeacherAddress teacherAddress = teacherAddressRepo.findTeacherAddressById(id);
        if (teacherAddress == null) {
            throw new ApiException("No address found for the teacher");
        }

        teacher.setTeacherAddress(null);
        teacherRepo.save(teacher);
        teacherAddressRepo.delete(teacherAddress);
    }
}

