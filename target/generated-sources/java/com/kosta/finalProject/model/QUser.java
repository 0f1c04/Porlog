package com.kosta.finalProject.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 2102842428L;

    public static final QUser user = new QUser("user");

    public final NumberPath<Integer> authLV = createNumber("authLV", Integer.class);

    public final StringPath eamil = createString("eamil");

    public final DateTimePath<java.util.Date> lastLogin = createDateTime("lastLogin", java.util.Date.class);

    public final DateTimePath<java.util.Date> lastPWChg = createDateTime("lastPWChg", java.util.Date.class);

    public final StringPath nickname = createString("nickname");

    public final StringPath userID = createString("userID");

    public final StringPath userPW = createString("userPW");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

