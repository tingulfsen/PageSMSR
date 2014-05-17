package org.smsr.pagesmsr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import org.smsr.pagesmsr.R;

public class PageListFragment extends ListFragment
{
	private static final String TAG = "PageListFragment";
	private List<String> messages;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.app_name);
        
        messages = MessageStore.get(getActivity()).getMessages(); 
        
        // simple_list_item_1 is a pre-defined layout from the resources provided by the Android SDK (an R.layout constant)
        // It has a TextView as its root element.
        ArrayAdapter<String> messageAdapter = new ArrayAdapter<String>(getActivity(),
        		                                                       android.R.layout.simple_list_item_1,
        		                                                       messages);
        setListAdapter(messageAdapter);
    }

    
    @Override
    public void onListItemClick(ListView l, View v, int position, long id)
    {
    	String message = (String)getListAdapter().getItem(position);
    	Log.d(TAG, "Message " + message + " was clicked, in position " + position); // first page is in list position 0!
    	
    	
    	Intent i = new Intent(getActivity(), PageActivity.class);
    	i.putExtra(PageFragment.EXTRA_MESSAGE_ID, position); // pass in the list position - i.e. 0 for the first message.
    	startActivity(i);
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
