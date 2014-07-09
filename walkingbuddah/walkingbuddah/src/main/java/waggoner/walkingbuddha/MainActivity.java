package waggoner.walkingbuddha;

import  android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import waggoner.walkingbuddha.fragments.*;


public class MainActivity extends ActionBarActivity  implements ListView.OnItemClickListener {


	/**..Nice way to handle fragment id's and such for swapping, nice and simple..**/
	public static enum BuddhaFrag {
		Splash("Walking Buddha",R.drawable.pretty_stupa,0),
		Prayer("Prayers",R.drawable.hands_in_prayer,1),
		Stupa("Stupas",R.drawable.pretty_stupa,2),
		Action("Action",R.drawable.ic_launcher,3);
		private final String name;
		private final int icon;
		public final int loc;
		BuddhaFrag(String name, int icon,int loc) {
			this.name = name;
			this.icon = icon;
			this.loc = loc;
		}
		public int getLoc() {
			return loc;
		}
		public int getIcon() {
			return icon;
		}
		public String getName() {
			return name;
		}
	}
	String[] frags = new String[]{BuddhaFrag.Splash.getName(),BuddhaFrag.Prayer.getName(),BuddhaFrag.Stupa.getName(),BuddhaFrag.Action.getName()};
	ActionBar bar;
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	ActionBarDrawerToggle mDrawerToggle;
	BuddhaFrag curFrag;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		bar = getSupportActionBar();
		curFrag = BuddhaFrag.Splash;
		mDrawerLayout =(DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);
		// set up the drawer
		mDrawerList.setAdapter(new ArrayAdapter<String>(this,
				R.layout.drawer_list_item,frags));
		mDrawerList.setOnItemClickListener(this);
		mDrawerToggle = new ActionBarDrawerToggle(
				this,                  /* host Activity */
				mDrawerLayout,         /* DrawerLayout object */
				R.drawable.ic_launcher,  /* nav drawer icon to replace 'Up' caret */
				R.string.drawer_open,  /* "open drawer" description */
				R.string.drawer_closed  /* "close drawer" description */
		) {

			/** Called when a drawer has settled in a completely closed state. */
			public void onDrawerClosed(View view) {
				super.onDrawerClosed(view);
				getSupportActionBar().setTitle(curFrag.getName() );
				setActionBarIcon();

			}

			/** Called when a drawer has settled in a completely open state. */
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				getSupportActionBar().setTitle("Select Mode");

			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		setActionBarIcon();

	}
	public void setActionBarIcon() {
		getSupportActionBar().setIcon(curFrag.getIcon());
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Pass the event to ActionBarDrawerToggle, if it returns
		// true, then it has handled the app icon touch event
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		// Handle your other action bar items...

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onItemClick(AdapterView parent, View view, int position, long id) {
		selectItem(position);
	}

	private void selectItem(final int position) {
		curFrag = BuddhaFrag.values()[position];
		instantiateAndShowCurFrag();
		mDrawerLayout.closeDrawer(Gravity.LEFT);
	}

	private void instantiateAndShowCurFrag() {
		Fragment frag = null;
		switch(curFrag) {
			case Splash:
				frag = new SplashFragment();
				break;
			case Prayer:
				frag = new PrayerFragment();
				break;
			case Stupa:
				frag = new StupaFragment();
				break;
			case Action:
				frag = new ActionFragment();
				break;
		}

		// Insert the fragment by replacing any existing fragment
		((BuddhaBaseFragment)frag).setActionBar(bar);
		FragmentManager fragmentManager = getSupportFragmentManager();

		fragmentManager.beginTransaction()
				.replace(R.id.fragment_holder, frag)
				.commit();
	}
}
