package by.grodno.pvt.site.webappsample.service;


public class Dep {
	private Integer id;
	private String depName;
	private String depInf;


	public Dep(Integer id, String depName, String depInf) {
		super();
		this.id = id;
		this.depName = depName;
		this.depInf = depInf;


	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName){this.depName = depName;}

	public String getDepInf() {
		return depInf;
	}

	public void setDepInf(String depInf) {this.depInf = depInf;	}








}
