package com.vicoga.springcloud.mcsv.course.models.entity;

import com.vicoga.springcloud.mcsv.course.models.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "course_id")
    private List<CourseUser> courseUsers;
    @Transient
    private List<User> users;

    public Course() {
        courseUsers= new ArrayList<>();
        users= new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCourseUser(CourseUser courseUser){
        this.courseUsers.add(courseUser);
    }
    public void deleteCourseUser(CourseUser courseUser){
        this.courseUsers.remove(courseUser);
    }
    public List<CourseUser> getCourseUsers() {
        return courseUsers;
    }

    public void setCourseUsers(List<CourseUser> courseUsers) {
        this.courseUsers = courseUsers;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
