package com.lys.runningpro_lys.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPasswordResets is a Querydsl query type for PasswordResets
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPasswordResets extends EntityPathBase<PasswordResets> {

    private static final long serialVersionUID = -308625562L;

    public static final QPasswordResets passwordResets = new QPasswordResets("passwordResets");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final StringPath email = createString("email");

    public final DateTimePath<java.time.LocalDateTime> expiresAt = createDateTime("expiresAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath token = createString("token");

    public final BooleanPath used = createBoolean("used");

    public QPasswordResets(String variable) {
        super(PasswordResets.class, forVariable(variable));
    }

    public QPasswordResets(Path<? extends PasswordResets> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPasswordResets(PathMetadata metadata) {
        super(PasswordResets.class, metadata);
    }

}

