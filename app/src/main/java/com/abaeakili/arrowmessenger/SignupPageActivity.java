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



public class SignupPageActivity extends Activity {

	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private TextView username_textview;
	private EditText username_edittext;
	private TextView password_textview;
	private EditText password_edittext;
	private Button signup_button;



	private SharedPreferences file;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup_page);
		initialize();
		initializeLogic();
	}

	private void  initialize() {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		username_textview = (TextView) findViewById(R.id.username_textview);
		username_edittext = (EditText) findViewById(R.id.username_edittext);
		password_textview = (TextView) findViewById(R.id.password_textview);
		password_edittext = (EditText) findViewById(R.id.password_edittext);
		signup_button = (Button) findViewById(R.id.signup_button);

		file = getSharedPreferences("userInformation", Activity.MODE_PRIVATE);

		signup_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				if ((0 < username_edittext.getText().toString().length()) && (0 < password_edittext.getText().toString().length())) {
					file.edit().putString(username_edittext.getText().toString(), password_edittext.getText().toString()).commit();
					showMessage("Sign up complete!");
					finish();
				}
				else {
					showMessage("Username or password required!");
				}
			}
		});

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
