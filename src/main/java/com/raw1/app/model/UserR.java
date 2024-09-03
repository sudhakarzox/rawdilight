package com.raw1.app.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserR {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String firstName;
	    private String lastName;
	    private String phone;
	    private String flatNo;
	    private String block;

//	    @OneToOne(mappedBy = "userr", cascade = CascadeType.ALL)
//	    private Cart cart;

	    @OneToOne(mappedBy = "userr", cascade = CascadeType.ALL)
	    private Subscription subscription;

		@Override
		public String toString() {
			return "UserR [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone
					+ ", flatNo=" + flatNo + "]";
		}


}
