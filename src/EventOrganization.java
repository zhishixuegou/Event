import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.ArrayList;  
import java.util.Date;  
import java.util.Scanner;  
  
public class EventOrganization {  
    public static void main(String[] args) {  
        try (Scanner scanner = new Scanner(System.in)) {
            Event event = new Event();  
  
            System.out.print("Enter the event ID: ");  
            event.setEventID(scanner.nextLine());  
  
            System.out.print("Enter the event name: ");  
            event.setEventName(scanner.nextLine());  
  
            System.out.print("Enter the event venue: ");  
            event.setEventVenue(scanner.nextLine());  
  
            System.out.print("Enter the event date (YYYY-MM-DD): ");  
            String dateString = scanner.nextLine();  
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
            try {  
                event.setEventDate(sdf.parse(dateString));  
            } catch (ParseException e) {  
                System.out.println("Invalid date format. Please use YYYY-MM-DD.");  
                return;  
            }  
  
            System.out.println("Enter the names of the attendees (enter 'done' to finish):");  
            while (true) {  
                String name = scanner.nextLine();  
                if (name.equalsIgnoreCase("done")) {  
                    break;  
                }  
                event.addEventAttendee(name);  
            }  
  
            event.organizeEvent();
        }  
    }  
}  
  
class Event {  
    private String eventID;  
    private String eventName;  
    private String eventVenue;  
    private Date eventDate;  
    private ArrayList<String> eventAttendees;  
  
    public Event() {  
        this.eventAttendees = new ArrayList<>();  
    }  
  
    public void setEventID(String eventID) {  
        this.eventID = eventID;  
    }  
  
    public void setEventName(String eventName) {  
        this.eventName = eventName;  
    }  
  
    public void setEventVenue(String eventVenue) {  
        this.eventVenue = eventVenue;  
    }  
  
    public void setEventDate(Date eventDate) {  
        this.eventDate = eventDate;  
    }  
  
    public void addEventAttendee(String name) {  
        eventAttendees.add(name);  
    }  
  
    public void organizeEvent() {  
        System.out.println("Event Details:");  
        System.out.println("Event ID: " + eventID);  
        System.out.println("Event Name: " + eventName);  
        System.out.println("Event Venue: " + eventVenue);  
        System.out.println("Event Date: " + eventDate);  
        System.out.println("Attendees:");  
        for (String attendee : eventAttendees) {  
            System.out.println(attendee);  
        }  
        System.out.println("Total number of attendees: " + eventAttendees.size());  
    }  
  
    @Override  
    public String toString() {  
        return "Event [eventID=" + eventID + ", eventName=" + eventName + ", eventVenue=" + eventVenue  
                + ", eventDate=" + eventDate + ", eventAttendees=" + eventAttendees + "]";  
    }  
}