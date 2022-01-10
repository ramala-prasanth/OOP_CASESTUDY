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
	void initialValues(){
		for(int i=0;i<1000;i++){
			appointment_time[i]="";
			appointment_date[i]="";
			illness[i]="";
			Doctor_name[i]="";
		}
	}
	public void setappointment(int j,String date,String time,String disease,String DName){
		this.appointment_time[j]=appointment_time[j]+time;
		this.appointment_date[j]=appointment_date[j]+date;
		this.illness[j]= illness[j]+disease;
		this.Doctor_name[j]=Doctor_name[j]+DName;
   }
}

//class for diagnosis.
class diagnosis{
    String[] disease= new String[1000];
    String[] symptoms=new String[1000];
	void initValues(){
		for(int i=0;i<1000;i++){
			disease[i]="";
			symptoms[i]="";
		}
	}

    public void disease_ask(int b){
        Scanner s= new Scanner (System.in);
        System.out.println("Enter the disease:");
        this.disease[b]=disease[b]+s.nextLine();
		s.close();
    }
    public void symptoms_ask(int b){
        Scanner s= new Scanner (System.in);
        System.out.println("Enter the symptoms:");
        this.symptoms[b]=symptoms[b]+s.nextLine();
		s.close();
    }
    public void display_diagnosis(int b) {
		String[] arrDisease=disease[b].split(" ",0);
		String[] arrSymptoms= symptoms[b].split(" ",0);
		System.out.println("S.No\t\tDisease\t\t\tSymptoms");
		for(int i=0;i<arrSymptoms.length;i++){
			System.out.println(i+"\t\t"+arrDisease[i]+"\t\t\t"+arrSymptoms[i]);
		}
     	/*System.out.println("The disease is");
        System.out.println(disease);
        System.out.println("And symptoms are");
        System.out.println(symptoms);*/
    }
}
// class for prescriptions and lab reports
class prescriptions_labtest extends diagnosis {
	Scanner input = new Scanner(System.in);
	String[] medicine_name = new String[1000];
	String[] medicine_dosage = new String[1000];
	float[] medicine_cost= new float[1000];
	String[] test_name = new String[1000];
	String[] test_cost = new String[1000];
	String[] lab_test = new String[10];
	float lab_cost[] = new float[10];


	void intialize(){
		for(int i=0;i<1000;i++){
			medicine_name[i] = "";
			medicine_dosage[i]="";
			test_name[i]="";
		}
		lab_test[0]="Blood Test";
		lab_test[1]="Urine Test";
		lab_test[2]="Thyroid Test";
		lab_test[3]="Diabetes Test";
		lab_cost[0]=1500;
		lab_cost[1]=2499;
		lab_cost[2]=3333;
		lab_cost[3]=1250;
	}
	

	public void name_ask(int b) {
		System.out.println("Enter the medicine name:");
		this.medicine_name[b] = medicine_name[b]+input.nextLine();
	}

	public void dosage_ask(int b) {
		System.out.println("Enter the dosage:");
		this.medicine_dosage[b] = medicine_dosage[b]+input.nextLine();
	}

	public void test_name_ask(int b) {
		System.out.println("Enter the test number");
		this.test_name[b] = test_name[b]+input.nextLine();
	}
	void display_test_name(int b){
		String[] arrLab= test_name[b].split(" ",0);
		int[] lab_number= new int[arrLab.length];
		for(int i=0;i<arrLab.length;i++){
			lab_number[i]=Integer.parseInt(arrLab[i]);
			System.out.println(lab_test[lab_number[i]]);
		}
	}
	public void display_prescription(int b) {
		patient patient_new = new patient();
		System.out.println("Name of the patient: "+patient_new.getPatientName(b));
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.println("Medicine\t\t\tDosage");
		String[] arrMedicine = medicine_name[b].split(" ",0);
		String[] arrDosage = medicine_dosage[b].split(" ",0);
		for(int i=0; i<arrDosage.length; i++){
			System.out.println(arrMedicine[i]+"\t\t\t"+arrDosage[i]);
		}

		/*System.out.println("The medicine name is");
		System.out.println(medicine_name[b]);
		System.out.println("dosage is:");
		System.out.println(medicine_dosage[b]);
		System.out.println("And test name is:");
		System.out.println(test_name[b]);*/
	}
	void display_labreport(int b, int lab_no){
		patient patient_new = new patient();
		if(lab_no==0){
			System.out.println("                                  LAB REPORT                                              ");
			System.out.println("-----------------------------------------------------------------------------------------");
			System.out.println("Patient Name: "+patient_new.getPatientName(b));
			System.out.println("Patient Name: "+patient_new.getPatientAge(b));
			System.out.println("Test name: "+test_name[b]);
			System.out.println("Haemoglobin : 10.0 to 17.7 g/dL");
			double x=10.0;
		    double y=17.7;
		    double random = x-((int)Math.round((Math.random())*(x-y)));
	        System.out.println("The haemoglobin level in your blood:"+random);
	        System.out.println("WBC : 3.5 to 10.5 billion/L");
	        double a=3.5;
		    double c=10.5;
		    double WBC = a-((int)Math.round((Math.random())*(a-c)));
	        System.out.println("The WBC level in your blood :" + WBC + "billion/L");
	        System.out.println("Platelets : 150 to 450 billion/L");
	        double z=150;
		    double e=450;
		    double platelets = z-((int)Math.round((Math.random())*(z-e)));
	        System.out.println("The platelets level in your blood :" + platelets + "billion/L");
			
			
			
			
			//double l = (double) (10.0 + (int)(Math.random() * 17.7));
			//System.out.println("Haemoglobin level :"+ l + "g/dL");
			
			/*int randomPWD = (int) (Math.random() * 90000);
			patient_password[b] = "PWD_" + randomPWD;*/
		}
		if(lab_no==1){
			System.out.println("                                  LAB REPORT                                              ");
			System.out.println("-----------------------------------------------------------------------------------------");
			System.out.println("Patient Name: "+patient_new.getPatientName(b));
			System.out.println("Patient Name: "+patient_new.getPatientAge(b));
			System.out.println("Test name: "+test_name[b]);
			System.out.println("Epinephrine : 0 to 20 mug/24h");
			double x1=0;
		    double y1=20;
		    double E = x1-((int)Math.round((Math.random())*(x1-y1)));
	        System.out.println("The Epinephrine level in your level:"+ E + " mug/24h");
	        System.out.println("Dopamine : 65 to 400 mug/24h");
			double x2=65;
		    double y2=400;
		    double D = x2-((int)Math.round((Math.random())*(x2-y2)));
	        System.out.println("The Dopamine level in your level:"+ D + " mug/24h");
	        System.out.println("Metanephrine : 0 to 1000 mug/24h");
			double x3=0;
		    double y3=1000;
		    double M = x3-((int)Math.round((Math.random())*(x3-y3)));
	        System.out.println("The Metanephrine level in your level:"+ M + " mug/24h");

		}
		if(lab_no==2){
			System.out.println("                                  LAB REPORT                                              ");
			System.out.println("-----------------------------------------------------------------------------------------");
			System.out.println("Patient Name: "+patient_new.getPatientName(b));
			System.out.println("Patient Name: "+patient_new.getPatientAge(b));
			System.out.println("Test name: "+test_name[b]);
			System.out.println("Thyroxine : 4.5 to 12 mug/24h");
			double y1=4.5;
		    double z1=12;
		    double T = y1-((int)Math.round((Math.random())*(y1-z1)));
	        System.out.println("The Thyroxine level in your level:"+ T + " ug/dL");
	        System.out.println("TSH : 0.450 to 4.500 uIU/mL");
			double t1=0.450;
		    double t2=4.500;
		    double T1 = t1-((int)Math.round((Math.random())*(t1-t2)));
	        System.out.println("The TSH level in your level:"+ T1 + " mug/24h");
	        System.out.println("Trioiodothyronine : 2.0 to 4.4 pg/mL");
			double i1=2.0;
		    double i2=4.4;
		    double T2 = i1-((int)Math.round((Math.random())*(i1-i2)));
	        System.out.println("The Triiodothyronine level in your level:"+ T2 + " mug/24h");
		}
		if(lab_no==3) {
			System.out.println("                                  LAB REPORT                                              ");
			System.out.println("-----------------------------------------------------------------------------------------");
			System.out.println("Patient Name: "+patient_new.getPatientName(b));
			System.out.println("Patient Name: "+patient_new.getPatientAge(b));
			System.out.println("Test name: "+test_name[b]);
			System.out.println("Blood Glucose(F) : 60 to 100 mgs/dl");
			double z1=60;
		    double z2=100;
		    double B = z1-((int)Math.round((Math.random())*(z1-z2)));
	        System.out.println("The Blood Glucose(F) level in your level:"+ B + " ug/dL");
	        System.out.println("Blood Glucose(PP) : 60 to 100 mgs/dl");
			double s1=100;
		    double s2=150;
		    double G = s1-((int)Math.round((Math.random())*(s1-s2)));
	        System.out.println("The Blood Glucose(PP) level in your level:"+ G + " ug/dL");
		}
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
	//String[] appointment_time = new String[1000];
	//String[] appointment_date = new String[1000];
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
		System.out.println("-----------------------------------------------------------------");
		String[] arrDate= appointment_date[b].split(" ",0);
		String[] arrTime= appointment_time[b].split(" ",0);
		String[] arrIllness= illness[b].split(" ",0);
		String[] arrDoctor= Doctor_name[b].split(" ",0);
		System.out.println("Apointment date\t\tAppointment Time\t\tIllness\t\tDoctor Name");
		for(int i=0;i<arrDate.length;i++){
			System.out.println(arrDate[i]+"\t\t"+arrTime[i]+"\t\t"+arrIllness[i]+"\t\t"+arrDoctor[i]);
		}
		/*System.out.println("Apointment date: " + appointment_date[b]);
		System.out.println("Apointment time: " + appointment_time[b]);
		System.out.println("Illness : "+illness[b]);
		System.out.println("Name of the doctor : "+Doctor_name[b]);*/
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
		admin admini=new admin();
		patient patient=new patient();
		doctor doctor=new doctor();
		Appointments appointment=new Appointments();
		diagnosis diagnosis = new diagnosis();
		prescriptions_labtest prescriptions = new prescriptions_labtest();
		diagnosis.initValues();
		prescriptions.intialize();
		//callling method to set appointment details to null 
		appointment.initialValues();
		//creating admin usernames and passwords.
			for(int j=0;j<1000;j++){
				admini.setAdminUsername("abcedf",j);
				admini.setAdminPassword("PASSWORD",j);
			}
			admini.setAdminUsername("prasanth_r",0);
			admini.setAdminUsername("lokesh_d",1);
			admini.setAdminUsername("preetham_a",2);
			admini.setAdminUsername("dheepthi_d",3);			
		//creating duplicate names for patients
		for(int j=0;j<1000;j++){
			patient.setPatientName("abcdefg",j);
		}
		//creating duplicate names for doctors
		for(int j=0;j<1000;j++){
			doctor.setDoctorName("abcdefgh",j);
		}
		//creating three doctors...
		doctor.setDoctorName("James Mathew",0);
		doctor.setDoctorPhone("1029384756",0);
		doctor.setDoctorEmail("james_m@gmail.com",0);
		doctor.setDoctorDepartment("Cardiology",0);

		doctor.setDoctorName("Lila Das",1);
		doctor.setDoctorPhone("9652744412",1);
		doctor.setDoctorEmail("lila_das@gmail.com",1);
		doctor.setDoctorDepartment("gastroenterology",1);

		doctor.setDoctorName("Jason Paul",2);
		doctor.setDoctorPhone("9989033143",2);
		doctor.setDoctorEmail("paul_j@gmail.com",2);
		doctor.setDoctorDepartment("Radiology",2);

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
					B=admini.username_verification(AdminUsername);
					//System.out.println(verify);
					if(B==-1){
						System.out.println("The Administrator does not exist!\nTry again!");
						continue;
					}
					System.out.println("Enter your password:");
					String AdminPassword=input.nextLine();
					B=admini.password_verification(AdminPassword);
					if(B==-1){
						System.out.println("The password is incorrect! Try again!");
						continue;
					}
					System.out.println("Hello "+admini.getAdminUsername(B));
					while(true){
						System.out.println("What would you like to do?\nPlease enter:\n1 for adding patients.\n3 for deleting patients records.\n2 for adding doctors.\n10 for going back to the main menu.");
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
								System.out.println("What would you like to do?\n1.Book an appointment.\n2.View the appointment schedule.\n3.Change username and password.\n4.Get doctor details.\n5 to get diagnosis details\n6. to display prescription\n7 to display lab report.\n8 to display the bill.\n10.To go back to main menu.\n");				
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
								patient.display_appointment(B);
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
						  if(ch==4){
							  System.out.println("Details of Doctor: ");
							  System.out.println("Doctor Name\t\tDepartment\t\tPhone NO.");
							  for(int i=0;i<3;i++){
								  System.out.println(doctor.getDoctorName(i)+"\t\t"+doctor.getDoctorDepartment(i)+"\t\t"+doctor.getDoctorPhone(i));
							  }
						  }
						  if(ch==5){
							  System.out.println("Diagnosis Details: ");
							  diagnosis.display_diagnosis(B);
						  }
						  if(ch==6){
							  System.out.println("Prescription:");
							  prescriptions.display_prescription(B);
						  }
						  if(ch==7){
							  System.out.println("You have taken tests for:");
							  prescriptions.display_test_name(B);
							  while(true){
									System.out.println("Enter:\n0 for Blood test\n1 for Urine Test\n2 for Thyroid Test\n3 for Diabetes Test");
									int num=input.nextInt();
									input.nextLine();
									prescriptions.display_labreport(B,num);
									System.out.println("Do you want to see another report?\nPress 'y' to continue\nelse press any other key.");
									String cha=input.nextLine();
									if(cha.equals("y")){
										continue;
									}
									else{
										break;
									}
							  }
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
						System.out.println("What would you like to do?\n1.Book an appointment.\n2.View the appointment schedule.\n3.Change username and password.\n4.Get doctor details.\n5 to get diagnosis details\n6. to display prescription\n7 to display lab report.\n8 to display the bill.\n10.To go back to main menu.\n");								
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
						patient.display_appointment(B);
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
				  if(ch==4){
					System.out.println("Details of Doctor: ");
					System.out.println("Doctor Name\t\tDepartment\t\tPhone NO.");
					for(int i=0;i<3;i++){
						System.out.println(doctor.getDoctorName(i)+"\t\t"+doctor.getDoctorDepartment(i)+"\t\t"+doctor.getDoctorPhone(i));
					}
				}
				if(ch==5){
					System.out.println("Diagnosis Details: ");
					diagnosis.display_diagnosis(B);
				}
				if(ch==6){
					System.out.println("Prescription:");
					prescriptions.display_prescription(B);
				}
				if(ch==7){
					System.out.println("You have taken tests for:");
					prescriptions.display_test_name(B);
					while(true){
						  System.out.println("Enter:\n0 for Blood test\n1 for Urine Test\n2 for Thyroid Test\n3 for Diabetes Test");
						  int num=input.nextInt();
						  input.nextLine();
						  prescriptions.display_labreport(B,num);
						  System.out.println("Do you want to see another report?\nPress 'y' to continue\nelse press any other key.");
						  String cha=input.nextLine();
						  if(cha.equals("y")){
							  continue;
						  }
						  else{
							  break;
						  }
					}
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
							System.out.println("Enter:\n1 to change username and password\n2 for diagnosing the patient.\n3 for prescribing medicines and any labtests\n4 for viewing patient details.\n10 to go back to the main menu");
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
							while(true){
								System.out.println("Enter patient's name.");
								String pname = input.nextLine();
								int C=-1;
								for(int i=0;i<1000;i++){
									if(pname.equals(patient.getPatientName(i))){
										C=i;
										break;
									}
								}
								if(C==-1){
									System.out.println("The name is not in our records. Try again!");
									continue;
								}
								System.out.println("Please enter the diseases and symptoms seperated by a 'SPACE'.");
								diagnosis.disease_ask(C);
								diagnosis.symptoms_ask(C);
								break;
							}
						}
						if(ch==3){
							while(true){
								System.out.println("Enter patient's name.");
								String pname = input.nextLine();
								int C=-1;
								for(int i=0;i<1000;i++){
									if(pname.equals(patient.getPatientName(i))){
										C=i;
										break;
									}
								}
								if(C==-1){
									System.out.println("The name is not in our records. Try again!");
									continue;
								}
								System.out.println("Enter the medicine and dosage seperated by a 'SPACE'.");
								prescriptions.name_ask(C);
								prescriptions.dosage_ask(C);
								System.out.println("Do you want to recommend any lab tests?\nPress:\n'y' if yes\nany other key if no.");
								String x= input.nextLine();
								if(x.equals("y")){
									System.out.println("Enter:\n0 for Blood test\n1 for Urine Test\n2 for Thyroid Test\n3 for Diabetes Test");
									System.out.println("(Seperate the numbers with a 'SPACE' if you want to recommend more than 1 test)");
									prescriptions.test_name_ask(C);									
								}
								break;
							}
						}
						if(ch==4){
							while(true){
								System.out.println("Enter the patient's name.");
								String pname=input.nextLine();
								int C=-1;
								for(int i=0;i<1000;i++){
									if(pname.equals(patient.getPatientName(i))){
										C=i;
										break;
									}
								}
								if(C==-1){
									System.out.println("The name is not in our records. Try again!");
									continue;
								}
								System.out.println("Basic Details of patient:");
								patient.display_patient(C);
								System.out.println("Diagnosis: ");
								diagnosis.display_diagnosis(C);
							}
						}
						if(ch==10){
							break;
						}
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
						System.out.println("Enter:\n1 to change username and password\n2 for diagnosing the patient.\n3 for prescribing medicines and any labtests\n4 for viewing patient details.\n10 to go back to the main menu");
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
							while(true){
								System.out.println("Enter patient's name.");
								String pname = input.nextLine();
								int C=-1;
								for(int i=0;i<1000;i++){
									if(pname.equals(patient.getPatientName(i))){
										C=i;
										break;
									}
								}
								if(C==-1){
									System.out.println("The name is not in our records. Try again!");
									continue;
								}
								System.out.println("Please enter the diseases and symptoms seperated by a 'SPACE'.");
								diagnosis.disease_ask(C);
								diagnosis.symptoms_ask(C);
								break;
							}
						}
						if(ch==3){
							while(true){
								System.out.println("Enter patient's name.");
								String pname = input.nextLine();
								int C=-1;
								for(int i=0;i<1000;i++){
									if(pname.equals(patient.getPatientName(i))){
										C=i;
										break;
									}
								}
								if(C==-1){
									System.out.println("The name is not in our records. Try again!");
									continue;
								}
								System.out.println("Enter the medicine and dosage seperated by a 'SPACE'.");
								prescriptions.name_ask(C);
								prescriptions.dosage_ask(C);
								System.out.println("Do you want to recommend any lab tests?\nPress:\n'y' if yes\nany other key if no.");
								String x= input.nextLine();
								if(x.equals("y")){
									System.out.println("Enter:\n0 for Blood test\n1 for Urine Test\n2 for Thyroid Test\n3 for Diabetes Test");
									System.out.println("(Seperate the numbers with a 'SPACE' if you want to recommend more than 1 test)");
									prescriptions.test_name_ask(C);									
								}
								break;
							}
						}
						if(ch==4){
							while(true){
								System.out.println("Enter the patient's name.");
								String pname=input.nextLine();
								int C=-1;
								for(int i=0;i<1000;i++){
									if(pname.equals(patient.getPatientName(i))){
										C=i;
										break;
									}
								}
								if(C==-1){
									System.out.println("The name is not in our records. Try again!");
									continue;
								}
								System.out.println("Basic Details of patient:");
								patient.display_patient(C);
								System.out.println("Diagnosis: ");
								diagnosis.display_diagnosis(C);
							}
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


