package com.example.mvp01.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

import android.view.View;

public abstract class BaseManager<T> {
	/**
	 * @author Administrator
	 * 2016-3-26
	 */
	protected Reference<T> viewReference; //view的弱应用
	
	/**
	 * 与view建立联系
	 * @author Administrator
	 * 2016-3-26
	 */
	public void attachView(T view){
		viewReference = new WeakReference<T>(view);
	}
	
	/**
	 * 获得View
	 * @author Administrator
	 * 2016-3-26
	 */
	protected T getView(){
		return viewReference.get();
	}
	
	/**
	 * 判断是否与view联系
	 * @author Administrator
	 * 2016-3-26
	 */
	public boolean isViewAttache(){
		return viewReference != null && viewReference.get() != null ;
	}
	
	/**
	 * 取消与view的联系.
	 * @author Administrator
	 * 2016-3-26
	 */
	public void detachView(){
		if (viewReference != null ) {
			viewReference.clear();
			viewReference = null ;
		}
	}
	
}
