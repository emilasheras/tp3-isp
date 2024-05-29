package com.emilasheras.modules.user.models;

import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ extends com.emilasheras.components.models.CModel_ {

	public static volatile ListAttribute<User, UserPassword> passwords;
	public static volatile SingularAttribute<User, String> username;

	public static final String PASSWORDS = "passwords";
	public static final String USERNAME = "username";

}

