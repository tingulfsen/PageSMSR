package org.smsr.pagesmsr;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PageFragment extends Fragment
{
	private static final String TAG = "PageFragment";
	public static final String EXTRA_MESSAGE_ID = "org.smsr.pagesmsr.extra_message_id";
	private String message;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		int messageID = (Integer)getArguments().getSerializable(EXTRA_MESSAGE_ID);
		message = MessageStore.get(getActivity()).getMessage(messageID);
	}
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		// Inflate this fragment's layout and add it to the container
		View v = inflater.inflate(R.layout.fragment_single_page, container, false);
		TextView pageMessage = (TextView)v.findViewById(R.id.single_page_text);
	    pageMessage.setText(message);
		return v;
	}
	
	
	/**
	 * Create a new fragment. The method sets up the Bundle arguments AFTER the fragment is created but BEFORE it is added
	 * to its hosting activity.
	 * @param messageID
	 * @return
	 */
	public static PageFragment newInstance(int messageID)
	{
		Bundle args = new Bundle();
		args.putSerializable(EXTRA_MESSAGE_ID, messageID);
		
		PageFragment fragment = new PageFragment();
		fragment.setArguments(args);
		return fragment;
	}
	
	
	@Override
    public void onPause()
    {
    	super.onPause();
    	try
    	{
    		MessageStore.get(getActivity()).save();
    	}
    	catch(IOException ioe)
    	{
    		Log.e(TAG, "Exception occurred attempting to save messages: " + ioe.getMessage());
    		
    	    StringWriter sw = new StringWriter();
    	    ioe.printStackTrace(new PrintWriter(sw));
    		Log.e(TAG, sw.toString());
    	}
    }
	
}
