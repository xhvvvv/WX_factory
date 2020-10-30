package pojo;

public class User {
	  int id;
	 String name;
	 String Password;
	 String Time;
	 String Idenitiy;
	 int Code;
	/*
	 getId()
	  setId(int id)
	  getName()
	  setName(String name)
	  getPassword()
	 	setPassword(String Password)
	 	getTime()
	 	setTime(String Time)
	 	getIdenitiy()
	 	setIdenitiy(String Idenitiy)
	 	getCode()
	 	setCode(int Code)
	 */
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    public String getTime() {
        return Time;
    }
    public void setTime(String Time) {
        this.Time = Time;
    }
    
    
    public String getIdenitiy() {
        return Idenitiy;
    }
    public void setIdenitiy(String Idenitiy) {
        this.Idenitiy = Idenitiy;
        
    }
	
    public int getCode() {
        return Code;
    }
    public void setCode(int Code) {
        this.Code = Code;
    }
}
