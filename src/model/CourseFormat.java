package model;

import enums.Format;

public class CourseFormat extends  BaseEntity{
    protected Format format;
    protected boolean isOnline;
    protected int durationInWeek;
    protected int lessonDuration;
    protected int lessonCountPerWeek;

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public int getDurationInWeek() {
        return durationInWeek;
    }

    public void setDurationInWeek(int durationInWeek) {
        this.durationInWeek = durationInWeek;
    }

    public int getLessonDuration() {
        return lessonDuration;
    }

    public void setLessonDuration(int lessonDuration) {
        this.lessonDuration = lessonDuration;
    }

    public int getLessonCountPerWeek() {
        return lessonCountPerWeek;
    }

    public void setLessonCountPerWeek(int lessonCountPerWeek) {
        this.lessonCountPerWeek = lessonCountPerWeek;
    }

    @Override
    public String toString() {
        return "CourseFormat{" +
                "format='" + format + '\'' +
                ", isOnline=" + isOnline +
                ", durationInWeek=" + durationInWeek +
                ", lessonDuration=" + lessonDuration +
                ", lessonCountPerWeek=" + lessonCountPerWeek +
                ", id=" + id +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
