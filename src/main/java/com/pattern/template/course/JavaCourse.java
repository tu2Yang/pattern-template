package com.pattern.template.course;

public class JavaCourse extends NetworkCourse {

    @Override
    protected boolean needHomework() {
        return false;
    }

    @Override
    public void checkHomework() {
        System.out.println("检查java作业");
    }

}
