package waggoner.walkingbuddha.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.gson.annotations.SerializedName;
import waggoner.walkingbuddha.R;

/**
 * Created by transapps on 7/8/14.
 */
public abstract class BuddhaBaseFragment extends Fragment {

	View page;
	int layout;

	public BuddhaBaseFragment(int layout){
		this.layout = layout;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		return inflater.inflate(layout, container, false);
	}

	private ActionBar actionBar;

	public ActionBar getActionBar() {
		return actionBar;
	}

	public void setActionBar(ActionBar actionBar) {
		this.actionBar = actionBar;
	}

}
