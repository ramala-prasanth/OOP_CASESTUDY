import java.util.*;
abstract class login{
	String username;
	String password;
	abstract int username_verification(String username);
	abstract int password_verification(String password);
	
}
// class for patients which includes details like patient name, patient username, age, etc and also methods to get and set the data.
class patient extends login{
		String[] patient_username=new String[1000];
		String[] patient_password=new String [1000];
		String[] patient_name=new String[1000];
		String[] patient_age=new String[1000];
		String[] patient_phone=new String[1000];
		String[] patient_gender=new String[1000];
		String[] patient_email=new String[1000];

		//methods for basic details of patients.
		void patient_name_ask(){
			System.out.println("Enter the name of patient:");
		}
		void patient_age_ask(){
			System.out.println("Enter the age of patient:");
		}
		void patient_gender_ask(){
			System.out.println("Enter the gender of patient:");
		}
		void patient_phone_ask(){
			System.out.println("Enter the phone number of patient:");
		}
		void patient_email_ask(){
			System.out.println("Enter the email of patient:");
		}

		//getter and setter methods for patient name
		String getPatientName(int b){
			return patient_name[b];
		}
		void setPatientName(String newPatientName,int b){
			this.patient_name[b] = newPatientName;
		}
		//getter and setter methods for patient age
		String getPatientAge(int b){
			return patient_age[b];
		}
		void setPatientAge(String newPatientAge,int b){
			this.patient_age[b]= newPatientAge;
		}
		//getter and setter methods for patient gender
		String getPatientGender(int b){
			return patient_gender[b];
		}
		void setPatientGender(String newPatientGender,int b){
			this.patient_gender[b]= newPatientGender;
		}
		//getter and setter methods for patient phone.
		String getPatientPhone(int b){
			return patient_phone[b];
		}
		void setPatientPhone(String newPatientPhone, int b){
			this.patient_phone[b]= newPatientPhone;
		}
		//getter and setter methods for patient email.
		String getPatientEmail(int b){
			return patient_email[b];
		}
		void setPatientEmail(String newPatientEmail, int b){
			this.patient_email[b]= newPatientEmail;
		}
		//Generating patient username and passwords:
		void username_generation(int b){ 
			String dummy="JP00";
			String number=String.valueOf(b);
			patient_username[b]=dummy.concat(number);
		}
		
		//methods for verifying patient username and password.
		int username_verification(String username){

		}
		
}

//class for admin which inlcudes the admin username and password and methods for verifying the username and password.
class admin extends login{
		private String[] admin_username=new String[1000];
		private String[] admin_password=new String[1000];
		int c=-1;
		//getter and setter methods for admin username.
		String getAdminUsername(int b){
			return admin_username[b];
		}
		void setAdminUsername(String newAdminUsername,int b){
			this.admin_username[b] = newAdminUsername;
		}
		//getter and setter methods for admin password.
		String getAdminPassword(int b){
			return admin_password[b];
		}
		void setAdminPassword(String newAdminPassword,int b){
			this.admin_password[b] = newAdminPassword;
		}
		//admin username and password verification.
		int username_verification(String username){
			for(int i=0;i<1000;i++){
				if(username.equals(getAdminUsername(i))){
					c=i;
					break;		
				}
			}
			return c;
		}
		int password_verification(String password){
			for(int i=0;i<1000;i++){
				if(password.equals(getAdminPassword(i))){
					c=i;
					break;
				}
			}
			return c;
		}
}

public class Main{
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int B;
		patient patient=new patient();
		admin admin;
		admin=new admin();
		//creating admin usernames and passwords.
			for(int j=0;j<1000;j++){
				admin.setAdminUsername("abcedf",j);
				admin.setAdminPassword("PASSWORD",j);
			}
			admin.setAdminUsername("prasanth_r",0);
			admin.setAdminUsername("lokesh_d",1);
			admin.setAdminUsername("preetham_a",2);
			admin.setAdminUsername("dheepthi_d",3);			
		//creating duplicate names for new patients
		for(int j=0;j<1000;j++){
			patient.setPatientName("abcdefg",j);
		}
		boolean flag=true;
		while(flag==true)
		{
			System.out.println("Welcome to JavaSoft systems!\nChoose:\n1 for Administrator.\n2 for patients\n3 for Doctors\n4 to exit");
			int choice=input.nextInt();
			input.nextLine();
			boolean stat=true;
			if(choice==1){
				while(stat==true){
					System.out.println("Enter your Username:");
					String AdminUsername=input.nextLine();
					B=admin.username_verification(AdminUsername);
					//System.out.println(verify);
					if(B==-1){
						System.out.println("The Administrator does not exist!\nTry again!");
						continue;
					}
					System.out.println("Enter your password:");
					String AdminPassword=input.nextLine();
					B=admin.password_verification(AdminPassword);
					if(B==-1){
						System.out.println("The password is incorrect! Try again!");
						continue;
					}
					System.out.println("Hello "+admin.getAdminUsername(B));
					while(true){
						System.out.println("What would you like to do?\nPlease enter:\n1 for adding patients.\n2 for adding doctors.\n10 for going back to the main menu.");
						choice=input.nextInt();						
						input.nextLine();
						int C=-1;
						if(choice==1){
							for(int j=0;j<1000;j++){
								if(patient.getPatientName(j).equals("abcdefg")){
									C=j;
									break;
								}
							}
							patient.patient_name_ask();
							patient.setPatientName(input.nextLine(),C);
							patient.patient_age_ask();
							patient.setPatientAge(input.nextLine(),C);
						}
						if(choice==10){
							break;
						}
					}
					
					stat=false;
				}	
				
							
			}
			if(choice==4){
				flag=false;
				System.out.println("Thank you for using our services. Have a nice day!");
			}
		}
		input.close();
	}
}
