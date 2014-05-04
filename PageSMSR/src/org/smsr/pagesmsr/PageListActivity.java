package org.smsr.pagesmsr;

import android.support.v4.app.Fragment;

/**
 * 
 * @author root
 *
 */
public class PageListActivity extends SingleFragmentActivity
{
	@Override
	protected Fragment createFragment()
	{
		return new PageListFragment();
	}

}
