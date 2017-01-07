import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
/**
 * This class represents an appointment scheduler
 * @author Matthew Fishman
 * @date 1/28/2015
 */
public class AppointmentCollection {
	private ArrayList<Appointment> myList = new ArrayList<Appointment>();//makes a list of appointments
	/**
	 * This method adds an Appointment instance to this collection. It will not
	 * allow a duplicate of another Appointment to be added, as determined by
	 * compareTo. Furthermore, no two Appointments can be added with the same
	 * time, or can there be any overlap between Appointments. (e.g. No
	 * Appointment may be added between the start time and end time of another
	 * Appointment)
	 * 
	 * @param appt
	 *            The appointment to add to this collection.
	 * 
	 * @return true of the Appointment was successfully added, or false if not
	 *         (e.g. there was a duplicate).
	 */
	public boolean addAppt(Appointment appt){
		//interates through the list of appointments checking for duplicates
		for (Appointment appointment : myList){
			if(appointment.compareTo(appt) == 0){ //if duplicate is found it will return false and not add the appointment
				return false;
			}
		}
		myList.add(appt);//if the appointment is not a duplicate add it to the list
		return true;
	}

	/**
	 * This method removes a Appointment instance from this collection. The
	 * given Appointment instance must be identical to another Appointment
	 * instance in this collection, as determined by compareTo. If the method
	 * determines that there is a Appointment in the collection that matches the
	 * given Appointment, it will be removed and the method will return true.
	 * Otherwise, it will do nothing to the collection and return false.
	 * 
	 * @param toRemove
	 *            An instance identical to an Appointment to remove from this
	 *            collection.
	 * 
	 * @return true if the Appointment was removed, false if not.
	 */
	public boolean removeAppt(Appointment toRemove){
		//interates through the list of appointments if it finds two appointments that are the same it removes one
		for (int i = 0; i< myList.size(); i++){
			if (myList.get(i).compareTo(toRemove) == 0){//checks if appointment matches another appointments
				myList.remove(i);//removes appointment
				return true;
			}
		}
		return false;
	}

	/**
	 * This method gets a List of uncompleted Appointments with approaching
	 * times and puts them in chronological order. It should ignore Appointments
	 * that have been completed and Appointments with deadlines that have
	 * passed. (An Appointment whose time plus duration has passed)
	 * 
	 * @return A sorted List of pending Appointments from this collection, in
	 *         chronological order.
	 */
	public List<Appointment> getPendingAppts(){
		List<Appointment> pendingList = new ArrayList<Appointment>();//new list for pending appointments
		
		/**iterates through the list of appointments and checks if they are
		 *not complete and that the date of the appointment has not past. 
		 */
		for (Appointment appointment : myList){
			if(appointment.isCompleted() == false){
				if(appointment.getTime().getTimeInMillis() > System.currentTimeMillis()){
					pendingList.add(appointment); //adds the pending appointments to a new list
				}
			}
		}
		//Sorts the new list of pending appointments
		Collections.sort(pendingList);
		return pendingList;
	}

	/**
	 * This method gets a List of completed Appointments and puts them in
	 * chronological order.
	 * 
	 * @return A sorted List of completed Appointments from this collection, in
	 *         chronological order.
	 */
	public List<Appointment> getCompletedAppts(){
		List<Appointment> completedList = new ArrayList<Appointment>(); //new list for completed appointments
		
		/**iterates through the list of appointments and checks if they 
		 *are completed
		 */
		for (Appointment appointment : myList){
			if(appointment.isCompleted() == true){
				completedList.add(appointment); //adds the completed appointments to a new list
			}
		}
		//sorts the new list of completed appointments
		Collections.sort(completedList);
		return completedList;
	}

	/**
	 * This method returns a sorted list of Appointments that have not been
	 * completed and whose deadlines have passed.
	 * 
	 * 
	 * @return A sorted List of past-due Appointments from this collection, in
	 *         chronological order.
	 */
	public List<Appointment> getPastDueAppts(){
		
		List<Appointment> pastDueList = new ArrayList<Appointment>(); //new list for past due appointments
		
		/**iterates through the list of appointments and checks if to see if the time of 
		 *the appoinment has past and that the appointment is not completed
		 */ 
		for (Appointment appointment : myList){
			if(appointment.getTime().getTimeInMillis() < System.currentTimeMillis())
				if(appointment.isCompleted() == false){
				pastDueList.add(appointment);//adds the completed appointments to a new list
			}
		}
		Collections.sort(pastDueList);//sorts the new list of past due appointments
		return pastDueList;
	}
	
	/**
	*This method iterates through the list of Appointments and prints them out one by one. 
	*
	*/
	public void printList(){
		for(Appointment appointment : myList){
			System.out.println(appointment.toString());
		}
	}
}
