package waggoner.walkingbuddha.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import android.util.Log;
import com.google.gson.Gson;
import waggoner.walkingbuddha.domain.Prayer;
import waggoner.walkingbuddha.domain.Stupa;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by transapps on 7/7/14.
 */
public class Utils {
	public static String SD_CARD_LOC = Environment.getExternalStorageDirectory().getAbsolutePath();
	public static String WALKING_BUDDHA_LOC = SD_CARD_LOC+File.separator+"WalkingBuddha";
	public static String STUPAS = WALKING_BUDDHA_LOC+File.separator+ "/stupas";
	public static String PRAYERS = WALKING_BUDDHA_LOC+File.separator+ "/prayers";
	public static String FONTS = WALKING_BUDDHA_LOC+File.separator+ "/fonts";
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
			try {
				prayers.add(loadPrayerFromFile(s,gson));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return prayers.toArray(new Prayer[prayers.size()]);
	}
	public static Stupa[] getStupas() {
		Gson gson = new Gson();
		ArrayList<Stupa> stupas = new ArrayList<Stupa>();
		for(String s:getListOfPrayers()) {
			try {
				stupas.add(loadStupaFromFile(s,gson));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return stupas.toArray(new Stupa[stupas.size()]);
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

//	public static void copyAssets(Context ctx) {
//		setUpFiles();
//		AssetManager assetManager = ctx.getAssets();
//		copyFilesFromStupas(assetManager);
//		copyFilesFromPrayes(assetManager);
//		copyFilesFromFonts(assetManager);
//	}
//
//	private static void copyFilesFromFonts(AssetManager am) {
//		copyFromAssetsTo("WalkingBuddha.fonts",FONTS,am);
//
//	}
//
//	private static void copyFilesFromPrayes(AssetManager am) {
//		copyFromAssetsTo("WalkingBuddha.prayers",PRAYERS,am);
//	}
//
//	private static void copyFilesFromStupas(AssetManager am) {
//		copyFromAssetsTo("WalkingBuddha.stupas",STUPAS,am);
//	}
//
//	private static void copyFromAssetsTo(String from, String to, AssetManager assetManager) {
//		String[] files = null;
//		try {
//			files = assetManager.list(from);
//		} catch (IOException e) {
//			Log.e("tag", "Failed to get asset file list.", e);
//		}
//		for(String filename : files) {
//			InputStream in = null;
//			OutputStream out = null;
//			try {
//				in = assetManager.open(filename);
//				File outFile = new File(WALKING_BUDDHA_LOC, filename);
//				out = new FileOutputStream(outFile);
//				copyFile(in, out);
//				in.close();
//				in = null;
//				out.flush();
//				out.close();
//				out = null;
//			} catch(IOException e) {
//				Log.e("tag", "Failed to copy asset file: " + filename, e);
//			}
//		}
//	}
//	private static void setUpFiles() {
//		File f = new File(WALKING_BUDDHA_LOC);
//		f.mkdirs();
//		f = new File(STUPAS);
//		f.mkdirs();
//		f = new File(PRAYERS);
//		f.mkdirs();
//
//	}
//
//	private static void copyFile(InputStream in, OutputStream out) throws IOException {
//		byte[] buffer = new byte[1024];
//		int read;
//		while((read = in.read(buffer)) != -1){
//			out.write(buffer, 0, read);
//		}
//	}

}
