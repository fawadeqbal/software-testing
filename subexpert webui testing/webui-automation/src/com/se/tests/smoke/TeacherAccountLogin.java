package com.se.tests.smoke;

import com.se.rolesbase.TeacherLoginBase;
import org.testng.annotations.Test;

public class TeacherAccountLogin extends TeacherLoginBase {

    @Test
    public void verifyTeacherIsLoggedIn(){
        System.out.println("Teacher is Logged In Successfully.");
    }
}
