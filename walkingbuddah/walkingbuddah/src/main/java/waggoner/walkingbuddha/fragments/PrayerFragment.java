package waggoner.walkingbuddha.fragments;

import android.os.Bundle;
import android.view.*;
import waggoner.walkingbuddha.R;
/**
 * Created by transapps on 7/8/14.
 */
public class PrayerFragment extends BuddhaBaseFragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		setHasOptionsMenu(true);
		return inflater.inflate(R.layout.prayer_view_layout, container, false);
	}
	@Override
	public void onCreateOptionsMenu(Menu menu,MenuInflater inflater) {
		// Inflate the menu items for use in the action bar
		inflater.inflate(R.menu.prayers_fragment_menu, menu);
		super.onCreateOptionsMenu(menu,inflater);
	}
}

