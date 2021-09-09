package ua.gudz.hw7.task2;

public class Aspirant extends Student {
    public String sciWork;

    public Aspirant(String firstName, String lastName, String group, double averageMark, String sciWork) {
        super(firstName, lastName, group, averageMark);
        this.sciWork = sciWork;
    }

    @Override
    public int getScholarship() {
        return super.getScholarship() + 100;
    }
}




