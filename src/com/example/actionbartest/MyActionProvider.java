package com.example.actionbartest;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

public class MyActionProvider extends ActionProvider {

	public MyActionProvider(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View onCreateActionView() {
		// TODO Auto-generated method stub
		return null;
	}
    @Override  
    public void onPrepareSubMenu(SubMenu subMenu) {  
        subMenu.clear();  
        subMenu.add("类别 1").setIcon(R.drawable.ic_action_search)  
                .setOnMenuItemClickListener(new OnMenuItemClickListener() {  
                    @Override  
                    public boolean onMenuItemClick(MenuItem item) {  
                        return true;  
                    }  
                });  
        subMenu.add("类别 2").setIcon(R.drawable.ic_launcher)  
                .setOnMenuItemClickListener(new OnMenuItemClickListener() {  
                    @Override  
                    public boolean onMenuItemClick(MenuItem item) {  
                        return false;  
                    }  
                });
        subMenu.add("类别 3").setIcon(R.drawable.ic_action_share)  
		        .setOnMenuItemClickListener(new OnMenuItemClickListener() {  
		            @Override  
		            public boolean onMenuItemClick(MenuItem item) {  
		                return false;  
		            }  
		        }); 
    }  
  
    @Override  
    public boolean hasSubMenu() {  
        return true;  
    }  
}
