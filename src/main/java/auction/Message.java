/**
 */
package main.java.auction;

import javax.persistence.Entity;

@Entity
public class Message {

	protected int message_id;

	protected String topic;

	protected String text;
	protected int from;

	protected int to;

	public int getMessage_id() {
		return message_id;
	}

	public void setMessage_id(int newMessage_id) {
		int oldMessage_id = message_id;
		message_id = newMessage_id;

	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String newTopic) {
		String oldTopic = topic;
		topic = newTopic;

	}

	public String getText() {
		return text;
	}

	public void setText(String newText) {
		String oldText = text;
		text = newText;

	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int newFrom) {
		int oldFrom = from;
		from = newFrom;

	}

	public int getTo() {
		return to;
	}

	public void setTo(int newTo) {
		int oldTo = to;
		to = newTo;

	}

} // MessageImpl
