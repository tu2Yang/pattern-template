package com.pattern.template.course;

public class BigDataCourse extends NetworkCourse {

    private boolean needHomeworkFlag;

    public BigDataCourse(boolean needHomeworkFlag) {
        this.needHomeworkFlag = needHomeworkFlag;
    }

    @Override
    protected boolean needHomework() {
        return this.needHomeworkFlag;
    }

    @Override
    public void checkHomework() {
        System.out.println("检查大数据作业");
    }

}
