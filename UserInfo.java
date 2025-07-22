public class UserInfo {
    private string name;
    private int age;
    private string email;
    private boolean isActive;

    public UserInfo(string name, int age, string email, boolean isActive) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void displayInfo() {
        System.out.println("User Information:");
        System.out.println("Name     : " + name);
        System.out.println("Age      : " + age);
        System.out.println("Email    : " + email);
        System.out.println("Active   : " + (isActive ? "Yes" : "No"));
    }

    public static void main(String[] args) {
        UserInfo user1 = new UserInfo("Sara", 21, "sarara@example.com", true);
        UserInfo user2 = new UserInfo("alaa", 22, "lulu@example.com", false);
        UserInfo user3 = new UserInfo("fatma", 25, "fatma@example.com", true);
        user1.displayInfo();
        user2.displayInfo();
        user3.displayInfo();

        user1.setName("maryam");
        user1.setAge(33);
        user1.setIsActive(false);
        System.out.println("Updated name of user1:" + " " + user1.getName());
        System.out.println("Updated age of user1:" + " " + user1.getAge());
        System.out.println("Is user1 active?" + " " + user1.getIsActive());
        user1.displayInfo();
    }
}
