package com.se.tests.smoke;

import com.se.config.Constants.*;
import com.se.rolesbase.TeacherLoginBase;
import org.testng.Assert;
import org.testng.annotations.Test;


import static com.se.utils.UtilsSet.*;

public class TeacherAccountTest extends TeacherLoginBase {

    @Test
    public void verifyTeacherIsLoggedIn(){
        System.out.println("Teacher is Logged In Successfully.");
    }

    @Test
    public void checkTeacherRoleAfterLogin(){
        clickOnElement(Dashboard.By_skip_now);
        String role=getElementText(Dashboard.By_role);
        Assert.assertEquals(role,_loginParameters.getRole().getRoleName());
    }

}
