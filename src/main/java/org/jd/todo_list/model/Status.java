package org.jd.todo_list.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Comparator;

@AllArgsConstructor
@Getter
public enum Status implements Comparator<Status> {
    STUCK(-1), COMPLETE(2),
    IN_PROGRESS(1),
    NOT_STARTED(0);

    private int value;

    Status(int value) {
        this.value = value;
    }

    public static Status getStatusByValue(int value){
        for (Status status : Status.values()){
            if (status.get() == value)
                return status;
        }
        return Status.NOT_STARTED;
    }

    @Override
    public int compare(Status o1, Status o2) {
        return o1.get() - o2.get();
    }

    public int get() {
        return value;
    }

}
