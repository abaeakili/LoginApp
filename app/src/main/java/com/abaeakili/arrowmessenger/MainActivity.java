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



public class MainActivity extends Activity {

	private LinearLayout username_linear;
	private LinearLayout linear2;
	private LinearLayout buttons_linear;
	private TextView username_textview;
	private EditText username_edittext;
	private TextView password_textview;
	private EditText password_edittext;
	private Button login_button;
	private Button signup_button;



	private SharedPreferences file;
	private Intent setScreen = new Intent();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initialize();
		initializeLogic();
	}

	private void  initialize() {
		username_linear = (LinearLayout) findViewById(R.id.username_linear);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		buttons_linear = (LinearLayout) findViewById(R.id.buttons_linear);
		username_textview = (TextView) findViewById(R.id.username_textview);
		username_edittext = (EditText) findViewById(R.id.username_edittext);
		password_textview = (TextView) findViewById(R.id.password_textview);
		password_edittext = (EditText) findViewById(R.id.password_edittext);
		login_button = (Button) findViewById(R.id.login_button);
		signup_button = (Button) findViewById(R.id.signup_button);

		file = getSharedPreferences("userInformation", Activity.MODE_PRIVATE);


		login_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				if ((0 < username_edittext.getText().toString().length()) && (0 < password_edittext.getText().toString().length())) {
					if (file.getString(username_edittext.getText().toString(), "").equals(password_edittext.getText().toString())) {
						setScreen.setClass(getApplicationContext(), LoggedinPageActivity.class);
						startActivity(setScreen);
					}
					else {
						showMessage("Login failed!");
					}
				}
				else {
					showMessage("Username or Password required!");
				}
			}
		});
		signup_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) { 
				setScreen.setClass(getApplicationContext(), SignupPageActivity.class);
				startActivity(setScreen);

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
