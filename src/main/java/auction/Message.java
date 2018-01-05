/**
 */
package main.java.auction;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int message_id;

	protected String topic;

	protected String text;

	@ManyToOne
	@JoinColumn(name = "receiver", nullable = false)
	protected User from;

	@ManyToOne
	@JoinColumn(name = "sender", nullable = false)
	protected User to;

	public int getMessage_id() {
		return message_id;
	}

	public void setMessage_id(int newMessage_id) {
		message_id = newMessage_id;

	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String newTopic) {
		topic = newTopic;

	}

	public String getText() {
		return text;
	}

	public void setText(String newText) {
		text = newText;

	}

	public User getFrom() {
		return from;
	}

	public void setFrom(User newFrom) {
		from = newFrom;

	}

	public User getTo() {
		return to;
	}

	public void setTo(User newTo) {
		to = newTo;

	}

} // MessageImpl
