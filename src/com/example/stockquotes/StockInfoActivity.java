package com.example.stockquotes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class StockInfoActivity extends Activity {
	
	private static final String TAG = "STOCKQUOTE";
	
	TextView companyNameTextView;
	TextView yearLowTextView;
	TextView yearHighTextView;
	TextView daysLowTextView;
	TextView daysHighTextView;
	TextView lastTradePriceOnlyTextView;
	TextView changeTextView;
	TextView daysRangeTextView;
	
	//Parent node for the xml file
	static final String KEY_ITEM = "quote";

	//Key nodes
	static final String KEY_NAME = "Name";
	static final String KEY_YEAR_LOW = "YearLow";
	static final String KEY_YEAR_HIGH = "YearHigh";
	static final String KEY_DAYS_LOW = "Days_Low";
	static final String KEY_DAYS_HIGH = "Days_High";
	static final String KEY_LAST_TRADE_PRICE_ONLY = "LastTradePriceOnly";
	static final String KEY_ITEM_CHANGE_TEXT = "ChangeText";
	static final String KEY_ITEM_DAYS_RANGE = "DaysRange";
	
	//Information to get
	String name = "";
	String yearLow = "";
	String yearHigh = "";
	String daysLow = "";
	String daysHigh = "";
	String lastTradePriceOnly = "";
	String change = "";
	String daysRange = "";
	
	String yahooURLFirst = "http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20yahoo.finance.quote%20where%20symbol%20in%20(%22";
	String yahooURLSecond = "%22)&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
	
	protected void OnCreate (Bundle savedInstanceState){
		
		super.onCreate(savedInstanceState);
		
		setContentView (R.layout.activity_stock_info);
		
		//Getting the passed info from other activity
		Intent intent = getIntent();
		String stockSymbol = intent.getStringExtra(MainActivity.STOCK_SYMBOL);
		
		// Initialize TextViews
		companyNameTextView = (TextView) findViewById(R.id.companyNameTextView);
		yearLowTextView = (TextView) findViewById(R.id.yearLowTextView);
		yearHighTextView = (TextView) findViewById(R.id.yearHighTextView);
		daysLowTextView = (TextView) findViewById(R.id.daysLowTextView);
		daysHighTextView = (TextView) findViewById(R.id.daysHighTextView);
		lastTradePriceOnlyTextView = (TextView) findViewById(R.id.lastTradePriceOnlyTextView);
		changeTextView = (TextView) findViewById(R.id.changeTextView);
		daysRangeTextView = (TextView) findViewById(R.id.daysRangeTextView);
		
		final String yqlURL = yahooURLFirst + stockSymbol + yahooURLSecond;
		
		
	}
	
}
