package waggoner.walkingbuddha.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import waggoner.walkingbuddha.R;
import waggoner.walkingbuddha.domain.Stupa;
import waggoner.walkingbuddha.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by transapps on 7/8/14.
 */
public class StupaFragment extends BuddhaBaseFragment {
	private static final String TAG = "STUPA FRAGMENT";
	Stupa[] stupas;
	List<String> stupaNames;
	Stupa activeStupa;
	Spinner selectionSpinner;
	ImageView stupaImage;
	TextView descriptionView;
	public StupaFragment() {
		super(R.layout.stupa_view_layout);
		stupas = Utils.getStupas();
		stupaNames = getStupaNames();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		setHasOptionsMenu(true);
		page = super.onCreateView( inflater, container,savedInstanceState);
		selectionSpinner = (Spinner) page.findViewById(R.id.stupa_selection_spinner);
		selectionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				setStupa(stupas[position]);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_spinner_item, stupaNames);
		selectionSpinner.setAdapter(dataAdapter);
		if(stupaNames.size()>0 && stupaNames.get(0)!=null) {
			selectionSpinner.setSelection(0);
		}
		stupaImage = (ImageView)page.findViewById(R.id.stupa_image_view);
		descriptionView = (TextView) page.findViewById(R.id.stupa_description_view);
		return page;
	}

	private void setStupa(Stupa stupa) {
		activeStupa = stupa;
		updateView();
	}

	/**Set the UI to display the basic info for the current stupa
	 * We are going to be EXTRA craful anywhere we show user created content, since they might have made mistakes
	 */
	private void updateView() {
		if(activeStupa!=null) {
			if(activeStupa.getDesc()!=null) {
				descriptionView.setText(activeStupa.getDesc());
			} else {
				Utils.showToast(getActivity(), "Tried to laod Stupa with no description");
				Log.e(TAG,"Failed to find description for Stupa: "+activeStupa.getName() );
			}
			if(activeStupa.getImages()!=null && activeStupa.getImages()[0]!=null && activeStupa.getFilepath()!=null) {
				Bitmap bitmap = BitmapFactory.decodeFile(Utils.getImagePath(activeStupa.getFilepath(), activeStupa.getImages()[0]));
				stupaImage.setImageBitmap(bitmap);
			}else {
				Utils.showToast(getActivity(), "Tried to laod Stupa with no associate images");
				Log.e(TAG,"Failed to find description for Stupa: "+activeStupa.getName() );
			}

		}
	};

	public List<String> getStupaNames() {
		List<String> stupaNames = new ArrayList<String>();
		for(Stupa s: stupas) {
			if(s.getName()!=null) {
				stupaNames.add(s.getName());
			} else {
				Log.e(TAG,"Failed to find name for Stupa, not showing in list.");
			}
		}
		return stupaNames;
	}

}
