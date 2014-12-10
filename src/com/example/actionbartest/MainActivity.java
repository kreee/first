package com.example.actionbartest;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ShareActionProvider;

/**
 * @author Administrator
 *
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();  
	    inflater.inflate(R.menu.main, menu);  
	    MenuItem searchItem = menu.findItem(R.id.action_search);  
	    searchItem.setOnActionExpandListener(new OnActionExpandListener() {  
	        @Override  
	        public boolean onMenuItemActionExpand(MenuItem item) {  
	            Log.d("TAG", "on expand");  
	            return true;  
	        }  
	          
	        @Override  
	        public boolean onMenuItemActionCollapse(MenuItem item) {  
	            Log.d("TAG", "on collapse");  
	            return true;  
	        }  
	    });
	    MenuItem shareItem = menu.findItem(R.id.action_share); 
	    ShareActionProvider provider = (ShareActionProvider) shareItem.getActionProvider();  
	    provider.setShareIntent(getDefaultIntent());  

	    return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
	
	//share
	private Intent getDefaultIntent() {  
	    Intent intent = new Intent(Intent.ACTION_SEND);  
	    intent.setType("image/*");  
	    return intent;  
	}
}
