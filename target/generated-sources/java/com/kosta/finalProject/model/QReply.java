package com.kosta.finalProject.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReply is a Querydsl query type for Reply
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QReply extends EntityPathBase<Reply> {

    private static final long serialVersionUID = 760428697L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReply reply1 = new QReply("reply1");

    public final QPost post;

    public final StringPath reply = createString("reply");

    public final DateTimePath<java.util.Date> replyDate = createDateTime("replyDate", java.util.Date.class);

    public final NumberPath<Integer> replyNO = createNumber("replyNO", Integer.class);

    public final QUser replyUser;

    public QReply(String variable) {
        this(Reply.class, forVariable(variable), INITS);
    }

    public QReply(Path<? extends Reply> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReply(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReply(PathMetadata metadata, PathInits inits) {
        this(Reply.class, metadata, inits);
    }

    public QReply(Class<? extends Reply> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.post = inits.isInitialized("post") ? new QPost(forProperty("post"), inits.get("post")) : null;
        this.replyUser = inits.isInitialized("replyUser") ? new QUser(forProperty("replyUser")) : null;
    }

}

