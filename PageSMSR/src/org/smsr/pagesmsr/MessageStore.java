package org.smsr.pagesmsr;

import android.content.Context;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * A singleton class for storing pages.
 * @author root
 *
 */
public class MessageStore
{
	private static final String SMSR_FILENAME = "pagesmsr.txt";
	private static MessageStore messageList;
	private MessageSerializer serializer;
	private Context appContext;
	private ArrayList<String> messages;
	
	private MessageStore(Context c)
		throws IOException
	{
		appContext = c;
		//messages = new ArrayList<String>(); only when not having a file in place
		serializer = new MessageSerializer(appContext, SMSR_FILENAME);
		messages = serializer.loadMessages();
		
		//populateDebugMessages(); only when not having a file in place
	}
	
	
	public static MessageStore get(Context c)
		throws IOException
	{
		if(messageList == null)
			return new MessageStore(c.getApplicationContext());
		else return messageList;
	}
	
	
	public List<String> getMessages()
	{
		return messages;
	}
	
	
	public String getMessage(int i)
	{
		return messages.get(i);
	}
	
	
	public void save()
		throws IOException
	{
		//MessageSerializer serializer = new MessageSerializer(appContext, SMSR_FILENAME);
		serializer.saveMessages(messages);
	}
	
	
	private void populateDebugMessages()
	{
		messages.add("Page number 1");
		messages.add("Page number 2");
		messages.add("Page number 3");
		messages.add("Page number 4");
		messages.add("Page number 5");
		messages.add("Page number 6");
		messages.add("Page number 7");
		messages.add("Page number 8");
		messages.add("Page number 9");
		messages.add("Page number 10");
	}
}
