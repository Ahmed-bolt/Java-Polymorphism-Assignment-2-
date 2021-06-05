//Firm was used in place of Q1 since it was the public class with the public method as in the UML diagram
//The payday is calculated by the multiplying the rate with the number of hours and adding it to the comission rate multiplied by the total sales

class Staff{
	private StaffMember[]staffList;
	
	Staff(){
		staffList=new StaffMember[8];
		staffList[0]=new Volunteer ("kwabena","EB-0012-1234","0271832772");
		staffList[1]=new Volunteer ("John","EB-0015-7442","0245734562");
		staffList[2]=new Employee ("Kwame","EB-0015-7733","0203344567","66993",9.0);
		staffList[3]=new Employee ("Larry","EB-0015-9944","0244567890","7645",2.4);
		staffList[4]=new Executive ("Kojo","EB-0015-3342","0245890056","0066",11.4);
		staffList[5]=new Hourly ("Burga","EB-0015-2234","0277113456","8890",34.7);
		staffList[6]=new Commission ("Charity","EB-0015-0000","0247943828","7777",1.34,0.3);
		staffList[7]=new Commission ("Abena","EB-0015-6752","050779900","6067",8.90,0.13);
		
		
		((Commission)staffList[6]).addHours(35);
		((Commission)staffList[6]).addsales(675);
		((Commission)staffList[7]).addHours(75);
		((Commission)staffList[7]).addsales(655);
		
		
	}
	public void payday() {
		for (int i=0;i<staffList.length;i++) {
			System.out.println(staffList[i]);
			System.out.println("Paid:   "+staffList[i].pay());
		}
	}
}

abstract class StaffMember{
	protected String name;
	protected String address;
	protected String phone;
	
	StaffMember(String name, String address, String phone){
		this.name=name;
		this.address=address;
		this.phone=phone;
		
	}
	public String toString() {
		return "Name:" + name + "Address:" +address + "Phone Number:"+phone;
		
	}
	public double pay() {
		return 0;
		
	}
	
	
	
}

class Volunteer extends StaffMember{
	Volunteer(String vname, String vaddress, String vphone){
		super(vname,vaddress,vphone);
	}
	
	public double pay() {
		return 0;
	}
}

class Employee extends StaffMember{
	
	protected String socialSecurityNumber;
	protected double payRate;
	
	Employee(String ename, String eaddress, String ephone,String soSecurityNumber, double rate){
		super(ename, eaddress,ephone);
		socialSecurityNumber=soSecurityNumber;
		payRate=rate;
		

	}
	
	public String toString() {
		return super.toString() + "Social Security Number is:" + socialSecurityNumber + "Pay Rate is:" + payRate;
	
	}
	
	public double pay() {
		return 0;
	}
}
class Executive extends Employee{
	private double bonus;
	
	Executive(String exname, String exaddress, String exphone, String soSecurityNumber, double rate){
	super(exname, exaddress,   exphone, soSecurityNumber,rate);	
	}
	
	public double awardBonus(double exbonus) {
		bonus=exbonus;
		return bonus;
	}
	
	public double pay() {
		return payRate;
	}
}

class Hourly extends Employee{
	private int hoursWorked;
	
	Hourly(String ename, String eaddress,String ephone,String soSecurityNumber,double rate){
		super(ename,    eaddress,    ephone,  soSecurityNumber,rate);
	}
	public void addHours(int moreHours) {
		hoursWorked +=moreHours; 
	}
	
	public double pay() {
		return hoursWorked*payRate;
	}
	public String toString() {
		return super.toString();
		
	}
}
class Commission extends Hourly{
	double totalSales=0;
	double commissionRate;
	
	Commission(String ename,  String eaddress, String ephone, String soSecurityNumber, double rate, double coRate){
		super(ename,    eaddress,     ephone,    soSecurityNumber,rate);
		commissionRate=coRate;
	}
	
	public void addsales(double totalSales) {
		totalSales +=totalSales;
	}
	
	public double pay() {
		return     super.pay()      +totalSales*commissionRate;
	}
}
public class Firm {

	public static void main(String[] args) {
		Staff s=new Staff();
		
		s.payday();
		

	}

}
