package com.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Student;
import com.app.repo.StudentRepository;
import com.app.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {
	@Autowired
	private StudentRepository repo;

	@Transactional
	public Integer saveStudent(Student s) {
		s=repo.save(s);
		return s.getStdId();
	}

	@Transactional(readOnly = true)
	public List<Student> getAllStudents() {
		List<Student> stdList=repo.findAll();
		//sort based on name
		/*Collections.sort(stdList, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.getStdName().compareTo(o2.getStdName());
			}
		});*/

		if(stdList!=null && !stdList.isEmpty()) {
			stdList.stream()
			.sorted((s1,s2)->s1.getStdName()
					.compareTo(s2.getStdName()));
		}

		return stdList;
	}




	@Transactional(readOnly = true)
	public Student getOneStudent(Integer id) {
		Optional<Student> opt=repo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		return null;
	}
	
	
	@Transactional
	public void deleteStudent(Integer id) {
		repo.deleteById(id);
	}

}









