package com.example.mvp01.presenter;

import com.example.mvp01.base.BaseManager;
import com.example.mvp01.minterface.ViewInterface;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

public class TextManager extends BaseManager<ViewInterface> {
	
	private ViewInterface viewInterface ;
	private HttpUtils httpUtils ;

	public TextManager(ViewInterface view){
		viewInterface = view ;
		httpUtils = new HttpUtils();
		httpUtils.configCurrentHttpCacheExpiry(0);
	}
	
	
	public void getDataFormWebToGet(String url){
		httpUtils.send(HttpMethod.GET, url,new RequestCallBack(){

			@Override
			public void onSuccess(ResponseInfo responseInfo) {
				viewInterface.showView(responseInfo.result);
				
			}

			@Override
			public void onFailure(HttpException error, String msg) {
				viewInterface.showView("错误");
			}
			
		});
		
	}
	
}
