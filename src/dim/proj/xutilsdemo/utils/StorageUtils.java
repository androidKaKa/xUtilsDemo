package dim.proj.xutilsdemo.utils;

import java.io.File;

import android.os.Environment;
import android.util.Log;

public class StorageUtils {
	public static String CONFIG_FILE_NAME = "INFRARED_CONFIGTION_FILE";
	
	/** 全局性的判断SD卡是否存在的变量*/
	private static boolean hasSDCard;
	public StorageUtils(){
		
	}
	
	public static String getMediaFileDefaultPath(){
	    File sysFile ;
		String mStorePath ;
		sysFile = new File(Environment.getExternalStorageDirectory()+"/external_sdcard","SaTir");
		if (!sysFile.exists()) {
			if (!sysFile.mkdirs()) {
				Log.d("Sys", "failed to create directory");
				return null;
			}
		}
		mStorePath = sysFile.getPath() + File.separator ;
		return mStorePath;
	}
	
	 
	/**
	 * 输入绝对路径+文件名 判断是否存在
	 * @param filePath
	 * @return
	 */
	public static boolean isFileExisit(String filePath) {
		// File file=new File("/data/data/com.car/shared_prefs/nari.xml");
		File file = new File(filePath);
		if (!file.exists()) {
			return false;
		} else {
			return true;
		}
	}
	/**
	 * 删除系统配置文件
	 */
	public static void deleteSharePreference(){
		File file = new File("/data/data/" + "com.example.nv618interface"+"/shared_prefs/"+CONFIG_FILE_NAME + ".xml");
		File sysFile = new File("data/data/"+ "com.example.nv618interface"+"/shared_prefs/"+ "com.example.nv618interface"+"_prefenrences.xml");
		if (file.exists()) {
			file.delete();
//			Toast.makeText(InfraredSystemMainActivity.this, "删除成功",
//					Toast.LENGTH_LONG).show();
		}else 
			Log.d("Sys", "红外配置文件不存在");
		if(sysFile.exists()){
			sysFile.delete();
		}else
			Log.d("Sys", "系统配置文件不存在");
	}
	/** 检查内部SD卡是否存在*/
	public static boolean isExistSDcard(){
		if (android.os.Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED)){
			return true;
		}
		return false;
	}
	
//	/** 检查外部SD卡是否存在*/
//	public static boolean isExistExternalSDcard(){
//		File file=new File("/sdcard/external_sdcard/");
//	    if (file.exists()) {   
//	     Log.d("explorer", "SDcard is useful!");
//	     isSdcard=true;
//	     btn_sdcard.setEnabled(true);           
//	     }else {   
//	     // 当前不可用 
//	      isSdcard=false;
//	      Log.d("explorer", "SDcard is no use!");
//	      btn_sdcard.setEnabled(false); 
//	     } 
//	}
	
	
	public static boolean isHasSDCard() {
		return hasSDCard;
	}

	public static void setHasSDCard(boolean hasSDCard) {
		StorageUtils.hasSDCard = hasSDCard;
	}
}
