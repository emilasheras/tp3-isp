package com.emilasheras.modules.user_password.models;

import com.emilasheras.modules.user.models.User;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserPassword.class)
public abstract class UserPassword_ extends com.emilasheras.components.models.CModel_ {

	public static volatile SingularAttribute<UserPassword, String> password;
	public static volatile SingularAttribute<UserPassword, String> salt;
	public static volatile SingularAttribute<UserPassword, User> user;

	public static final String PASSWORD = "password";
	public static final String SALT = "salt";
	public static final String USER = "user";

}

