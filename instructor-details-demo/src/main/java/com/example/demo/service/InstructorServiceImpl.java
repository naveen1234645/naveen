package com.example.demo.service;
import java.util.Iterator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.InstructorDao;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;
@Service
public class InstructorServiceImpl implements InstructorService {
	
	private InstructorDao instructorDao;
	@Autowired
	public InstructorServiceImpl(InstructorDao instructorDao) {
		super();
		this.instructorDao = instructorDao;
	}

	@Override
	public Instructor createInstructor(Instructor instructor) {
		
		return instructorDao.save(instructor);
	}

	@Override
	public List<Instructor> getAllInstructor() {
		List<Instructor> i=(List<Instructor>) instructorDao.findAll();
		return i;
	}

	@Override
	public Instructor getInstructorById(Integer Id) {
		Instructor n= instructorDao.findById(Id).get();
		return n;
	}

	@Override
	
	public Instructor updateInstructorById(Integer Id, Instructor instructor, InstructorDetail instructorDetail) {
		Instructor n1= getInstructorById(Id);
		n1.setFirst_Name(instructor.getFirst_Name());
		n1.setLast_Name(instructor.getLast_Name());
		n1.setEmail(instructor.getEmail());
		InstructorDetail n2 =new InstructorDetail();
		n2.setYoutubeChannel(instructorDetail.getYoutubeChannel());
		n2.setHobby(instructorDetail.getHobby());
		n1.setInstructorDetail(n2);
		return instructorDao.save(n1) ;
	}

	@Override
	public String deleteById(Integer Id) {
		try {
			instructorDao.deleteById(Id);
			return "deleted Successfully:";
			
		}catch(Exception e) {
			return "Enter Correct One:";
		}
		
	}

}