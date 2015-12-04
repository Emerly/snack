package sqltext;

public class student {
	private int id;
	private String sno;
	private String sname;
	private String sex;
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "  " + sno + "   " + sname + "   " + sex ;
	}

}
