package com.accolite.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="logging")
public class Logging {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    private String message;
    private String date;
    private long userid;
	public Logging(long id, String message, String date, long userid) {
		super();
		this.id = id;
		this.message = message;
		this.date = date;
		this.userid = userid;
	}
    
    
}
