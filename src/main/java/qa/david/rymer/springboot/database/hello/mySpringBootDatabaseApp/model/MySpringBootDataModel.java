package qa.david.rymer.springboot.database.hello.mySpringBootDatabaseApp.model;

import java.util.Date;
import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
	@Table(name = "dvd")
	@EntityListeners(AuditingEntityListener.class)
	@JsonIgnoreProperties(value = {"rentDate","dueDate"}, allowGetters = true)
	
	public class MySpringBootDataModel implements Serializable {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NotBlank
		private String title;
		
		private Integer age;
		
		@Column(nullable = false, updatable = false)
		@Temporal(TemporalType.TIMESTAMP)
		@CreatedDate
		private Date rentDate;
		
		@Column(nullable = false)
		@Temporal(TemporalType.TIMESTAMP)
		@LastModifiedDate
		private Date dueDate;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public Date getRentDate() {
			return rentDate;
		}

		public void setRentDate(Date rentDate) {
			this.rentDate = rentDate;
		}

		public Date getDueDate() {
			return dueDate;
		}

		public void setDueDate(Date dueDate) {
			this.dueDate = dueDate;
		}

		
	}		

