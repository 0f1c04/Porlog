package com.kosta.finalProject.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPost_Contents is a Querydsl query type for Post_Contents
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPost_Contents extends EntityPathBase<Post_Contents> {

    private static final long serialVersionUID = 1669075624L;

    public static final QPost_Contents post_Contents = new QPost_Contents("post_Contents");

    public final StringPath contents = createString("contents");

    public final StringPath postID = createString("postID");

    public QPost_Contents(String variable) {
        super(Post_Contents.class, forVariable(variable));
    }

    public QPost_Contents(Path<? extends Post_Contents> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPost_Contents(PathMetadata metadata) {
        super(Post_Contents.class, metadata);
    }

}

