package com.cybertek.education.controller;

import com.cybertek.education.model.Class;
import com.cybertek.education.model.*;
import com.cybertek.education.repository.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
public class EducationController {


    private final AddressRepository addressRepository;


    private final ClassRepository classRepository;


    private final ParentRepository parentRepository;

    private final StudentRepository studentRepository;

    private final TeacherRepository teacherRepository;

    private final CourseRepository courseRepository;

    private final RestTemplate restTemplate;

    public EducationController(AddressRepository addressRepository, ClassRepository classRepository,
                               ParentRepository parentRepository, StudentRepository studentRepository,
                               TeacherRepository teacherRepository, CourseRepository courseRepository,
                               RestTemplate restTemplate) {
        this.addressRepository = addressRepository;
        this.classRepository = classRepository;
        this.parentRepository = parentRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.courseRepository = courseRepository;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> readAllStudents() {
        ResponseWrapper responseWrapper = ResponseWrapper.builder()
                .success(true)
                .code(HttpStatus.OK.value())
                .message("Students are successfully retrieved")
                .data(studentRepository.findAll())
                .build();
       return ResponseEntity.ok(responseWrapper);
    }

    @GetMapping("/parents")
    public ResponseEntity<ResponseWrapper> readAllParents() {
        ResponseWrapper responseWrapper = new ResponseWrapper(true,
                "Parents are successfully retrieved",
                HttpStatus.ACCEPTED.value(),
                parentRepository.findAll());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(responseWrapper);
    }

    @GetMapping("/teachers")
    public List<Teacher> readAllTeachers() {
        return teacherRepository.findAll();
    }



    @GetMapping("/classes")
    public List<Class> readAllClasses() {
        return classRepository.findAll();
    }

    @GetMapping("/courses")
    public List<Course> readAllCourses() {
        return courseRepository.findAll();
    }


    @GetMapping("/addresses")
    public List<Address> readAllAddresses() {
        return addressRepository.findAll();
    }


    @PutMapping("/address/{id}")
    public Address updateAddress(@PathVariable("id") Long id, @RequestBody Address address) throws Exception {

        Optional<Address> foundAddress = addressRepository.findById(id);

        if (!foundAddress.isPresent()) {
            throw new Exception("Address does not exists!");
        }

        address.setId(foundAddress.get().getId());

        return addressRepository.save(address);
    }

    @PostMapping("/parent")
    public ResponseEntity<ResponseWrapper> createParent(@RequestBody Parent parent) {

        Parent createdParent = parentRepository.save(parent);

        ResponseWrapper responseWrapper = new ResponseWrapper(true,
                "Parent has been created",
                HttpStatus.CREATED.value(),
                createdParent);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseWrapper);
    }
}
