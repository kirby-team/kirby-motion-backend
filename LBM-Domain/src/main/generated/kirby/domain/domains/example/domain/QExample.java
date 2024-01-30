package kirby.domain.domains.example.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QExample is a Querydsl query type for Example
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QExample extends EntityPathBase<Example> {

    private static final long serialVersionUID = 1031458986L;

    public static final QExample example = new QExample("example");

    public final kirby.domain.common.model.QBaseTimeEntity _super = new kirby.domain.common.model.QBaseTimeEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QExample(String variable) {
        super(Example.class, forVariable(variable));
    }

    public QExample(Path<? extends Example> path) {
        super(path.getType(), path.getMetadata());
    }

    public QExample(PathMetadata metadata) {
        super(Example.class, metadata);
    }

}

