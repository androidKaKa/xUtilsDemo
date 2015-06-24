package dim.proj.xutilsdemo.db;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Finder;
import com.lidroid.xutils.db.annotation.Table;
import com.lidroid.xutils.db.sqlite.FinderLazyLoader;

@Table (name="user")
public class User {
	@Column(column="name")
     private String name="";
	@Column(column="email")
     private String Email="";
	
    @Finder(valueColumn = "id", targetColumn = "userId")
    public FinderLazyLoader<User> user; 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
     
     
}
