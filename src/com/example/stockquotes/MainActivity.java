package com.example.stockquotes;

import java.util.Arrays;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

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
		if (symbolToAdd != null){
			
			// Enter the new stock in sorted order into the array
			insertStockInScrollView (newStockSymbol, Arrays.binarySearch(stocks, newStockSymbol));
			
		}else{
			
			// Display saved stocks list
			for (int i = 0; i < stocks.length; i++){
				
				insertStockInScrollView(stocks[i], i);
				
			}
			
		}
		
	}
	
	private void saveStockSymbol(String newStock){
		
		//Check if new stock
		String isTheStockNew = stockSymbolsEntered.getString(newStock, null);
		SharedPreferences.Editor preferencesEditor = stockSymbolsEntered.edit();
		preferencesEditor.putString(newStock, newStock);
		preferencesEditor.apply();
		
		if (isTheStockNew == null){
			updateSavedStockList(newStock);
		}
		
	}
	
	private void insertStockInScrollView (String stock, int arrayIndex){
		
		//Get layoutInflator
		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
		
		//Use the inflater to inflate a stockrow
		View newStockRow = inflater.inflate(R.layout.stock_quote_row, null);
		
		//Make Text View
		TextView newStockTextView = (TextView) newStockRow.findViewById(R.id.stockSymbolTextView);
		
		//Add the stockSymbol to the textview
		newStockTextView.setText(stock);
		
		Button stockQuoteButton = (Button) newStockRow.findViewById(R.id.stockQuoteButton);
		stockQuoteButton.setOnClickListener(getStockActivityListener);
		
		Button quoteFromWebButton = (Button) newStockRow.findViewById (R.id.quoteFromWebButton);
		quoteFromWebButton.setOnClickListener(getStockFromWebsiteListener);
		
		//Add the new component in the tablelayout
		stockTableScrollView.addView(newStockRow, arrayIndex);
		
	}
	
	public OnClickListener enterStockButtonListener = new OnClickListener () {
		
		@Override
		public void onClick(DialogInterface dialog, int which) {
			
			//Check if the stock symbol is provided
			if (stockSymbolEditText.getText().length() > 0){
				
				saveStockSymbol (stockSymbolEditText.getText().toString());
				stockSymbolEditText.setText("");
				//Force keyboard to close:
				InputMethodManager imm = (InputMethodManager) getSystemService (Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(stockSymbolEditText.getWindowToken(), 0);
				
			}else{
				
				//If the editText is empty show alert dialog box
				
				//Create the dialog box
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				
				//Set Alert Title
				builder.setTitle(R.string.invalid_stock_symbol);
				
				//Set value of positive reaction from user
				builder.setPositiveButton(R.string.ok, null);
				builder.setMessage(R.string.missing_stock_symbol);
				AlertDialog theAlertDialog = builder.create();
				theAlertDialog.show();
				
			}
			
		}
		
	};
	
	public void deleteAllStocks() {
		
		//delete from table layout
		stockTableScrollView.removeAllViews();
		
	}
	
	public OnClickListener deleteStocksButtonListener = new OnClickListener (){

		@Override
		public void onClick(View v) {
			
			
			
		}
		
	};
	
	public OnClickListener getStockFromWebsiteListener = new OnClickListener (){

		@Override
		public void onClick(DialogInterface dialog, int which) {
		
			
			
		}
		
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
