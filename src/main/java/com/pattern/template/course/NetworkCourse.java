package com.pattern.template.course;

public abstract class NetworkCourse {

    protected final void createCourse() {

        this.postPreResuource();

        this.createPPT();

        this.liveVideo();

        this.postNote();

        this.postSource();

        if(needHomework()) {
            checkHomework();
        }

    }

    final void postPreResuource() {
        System.out.println("预习资料");
    }

    final void createPPT() {
        System.out.println("备课PPT");
    }

    final void liveVideo() {
        System.out.println("直播");
    }

    final void postNote() {
        System.out.println("提交课件");
    }

    final void postSource() {
        System.out.println("提交源码");
    }

    // 留给用户微调的方法
    protected boolean needHomework() {
        return false;
    }

    public abstract void checkHomework();

}
