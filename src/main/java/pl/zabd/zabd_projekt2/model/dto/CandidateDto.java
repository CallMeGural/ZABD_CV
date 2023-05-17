package pl.zabd.zabd_projekt2.model.dto;

import pl.zabd.zabd_projekt2.model.Skill;

import java.util.ArrayList;
import java.util.List;


public class CandidateDto {
    private String name;
    private String surname;
    private String phoneNumber;
    private boolean isStudent;
    private List<String> skills;

    public CandidateDto() {
        this.skills = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean getIsStudent() {
        return isStudent;
    }

    public void setIsStudent(boolean student) {
        isStudent = student;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "CandidateDto{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", isStudent=" + isStudent +
                ", skills=" + skills +
                '}';
    }
}
