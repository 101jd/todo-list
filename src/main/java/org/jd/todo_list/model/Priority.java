package org.jd.todo_list.model;

import lombok.Getter;

import java.util.Comparator;


@Getter
public enum Priority implements Comparator<Priority> {
    HIGH(0), MEDIUM(1), LOW(2);

    Priority(int value) {
        this.value = value;
//        this.name = name;
    }

    private int value;
//    private String name;

    public static Priority getPriorityByValue(int value){
        for (Priority priority : Priority.values()){
            if (priority.get() == value)
                return priority;
        }
        return Priority.LOW;
    }

//    public static Priority getPriorityByName(String name){
//        for (Priority priority : Priority.values()){
//            if (priority.getName().equals(name))
//                return priority;
//        }
//        return Priority.LOW;
//    }

    @Override
    public int compare(Priority o1, Priority o2) {
        return o1.get() - o2.get();
    }

    public int get() {
        return value;
    }

//    public String getName() {
//        return name;
//    }
}
