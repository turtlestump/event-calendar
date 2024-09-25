// Class imports
import javax.swing.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class EventPlanner {

    // Window size variables
    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;

    public static void main(String[] args) {

        // Create JFrame
        JFrame frame = new JFrame("Event Planner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);

        // Create and add EventListPanel.
        EventListPanel eventList = new EventListPanel();
        frame.add(eventList);

        // Add default events.
        addDefaultEvents(eventList.events);

        frame.setVisible(true);

    }

    public static void addDefaultEvents(ArrayList<Event> events) {

        // Add deadline event (Will be due 3 days from runtime)
        Deadline defaultDeadline = new Deadline("Default Deadline", LocalDateTime.now().plusDays(3));
        events.add(defaultDeadline);

        // Add meeting event (Will begin 3 days from runtime and end after 1 hour)
        Meeting defaultMeeting = new Meeting("Default Meeting", LocalDateTime.now().plusDays(3), LocalDateTime.now().plusHours(1), "MCS 339");
        events.add(defaultMeeting);

    }

}
