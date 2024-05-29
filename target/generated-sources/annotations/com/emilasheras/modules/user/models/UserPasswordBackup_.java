package com.emilasheras.modules.user.models;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserPasswordBackup.class)
public abstract class UserPasswordBackup_ {

	public static volatile SingularAttribute<UserPasswordBackup, String> salt;
	public static volatile SingularAttribute<UserPasswordBackup, Integer> id;
	public static volatile SingularAttribute<UserPasswordBackup, String> passwordHash;
	public static volatile SingularAttribute<UserPasswordBackup, String> username;

	public static final String SALT = "salt";
	public static final String ID = "id";
	public static final String PASSWORD_HASH = "passwordHash";
	public static final String USERNAME = "username";

}
