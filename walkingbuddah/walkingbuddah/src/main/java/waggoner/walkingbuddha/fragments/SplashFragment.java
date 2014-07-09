package waggoner.walkingbuddha.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.*;
import android.widget.ImageView;
import waggoner.walkingbuddha.R;
/**
 * Created by transapps on 7/8/14.
 */
public class SplashFragment extends BuddhaBaseFragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		return inflater.inflate(R.layout.splash_view_layout, container, false);
	}

}
