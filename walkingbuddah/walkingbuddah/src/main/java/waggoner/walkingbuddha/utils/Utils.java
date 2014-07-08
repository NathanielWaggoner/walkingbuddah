package waggoner.walkingbuddha.utils;

import android.os.Environment;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import waggoner.walkingbuddha.domain.Prayer;
import waggoner.walkingbuddha.domain.Stupa;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.List;

/**
 * Created by transapps on 7/7/14.
 */
public class Utils {
	public static String SD_CARD_LOC = Environment.getDownloadCacheDirectory().getAbsolutePath();
	public static String WALKING_BUDDHA_LOC = SD_CARD_LOC+File.separator+"WALKING_BUDDHA";
	public static String STUPAS = WALKING_BUDDHA_LOC+File.separator+"STUPAS";
	public static String PRAYERS = WALKING_BUDDHA_LOC+File.separator+"PRAYERS";
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

	/** Get a list of all files in the prayers
	 * @return a list of prayer paths
	 */
	public static String[] getListOfPrayers() {
		return listFilesInDir(PRAYERS);
	}
	/** Get a list of all files in the stupas
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
}
