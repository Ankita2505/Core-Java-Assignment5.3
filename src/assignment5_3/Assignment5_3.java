package assignment5_3;
/*
 * program that will compute an Employee's salary and manage their leave details.
 */
import java.io.IOException;//Import Input output Exception
import java.io.*;//Import Input Output header file for user input

abstract class Employee// Employee Abstract Class
{
	int empId;
	String empName;
	int total_leaves;
	double total_salary;
	abstract void calculate_balance_leaves();//Abstract Method to calculate balance leaves
	abstract boolean avail_leave(int no_of_leaves,char type_of_leave);//Abstract Method to check avail_leave
	abstract void calculate_salary();//Abstract method to calculate salary
}
class PermanentEmp extends Employee//Permanent Employee Child Class Inherits property of Employee Parent class
{
	//Hard coding paid leave, sick leave, casual leave approved values
	int paid_leave_approved  = 10;
	int sick_leave_approved = 10;
	int casual_leave_approved = 10;
	double basic;
	double hra;
	double pfa;
	int paid_leave_consumed; 
	int sick_leave_consumed; 
	int casual_leave_consumed;
	int paid_leave_balance;
	int sick_leave_balance;
	int casual_leave_balance;
	PermanentEmp(int EmpId1,String empname1,int paid_leave1,int sick_leave1,int casual_leave1,double basic1)//Parameterized Constructor of permanent employee
	{
		empId = EmpId1;
		empName =empname1;
		paid_leave_consumed=paid_leave1;
		sick_leave_consumed=sick_leave1;
		casual_leave_consumed=casual_leave1;
		basic =basic1;
		calculate_balance_leaves();
	}
	void print_leave_details()//Prints Leave Details of Permanent Employee
	{
		System.out.println("Total Paid leave =>" + paid_leave_approved);
		System.out.println("Paid leave balance=>" + paid_leave_balance);
		System.out.println("Total Sick leave =>" + sick_leave_approved);
		System.out.println("Sick leave balance=>" + sick_leave_balance);
		System.out.println("Total Casual leave =>" + casual_leave_approved);
		System.out.println("Casual leave balance=>" + casual_leave_balance);

	}
	void calculate_balance_leaves()//Calculate Balance Leaves of Permanent Employee
	{
		paid_leave_balance=paid_leave_approved-paid_leave_consumed;
		sick_leave_balance=sick_leave_approved-sick_leave_consumed;
		casual_leave_balance =casual_leave_approved-casual_leave_consumed;
	}
	boolean avail_leave(int no_of_leaves, char type_of_leave)//Checking Boolean Result for Avail_leave for Permanent Employee
	{
		switch (type_of_leave)
		{
		case '1':
		{
			if(paid_leave_balance>=no_of_leaves)
			{
				paid_leave_balance=paid_leave_balance-no_of_leaves;
				print_leave_details();
				return true;
			}
			else 
				return false;

		}
		case '2':
		{
			if(sick_leave_balance>=no_of_leaves)	
			{
				sick_leave_balance=sick_leave_balance-no_of_leaves;
				print_leave_details();
				return true;
			}
			else 
				return false;
		}
		case '3':
		{
			if(casual_leave_balance>=no_of_leaves)	
			{
				casual_leave_balance=casual_leave_balance-no_of_leaves;
				print_leave_details();
				return true;
			}
			else 
				return false;
		}
		default: break;
		}
		return true;
	}
	void calculate_salary()//Calculating Salary of Permanent Employee
	{
		pfa=basic*12/100;
		hra=basic*50/100;
		total_salary=basic+hra-pfa;
	}
}
class TemporaryEmp extends Employee//Temporary Employee Child Class Inherits property of Employee Parent class
{
	int total_leave=20;//hard coding total leave for temporary employee
	int total_leave_consumed;
	int total_leave_balance;
	TemporaryEmp(int EmpId1,String empname1,int leave1,double salary1)//Parameterized Constructor of Temporary employee
	{
		empId = EmpId1;
		empName =empname1;
		total_leave_consumed=leave1;
		total_salary =salary1;
		calculate_balance_leaves();
	}
	void calculate_balance_leaves()//Calculate Balance Leaves of Temporary Employee
	{
		total_leave_balance =total_leave-total_leave_consumed;
	}
	void print_leave_details()//Prints Leave Details of Temporary Employee
	{
		System.out.println("Total Leave =>" + total_leave);
		System.out.println("Leave balance=>" + total_leave_balance);
	}
	boolean avail_leave(int no_of_leaves,char type_of_leave)//Checking Boolean Result for Avail_leave for Temporary Employee
	{
		if(total_leave_balance>=no_of_leaves)
		{
			total_leave_balance= total_leave_balance-no_of_leaves;
			print_leave_details();
			return true;
		}
		else 
			return false;
	}
	void calculate_salary()//Calculating Salary of Temporary employee
	{
		System.out.println("Total salary =>" + total_salary);
	}
}
public class Assignment5_3 
{
	public static void main(String[] args)throws IOException //Start of Main Class
	{
		// TODO Auto-generated method stub
		int EmpId_Inp;
		String EmpName_Inp;
		int paid_leave_Inp;
		int sick_leave_Inp;
		int casual_leave_Inp;
		double basic_Inp;
		int no_of_perm_emp;
		int no_of_temp_emp;
		int perm_cnt;
		int temp_cnt;
		BufferedReader br= new BufferedReader (new InputStreamReader(System.in));
		System.out.println("Enter Number of permanent Employee:-");// Taking input For Number of Permanent employee
		no_of_perm_emp=Integer.parseInt(br.readLine());
		System.out.println("Enter Number of temporary Employee:-");// Taking input For Number of Temporary Employee
		no_of_temp_emp=Integer.parseInt(br.readLine());
		PermanentEmp per_emp[]=new PermanentEmp[no_of_perm_emp];
		TemporaryEmp temp_emp[]=new TemporaryEmp[no_of_temp_emp];
		System.out.println("Enter permanent employee details:-");// Entering Permanent Employee Details
		for(perm_cnt=0;perm_cnt<no_of_perm_emp;perm_cnt++) 
		{
			System.out.println("Enter EmpId:- ");//User Input For Permanent Employee Id
			EmpId_Inp=Integer.parseInt(br.readLine());
			System.out.println("Enter EmpName:- ");//User Input for Permanent Employee Name
			EmpName_Inp=br.readLine();
			System.out.println("Enter basic salary:- ");//User Input for Permanent Employee Basic Salary
			basic_Inp=Integer.parseInt(br.readLine());
			System.out.println("Enter paid leave consumed(max 10):- ");//user For for paid leave
			paid_leave_Inp=Integer.parseInt(br.readLine());
			System.out.println("Enter sick leave consumed(max 10):- ");//user input for sick leave
			sick_leave_Inp=Integer.parseInt(br.readLine());
			System.out.println("Enter casual leave consumed(max 10):- ");//user input for casual leave
			casual_leave_Inp=Integer.parseInt(br.readLine());
			per_emp[perm_cnt]=new PermanentEmp(EmpId_Inp,EmpName_Inp,paid_leave_Inp,sick_leave_Inp,casual_leave_Inp,basic_Inp);
			per_emp[perm_cnt].calculate_salary();
			System.out.println("Total pfa =>" + per_emp[perm_cnt].pfa);
			System.out.println("Total hra =>" + per_emp[perm_cnt].hra);
			System.out.println("Total salary =>" + per_emp[perm_cnt].total_salary);
			per_emp[perm_cnt].print_leave_details();
			System.out.println("Do you want to apply for leave");
			System.out.println("(1/0):- ");
			int Inp=Integer.parseInt(br.readLine());
			if(Inp==1)
			{
				System.out.println("1.Paid Leave ");
				System.out.println("2.Sick Leave");
				System.out.println("3.Casual Leave");
				System.out.println("Select the type of leave(1,2,3)");
				int opt=Integer.parseInt(br.readLine());
				System.out.println("Enter number of leave to apply ");
				int leave_apply=Integer.parseInt(br.readLine());
				boolean ret =per_emp[perm_cnt].avail_leave(leave_apply,(char)opt); 
				if(ret==true)
					System.out.println("Leave applied successfully");
				else 
					System.out.println("Leave not available");
			}
		}
		System.out.println("Enter temporary employee details:-");// Entering Temporary Employee Details
		for(temp_cnt=0;temp_cnt<no_of_temp_emp;temp_cnt++) 
		{
			System.out.println("Enter EmpId:- ");//User Input For Temporary Employee Id
			EmpId_Inp=Integer.parseInt(br.readLine());
			System.out.println("Enter EmpName:- ");//User Input for Temporary Employee Name
			EmpName_Inp=br.readLine();
			System.out.println("Enter total leave consumed(max 20):- ");//User input for total leave consumed for temporary employee
			int leaves=Integer.parseInt(br.readLine());
			System.out.println("Enter total salary:- ");//User input for total salary of Temporary Employee
			double salary=Integer.parseInt(br.readLine());
			temp_emp[temp_cnt]=new TemporaryEmp(EmpId_Inp,EmpName_Inp,leaves,salary);
			temp_emp[temp_cnt].calculate_salary();
			temp_emp[temp_cnt].print_leave_details();
			System.out.println("Do you want to apply for leave");
			System.out.println("(1/0):- ");
			int Inp=Integer.parseInt(br.readLine());
			if(Inp==1)
			{
				System.out.println("Enter number of leave to apply ");
				int leave_apply=Integer.parseInt(br.readLine());
				boolean ret =temp_emp[temp_cnt].avail_leave(leave_apply,'1'); 
				if(ret==true)
					System.out.println("Leave applied successfully");
				else 
					System.out.println("Leave not available");
			}
		}
	}//Close main Class
}


