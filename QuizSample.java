package e.saloni.task2;

public class QuizSample {

    private String name;
    private int marks;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getMarks(){
        return marks;
    }

    public void setMarks(int marks){
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "QuizSample{" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}
