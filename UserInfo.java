public class UserInfo {
    private string name;
    private int age;
    private string email;
    private boolean isActive;

    public UserInfo( string name, int age, string email, boolean isActive){
        this.name = name;
        this.age = age;
        this.email = email;
        this.isActive = isActive;
    }
    public String getName() {return name;}

    public int getAge() {return age;}

    public String getEmail() {return email;}

    public boolean getIsActive() {return isActive;}

    public void displayInfo() {
        System.out.println("User Information:");
        System.out.println("Name     : " + name);
        System.out.println("Age      : " + age);
        System.out.println("Email    : " + email);
        System.out.println("Active   : " + (isActive ? "Yes" : "No"));
    }



}
