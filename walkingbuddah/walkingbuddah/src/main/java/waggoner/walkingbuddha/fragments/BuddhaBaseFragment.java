package waggoner.walkingbuddha.fragments;

import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;

/**
 * Created by transapps on 7/8/14.
 */
public abstract class BuddhaBaseFragment extends Fragment {

	private ActionBar actionBar;

	public ActionBar getActionBar() {
		return actionBar;
	}

	public void setActionBar(ActionBar actionBar) {
		this.actionBar = actionBar;
	}
}
