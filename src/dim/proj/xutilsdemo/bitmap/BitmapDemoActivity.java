package dim.proj.xutilsdemo.bitmap;

import java.util.ArrayList;
import java.util.List;

import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.bitmap.BitmapCommonUtils; 
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.bitmap.callback.BitmapLoadFrom;
import com.lidroid.xutils.bitmap.callback.DefaultBitmapLoadCallBack;
import com.lidroid.xutils.view.annotation.ContentView;  
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnItemClick;

import dim.proj.xutilsdemo.R;
import dim.proj.xutilsdemo.utils.BitmapHelp;
import dim.proj.xutilsdemo.utils.PicFiles;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
@ContentView(R.layout.bitmap)

public class BitmapDemoActivity extends Activity{
	
	private static String TAG="BitmapDemoActivity--->>";
	public static BitmapUtils bitmapUtils;
	private String path="/mnt/sdcard/DCIM/Camera/";
	public PicFiles pf=null;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	 ViewUtils.inject(this); 

     bitmapUtils = BitmapHelp.getBitmapUtils(BitmapDemoActivity.this.getApplicationContext());
     bitmapUtils.configDefaultLoadingImage(R.drawable.ic_launcher);
     bitmapUtils.configDefaultLoadFailedImage(R.drawable.ic_launcher);
     bitmapUtils.configDefaultBitmapConfig(Bitmap.Config.RGB_565);
     bitmapUtils.configDefaultBitmapMaxSize(BitmapCommonUtils.getScreenSize(BitmapDemoActivity.this).scaleDown(3));
     pf=new PicFiles(path);
     imageListAdapter = new ImageListAdapter( (this));
     for(int i=0;i<pf.getPicNameArray().size();i++)
     {
    	 imageListAdapter.imgSrcList.add(path+pf.getPicNameArray().get(i));
    	 Log.i(TAG, path+pf.getPicNameArray().get(i));
    	 if(i>100)break;
     }
//     for(int i=0;i<100;i++)
//     {
//     	  if(i%2==0)
//     	  {
//       imageListAdapter.imgSrcList.add("http://www.sinaimg.cn/dy/slidenews/4_img/2015_12/704_1579346_230297.jpg");
//     	  }else{
//       imageListAdapter.imgSrcList.add("/mnt/sdcard/DCIM/Camera/1.jpg");
//     	  }
//     	  }
     imageListView.setAdapter(imageListAdapter); 
	 
}

@OnItemClick(R.id.img_list)
public void onImageItemClick(AdapterView<?> parent, View view, int position, long id) { 
}
 
@ViewInject(R.id.img_list)
private ListView imageListView;
private ImageListAdapter imageListAdapter;
private class ImageListAdapter extends BaseAdapter {

    private Context mContext;
    private final LayoutInflater mInflater;
    private ArrayList<String> imgSrcList;

    public ImageListAdapter(Context context) {
        super();
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
        imgSrcList = new ArrayList<String>();
    }

    public void addSrc(List<String> imgSrcList) {
        this.imgSrcList.addAll(imgSrcList);
    }

    public void addSrc(String imgUrl) {
        this.imgSrcList.add(imgUrl);
    }

    @Override
    public int getCount() {
        return imgSrcList.size();
    }

    @Override
    public Object getItem(int position) {
        return imgSrcList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        ImageItemHolder holder = null;
        if (view == null) {
            view = mInflater.inflate(R.layout.bitmap_item, null);
            holder = new ImageItemHolder();
            ViewUtils.inject(holder, view);
            view.setTag(holder);
        } else {
            holder = (ImageItemHolder) view.getTag();
        }
        holder.imgPb.setProgress(0);
       //bitmapUtils.display(holder.imgItem, imgSrcList.get(position), new CustomBitmapLoadCallBack(holder)); 
        bitmapUtils.display(holder.imgItem, imgSrcList.get(position));
        return view;
    }
}

private class ImageItemHolder {
    @ViewInject(R.id.img_item)
    private ImageView imgItem;

    @ViewInject(R.id.img_pb)
    private ProgressBar imgPb;
}

public class CustomBitmapLoadCallBack extends DefaultBitmapLoadCallBack<ImageView> {
    private final ImageItemHolder holder;

    public CustomBitmapLoadCallBack(ImageItemHolder holder) {
        this.holder = holder;
    }

    @Override
    public void onLoading(ImageView container, String uri, BitmapDisplayConfig config, long total, long current) {
        this.holder.imgPb.setProgress((int) (current * 100 / total));
    }

    @Override
    public void onLoadCompleted(ImageView container, String uri, Bitmap bitmap, BitmapDisplayConfig config, BitmapLoadFrom from) {
        //super.onLoadCompleted(container, uri, bitmap, config, from);
        fadeInDisplay(container, bitmap);
        this.holder.imgPb.setProgress(100);
    }
}

private static final ColorDrawable TRANSPARENT_DRAWABLE = new ColorDrawable(android.R.color.transparent);

private void fadeInDisplay(ImageView imageView, Bitmap bitmap) {
    final TransitionDrawable transitionDrawable =
            new TransitionDrawable(new Drawable[]{
                    TRANSPARENT_DRAWABLE,
                    new BitmapDrawable(imageView.getResources(), bitmap)
            });
    imageView.setImageDrawable(transitionDrawable);
    transitionDrawable.startTransition(500);
}

 public void loadFiles()
 {
	 
 }
}
