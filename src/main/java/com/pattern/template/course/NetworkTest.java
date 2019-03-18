package com.pattern.template.course;

public class NetworkTest {

    public static void main(String[] args) {

        NetworkCourse javaCourse = new JavaCourse();
        javaCourse.createCourse();

        NetworkCourse bigDataCourse = new BigDataCourse(true);
        bigDataCourse.createCourse();
    }

}
