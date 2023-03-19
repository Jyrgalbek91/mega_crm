package model;

public class Course extends BaseEntity{
    protected String name;
    protected double price;
    protected CourseFormat courseFormat;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CourseFormat getCourseFormat() {
        return courseFormat;
    }

    public void setCourseFormat(CourseFormat courseFormat) {
        this.courseFormat = courseFormat;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", courseFormat=" + courseFormat +
                ", id=" + id +
                ", dateCreated=" + dateCreated +
                '}';
    }
}


