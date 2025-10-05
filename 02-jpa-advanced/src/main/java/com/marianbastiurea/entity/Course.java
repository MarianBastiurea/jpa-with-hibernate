package com.marianbastiurea.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
// daca numele tabelului este diferit de numele clasei
//@Table(name="altceva")

//daca vreau sa rulez o interogare specifica
//@NamedQueries(value = {
//		@NamedQuery(name = "query_get_all_courses",
//				query = "Select  c  From Course c"),
//		@NamedQuery(name = "query_get_all_courses_join_fetch",
//		query = "Select  c  From Course c JOIN FETCH c.students s"),
//		@NamedQuery(name = "query_get_100_Step_courses",
//		query = "Select  c  From Course c where name like '%100 Steps'") })

public class Course {

    @Id
    @GeneratedValue
    private Long id;

    //daca numele coloanei din tabel este diferit de numele parametrului din clasa
    //@Column(name="altceva")
    private String name;

    @OneToMany(mappedBy = "course")
    private List<Review> reviews=new ArrayList<>();

    @ManyToMany(mappedBy = "courses")
    private  List<Student> students= new ArrayList<>();



// cand am nevoie de data creearii si a ultimei modificari
    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp
    private LocalDate createdDate;


    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format(
                "Course[%s] ", name);

    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review){
        this.reviews.add(review);
    }

    public  void removeReview(Review review){
        this.reviews.remove(review);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }
}
