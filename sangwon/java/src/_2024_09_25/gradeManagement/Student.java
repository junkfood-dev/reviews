package _2024_09_25.gradeManagement;

public class Student {
    private String name;
    private int koreanLanguage;
    private int mathematics;
    private int english;

    public Student(String name, int koreanLanguage, int mathematics, int english) {
        this.name = name;
        this.koreanLanguage = koreanLanguage;
        this.mathematics = mathematics;
        this.english = english;
    }

    public String getName() {
        return name;
    }

    public int getKoreanLanguage() {
        return koreanLanguage;
    }

    public int getMathematics() {
        return mathematics;
    }

    public int getEnglish() {
        return english;
    }

    public double getAverage() {
        return (double) (koreanLanguage + mathematics + english) / 3;
    }
}
