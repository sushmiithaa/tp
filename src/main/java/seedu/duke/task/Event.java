package seedu.duke.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {

    protected LocalDateTime from;
    protected LocalDateTime to;

    public Event(String description, LocalDateTime from, LocalDateTime to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    public LocalDateTime getFrom(){
        return from;
    }

    public LocalDateTime getTo(){
        return to;
    }

    public String toString() {
        DateTimeFormatter displayFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return super.toString() + " (from: " + from.format(displayFormatter) + " to: " + to.format(displayFormatter) + ")";
    }

    @Override
    public String toFileFormat() {
        DateTimeFormatter storageFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
        return String.format("E | %d | %s | %s | %s", (isDone ? 1 : 0), description, from.format(storageFormatter), to.format(storageFormatter));
    }
}
