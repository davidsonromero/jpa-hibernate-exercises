package model.inheritance.singleTable;

import javax.persistence.*;

@Entity
@DiscriminatorValue("SS")
public class ScholarshipStudent extends Student{
    private double scholarshipAmount;

     public ScholarshipStudent(long registrationNumber, String name, double scholarshipAmount) {
         super(registrationNumber, name);
         this.scholarshipAmount = scholarshipAmount;
     }

    public double getScholarshipAmount() {
        return scholarshipAmount;
    }

    public void setScholarshipAmount(double scholarshipAmount) {
        this.scholarshipAmount = scholarshipAmount;
    }
}
