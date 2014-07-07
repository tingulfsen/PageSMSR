package org.smsr.pagesmsr;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * A concrete class to hold two fragments. The top fragment is the list of pages (i.e. messages). The bottom fragment is just the
 * 'Add Message' button.
 * @author root
 *
 */
public class DoubleFragmentActivity extends FragmentActivity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_double_fragment);
		FragmentManager fm = getSupportFragmentManager();
		Fragment fragment = fm.findFragmentById(R.id.page_list_fragment_container);
		
		if(fragment == null)
		{
			fragment = new PageListFragment();
			Fragment addMessageFragment = new AddMessageFragment();
			FragmentTransaction trans = fm.beginTransaction();
			
			trans.add(R.id.page_list_fragment_container, fragment, "page_list_fragment");
			trans.add(R.id.page_button_fragment_container, addMessageFragment, "add_message_fragment");
			trans.commit();
		}
	}
}
