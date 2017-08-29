package com.abaeakili.arrowmessenger;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.ClipboardManager;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import java.util.*;
import java.text.*;



public class LoggedinPageActivity extends Activity {

	private LinearLayout welcome_linear;
	private LinearLayout linear1;
	private TextView welcome_textview;
	private TextView textview1;



	private Intent Web = new Intent();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loggedin_page);
		initialize();
		initializeLogic();
	}

	private void  initialize() {
		welcome_linear = (LinearLayout) findViewById(R.id.welcome_linear);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		welcome_textview = (TextView) findViewById(R.id.welcome_textview);
		textview1 = (TextView) findViewById(R.id.textview1);




	}

	private void  initializeLogic() {

	}




	// created automatically
	private void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}

	private int getRandom(int _minValue ,int _maxValue){
		Random random = new Random();
		return random.nextInt(_maxValue - _minValue + 1) + _minValue;
	}

	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
				_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}

}
