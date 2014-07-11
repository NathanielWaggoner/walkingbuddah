package waggoner.walkingbuddha.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import waggoner.walkingbuddha.R;
import waggoner.walkingbuddha.domain.Stupa;
import waggoner.walkingbuddha.utils.Utils;

/**
 * Created by transapps on 7/8/14.
 */
public class StupaFragment extends BuddhaBaseFragment {
	Stupa[] stupas;
	public StupaFragment() {
		super(R.layout.stupa_view_layout);
		stupas = Utils.getStupas();
		for(Stupa s: stupas) {
			Log.e("Loaded a Stupa",s.getDesc() + s.getLat() + s.getLon() + s.getName() + s.getType() + s.getName());
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		setHasOptionsMenu(true);
		page = super.onCreateView( inflater, container,savedInstanceState);
		return page;
	}

}
