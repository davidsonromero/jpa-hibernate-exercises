package model.inheritance.singleTable;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "student_type", length = 2, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("ST")
public class Student {
    @Id
    private long registrationNumber;
    @Column
    private String name;

    public Student() {
    }

    public Student(long registrationNumber, String name) {
        this.registrationNumber = registrationNumber;
        this.name = name;
    }

    public long getRegistrationNumber() {
        return registrationNumber;
    }

    public String getName() {
        return name;
    }

    public void setRegistrationNumber(long registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setName(String name) {
        this.name = name;
    }
}
