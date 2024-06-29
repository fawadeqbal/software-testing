package com.se.tests.smoke;

import com.se.config.Constants;
import com.se.config.LoginParameters;
import com.se.rolesbase.StudentLoginBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.se.utils.UtilsSet.*;

public class StudentAccountTest extends StudentLoginBase {


    @Test
    public void verifyStudentIsLoggedIn(){

        System.out.println("A Student is now logged in");
    }

    @Test
    public void verifyStudentRoleAfterLogin(){
//        clickOnElement(Constants.Dashboard.By_skip_now);
        String role=getElementText(Constants.Dashboard.By_role);
        Assert.assertEquals(role,this._loginParameters.getRole().getRoleName());
    }

    @Test
    public void verifyStudentNumberOfCoursesAfterLogin(){
//        clickOnElement(Constants.Dashboard.By_skip_now);
        int noOfCourses=Integer.parseInt(getElementText(Constants.Dashboard.By_Student_Number_of_courses));
        Assert.assertEquals(noOfCourses,14);
    }

}
