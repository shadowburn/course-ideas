package com.teamtreehouse.courses.model;


import apple.laf.JRSUIConstants;
import com.github.slugify.Slugify;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by CalvinZhang on 2017-02-02.
 */
public class CourseIdea {
    private String slug;
    private String title;
    private String creater;
    private Set<String> voters;


    public CourseIdea(String title, String creater) {
        voters = new HashSet<>();
        this.title = title;
        this.creater = creater;

        try {
            Slugify slugify = new Slugify();
            slug = slugify.slugify(title);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public String getTitle() {
        return title;
    }

    public String getCreater() {
        return creater;
    }

    public String getSlug() {
        return slug;
    }

    public List<String> getVoters(){
        return new ArrayList<>(voters);
    }

    public boolean addVoter(String voterUserName){
        return voters.add(voterUserName);
    }

    public int getVoteCount(){
        return voters.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseIdea that = (CourseIdea) o;

        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        return creater != null ? creater.equals(that.creater) : that.creater == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (creater != null ? creater.hashCode() : 0);
        return result;
    }
}
