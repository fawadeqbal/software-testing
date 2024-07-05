package com.se.tests.smoke;

import com.se.config.Constants;
import com.se.rolesbase.StudentLoginBase;
import org.testng.Assert;
import org.testng.annotations.Test;


import static com.se.utils.UtilsSet.*;

public class LectureTest extends StudentLoginBase
{
    @Test
    public void verifyLecturePerformance() throws InterruptedException {
        clickOnElement(Constants.Lecture.By_learn_btn);
        Thread.sleep(2000 );
        clickOnElement(Constants.Lecture.By_course_btn);
        Thread.sleep(2000 );
        clickOnElement(Constants.Lecture.By_lectures_btn);
        Thread.sleep(2000 );
        clickOnElement(Constants.Lecture.By_lecture_introduction_btn);
        Thread.sleep(2000 );
        clickOnElement(Constants.Lecture.By_lecture_performance_btn);
        Thread.sleep(2000 );
        String regNo= getElementText(Constants.Lecture.By_lecture_top_student_reg_no);
        Assert.assertEquals(regNo,"FA21-BSE-012");
    }

    @Test
    public void verifyLectureTaskStatus() throws InterruptedException {
        clickOnElement(Constants.Lecture.By_learn_btn);
        Thread.sleep(2000 );
        clickOnElement(Constants.Lecture.By_course_btn);
        Thread.sleep(2000 );
        clickOnElement(Constants.Lecture.By_lectures_btn);
        Thread.sleep(2000 );
        clickOnElement(Constants.Lecture.By_lecture_introduction_btn);
        Thread.sleep(2000 );
        clickOnElement(Constants.Lecture.By_lecture_task_btn);
        Thread.sleep(2000 );
        clickOnElement(Constants.Lecture.By_lecture_task_title_lbl);
        Thread.sleep(2000 );
        String taskTitle=getElementText(Constants.Lecture.By_lecture_task_title_lbl);
        Assert.assertEquals(taskTitle,"Writing Basic Test Cases");
    }

}
