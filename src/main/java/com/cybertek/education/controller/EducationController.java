package com.cybertek.education.controller;

import com.cybertek.education.model.*;
import com.cybertek.education.model.Class;
import com.cybertek.education.repository.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EducationController {

    private final AddressRepository addressRepository;

    private final AttendanceRepository attendanceRepository;

    private final ClassRepository classRepository;

    private final ExamRepository examRepository;

    private final ExamResultRepository examResultRepository;

    private final ParentRepository parentRepository;

    private final StudentRepository studentRepository;

    private final TeacherRepository teacherRepository;

    private final CourseRepository courseRepository;

    public EducationController(AddressRepository addressRepository, AttendanceRepository attendanceRepository,
                               ClassRepository classRepository, ExamRepository examRepository,
                               ExamResultRepository examResultRepository, ParentRepository parentRepository,
                               StudentRepository studentRepository, TeacherRepository teacherRepository, CourseRepository courseRepository) {
        this.addressRepository = addressRepository;
        this.attendanceRepository = attendanceRepository;
        this.classRepository = classRepository;
        this.examRepository = examRepository;
        this.examResultRepository = examResultRepository;
        this.parentRepository = parentRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.courseRepository = courseRepository;
    }


    @GetMapping("/students")
    public List<Student> readAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/parents")
    public List<Parent> readAllParents() {
        return parentRepository.findAll();
    }

    @GetMapping("/teachers")
    public List<Teacher> readAllTeachers() {
        return teacherRepository.findAll();
    }

    @GetMapping("/attends")
    public List<Attendance> readAllAttends() {
        return attendanceRepository.findAll();
    }

    @GetMapping("/classes")
    public List<Class> readAllClasses() {
        return classRepository.findAll();
    }

    @GetMapping("/courses")
    public List<Course> readAllCourses() {
        return courseRepository.findAll();
    }


    @GetMapping("/exams")
    public List<Exam> readAllExams() {
        return examRepository.findAll();
    }

    @GetMapping("/exam-result")
    public List<ExamResult> readAllExamResults() {
        return examResultRepository.findAll();
    }

    @GetMapping("/addresses")
    public List<Address> readAllAddresses() {
        return addressRepository.findAll();
    }
}
