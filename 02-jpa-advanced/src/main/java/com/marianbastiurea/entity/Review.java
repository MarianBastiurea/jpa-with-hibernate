package com.marianbastiurea.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private ReviewRating rating;

    @ManyToOne
    Course course;

    public Review() {
    }

    public Review(String description, ReviewRating rating) {
        this.description = description;
        this.rating = rating;
    }

    public ReviewRating getRating() {
        return rating;
    }

    public void setRating(ReviewRating rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format(
                "Review[%s] ", description);

    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
