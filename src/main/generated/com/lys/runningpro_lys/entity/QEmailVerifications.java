package com.lys.runningpro_lys.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QEmailVerifications is a Querydsl query type for EmailVerifications
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEmailVerifications extends EntityPathBase<EmailVerifications> {

    private static final long serialVersionUID = -1075810333L;

    public static final QEmailVerifications emailVerifications = new QEmailVerifications("emailVerifications");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final StringPath email = createString("email");

    public final DateTimePath<java.time.LocalDateTime> expiresDate = createDateTime("expiresDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath token = createString("token");

    public final BooleanPath used = createBoolean("used");

    public QEmailVerifications(String variable) {
        super(EmailVerifications.class, forVariable(variable));
    }

    public QEmailVerifications(Path<? extends EmailVerifications> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEmailVerifications(PathMetadata metadata) {
        super(EmailVerifications.class, metadata);
    }

}

