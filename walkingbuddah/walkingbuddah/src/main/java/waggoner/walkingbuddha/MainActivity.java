package waggoner.walkingbuddha;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

	/**..Nice way to handle fragment id's and such for swapping, nice and simple..**/
	public static enum BuddhaFrag {
		Splash("Splash",R.id.icon),
		Prayer("Prayers",R.id.icon),
		Stupa("Stupas",R.id.icon),
		Action("Action",R.id.icon);
		private final String name;
		private final int icon;
		BuddhaFrag(String name, int icon) {
			this.name = name;
			this.icon = icon;
		}
	}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
