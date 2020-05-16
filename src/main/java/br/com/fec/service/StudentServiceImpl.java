package br.com.fec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fec.model.Student;
import br.com.fec.model.exception.ResourceNotFoundException;
import br.com.fec.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);

	}

	@Override
	public Student updateStudent(Student student) {
		Optional<Student> studentDb = this.studentRepository.findById(student.getId());
		if(studentDb.isPresent()) {
			Student studentUpdate = studentDb.get();
			studentUpdate.setId(student.getId());
			studentUpdate.setFirstName(student.getFirstName());
			studentUpdate.setLastName(student.getLastName());
			studentUpdate.setEmail(student.getEmail());
			studentUpdate.setBirthday(student.getBirthday());
			studentUpdate.setStatus(student.getStatus());
			studentUpdate.setSexo(student.getSexo());
			studentUpdate.setProfession(student.getProfession());
			studentUpdate.setCpf(student.getCpf());
			studentUpdate.setAddress(student.getAddress());
			studentUpdate.setCep(student.getCep());
			studentUpdate.setPhoto(student.getPhoto());
			studentUpdate.setPhone(student.getPhone());
			studentUpdate.setRegistration(student.getRegistration());
			studentRepository.save(studentUpdate);	
			return studentUpdate;
		}else {
			throw new ResourceNotFoundException("Record not found with id: " + student.getId());
		}
		
	}

	@Override
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(Integer studentId) {
		Optional<Student> studentDb = this.studentRepository.findById(studentId);
		if(studentDb.isPresent()) {
			return studentDb.get();
		}else {
			throw new ResourceNotFoundException("Record not found with id : "+ studentId);
		}
	}

	@Override
	public void deleteStudent(Integer studentId) {
		Optional<Student> studentDb = this.studentRepository.findById(studentId);
		if(studentDb.isPresent()) {
			this.studentRepository.delete(studentDb.get());
		}else {
			throw new ResourceNotFoundException("Record not found with id : "+ studentId);

		}

	}

}
