package dto;

import java.io.Serializable;

// IT IS DATA TRANSFER OBJECT , USED TO TRANSFER DATA FROM ONE LAYER TO ANOTHER LAYER.. 
//STUDENTDAOIMPL CLASS CONNECTED TO DATABASE(JDBC) SO THE RESULT TYPE IS RESULT SET , 
//RESULT SET YOU CANNOT SEND THROUGH NETWORK SO WE NEED STUDENT TYPE DATATYPE , 
//IT IS USED TO DATA TRANSFER OBJECT

public class Student implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getMarks() {
		return marks;
	}
	public void setMarks(Integer marks) {
		this.marks = marks;
	}
	private String name;
	private Integer marks;
	@Override
	public String toString() {
		return "Student [sid="+id+",sname="+name+ "+smarks= "+marks+"]";
	}
	

}
