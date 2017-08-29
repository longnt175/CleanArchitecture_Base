package com.sumsign.caterwin.domain.entity;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserEntityTest {

    private static final String FAKE_EMAIL = "email@test.com";

    private UserEntity user;

    @Before
    public void setup() {
        this.user = new UserEntity(FAKE_EMAIL);
    }

    @Test
    public void testUserConstructor() {
        assertThat(this.user.getEmail(), is(FAKE_EMAIL));
    }

    @Test
    public void testUserSetters() {
        this.user.setEmail("another@email.com");
        this.user.setToken("1234TOKEN");
        this.user.setPassword("password");
        this.user.setPasswordConfirmation("conf_password");
        this.user.setNewPassword("new_password");
        this.user.setNewPasswordConfirmation("new_conf_password");

        assertThat(this.user.getEmail(), is("another@email.com"));
        assertThat(this.user.getToken(), is("1234TOKEN"));
        assertThat(this.user.getPassword(), is("password"));
        assertThat(this.user.getPasswordConfirmation(), is("conf_password"));
        assertThat(this.user.getNewPassword(), is("new_password"));
        assertThat(this.user.getNewPasswordConfirmation(), is("new_conf_password"));
    }
}
