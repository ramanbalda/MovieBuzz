package com.module;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class QuestionAns {
	@Id
	int qnaId;
	String message;
	int admin; 
	int senderId;
	LocalDateTime dateTime;
	public int getQnaId() {
		return qnaId;
	}
	public void setQnaId(int qnaId) {
		this.qnaId = qnaId;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	@Override
	public String toString() {
		return "QuestionAns [qnaId=" + qnaId + ", message=" + message + ", admin=" + admin + ", senderId=" + senderId
				+ ", dateTime=" + dateTime + "]";
	}

	public QuestionAns(String message, int admin, int senderId, LocalDateTime dateTime) {
		super();
		this.message = message;
		this.admin = admin;
		this.senderId = senderId;
		this.dateTime = dateTime;
	}
	public QuestionAns() {
		super();
	}
	

}
