import java.util.Calendar;
/**
 * This class represents data for an appointment and implements it
 * @author Matthew Fishman
 * @date 1/28/2015
 */
public class Appointment implements Comparable<Appointment> {

	//Instance Variables
	private Calendar time; 
	private int duration;
	private String description;
	private boolean isCompleted;
	
	/**
	 * This is the Appointment constructor. 
	 * 
	 * @param time
	 *            When this appointment will take place
	 * 
	 * @param duration
	 *            The length of the given task, in minutes.
	 * 
	 * @param description
	 *            A long description of the scheduled appointment.
	 * 
	 * @param isCompleted
	 *            True if this task is completed, otherwise false.
	 */

	public Appointment(Calendar time, int duration, String description,
			boolean isCompleted) {

		this.time = time;   
		this.duration = duration;
		this.description = description;
		this.isCompleted = isCompleted;
	}

	/**
	 * Get this Appointment's description.
	 * 
	 * @return The description of this class
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Get the time of this Appointment
	 * 
	 * @return The time this task is scheduled for.
	 */
	public Calendar getTime() {
		return time;
	}

	/**
	 * Get the duration of this Appointment
	 * 
	 * @return The length of time this task is scheduled for.
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * Has this appointment been completed?
	 * 
	 * @return true if the Appointment is completed, false otherwise.
	 */
	public boolean isCompleted() {
		return isCompleted;
	}

	/**
	 * This method sets the completion status of an Appointment
	 * 
	 * @param toSet
	 *            The completion status to assign to this Appointment
	 */
	public void setCompleted(boolean toSet) {
		toSet = isCompleted;
	}

	/**
	 * Compare one Appointment to another. Appointment t1 is "greater than"
	 * Appointment t2 if t1's scheduled time is sooner. If they are at the same
	 * time, t1 is > t2 if t1's duration is longer. If the duration is the same,
	 * return the compareTo value for their respective descriptions. Also, t1
	 * "equals" t2 if they have the same time, duration and description.
	 * 
	 * @param apptToCompare
	 *            The instance to compare this Appointment to.
	 * @return A positive integer if this appointment is "greater than"
	 *         apptToCompare; zero if this is "equal to" apptToCompare; a
	 *         negative integer if this is "less than" apptToCompare.
	 */
	public int compareTo(Appointment apptToCompare) {
		if (this.time.compareTo(apptToCompare.getTime()) == 0){//checks if appointments are at the same time
			if (this.duration == apptToCompare.getDuration()){//checks if the appointments will take the same time
				return 0;
			}
			else if (this.duration > apptToCompare.getDuration()){//
				return -1;
			}
			else
				return 1;
		}
		return  this.time.compareTo(apptToCompare.getTime());
	}

	/**
	 * The toString method should return a representation of an Appointment as a
	 * String in the following format: Time of Appointment: <time> Duration:
	 * <duration> Completed? <isCompleted> Description: <description>
	 * 
	 * 
	 * @return A string representation of an Appointment
	 */
	public String toString() {
         return "Time of Appointment:" + this.time.getTime() + "\n" + "Duration: " + this.duration + "\n" + "Completed? " +  this.isCompleted + "\n" + "Description: " + this.description + "\n";
	}
}
