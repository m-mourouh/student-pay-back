package com.mmourouh.studentpay.web;


import com.mmourouh.studentpay.dto.NewPaymentDTO;
import com.mmourouh.studentpay.entities.Payment;
import com.mmourouh.studentpay.entities.Student;
import com.mmourouh.studentpay.enums.PaymentStatus;
import com.mmourouh.studentpay.enums.PaymentType;
import com.mmourouh.studentpay.repository.PaymentRepository;
import com.mmourouh.studentpay.repository.StudentRepository;
import com.mmourouh.studentpay.services.PaymentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.time.LocalDate;
import java.util.List;


@RestController
@CrossOrigin("*")
public class PaymentRestController {
    StudentRepository studentRepository;
    PaymentRepository paymentRepository;
    PaymentService paymentService;
    public PaymentRestController(StudentRepository studentRepository, PaymentRepository paymentRepository,
                                 PaymentService paymentService) {
        this.studentRepository = studentRepository;
        this.paymentRepository = paymentRepository;
        this.paymentService = paymentService;
    }

    @GetMapping(path = "/payments")
    public List<Payment> getAllPayments(){
        return paymentRepository.findAll();
    }

    @GetMapping(path = "/payments/{id}")
    public Payment getPaymentsById(@PathVariable Long id){
        return paymentRepository.findById(id).orElse(null);
    }
    @GetMapping(path = "/students/{code}/payments")
    public List<Payment> getPaymentsByStudentCode(@PathVariable String code){
        return paymentRepository.findByStudentCode(code);
    }
    @GetMapping(path = "/payments-status")
    public List<Payment> getPaymentsByStatus(@RequestParam PaymentStatus status){
        return paymentRepository.findByStatus(status);
    }
    @GetMapping(path = "/payments-type")
    public List<Payment> getPaymentsByType(@RequestParam PaymentType type){
        return paymentRepository.findByType(type);
    }

    @GetMapping(path = "/students")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping(path = "/students/{code}")
    public Student getStudentById(@PathVariable String code){
        return studentRepository.findStudentByCode(code);
    }

    @GetMapping(path = "/students-program-id")
    public List<Student> getStudentsByProgramId(@RequestParam String programId){
        return studentRepository.findStudentsByProgramId(programId);
    }

    @PutMapping(path = "/payments/{id}")
    public Payment updatePaymentStatus(@PathVariable Long id, PaymentStatus status){
        return paymentService.updatePaymentStatus(id, status);
    }

    @PostMapping(path = "/payments", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Payment savePayment(@RequestParam("file") MultipartFile file, NewPaymentDTO newPaymentDTO) throws IOException {
        return paymentService.savePayment(file, newPaymentDTO);
    }

    @GetMapping(path = "/payment-file/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] getPaymentFile(@PathVariable Long id) throws IOException {
        return paymentService.getPaymentFile(id);
    }

}
