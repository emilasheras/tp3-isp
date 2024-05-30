package com.emilasheras.modules.user_password.models;

import com.emilasheras.modules.user.models.User;

public interface UserPasswordInterface {
    String getPassword();
    void setPassword(String password);

    String getSalt();
    void setSalt(String salt);

    User getUser();
    void setUser(User user);
}
