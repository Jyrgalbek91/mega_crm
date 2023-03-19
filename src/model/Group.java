package model;

import java.time.LocalTime;

public class Group extends BaseEntity{
    protected String name;
    protected String room;
    protected LocalTime startTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                ", room='" + room + '\'' +
                ", startTime=" + startTime +
                ", id=" + id +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
