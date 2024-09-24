// Class imports
import java.time.LocalDateTime;

public class Meeting extends Event implements Completable {

    // Attributes
    LocalDateTime endDateTime;
    String location;

    // Accessors
    LocalDateTime getEndTime() {

        return endDateTime;

    }
    int getDuration() {

        return 0;

    }
    String getLocation() {

        return location;

    }

    // Mutators
    void setEndTime(LocalDateTime endDateTime) {

        this.endDateTime = endDateTime;

    }
    void setLocation(String location) {

        this.location = location;

    }

    // Completable implementation
    public void complete() {



    }
    public boolean isComplete() {

        return false;

    }

}
