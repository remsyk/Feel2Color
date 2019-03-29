package com.example.i77ki.feel2color_test1;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
	final MainActivity c = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		FloatingActionButton fab = findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
				View mView = layoutInflaterAndroid.inflate(R.layout.dialog_box, null);
				AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
				alertDialogBuilderUserInput.setView(mView);

				final EditText userInputDialogEditText = mView.findViewById(R.id.userInputDialog);
				userInputDialogEditText.setHorizontallyScrolling(false);

				alertDialogBuilderUserInput.setCancelable(false).setPositiveButton("Submit", new DialogInterface.OnClickListener() {
					@RequiresApi(api = Build.VERSION_CODES.O)
					public void onClick(DialogInterface dialogBox, int id) {//sets up submit button and the actions that need to happen from it being pushed
						 if(userInputDialogEditText.getText().toString().length()==0){
							 Toast.makeText(c, "No Entry Created!", Toast.LENGTH_SHORT).show();
						 }else {
						 	String entry = userInputDialogEditText.getText().toString();

							 addBtn(String2Color.wordColor(entry, entry.length()));
						 }
					}
				})
						.setNegativeButton("Cancel",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialogBox, int id) {
										dialogBox.cancel();
									}
								});

				AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
				alertDialogAndroid.show();			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	public void addBtn(int btnColor){

		RadioButton myButton = new RadioButton(this);

		GridLayout ll = findViewById(R.id.test);
		GridLayout.LayoutParams lp = new GridLayout.LayoutParams();
		myButton.setBackgroundColor(btnColor);

		ll.addView(myButton, lp);
	}

}
