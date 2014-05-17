package org.smsr.pagesmsr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;

/**
 * Saves pager messages to local file.
 * @author root
 *
 */
public class MessageSerializer
{
	private Context context;
	private String filename;
	
	public MessageSerializer(Context c, String f)
	{
		context = c;
		filename = context.getFilesDir().getPath().toString() + "/" + f; // don't save to root, save to the application's directory
	}
	
	
	public void saveMessages(List<String> messages)
		throws IOException
	{
		// Force UTF-8 encoding
		BufferedWriter outs = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "UTF-8"));
		for(String s : messages)
		{
			outs.write(s);
			outs.newLine();
		}
		outs.close();
	}
	
	
	public ArrayList<String> loadMessages()
		throws IOException
	{
		String m;
		ArrayList<String> messageList = new ArrayList<String>();
		
		try
		{
			BufferedReader ins = new BufferedReader(new FileReader(filename));
		
			while((m = ins.readLine()) != null)
				messageList.add(m);
			ins.close();
		}
		catch(FileNotFoundException fnfe)
		{} // ignore - happens on first call when no file exists yet
		
		return messageList;
	}
}
