package com.teamtreehouse.courses.model;

import com.teamtreehouse.courses.model.CourseIdea;
import com.teamtreehouse.courses.model.CourseIdeaDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CalvinZhang on 2017-02-02.
 */
public class SimpleCourseIdeaDAO implements CourseIdeaDAO {
    private List<CourseIdea> ideas;

    public SimpleCourseIdeaDAO(){
        ideas = new ArrayList<>();
    }

    @Override
    public boolean add(CourseIdea idea) {
        return ideas.add(idea);
    }

    @Override
    public List<CourseIdea> findAll() {
        return new ArrayList<>(ideas);
    }

    @Override
    public CourseIdea findBySlug(String slug)  {
        return ideas.stream()
                .filter(idea -> idea.getSlug().equals(slug))
                        .findFirst()
                        .orElseThrow(NotFoundException::new);

    }
}
