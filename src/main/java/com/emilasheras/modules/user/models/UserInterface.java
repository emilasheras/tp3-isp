package com.emilasheras.modules.user.models;

import java.util.List;
import com.emilasheras.modules.user_password.models.UserPassword;

public interface UserInterface {
    String getUsername();
    void setUsername(String username);

    List<UserPassword> getPasswords();
    void setPasswords(List<UserPassword> passwords);
}
