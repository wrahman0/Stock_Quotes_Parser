package com.example.stockquotes;

import java.util.Arrays;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;

public class MainActivity extends Activity {

	
	public final static String STOCK_SYMBOL = "com.example.stockquote.STOCK";
	private SharedPreferences stockSymbolsEntered;
	private TableLayout stockTableScrollView;
	private EditText stockSymbolEditText;
	
	Button enterStockSymbolButton;
	Button deleteStocksButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Retrieve Saved Stocks
		stockSymbolsEntered = getSharedPreferences("stockList", MODE_PRIVATE);
		
		//Setup the rest of the variables
		stockTableScrollView = (TableLayout) findViewById(R.id.stockTableScrollView);
		stockSymbolEditText = (EditText) findViewById (R.id.stockSymbolEditText);
		enterStockSymbolButton = (Button) findViewById (R.id.enterStockSymbolButton);
		deleteStocksButton = (Button) findViewById (R.id.deleteStocksButton);
		
		//Click Listeners to the buttons
		enterStockSymbolButton.setOnClickListener(enterStockButtonListener);
		deleteStocksButton.setOnClickListener(deleteStocksButtonListener);
		
		//Add saved stocks to the ScrollView
		updateSavedStockList(null);
		
		
	}
	
	//Add new stock or update with saved stocks if null is passed through
	private void updateSavedStockList(String symbolToAdd){
		
		//Get the saved stocks
		String[] stocks = stockSymbolsEntered.getAll().keySet().toArray(new String[0]);
		Arrays.sort(stocks, String.CASE_INSENSITIVE_ORDER);
		
		//update
		if (symbolToAdd == null){
			
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
