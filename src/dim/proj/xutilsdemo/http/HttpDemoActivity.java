package dim.proj.xutilsdemo.http;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;

import dim.proj.xutilsdemo.R;

import android.app.Activity;
import android.os.Bundle;

@ContentView(R.layout.http_demo)
public class HttpDemoActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);
	}
}
