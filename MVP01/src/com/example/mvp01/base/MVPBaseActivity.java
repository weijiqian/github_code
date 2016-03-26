package com.example.mvp01.base;

import com.example.mvp01.minterface.ViewInterface;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

/**
 * @author Administrator
 * 2016-3-26
 */
public abstract class MVPBaseActivity<V,T extends BaseManager<V>> extends Activity {
	
	protected T mmanager ;
	private boolean isFirst  = true ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mmanager = createManager();
		mmanager.attachView((V)this);
	}
	
	
	@Override
	protected void onStart() {
		super.onStart();
		if (isFirst) {
			initView();
			isFirst = false;
		}
		
	}
	
	protected abstract void initView();
	
	/**
	 * 弹出Toast
	 * 
	 * @param str
	 *            字符串
	 */
	public void showToast(String str) {
		Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
	}

	/**
	 * 弹出Toast
	 * 
	 * @param resId
	 *            资源ID
	 */
	public void showToast(int resId) {
		Toast.makeText(getApplicationContext(), resId, Toast.LENGTH_LONG)
				.show();
	}

	public void showLoading(){
		showToast("加载对话框");
	}
	
	public void cancleLoading(){
		showToast("取消对话框");
	}
	
	@Override
	protected void onDestroy() {
		
		super.onDestroy();
		mmanager.detachView();
	}
	
	
	
	protected abstract T createManager();
	
}
