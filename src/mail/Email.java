package mail;

import java.util.Scanner;

public class Email {
    private final String firstName;
    private final String lastName;
    private final String password ;
    private final String department;
    private int defaultPasswordLength = 8;
    private  int mailBoxCapacity;
    private int defaultMailBoxCapacity = 500;
    private String alternateEmailAddress;
    private final String email;
    private final String emailSuffix = "iocompany";

    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = setDepartment();
        this.password = generatRandomPassword(defaultPasswordLength);
        email = firstName.toLowerCase() + lastName.toLowerCase() + "@" + department + "." + emailSuffix;
    }
    private String setDepartment(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter department code: ");
        int input = in.nextInt();
        if (input == 1) {
            return "Sales";
        } else if (input == 2) {
            return "Developments";
        } else if (input == 3) {
            return "Accounting";
        }
            return "";
    }
    private String generatRandomPassword(int length){
        String passwordSet = "QWERTYUIOPLKJHGFDSAZXCVBNM0123456789!@#$%&qwertyuioplkjhgfdsazxcvbnm";
        char [] password = new char[length];
        for (int i = 0; i < length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    public void setMailBoxCapacity(int capacity){
        this.mailBoxCapacity = capacity;
    }
    public int getMailBoxCapacity(){
        return mailBoxCapacity;
    }

    public String getAlternateEmailAddress() {
        return alternateEmailAddress;
    }

    public void setAlternateEmailAddress(String alternateEmailAddress) {
        this.alternateEmailAddress = alternateEmailAddress;
    }
    public String info(){
        return "Full Name: " + firstName + " " + lastName + "\nDepartment: " + email + "\nMail Box Capacity: " + defaultMailBoxCapacity + "mb";
    }
}
