package com.swapnil.demo;

import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("students")
public class StudentResource 
{
	StudentRepository Stdrep=new StudentRepository();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudents() 
	{
		System.out.print("work");
		return Stdrep.getStudents();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudent(@PathParam("id") int id)
	{
		
		System.out.print("work");
		return Stdrep.getStudent(id);
	}
	
	@POST
	@Path("student")
	@Consumes(MediaType.APPLICATION_JSON) 
	public Student createStudent(Student s1)
	{
		System.out.println(s1);
		Stdrep.create(s1);
		return s1;
	}
	
	@PUT
	@Path("student")
	@Consumes(MediaType.APPLICATION_JSON) 
	public Student updateStudent(Student s1)
	{
		System.out.println(s1);
		Stdrep.update(s1);
		return s1;
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student deleteStudent(@PathParam("id") int id)
	{
		Student s=Stdrep.getStudent(id);
		if(s.getId()!=0)
			Stdrep.delete(id);
		return s;
	}
	
}
