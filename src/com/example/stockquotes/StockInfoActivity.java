package com.example.stockquotes;

import android.widget.TextView;

public class StockInfoActivity {
	
	private static final String TAG = "STOCKQUOTE";
	
	TextView companyNameTextView;
	TextView yearLowTextView;
	TextView yearHighTextView;
	TextView daysLowTextView;
	TextView daysHighTextView;
	TextView lastTradePriceOnlyTextView;
	TextView changeTextTextView;
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
}
