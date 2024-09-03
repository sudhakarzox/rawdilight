package com.raw1.app.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Subscription {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "userr_id")
    private UserR userr;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    private LocalDate startDate;
    private LocalDate endDate;
    private String subscriptionStatus;
    private String paymentType;
	@Override
	public String toString() {
		return "Subscription [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", subscriptionStatus="
				+ subscriptionStatus + ", paymentType=" + paymentType + "]";
	}
}
