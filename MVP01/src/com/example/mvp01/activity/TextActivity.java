package com.example.mvp01.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mvp01.R;
import com.example.mvp01.base.MVPBaseActivity;
import com.example.mvp01.minterface.ViewInterface;
import com.example.mvp01.presenter.TextManager;


public class TextActivity extends MVPBaseActivity<ViewInterface, TextManager> implements ViewInterface  {

	
	private TextView textView;
	private TextManager manager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_text);
		textView = (TextView) findViewById(R.id.text_id);
	}
	
	
	@Override
	protected void initView() {
		String url = "http://www.baidu.com";
		showLoading();
		manager.getDataFormWebToGet(url);
	}

	@Override
	protected TextManager createManager() {
		if (manager == null ) {
			manager = new TextManager(this);
		}
		return manager;
	}



	@Override
	public void showView(Object o) {
		cancleLoading();
		String text = (String) o;
		textView.setText(text);
		
	}
	
	public static Intent newIntent(Context context){
		Intent intent = new Intent();
		intent.setClass(context, TextActivity.class);
		return intent;
	}


}
