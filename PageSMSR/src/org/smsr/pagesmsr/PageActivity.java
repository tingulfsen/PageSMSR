package org.smsr.pagesmsr;

import android.support.v4.app.Fragment;

public class PageActivity extends SingleFragmentActivity
{

	@Override
	protected Fragment createFragment()
	{
		int messageID = (Integer)getIntent().getSerializableExtra(PageFragment.EXTRA_MESSAGE_ID);	
		return PageFragment.newInstance(messageID);
	}

}
