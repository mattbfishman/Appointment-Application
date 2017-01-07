import java.util.Calendar;
import java.util.List;
/**
 * This class represents a test class for the Appointments class and AppointmentCollection class
 * @author Matthew Fishman
 * @date 1/28/2015
 */
public class TestAppointment{

	public static void main(String[] args){
		/** 
		 * Creates the date and time of the appointments
		 */
		Calendar appt2 = Calendar.getInstance();
		appt2.set(2015,10,20,12,10);
		Calendar appt3 = Calendar.getInstance();
		appt3.set(2014,5,12,4,5);
		Calendar appt4 = Calendar.getInstance();
		appt4.set(2013,5,3,2,1);
		Calendar appt5 = Calendar.getInstance();
		appt5.set(2015,9,2,3,60);
		
		/** Creates the new appointments with parameters such as Time/Date, Duration, The Description of the appointment,
		 *  and whether or not the appointment is completed.
		 */
		Appointment t1 = new Appointment(Calendar.getInstance(),10,"Meeting",false);
		Appointment t2 = new Appointment(appt2, 12, "Birthday", false); 
		Appointment t3 = new Appointment(appt3, 5, "Work", true);
		Appointment t4 = new Appointment(appt4, 50, "Program", false);
		Appointment t5 = new Appointment(appt5, 3, "Daycare", false);
		Appointment t6 = new Appointment(Calendar.getInstance(),10, "Copy Meeting", false);//copy of the date and time as the first appointment to check addAppt() method
		
		//Test for printing out an appointment
		//System.out.println(t1.toString());
		//System.out.println(t2.toString());
		
		//Test for comparing two appointments 
		//System.out.println(t1.compareTo(t2));
		//System.out.println(t1.compareTo(t3));

		//Test list for appointment collection
		AppointmentCollection testApptCol = new AppointmentCollection();
		
		//adding the appointments to the test list for appointment collection made above
		testApptCol.addAppt(t1);
		testApptCol.addAppt(t2);
		testApptCol.addAppt(t3);
		testApptCol.addAppt(t4);
		testApptCol.addAppt(t5);
		testApptCol.addAppt(t6);//will be removed since the time is same as t1
		
		testApptCol.printList();//prints the list with the added appointments
		
		//testApptCol.removeAppt(t3);//tests the removeAppt() method in appointment collection
		//testApptCol.printList();//reprints the list to check if the appointment was removed


		System.out.println("----------------------------------------------------)" + "\n" + "Pending Appointments:" + "\n");
		
		/** Makes a new list by taking the list of appointment and running them through the 
		 *	getPendingAppts() method in the AppointmentCollection class. 
		 */
		List<Appointment> pendingAppts = testApptCol.getPendingAppts();//make new list
		// iterates through the list of pending appointments and prints them one by one
		for (Appointment appt : pendingAppts){
			System.out.println(appt.toString());//prints the appointment setting them to a string
		}
		
		System.out.println("----------------------------------------------------)" + "\n" + "Completed Appointments:" + "\n");
		
		/** Makes a new list by taking the list of appointment and running them through the 
		 *	completedAppts() method in the AppointmentCollection class. 
		 */
		List<Appointment> completedAppts = testApptCol.getCompletedAppts();
		// iterates through the list of completed appointments and prints them one by one
		for (Appointment appt : completedAppts){
			System.out.println(appt.toString());//prints the appointment setting them to a string
		}	
		
		System.out.println("----------------------------------------------------)" + "\n" + "Past Due Appointments:" + "\n");
		
		/** Makes a new list by taking the list of appointment and running them through the 
		 *	pastDueAppts() method in the AppointmentCollection class. 
		 */
		List<Appointment> pastDueAppts = testApptCol.getPastDueAppts();
		// iterates through the list of past due appointments and prints them one by one
		for (Appointment appt : pastDueAppts){
			System.out.println(appt.toString());//prints the appointment setting them to a string
		}
	}	
}