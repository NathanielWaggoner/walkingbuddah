package waggoner.walkingbuddha.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;
import com.google.gson.Gson;
import waggoner.walkingbuddha.domain.Prayer;
import waggoner.walkingbuddha.domain.Stupa;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by transapps on 7/7/14.
 */
public class Utils {
	private static final String TAG = Utils.class.getName();
	public static String SD_CARD_LOC = Environment.getExternalStorageDirectory().getAbsolutePath();
	public static String WALKING_BUDDHA = "WalkingBuddha";
	public static String WALKING_BUDDHA_LOC = SD_CARD_LOC+File.separator+WALKING_BUDDHA;
	public static String STUPAS = WALKING_BUDDHA_LOC+File.separator+ "stupas";
	public static String PRAYERS = WALKING_BUDDHA_LOC+File.separator+ "prayers";
	public static String FONTS = WALKING_BUDDHA_LOC+File.separator+ "fonts";
	public static String STUPA_IMAGES = "stupaimages";
	/** Open a FILE from somewhere on the SD Card
	 *
	 * @param path the file to load, not iincluding any of the SD card info (just STUPAS/stupa_name or PRAYER/prayer_name
	 * @return a file object of that path plus sd card info.
	 */
	public static File loadFileFromSdCard(String path) {
		File sdcard = Environment.getExternalStorageDirectory();
		File file = new File(sdcard,path);
		File f = new File(path);
		return f;
	}
	/** Parse a Stupa out of a file.
	 * @return the stupa to load.
	 */
	public static Stupa loadStupaFromFile(String path,Gson gson) throws FileNotFoundException {
		return gson.fromJson(getReaderForFile(path),Stupa.class);
	}

	public static Reader getReaderForFile(String path) throws FileNotFoundException {
		File f = loadFileFromSdCard(path);
		Gson gson = new Gson();
		return new InputStreamReader(new FileInputStream(f));
	}
	/**Loads a prayer form a file.
	 * @return the prayer to load
	 */
	public static Prayer loadPrayerFromFile(String path,Gson gson) throws FileNotFoundException {
		return gson.fromJson(getReaderForFile(path),Prayer.class);
	}

	/** Get a list of all files in the WalkingBuddha.prayers
	 * @return a list of prayer paths
	 */
	public static String[] getListOfPrayers() {
		return listFilesInDir(PRAYERS);
	}
	/** Get a list of all files in the WalkingBuddha.stupas
	 * @return a list of stupa paths
	 */
	public static String[] getListOfStupas() {
		return listFilesInDir(STUPAS);
	}

	/**Just return a list of all the names of all the files in the directory
	 *
	 * @param dir - the path to the directory you want to list
	 * @return the list of file names.
	 */
	public static String[] listFilesInDir(String dir) {
		File f = new File(dir);
		File[] files = f.listFiles();
		String[] fileNames = new String[files.length];
		for(int i = 0; i<files.length;i++) {
			fileNames[i]=files[i].getAbsolutePath();
		}
		return fileNames;
	}

	/** get dem WalkingBuddha.prayers
	 *
	 * @return
	 */
	public static Prayer[] getPrayers() {
		Gson gson = new Gson();
		ArrayList<Prayer> prayers = new ArrayList<Prayer>();
		for(String s:getListOfPrayers()) {
			String path = getJsonFileFromPathName(s);
			File f = new File(path);
			if(f.exists()) {
				try {
					prayers.add(loadPrayerFromFile(path, gson));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			} else {
				Log.e(TAG,"Found file "+s+" but it is not a .json file.");
			}
		}
		return prayers.toArray(new Prayer[prayers.size()]);
	}
	public static Stupa[] getStupas() {
		Gson gson = new Gson();
		ArrayList<Stupa> stupas = new ArrayList<Stupa>();
		for(String s:getListOfStupas()) {
			String path = getJsonFileFromPathName(s);
			try {
				stupas.add(loadStupaFromFile(path,gson));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return stupas.toArray(new Stupa[stupas.size()]);
	}

	private static String getJsonFileFromPathName(String s) {
		String idStr = s.substring(s.lastIndexOf('/') + 1);
		return s+File.separator+idStr+".json";

	}

	/**
	 * Copy the asset at the specified path to this app's data directory. If the
	 * asset is a directory, its contents are also copied.
	 *
	 * @param path
	 * Path to asset, relative to app's assets directory.
	 */
	public static void copyFileOrDir(Context ctx,String path) {
		AssetManager assetManager = ctx.getAssets();
		String assets[] = null;
		try {
			assets = assetManager.list(path);
			if (assets.length == 0) {
				copyFile(ctx,path);
			} else {
				String fullPath = Environment.getExternalStorageDirectory()+"/" + path;
				File dir = new File(fullPath);
				if (!dir.exists())
					dir.mkdir();
				for (int i = 0; i < assets.length; ++i) {
					copyFileOrDir(ctx,path + "/" + assets[i]);
				}
			}
		} catch (IOException ex) {
			Log.e("tag", "I/O Exception", ex);
		}
	}

	private static void copyFile(Context ctx,String filename) {
		AssetManager assetManager = ctx.getAssets();

		InputStream in = null;
		OutputStream out = null;
		try {
			in = assetManager.open(filename);
			String newFileName = Environment.getExternalStorageDirectory()+"/" + filename;
			out = new FileOutputStream(newFileName);

			byte[] buffer = new byte[1024];
			int read;
			while ((read = in.read(buffer)) != -1) {
				out.write(buffer, 0, read);
			}
			in.close();
			in = null;
			out.flush();
			out.close();
			out = null;
		} catch (Exception e) {
			Log.e("tag", e.getMessage());
		}

	}

	public static String getImagePath(String filepath, String imagename) {
		return STUPAS+File.separator+filepath+File.separator+STUPA_IMAGES+File.separator+imagename;
	}
	public static void showToast(Context ctx, String toShow) {
		Toast.makeText(ctx, toShow, Toast.LENGTH_LONG).show();
	}
}
