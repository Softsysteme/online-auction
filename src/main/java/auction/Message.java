/**
 */
package auction;

public class Message {

	protected static final int MESSAGE_ID_EDEFAULT = 0;

	protected int message_id = MESSAGE_ID_EDEFAULT;

	protected static final String TOPIC_EDEFAULT = null;

	protected String topic = TOPIC_EDEFAULT;

	protected static final String TEXT_EDEFAULT = null;

	protected String text = TEXT_EDEFAULT;

	protected static final int FROM_EDEFAULT = 0;

	protected int from = FROM_EDEFAULT;

	protected static final int TO_EDEFAULT = 0;
	protected int to = TO_EDEFAULT;

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
