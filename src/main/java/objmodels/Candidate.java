/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objmodels;

/**
 *
 * @author Eagle
 */
public class Candidate {
    public String name, position, company, year, salary, location;
    public String job_level, gender, src_link;
    public String referral;

    public String getReferral() {
        return referral;
    }

    public void setReferral(String val) {
        this.referral = val;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSrc_link() {
        return src_link;
    }

    public void setSrc_link(String src_link) {
        this.src_link = src_link;
    }

    public Candidate() {
    }

    public Candidate(String name, String position, String company, String year, String salary, String location, String src_link) {
        this.name = name;
        this.position = position;
        this.company = company;
        this.year = year;
        this.salary = salary;
        this.location = location;
        this.src_link = src_link;
    }

    @Override
    public String toString() {
        return "Candidate{" + "name=" + name + ", position=" + position + ", company=" + company + ", year=" + year + ", salary=" + salary + ", location=" + location + ", src_link=" + src_link + '}';
    }

}
