package waggoner.walkingbuddha.fragments;

import android.os.Bundle;
import android.view.*;
import waggoner.walkingbuddha.R;
import waggoner.walkingbuddha.domain.Prayer;
import waggoner.walkingbuddha.utils.Utils;

/**
 * Created by transapps on 7/8/14.
 */
public class PrayerFragment extends BuddhaBaseFragment {
	Prayer[] prayers;

	public PrayerFragment() {
		super(R.layout.prayer_view_layout);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		setHasOptionsMenu(true);
		page = super.onCreateView( inflater, container,savedInstanceState);
		return page;
	}
	@Override
	public void onCreateOptionsMenu(Menu menu,MenuInflater inflater) {
		// Inflate the menu items for use in the action bar
		inflater.inflate(R.menu.prayers_fragment_menu, menu);
		super.onCreateOptionsMenu(menu,inflater);
	}

	private void updateView() {
	}

	@Override
	public void onResume() {
		super.onResume();
		loadPrayers();
		updateView();
	}



	public void loadPrayers() {
		prayers = Utils.getPrayers();
	}
}

