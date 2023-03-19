package model;

public class Mentor extends User {
    protected double experience;
    protected double salaryForLesson;

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public double getSalaryForLesson() {
        return salaryForLesson;
    }

    public void setSalaryForLesson(double salaryForLesson) {
        this.salaryForLesson = salaryForLesson;
    }

    @Override
    public String
    toString() {
        return "Mentor{" +
                "experience=" + experience +
                ", salaryForLesson=" + salaryForLesson +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
