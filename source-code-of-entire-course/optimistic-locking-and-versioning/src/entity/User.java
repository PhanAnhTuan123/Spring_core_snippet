package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    private String username;

    @Column(name="num_of_posts")
    private Integer numOfPosts;

    private Integer level;
    
    @Column(name="active")
    private boolean isActive;
    
    @Version
    private Integer version;

    public User() {}    
	public User(String username, Integer numOfPosts, Integer level, boolean isActive) {
		this.username = username;
		this.numOfPosts = numOfPosts;
		this.level = level;
		this.isActive = isActive;
	}
	
	public void setLevel(Integer level) {
		this.level = level;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	@PostRemove
	public void foo() {
		System.out.println("User[id=" + this.id + "] just got deleted");
	}
	
	@PostUpdate
	public void bar() {
		System.out.println("User[id=" + this.id + "] just got updated");
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", numOfPosts=" + numOfPosts + ", level="
				+ level + ", isActive=" + isActive + "]";
	}
	
}
