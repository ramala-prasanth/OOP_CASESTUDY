import java.util.*;
import java.lang.Math;

interface login {
	String username = "";
	String password = "";

	abstract int username_verification(String username);

	abstract int password_verification(String password);
}

class Appointments {
	String[] appointment_time = new String[1000];
	String[] appointment_date = new String[1000];
	String[] illness=new String[1000];
	String[] Doctor_name=new String[1000];
	public void setappointment(int j,String date,String time,String illness,String DName){
		this.appointment_time[j]=time;
		this.appointment_date[j]=date;
		this.illness[j]=illness;
		this.Doctor_name[j]=DName;
   }
}

// class for prescriptions and lab reports
class prescriptions_labtest {
	Scanner input = new Scanner(System.in);
	String medicine_name;
	String medicine_dosage;
	String test_name;

	public void name_ask() {
		System.out.println("Enter the medicine name:");
		medicine_name = input.next();
	}

	public void dosage_ask() {
		System.out.println("Enter the dosage:");
		medicine_dosage = input.next();
	}

	public void test_name_ask() {
		System.out.println("Enter the test_name:");
		test_name = input.next();
	}

	public void display() {
		System.out.println("The medicine name is");
		System.out.println(medicine_name);
		System.out.println("dosage is:");
		System.out.println(medicine_dosage);
		System.out.println("And test name is:");
		System.out.println(test_name);
	}
}

// class for patients which includes details like patient name, patient
// username, age, etc and also methods to get and set the data.
class patient extends Appointments implements login {
	String[] patient_username = new String[1000];
	String[] patient_password = new String[1000];
	String[] patient_name = new String[1000];
	String[] patient_age = new String[1000];
	String[] patient_phone = new String[1000];
	String[] patient_gender = new String[1000];
	String[] patient_email = new String[1000];
	String[] appointment_time = new String[1000];
	String[] appointment_date = new String[1000];
	int c = -1;

	// methods for editing the details for patient
	void patient_edit() {
		System.out.println("Please enter:");
		System.out.println("1 if you want to change your username.");
		System.out.println("2 if you want to change your password.");
	}

	// methods for basic details of patients.
	void patient_name_ask() {
		System.out.println("Enter the name of patient:");
	}

	void patient_age_ask() {
		System.out.println("Enter the age of patient:");
	}

	void patient_gender_ask() {
		System.out.println("Enter the gender of patient:");
	}

	void patient_phone_ask() {
		System.out.println("Enter the phone number of patient:");
	}

	void patient_email_ask() {
		System.out.println("Enter the email of patient:");
	}

	void patient_password_ask() {
		System.out.println("Enter the password of patient:");
	}

	// getter and setter methods for patient name
	String getPatientName(int b) {
		return patient_name[b];
	}

	void setPatientName(String newPatientName, int b) {
		this.patient_name[b] = newPatientName;
	}

	// getter and setter methods for patient age
	String getPatientAge(int b) {
		return patient_age[b];
	}

	void setPatientAge(String newPatientAge, int b) {
		this.patient_age[b] = newPatientAge;
	}

	// getter and setter methods for patient gender
	String getPatientGender(int b) {
		return patient_gender[b];
	}

	void setPatientGender(String newPatientGender, int b) {
		this.patient_gender[b] = newPatientGender;
	}

	// getter and setter methods for patient phone.
	String getPatientPhone(int b) {
		return patient_phone[b];
	}

	void setPatientPhone(String newPatientPhone, int b) {
		this.patient_phone[b] = newPatientPhone;
	}

	// getter and setter methods for patient email.
	String getPatientEmail(int b) {
		return patient_email[b];
	}

	void setPatientEmail(String newPatientEmail, int b) {
		this.patient_email[b] = newPatientEmail;
	}

	// Generating patient username and passwords:
	void username_generation(int b) {
		String dummy = "JP00";
		String number = String.valueOf(b);
		patient_username[b] = dummy.concat(number);
	}

	void password_generation(int b) {
		int randomPWD = (int) (Math.random() * 90000);
		patient_password[b] = "PWD_" + randomPWD;
	}

	// getter and setter methods for patient username
	String getPatientUsername(int b) {
		return patient_username[b];
	}

	void setPatientUsername(String newPatientUsername, int b) {
		this.patient_username[b] = newPatientUsername;
	}

	// getter setter methods pateint password
	String getPatientPassword(int b) {
		return patient_password[b];
	}

	void setPatientPassword(String newPatientPassword, int b) {
		this.patient_password[b] = newPatientPassword;
	}

	// method for displaying details.
	void display_patient(int b) {
		System.out.println("Name: " + patient_name[b]);
		System.out.println("Age: " + patient_age[b]);
		System.out.println("Gender: " + patient_gender[b]);
		System.out.println("Phone: " + patient_phone[b]);
		System.out.println("Email: " + patient_email[b]);
		System.out.println("Username: " + patient_username[b]);
		System.out.println("Password: PWD_*****");
	}

	void display_appointment(int b) {
		System.out.println("Username: " + patient_username[b]);
		System.out.println("Apointment date: " + appointment_date[b]);
		System.out.println("Apointment time: " + appointment_time[b]);
		System.out.println("Illness : "+illness[b]);
		System.out.println("Name of the doctor : "+Doctor_name[b]);
	}

	// methods for verifying patient username and password.
	public int username_verification(String username) {
		for (int i = 0; i < 1000; i++) {
			if (username.equals(getPatientUsername(i))) {
				c = i;
				break;
			}
		}
		return c;
	}

	public int password_verification(String password) {
		for (int i = 0; i < 1000; i++) {
			if (password.equals(getPatientPassword(i))) {
				c = i;
				break;
			}
		}
		return c;
	}

}

// class for doctors containing basic details and methods for setting details
// and login verification.
class doctor extends Appointments implements login {
	String[] doctor_name = new String[1000];
	String[] doctor_phone = new String[1000];
	String[] doctor_email = new String[1000];
	String[] doctor_username = new String[1000];
	String[] doctor_password = new String[1000];
	String[] doctor_department = new String[1000];
	int c = -1;

	// methods for taking details of doctor
	void doctor_name_ask() {
		System.out.println("Enter the doctor's name");
	}

	void doctor_phone_ask() {
		System.out.println("Enter the phone number of doctor");
	}

	void doctor_email_ask() {
		System.out.println("Enter the email of doctor");
	}

	void doctor_password_ask() {
		System.out.println("Enter the password of doctor");
	}

	void doctor_department_ask() {
		System.out.println("Enter the department of doctor");
	}

	// getter and setter methods for doctor name.
	String getDoctorName(int b) {
		return doctor_name[b];
	}

	void setDoctorName(String newDoctorName, int b) {
		this.doctor_name[b] = newDoctorName;
	}

	// getter and setter methods for doctor phone
	String getDoctorPhone(int b) {
		return doctor_phone[b];
	}

	void setDoctorPhone(String newDoctorPhone, int b) {
		this.doctor_phone[b] = newDoctorPhone;
	}

	// getter and setter methods for doctor Email
	String getDoctorEmail(int b) {
		return doctor_email[b];
	}

	void setDoctorEmail(String newDoctorEmail, int b) {
		this.doctor_email[b] = newDoctorEmail;
	}

	// getter and setter methods for doctor username
	String getDoctorUsername(int b) {
		return doctor_username[b];
	}

	void setDoctorUsername(String newDoctorUsername, int b) {
		this.doctor_username[b] = newDoctorUsername;
	}

	// getter and setter methods for doctor password
	String getDoctorPassword(int b) {
		return doctor_password[b];
	}

	void setDoctorPassword(String newDoctorPassword, int b) {
		this.doctor_password[b] = newDoctorPassword;
	}

	// getter and setter methods for doctor department
	String getDoctorDepartment(int b) {
		return doctor_department[b];
	}

	void setDoctorDepartment(String newDoctorDepartment, int b) {
		this.doctor_department[b] = newDoctorDepartment;
	}

	// geneation of username and password
	void username_generation(int b) {
		String dummy = "JD00";
		String number = String.valueOf(b);
		doctor_username[b] = dummy.concat(number);
	}

	void password_generation(int b) {
		int randomPWD = (int) (Math.random() * 90000);
		doctor_password[b] = "PWD_" + randomPWD;
	}

	// Methods for displaying details of doctor
	void display_doctor(int b) {
		System.out.println("Name: " + doctor_name[b]);
		System.out.println("Department: " + doctor_department[b]);
		System.out.println("Email: " + doctor_email[b]);
		System.out.println("Phone: " + doctor_phone[b]);
		System.out.println("Username: " + doctor_username[b]);
		System.out.println("Password: PWD_***");
	}

	// methods for verifying doctor username and password
	public int username_verification(String username) {
		for (int i = 0; i < 1000; i++) {
			if (username.equals(getDoctorUsername(i))) {
				c = i;
				break;
			}
		}
		return c;
	}

	public int password_verification(String password) {
		for (int i = 0; i < 1000; i++) {
			if (password.equals(getDoctorPassword(i))) {
				c = i;
				break;
			}
		}
		return c;
	}
	//confirming appointment with the doctor
	public boolean confirmappointment(int j,String Date,String Time,String illness,String DocName) {
		boolean val=false;
		for(int i=0; i<1000;i++){
			if(DocName == doctor_name[i]) {
				if(Time == appointment_time[i]){
					val=false;
					break;
				}			
				else{
					val=true;
				}		
			}
			else{
				val=false;
			}
			/*else if(DocName != doctor_name[i]){
				System.out.println("Invalid Doctor Name! Please Try Again!");
				return false;	
			}*/
		}
		return val;
	}

// class for admin which inlcudes the admin username and password and methods
// for verifying the username and password.
class admin implements login {
	private String[] admin_username = new String[1000];
	private String[] admin_password = new String[1000];
	int c = -1;

	// getter and setter methods for admin username.
	String getAdminUsername(int b) {
		return admin_username[b];
	}

	void setAdminUsername(String newAdminUsername, int b) {
		this.admin_username[b] = newAdminUsername;
	}

	// getter and setter methods for admin password.
	String getAdminPassword(int b) {
		return admin_password[b];
	}

	void setAdminPassword(String newAdminPassword, int b) {
		this.admin_password[b] = newAdminPassword;
	}

	// admin username and password verification.
	public int username_verification(String username) {
		for (int i = 0; i < 1000; i++) {
			if (username.equals(getAdminUsername(i))) {
				c = i;
				break;
			}
		}
		return c;
	}

	public int password_verification(String password) {
		for (int i = 0; i < 1000; i++) {
			if (password.equals(getAdminPassword(i))) {
				c = i;
				break;
			}
		}
		return c;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int B;
		patient patient=new patient();
		doctor doctor=new doctor();
		admin admin=doctor.new admin();
		//Appointments appointment=new Appointments();
		//creating admin usernames and passwords.
			for(int j=0;j<1000;j++){
				admin.setAdminUsername("abcedf",j);
				admin.setAdminPassword("PASSWORD",j);
			}
			admin.setAdminUsername("prasanth_r",0);
			admin.setAdminUsername("lokesh_d",1);
			admin.setAdminUsername("preetham_a",2);
			admin.setAdminUsername("dheepthi_d",3);			
		//creating duplicate names for patients
		for(int j=0;j<1000;j++){
			patient.setPatientName("abcdefg",j);
		}
		//creating duplicate names for doctors
		for(int j=0;j<1000;j++){
			doctor.setDoctorName("abcdefgh",j);
		}
		boolean flag=true;
		while(flag==true)
		{
			System.out.println("Welcome to JavaSoft systems!\nChoose:\n1 for Administrator.\n2 for patients\n3 for Doctors\n4 to exit");
			int choice=input.nextInt();
			input.nextLine();
			//ADMIN
			if(choice==1){
				while(true){
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
							patient.patient_gender_ask();
							patient.setPatientGender(input.nextLine(),C);
							patient.patient_phone_ask();
							patient.setPatientPhone(input.nextLine(),C);
							patient.patient_email_ask();
							patient.setPatientEmail(input.nextLine(),C);		
							patient.username_generation(C);
							patient.password_generation(C);
							System.out.println("Patient added successfully\n\n");
							patient.display_patient(C);							
						}
						if(choice==2){
							for(int j=0;j<1000;j++){
								if(doctor.getDoctorName(j).equals("abcdefgh")){
									C=j;
									break;
								}
							}
							doctor.doctor_name_ask();
							doctor.setDoctorName(input.nextLine(),C);
							doctor.doctor_phone_ask();
							doctor.setDoctorPhone(input.nextLine(),C);
							doctor.doctor_email_ask();
							doctor.setDoctorEmail(input.nextLine(),C);
							doctor.doctor_department_ask();
							doctor.setDoctorDepartment(input.nextLine(),C);
							doctor.username_generation(C);
							doctor.password_generation(C);
							System.out.println("Doctor added successfully.\n\n");
							doctor.display_doctor(C);
						}
						if(choice==10){
							break;
						}
					}
					break;
				}	
			}
			//PATIENT
			if(choice==2) {
					System.out.println("Please choose:\n1 if you are logging in for the first time.\nElse press any other number.");
					int ch=input.nextInt();
					input.nextLine();
					if(ch==1){
						while(true){
							B=-1;
							System.out.println("Please enter your phone number to continue.");
							String phone=input.nextLine();
							for(int i=0;i<1000;i++){
								if(phone.equals(patient.getPatientPhone(i))){
									B=i;
									break;
								}
							}
							if(B==-1){
								System.out.println("The phone number you entered doesnt match with our records.\nPlease try again!");
								continue;
							}
							System.out.println("Enter the username and password displayed here:");
							System.out.println("Username: "+patient.getPatientUsername(B));
							String inputUsername=input.nextLine();
							System.out.println("Password: "+patient.getPatientPassword(B));
							String inputPassword=input.nextLine();
							if(B==patient.username_verification(inputUsername) && B==patient.password_verification(inputPassword)){
								System.out.println("Login Successful!");
							}	
							while(true){
								System.out.println("What would you like to do?\n1.Book an appointment.\n2.View the appointment schedule.\n3.Change username and password.\n4.Get doctor details.\n10.To go back to main menu.\n");				
							ch=input.nextInt();
							input.nextLine();
							if(ch==1){
								System.out.println("Enter the date and time in the same line.\nExample:\nDD/MM/YY HH:MM\nPlease enter time in 24 hr format!");
								while(true){
									System.out.println("Enter the date:\\nExample:\\nDD/MM/YY HH:MM");
							 Scanner l=new Scanner(System.in);
							 String Date=l.nextLine();
							 System.out.println("Enter the time:\nExample: HH:MM\nPlease enter time in 24 hr format!");
				             String Time=l.nextLine();
				             System.out.println("Enter the illness:");
				             String illness=l.nextLine();
				             System.out.println("Enter the Doctor's Name you want to consult:");
				             String DocName=l.nextLine();
				                 if(doctor.confirmappointment(B,Date,Time,illness,DocName) == true) {
				                	   patient.setappointment(B,Date,Time,illness,DocName);
				                 }
				                 if(doctor.confirmappointment(B,Date,Time,illness,DocName) == false) {
				                	   System.out.println("Try one more time! Doctor is not available at that time or the values entered may not be correct!:");
				                       continue;
				                 }
							 
				            
					         
							System.out.println("Do you want to book another appointment? Yes/No \n");
							String c=input.nextLine();
							if(c=="No" || c=="no" || c=="NO"){
							break;
							}
							l.close();
								}				
													
							}	
							if(ch==2) {
								
						  }
						  if(ch==3){
							System.out.println("Enter the new username to be changed.");
							String changeUsername=input.nextLine();
							System.out.println("Enter the new password to be changed.");
							String changePassword=input.nextLine();
							patient.setPatientUsername(changeUsername,B);
							patient.setPatientPassword(changePassword,B);
							System.out.println("Username and password changed succesfuly.");						
						  }
						  if(ch==10){
							  break;
						  }
						}
							break;				
						}						
					}
					else{
					while(true){
						B=-1;
						System.out.println("Enter your username:");
						String inputUsername=input.nextLine();
						System.out.println("Enter your password: ");
						String inputPassword=input.nextLine();
						if(patient.username_verification(inputUsername)==patient.password_verification(inputPassword)){
							B=patient.username_verification(inputUsername);
							break;
						}
						else if(B==-1){
							continue;
						}
					}
					while(true){
						System.out.println("What would you like to do?\n1.Book an appointment.\n2.View the appointment schedule.\n3.Change username and password.\n4.Get doctor details.\n10.To go back to main menu.\n");				
					ch=input.nextInt();
					input.nextLine();
					if(ch==1){
						System.out.println("Enter the date and time in the same line.\nExample:\nDD/MM/YY HH:MM\nPlease enter time in 24 hr format!");
						while(true){
							System.out.println("Enter the date:\\nExample:\\nDD/MM/YY HH:MM");
							 Scanner l=new Scanner(System.in);
							 String Date=l.nextLine();
							 System.out.println("Enter the time:\nExample: HH:MM\nPlease enter time in 24 hr format!");
				             String Time=l.nextLine();
				             System.out.println("Enter the illness:");
				             String illness=l.nextLine();
				             System.out.println("Enter the Doctor's Name you want to consult:");
				             String DocName=l.nextLine();
				                 if(doctor.confirmappointment(B,Date,Time,illness,DocName) == true) {
				                	   patient.setappointment(B,Date,Time,illness,DocName);
				                 }
				                 if(doctor.confirmappointment(B,Date,Time,illness,DocName) == false) {
				                	   System.out.println("Try one more time! Doctor is not available at that time or the values entered may not be correct!:");
				                       continue;
				                 }
							 
				            
					         
							System.out.println("Do you want to book another appointment? Yes/No \n");
							String c=input.nextLine();
							if(c=="No" || c=="no" || c=="NO"){
							break;
							}
							l.close();
						}								
					}	
					if(ch==2) {
						System.out.println("Enter the");
					   }
				  
				  if(ch==3){
					System.out.println("Enter the new username to be changed.");
					String changeUsername=input.nextLine();
					System.out.println("Enter the new password to be changed.");
					String changePassword=input.nextLine();
					patient.setPatientUsername(changeUsername,B);
					patient.setPatientPassword(changePassword,B);
					System.out.println("Username and password changed succesfuly.");						
				  }
				  if(ch==10){
					  break;
				  }
				}
			}		  			  
		}				  				
			// DOCTOR
			if(choice==3){
				System.out.println("Please choose:\n1 if you are logging in for the first time.\nElse press any other key.");
				int ch=input.nextInt();
				input.nextLine();
				if(ch==1){
					while(true){
						B=-1;
						System.out.println("Please enter your phone number to continue.");
						String phone=input.nextLine();
						for(int i=0;i<1000;i++){
							if(phone.equals(doctor.getDoctorPhone(i))){
								B=i;
								break;
							}
						}
						if(B==-1){
							System.out.println("The phone number you entered doesnt match with our records.\nPlease try again!");
							continue;
						}
						System.out.println("Enter the username and password displayed here:");
						System.out.println("Username: "+doctor.getDoctorUsername(B));
						String inputUsername=input.nextLine();
						System.out.println("Password: "+doctor.getDoctorPassword(B));
						String inputPassword=input.nextLine();
						if(B==doctor.username_verification(inputUsername) && B==doctor.password_verification(inputPassword)){
							System.out.println("Login Successful!");
						}
						while(true){
							System.out.println("What would you like to do?");
							System.out.println("Enter:\n1 to ");
						}					
					}		
				}
				else{
					while(true){
						B=-1;
						System.out.println("Enter your username:");
						String inputUsername=input.nextLine();
						System.out.println("Enter your password:");
						String inputPassword=input.nextLine();
						if(doctor.username_verification(inputUsername) == doctor.password_verification(inputPassword)){
							B=doctor.username_verification(inputUsername);
							break;
						}
						else if(B==-1){
							continue;
						}
					}
					while(true){
						System.out.println("What would you like to do?");
						System.out.println("Enter:\n1 to change username and password\n2 for prescribing medicines\n3 for prescribing lab tests.\n10 to go back to the main menu");
						ch=input.nextInt();
						input.nextLine();
						if(ch==1){
							System.out.println("Enter the new username to be changed.");
							String changeUsername=input.nextLine();
							System.out.println("Enter the new password to be changed.");
							String changePassword=input.nextLine();
							doctor.setDoctorUsername(changeUsername,B);
							doctor.setDoctorPassword(changePassword,B);
							System.out.println("Username and password changed succesfuly.");
						}
						if(ch==2){

						}
						if(ch==3){

						}
						if(ch==10){
							break;
						}
					}
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
}

