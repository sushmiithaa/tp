package seedu.duke.calender;

import seedu.duke.task.Deadline;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Calendar {
    private TreeMap<LocalDate, List<Deadline>> schedule;

    public Calendar() {
        this.schedule = new TreeMap<>();
    }

    public void registerDeadline(Deadline deadline) {
        LocalDate date = deadline.getBy().toLocalDate();
        schedule.computeIfAbsent(date, k -> new ArrayList<>()).add(deadline);
    }

    public void clear() {
        schedule.clear();
    }

    public void displayRange(LocalDate start, LocalDate end) {
        var view = schedule.subMap(start, true, end, true);
        if (view.isEmpty()) {
            System.out.println("No deadlines found in this range.");
            return;
        }

        for (var entry : view.entrySet()) {
            System.out.println("--- " + entry.getKey() + " ---");
            for (Deadline d : entry.getValue()) {
                System.out.println(d);
            }
        }

    }
}