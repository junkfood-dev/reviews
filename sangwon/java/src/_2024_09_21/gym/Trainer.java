package _2024_09_21.gym;

public class Trainer {
    String name;
    String specialty;
    String personalHistory;

    Trainer(String name, String specialty, String personalHistory){
        this.name = name;
        this.specialty = specialty;
        this.personalHistory = personalHistory;
    }

    public void printTrainer() {
        System.out.println("트레이너: " + getName());
        System.out.println("전문분야: " + getSpecialty());
        System.out.println("경력: \t" + getPersonalHistory());
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public String getPersonalHistory() {
        return personalHistory;
    }

    @Override
    public String toString() {
        return String.valueOf(name);
    }
}