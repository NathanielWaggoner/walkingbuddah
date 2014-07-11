package waggoner.walkingbuddha.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.*;
import android.widget.ImageView;
import waggoner.walkingbuddha.R;
import waggoner.walkingbuddha.utils.Utils;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by transapps on 7/8/14.
 */
public class SplashFragment extends BuddhaBaseFragment {

	public SplashFragment() {
		super(R.layout.splash_view_layout);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		//setHasOptionsMenu(true);
		page = super.onCreateView( inflater, container,savedInstanceState);
		setUpAssets();
		return page;
	}
	private void setUpAssets() {
		Utils.copyFileOrDir(getActivity(), "WalkingBuddha");
	}
}
