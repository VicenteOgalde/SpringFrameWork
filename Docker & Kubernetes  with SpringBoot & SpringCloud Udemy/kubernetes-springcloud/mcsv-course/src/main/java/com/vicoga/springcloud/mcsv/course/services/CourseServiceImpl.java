package com.vicoga.springcloud.mcsv.course.services;

import com.vicoga.springcloud.mcsv.course.clients.UserClientRest;
import com.vicoga.springcloud.mcsv.course.models.User;
import com.vicoga.springcloud.mcsv.course.models.entity.Course;
import com.vicoga.springcloud.mcsv.course.models.entity.CourseUser;
import com.vicoga.springcloud.mcsv.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository repository;
    @Autowired
    private UserClientRest userClientRest;
    @Transactional(readOnly = true)
    @Override
    public List<Course> findAll() {
        return repository.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public Optional<Course> findById(Long id) {
        return repository.findById(id);
    }
    @Transactional
    @Override
    public Course save(Course course) {
        return repository.save(course);
    }
    @Transactional
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    @Transactional(readOnly = true)
    @Override
    public Optional<Course> findByIdWithUsers(Long id) {
        Optional<Course> optionalCourse= repository.findById(id);
        if (optionalCourse.isPresent()){
            Course course= optionalCourse.get();
            if (!course.getUsers().isEmpty()){
                List<Long> ids=course.getCourseUsers().stream()
                        .map(CourseUser::getUserId)
                        .toList();

                List<User> users= userClientRest.getUsersByCourse(ids);
                course.setUsers(users);
            }
            return Optional.of(course);
        }
        return Optional.empty();
    }

    @Transactional
    @Override
    public Optional<User> assignUser(User user, Long courseId) {

        Optional<Course> optionalCourse= repository.findById(courseId);
        if(optionalCourse.isPresent()){
            User userMcsv= userClientRest.details(user.getId());
            Course course= optionalCourse.get();
            CourseUser courseUser= new CourseUser();
            courseUser.setUserId(userMcsv.getId());
            course.addCourseUser(courseUser);
            repository.save(course);
            return Optional.of(userMcsv);

        }

        return Optional.empty();
    }
    @Transactional
    @Override
    public Optional<User> createUser(User user, Long courseId)
    {
        Optional<Course> optionalCourse= repository.findById(courseId);
        if(optionalCourse.isPresent()){
            User newUserMcsv= userClientRest.create(user);
            Course course= optionalCourse.get();
            CourseUser courseUser= new CourseUser();
            courseUser.setUserId(newUserMcsv.getId());
            course.addCourseUser(courseUser);
            repository.save(course);
            return Optional.of(newUserMcsv);

        }

        return Optional.empty();

    }
    @Transactional
    @Override
    public Optional<User> unAssignUser(User user, Long courseId) {

        Optional<Course> optionalCourse= repository.findById(courseId);
        if(optionalCourse.isPresent()){
            User userMcsv= userClientRest.details(user.getId());
            Course course= optionalCourse.get();
            CourseUser courseUser= new CourseUser();
            courseUser.setUserId(userMcsv.getId());
            course.deleteCourseUser(courseUser);
            repository.save(course);
            return Optional.of(userMcsv);

        }

        return Optional.empty();
    }
}
