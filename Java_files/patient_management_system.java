import java.util.*;
abstract class login{
	String username;
	String password;
	abstract int username_verification(String username);
	abstract int password_verification(String password);
	
}
// class for patients which includes details like patient name, patient username, age, etc and also methods to get and set the data.
/*class patient extends login{
		String[] patient_username=new String[1000];
		String[] patient_password=new String [1000];
		String[] patient_name=new String[1000];
		String[] patient_age=new String[1000];
		String[] patient_phone=new String[1000];
		String patient_gender;
		private String patient_email;
		private String getPatientName(){
			return patient_name[i];
		}
		private void setPatientName(String newPatientName){
			this.patient_name[i] = newPatientName;
		}
		
}*/

class admin extends login{
		private String[] admin_username=new String[1000];
		private String[] admin_password=new String[1000];
		int c=-1;
		void add_patients(){

		}
		void add_doctors(){
			System.out.println("");
		}
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
		int verify;
		//patient patient=new patient();
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
		
		boolean flag=true;
		while(flag==true)
		{
			System.out.println("Welcome to JavaSoft systems!\nWhat would you like to do?\nChoose:\n1 for Administrator.\n2 for patients\n3 for Doctors\n4 to exit");
			int choice=input.nextInt();
			input.nextLine();
			boolean stat=true;
			if(choice==1){
				while(stat==true){
					System.out.println("Enter your Username:");
					String AdminUsername=input.nextLine();
					verify=admin.username_verification(AdminUsername);
					//System.out.println(verify);
					if(verify==-1){
						System.out.println("The Administrator does not exist!\nTry again!");
						continue;
					}
					System.out.println("Enter your password:");
					String AdminPassword=input.nextLine();
					verify=admin.password_verification(AdminPassword);
					if(verify==-1){
						System.out.println("The password is incorrect! Try again!");
						continue;
					}
					stat=false;
				}				
			}
		}
		input.close();
	}
}
