package dim.proj.xutilsdemo.utils;

import java.io.File;
import java.util.ArrayList;
import android.util.Log;
public class PicFiles {
	public String TAG = "GetSDTreeActivity";
	public static String sdRootPath = "/mnt/sdcard/DCIM/Camera/"; 
	ArrayList<String> picFilesArray=new ArrayList<String>();
	public static String[] picType=new String[]{"jpg","png"};
	// 存放当前路径下的所有文件及文件夹
	public static File[] datas;
	// 匹配图标时用到的文件类型
	String[] fileTypes = new String[] { "apk", "avi", "bat", "bin", "bmp",
			"chm", "css", "dat", "dll", "doc", "docx", "dos", "dvd", "gif",
			"html", "ifo", "inf", "iso", "ja va", "jpeg", "jpg", "log", "m4a",
			"mid", "mov", "movie", "mp2", "mp2v", "mp3", "mp4", "mpe", "mpeg",
			"mpg", "pdf", "php", "png", "ppt", "pptx", "psd", "rar", "tif",
			"ttf", "txt", "wav", "wma", "wmv", "xls", "xlsx", "xml", "xsl",
			"zip" };
	// 根目录
	File sdRoot;
	/**
	 * 
	 * @param path :the path of picture you want to load.
	 */
	public PicFiles(String path)
	{
		//sdRoot = new File(sdRootPath);
		sdRoot = new File(path);
		if (sdRoot.exists()) {
			try {
				loadFiles(sdRoot);
			} catch (Exception e) {
				// TODO: handle exception
				Log.e(TAG, "root file is wrong!");
			}
		
		}
	 
	}
	
	public  ArrayList<String> getPicNameArray()
	{
	 
		return picFilesArray;
	}
	/** 加载当前路径的所有文件 */
	public void loadFiles(File directory)
	{ 
		// 分类并排序
		File[] temp = directory.listFiles();
		ArrayList<File> tempFolder = new ArrayList<File>();
		for (int i = 0; i < temp.length; i++) {
			File file = temp[i];
			if (file.isDirectory()) {
				tempFolder.add(file);
			} else if (file.isFile()) {
				String picTypeName = file.getName();
				
				String typeString = picTypeName.substring(picTypeName.length()-3,
						picTypeName.length());
				Log.d(TAG, "   "+typeString);
				if(typeString.equals(picType[0])||typeString.equals(picType[1])){
					picFilesArray.add(picTypeName);
				//Log.i(TAG, picTypeName);
					
				}
			}
		} 
		// 数据处理结束 =========================================
	
	
	}
}
