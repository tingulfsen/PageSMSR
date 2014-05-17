package org.smsr.pagesmsr;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
		filename = f;
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
}
