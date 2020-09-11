package com.hazira.simkomdig;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Quiz2Activity extends AppCompatActivity {

	private static final int REQUEST_CODE_QUIZ = 1;
//    public static final int EXTRA_QUIZ_KD_ID = 1;

	public static final String SHARED_PREFS_M1Q2 = "sharedPrefs2";
	public static final String KEY_HIGHSCORE_M1Q2 = "keyHighscore2";

//    public static final int KEY_QUIZKD = 1;

	private TextView textViewHighscore;
	private int quizKDID;
	private int highscore2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz2);

		Toolbar toolbar = findViewById(R.id.toolbar_q2);
		setSupportActionBar(toolbar);

		if (getSupportActionBar() != null) {
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
			getSupportActionBar().setDisplayShowHomeEnabled(true);
			getSupportActionBar().setTitle("Evaluasi Semester");
		}

		textViewHighscore = findViewById(R.id.materi2_quiz_1_highscore);
		loadHighscore();

		final Button buttonStartQuiz = findViewById(R.id.button_start_m2q1);
		buttonStartQuiz.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View viewM1Q1) {
				startQuiz();
			}
		});

	}

	private void startQuiz() {

		String quizKDName = "Quiz Materi Semester";
		int value = 2;
		Intent intent = new Intent(Quiz2Activity.this, M1Q1Activity.class);
		intent.putExtra("quizKDID",value);
		startActivityForResult(intent, REQUEST_CODE_QUIZ);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == REQUEST_CODE_QUIZ) {
			if (resultCode == RESULT_OK) {
				int score = data.getIntExtra(M1Q1Activity.TOTAL_SCORE_M1Q2, 0);

				if (score > highscore2) {
					updateHighscore(score);
				} else {

				}
			} else {

			}
		} else {

		}
	}

	private void loadHighscore() {
		SharedPreferences prefs = getSharedPreferences(SHARED_PREFS_M1Q2, MODE_PRIVATE);
		highscore2 = prefs.getInt(KEY_HIGHSCORE_M1Q2, 0);
		textViewHighscore.setText("Highscore: " + highscore2);
	}

	private void updateHighscore(int highscoreNew) {
		highscore2 = highscoreNew;
		textViewHighscore.setText("Highscore: " + highscore2);

		SharedPreferences prefs2 = getSharedPreferences(SHARED_PREFS_M1Q2, MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs2.edit();
		editor.putInt(KEY_HIGHSCORE_M1Q2, highscore2);
		editor.apply();

	}

	public boolean onOptionsItemSelected(MenuItem items) {
		switch (items.getItemId()) {
//            case R.id.bottom_home:
//                new AlertDialog.Builder(this)
//                        .setMessage(R.string.intro_message)
//                        .setPositiveButton(android.R.string.ok, null)
//                        .show();
//                return true;

			case android.R.id.home:
				super.onBackPressed();
				finish();
		}
		return super.onOptionsItemSelected(items);
	}

}
