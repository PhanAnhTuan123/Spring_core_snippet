package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Guide.class)
public abstract class Guide_ {

	public static volatile SingularAttribute<Guide, String> name;
	public static volatile SetAttribute<Guide, Student> students;
	public static volatile SingularAttribute<Guide, Long> id;
	public static volatile SingularAttribute<Guide, Integer> salary;
	public static volatile SingularAttribute<Guide, String> staffId;

}

