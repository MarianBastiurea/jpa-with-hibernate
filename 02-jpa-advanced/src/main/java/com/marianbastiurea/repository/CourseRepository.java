package com.marianbastiurea.repository;

import com.marianbastiurea.entity.Course;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager entityManager;

    public Course findById(Long id){
        return entityManager.find(Course.class, id);
    }

    public  void deleteById(Long id){
        Course course=findById(id);
        entityManager.remove(course);
    }

    public Course save(Course course){
        if (course.getId()==null){
            entityManager.persist(course);
        } else{
            entityManager.merge(course);
        }
        return course;
    }

    public void playWithEntityManager(){
        Course course1=new Course("Wine");
        entityManager.persist(course1);
        Course course2=new Course("Cognac");
        entityManager.persist(course2);
        //trimite catre baza de date comanda acum, nu la sfarsitul metodei
        entityManager.flush();

        //blocheaza trimiterea update course2 catre baza de date
        entityManager.detach(course2);
        course2.setName("Beer");
        entityManager.flush();

        //elimina orice modificare a bazei de date si se intoarce la valoarea initiala
        entityManager.refresh(course1);

    }
}
