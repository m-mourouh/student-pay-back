package com.mmourouh.studentpay;

import com.mmourouh.studentpay.entities.Payment;
import com.mmourouh.studentpay.entities.Student;
import com.mmourouh.studentpay.enums.PaymentStatus;
import com.mmourouh.studentpay.enums.PaymentType;
import com.mmourouh.studentpay.repository.PaymentRepository;
import com.mmourouh.studentpay.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class StudentPayApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentPayApplication.class, args);
	}

	@Bean
	public CommandLineRunner start(StudentRepository studentRepository, PaymentRepository paymentRepository){
		return args -> {
			//Fill Student table with some data
			//Student 1
//			Student student1 = Student.builder()
//					.id(UUID.randomUUID().toString())
//					.firstName("Mohamed")
//					.lastName("MOUROUH")
//					.code("9599")
//					.programId("BDCC").build();
//			studentRepository.save(student1);
//			//Student 2
//			Student student2 = Student.builder()
//					.id(UUID.randomUUID().toString())
//					.firstName("John")
//					.lastName("Doe")
//					.code("8685")
//					.programId("GLSID").build();
//			studentRepository.save(student2);
//			//Student 3
//			Student student3 = Student.builder()
//					.id(UUID.randomUUID().toString())
//					.firstName("Jane")
//					.lastName("Olos")
//					.code("5698")
//					.programId("GLSID").build();
//			studentRepository.save(student3);
//			//Student 4
//			Student student4 = Student.builder()
//					.id(UUID.randomUUID().toString())
//					.firstName("Mark")
//					.lastName("Apolo")
//					.code("6985")
//					.programId("BDCC").build();
//			studentRepository.save(student4);
//
//			//Fill Payment table with some data
//			PaymentType[] paymentTypes = PaymentType.values();
//			Random random = new Random();
//			studentRepository.findAll().forEach(s -> {
//				//Create 10 payments for each student
//				for (int i = 0; i < 10; i++){
//					int index = random.nextInt(0,paymentTypes.length);
//					Payment p = Payment.builder()
//							.date(LocalDate.now())
//							.amount((int) (Math.random() + 20000))
//							.type(paymentTypes[index])
//							.status(PaymentStatus.CREATED)
//							.student(s)
//							.build();
//					paymentRepository.save(p);
//				}
//			});
		};
	}
}
