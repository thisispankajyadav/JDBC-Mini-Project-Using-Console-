package com.student.pojo;

public class Student {
	private int roll_no;
	private String name;
	private String city;
	private String qualification;
	public Student()
	{}
	public Student(String name, String city, String qualification)
	{
		super();
		this.name=name;
		this.city=city;
		this.qualification=qualification;
	}
	public int getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	@Override
	public String toString() {
		return "Student [roll_no=" + roll_no + ", name=" + name + ", city=" + city + ", qualification=" + qualification
				+ "]";
	}
}