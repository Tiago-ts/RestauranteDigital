package config;

import javax.enterprise.context.Conversation;

public class ConversationUtil {
	private Conversation conversation;

	public void beginConversation() {
		if (conversation.isTransient()) {
			conversation.setTimeout(1800000L);
			conversation.begin();
		}
	}

	public void endConversation() {
		 if (!conversation.isTransient()) {
		 conversation.end();
		 }
}
}
