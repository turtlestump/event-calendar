// Class imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EventListPanel extends JPanel {

    // Create a list of the events that will be displayed.
    ArrayList<Event> events = new ArrayList<>();

    // Create GUI elements for the event list.
    JPanel controlPanel = new JPanel();
    JPanel displayPanel = new JPanel();
    JCheckBox filterDisplay = new JCheckBox();
    JButton addEventButton = new JButton("Add Event");

    // Constructor
    EventListPanel() {

        // Create layout for JFrame
        setLayout(new BorderLayout());

        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.yellow);
        displayPanel.setPreferredSize(new Dimension(400, 200));
        controlPanel.setPreferredSize(new Dimension(400, 200));

        // Create sortDropDrown
        String[] sortBy = { "Name (A-Z)", "Name (Z-A)", "Date (Earliest)", " Date (Latest)" };
        JComboBox<String> sortDropDown = new JComboBox(sortBy);
        sortDropDown.addActionListener(e -> sort(sortDropDown.getSelectedItem().toString()));
        controlPanel.add(new JLabel("Sort by: "));
        controlPanel.add(sortDropDown);

        // Add the addEvent button.
        addEventButton.addActionListener(e -> addEventModal());
        controlPanel.add(addEventButton);

    }

    // Method to add events to the ArrayList
    void addEvent(Event e) {

        events.add(e);

    }

    // Method to sort events
    void sort(String sortBy) {

        if (sortBy.equals("Name (A-Z)")) {

            Collections.sort(events);

        }
        else if (sortBy.equals("Name (Z-A)")) {

            Collections.sort(events, Collections.reverseOrder());

        }
        else if (sortBy.equals("Date (Earliest)")) {

            Collections.sort(events, Comparator.comparing(Event::getDateTime));

        }
        else if (sortBy.equals("Date (Latest)")) {

            Collections.sort(events, Collections.reverseOrder(Comparator.comparing(Event::getDateTime)));

        }

    }

    // Method to open the add event modal.
    void addEventModal() {

        AddEventModal window = new AddEventModal(this);
        window.setVisible(true);

    }

}
