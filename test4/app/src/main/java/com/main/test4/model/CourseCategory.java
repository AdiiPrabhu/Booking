package com.main.test4.model;


import com.main.test4.adapter.CoursesAdapter;

public class CourseCategory implements CoursesAdapter.CourseAdapterItem {
    private String mName;

    public CourseCategory(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }
}
