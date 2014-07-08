package waggoner.walkingbuddha.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import waggoner.walkingbuddha.R;
/**
 * Created by transapps on 7/8/14.
 */
public class SplashFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		return inflater.inflate(R.layout.splash_view_layout, container, false);
	}

}
