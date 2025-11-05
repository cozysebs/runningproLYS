package com.lys.runningpro_lys.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSubscriptions is a Querydsl query type for Subscriptions
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSubscriptions extends EntityPathBase<Subscriptions> {

    private static final long serialVersionUID = 1580205615L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSubscriptions subscriptions = new QSubscriptions("subscriptions");

    public final DateTimePath<java.time.LocalDateTime> endDate = createDateTime("endDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<com.lys.runningpro_lys.entity.fieldenum.Plan> plan = createEnum("plan", com.lys.runningpro_lys.entity.fieldenum.Plan.class);

    public final DateTimePath<java.time.LocalDateTime> startDate = createDateTime("startDate", java.time.LocalDateTime.class);

    public final EnumPath<com.lys.runningpro_lys.entity.fieldenum.Status> status = createEnum("status", com.lys.runningpro_lys.entity.fieldenum.Status.class);

    public final QUsers users;

    public QSubscriptions(String variable) {
        this(Subscriptions.class, forVariable(variable), INITS);
    }

    public QSubscriptions(Path<? extends Subscriptions> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSubscriptions(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSubscriptions(PathMetadata metadata, PathInits inits) {
        this(Subscriptions.class, metadata, inits);
    }

    public QSubscriptions(Class<? extends Subscriptions> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.users = inits.isInitialized("users") ? new QUsers(forProperty("users")) : null;
    }

}

