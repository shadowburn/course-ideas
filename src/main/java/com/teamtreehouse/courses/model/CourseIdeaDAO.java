package com.teamtreehouse.courses.model;

import com.teamtreehouse.courses.model.CourseIdea;

import java.util.List;

/**
 * Created by CalvinZhang on 2017-02-02.
 */
public interface CourseIdeaDAO {
    boolean add(CourseIdea idea);

    List<CourseIdea> findAll();

    CourseIdea findBySlug(String slug);
}
