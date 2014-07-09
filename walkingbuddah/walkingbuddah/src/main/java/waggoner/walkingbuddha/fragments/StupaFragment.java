package waggoner.walkingbuddha.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import waggoner.walkingbuddha.R;

/**
 * Created by transapps on 7/8/14.
 */
public class StupaFragment extends BuddhaBaseFragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		return inflater.inflate(R.layout.stupa_view_layout, container, false);
	}

}
