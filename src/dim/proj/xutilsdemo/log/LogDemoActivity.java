package dim.proj.xutilsdemo.log;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;

import dim.proj.xutilsdemo.R;

import android.app.Activity;
import android.os.Bundle;

@ContentView(R.layout.log_demo)
public class LogDemoActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ViewUtils.inject(this);
	}
}
