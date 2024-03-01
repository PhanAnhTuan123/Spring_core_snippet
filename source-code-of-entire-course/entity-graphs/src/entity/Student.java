package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
@NamedEntityGraph(
	name = "Student.guide",
	attributeNodes = {
			@NamedAttributeNode("guide")
	}
)
public class Student {
	
	//for Hibernate 4.3.x Users
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	// for Hibernate 5.x Users
	// if you're using Hibernate 5.x, use GenerationType.IDENTITY id generator strategy explicitly
	// for more information on "GenerationType" have a look at https://www.udemy.com/hibernate-and-jpa-fundamentals/learn/v4/questions/937412
	/*
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	*/
	
	@Column(name="enrollment_id", nullable=false)
	private String enrollmentId;	
	
	private String name;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name="guide_id")
	private Guide guide;
	
	public Student() {}
	public Student(String enrollmentId, String name) {
		this.enrollmentId = enrollmentId;
		this.name = name;
	}

	public Guide getGuide() {
		return guide;
	}	
	public void setGuide(Guide guide) {
		this.guide = guide;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEnrollmentId() {
		return enrollmentId;
	}	
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(enrollmentId).toHashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Student)) return false;
		Student other = (Student) obj;
		return new EqualsBuilder().append(enrollmentId, other.enrollmentId).isEquals();
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ",\t enrollmentId=" + enrollmentId + ",\t name=" + name + "]";
	}	
	
}