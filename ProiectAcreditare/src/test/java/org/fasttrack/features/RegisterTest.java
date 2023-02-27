package org.fasttrack.features;

import net.bytebuddy.utility.RandomString;
import org.fasttrack.BaseTest.BaseTest;
import org.fasttrack.utils.EnvConstants;
import org.junit.Test;

public class RegisterTest extends BaseTest {

    RandomString randomString = new RandomString();

    String  random = randomString.nextString();

    @Test
    public void registerWithValidCredentials(){
        registerSteps.setValidCredentials("romi.pana"+ random + "@yahoo.com", EnvConstants.USER_PASS);
        registerSteps.clickRegisterButton();
        registerSteps.registerConfirmation("romi.pana" + random);
    }

    @Test
    public void registerWithAnExistentEmailAddress(){
        registerSteps.setValidCredentials(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        registerSteps.clickRegisterButton();
        registerSteps.registerError();
    }

    @Test
    public void registerWithInvalidEmailAddress(){
        registerSteps.setEmailAddress(EnvConstants.USER_ALREADY_REGISTER);
        registerSteps.setPassword(EnvConstants.USER_PASS);
        registerSteps.clickRegisterButton();
        registerSteps.invalidEmailErrorIsDisplayed();
    }
}
