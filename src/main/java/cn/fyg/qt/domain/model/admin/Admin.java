package cn.fyg.qt.domain.model.admin;

public class Admin {
	
	public static Admin admin=new Admin("admin","foryou88816965");
	
	private String name;
	
	private String password;
	
	private Admin(String name,String password) {
		this.name=name;
		this.password=password;
	}
	
	public boolean check(String name,String password){
		return admin.name.equals(name)&&admin.password.equals(password);
	}

}
