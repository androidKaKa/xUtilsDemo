package dim.proj.xutilsdemo.db;

import java.util.List;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.DbException;
import com.lidroid.xutils.view.annotation.ContentView;

import dim.proj.xutilsdemo.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

@ContentView(R.layout.db_demo)
public class DbDemoActivity extends Activity{
	private String TAG="dbUtils-->>";
@Override
protected void onCreate(Bundle savedInstanceState) {

	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	ViewUtils.inject(this);
	DbUtils db=DbUtils.create(this); 
    db.configAllowTransaction(true);
    db.configDebug(true);

	User userOne=new User();
    User userTwo=new User();
	
	try {
		userOne.setEmail("dim@phlin.com");
		db.save(userOne);
		
		userTwo.setEmail("test@t.com");
		db.save(userTwo);
	} catch (DbException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		List<User> list = db.findAll(User.class);
		list.get(0).getEmail();
		Log.e(TAG, list.get(0).getEmail());
		Log.e(TAG, list.get(1).getEmail());
	} catch (DbException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
