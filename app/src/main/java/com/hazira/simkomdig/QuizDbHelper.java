package com.hazira.simkomdig;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.hazira.simkomdig.QuizContract.*;

import java.util.ArrayList;

public class QuizDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "QuizDBAwesome.db";
    private static final int DATABASE_VERSION = 6;


    private static QuizDbHelper instance;

    private SQLiteDatabase db;


    public QuizDbHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /* used to access from multiple thread*/
//    public static synchronized QuizDbHelper getInstance(Context context) {
//        if (instance == null) {
//            instance = new QuizDbHelper(context.getApplicationContext());
//        }
//        return instance;
//    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER," +
                QuestionsTable.COLUMN_KD_QUIZ + " INTEGER )";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    private void fillQuestionsTable() {
        Question q1 = new Question("Program pengolah kata pada microsoft windows adalah....","MS-Excel","MS-Access","MS-Word","MS-Power Point",3,1);addQuestion(q1);
        Question q2 = new Question("Untuk membuka program Microsoft Office dengan menu shortcut secara cepat maka digunakan alat bantu ?","Keyboard","Mouse","Disket","Monitor",1,1);addQuestion(q2);
        Question q3 = new Question("Berikut ini manakah yang bukan merupakan program Microsoft Office","MS-Excel","MS-Access","MS-Word","Corel Draw",4,1);addQuestion(q3);
        Question q4 = new Question("Shortcut untuk untuk mengatur paragraf agar berada ditengah dokumen adalah?","Ctrl+D","Ctrl+E","Ctrl+F","Ctrl+G",2,1);addQuestion(q4);
        Question q5 = new Question("Fitur yang digunakan untuk mengatur tata letak dokumen adalah?","Page Layout","Page Size","Paper Size","Document layout",1,1);addQuestion(q5);
        Question q6 = new Question("Untuk mengatur jarak pengetikan dari pinggir kertas digunakan?","Gutter","Margins","Paper Hang","Typing Area",2,1);addQuestion(q6);
        Question q7 = new Question("Fitur untuk menebalkan huruf adalah","Underline","Italic","Strikethrough","Bold",4,1);addQuestion(q7);
        Question q8 = new Question("Fitur yang berhubungan dengan huruf adalah","Page Layout","Typeface","Font","Margins",3,1);addQuestion(q8);
        Question q9 = new Question("Shortcut untuk untuk memberi garis bawah pada tulisan adalah","Ctrl+U","Ctrl+B","Ctrl+I","Ctrl+G",1,1);addQuestion(q9);
        Question q10 = new Question("Pengaturan paragraf rata kiri digunakan","Align Center","Align Right","Align Right","Justify",2,1);addQuestion(q10);
        Question q11 = new Question("Untuk merinci uraian yang berurutan digunakan?","Bullet","Numbering","Bullet and Numbering","Icon",2,1);addQuestion(q11);
        Question q12 = new Question("Untuk mencari kata atau kalimat maka digunakan","Replace","Search","Explore","Find",4,1);addQuestion(q12);
        Question q13 = new Question("Untuk mengganti kata atau kalimat digunakan fitur","Replace","Find and Replace","Replace","Override",2,1);addQuestion(q13);
        Question q14 = new Question("Fitur yang digunakan agar tulisan menjorok adalah","Hanging","Tab","Indentasi","Text Delay",3,1);addQuestion(q14);
        Question q15 = new Question("Mengatur agar paragraf menjorok ke kanan digunakan","Hanging Right","Tab Right","Right Indent","Delay Right",3,1);addQuestion(q15);
        Question q16 = new Question("Fitur untuk membuat daftar isi otomatis pada Microsoft Word adalah","Table of Content","List of Content","Content Listing","Table of pages",1,1);addQuestion(q16);
        Question q17 = new Question("Untuk menjaga konstistensi jenis font, ukuran, dan pengatauran spasi maka fitur yg digunakan adalah","Header","Footer","Heading","Styles",4,1);addQuestion(q17);
        Question q18 = new Question("Untuk mengkases fitur daftar isi otomatis maka menu yang diakses adalah","Layout","View","References","Mailing",3,1);addQuestion(q18);
        Question q19 = new Question("Untuk mengatur posisi kertas (Horizontal/Vertikal) maka fitur yg digunakan","Orientation","Margins","Section Break","Gutter",1,1);addQuestion(q19);
        Question q20 = new Question("Format dokumen berikut yang tidak bisa dibuat menggukan excel adalah",".docx",".xlsx",".xml",".html",1,2);addQuestion(q20);
        Question q21 = new Question("Untuk menyimpan dokumen yang sedang dibuka dengan nama baru maka digunakan fitur...","Save","Share","Save as","Share as",3,1);addQuestion(q21);
        Question q22 = new Question("Penulisan formula sederhana dibawah ini yang benar adalah ...","=A1*A2","A1+A2=","= A1:A2","A1/A2=",1,1);addQuestion(q22);
        Question q23 = new Question("Buku digital yang ada beredar saat ini jumlahnya sangat banyak dan terdapat beberapa jenis format buku digital yang biasa digunakan oleh masyarakat. Berikut ini yang bukan jenis format buku digital adalah ....","EPUB","PDF","JAVA","AZW",3,1);addQuestion(q23);
        Question q24 = new Question("Pembuatan buku digital epub menggunakan beberapa aplikasi untuk mendukungnya. Contoh aplikasi yang digunakan sebagai ePub editor adalah ....","Ms Office","Sigil","Calibre","Photoshop",2,1);addQuestion(q24);
        Question q25 = new Question("Pembuatan buku digital dengan format epub memiliki keunggulan dapat memasukan file video. Format file video yang dapat langsung digunakan dalam proses tersebut adalah ....","MKV","AVI","FLV","MP4",4,1);addQuestion(q25);
        Question q25 = new Question("Sebuah informasi yang digunakan untuk mendeskripsikan Judul, Nama Pengarang, Tahun Penerbitan pada file buku digital epub terdapat pada .... ","Metadata","Daftar Isi","Index","Properties",1,1);addQuestion(q26);
    }

    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        cv.put(QuestionsTable.COLUMN_KD_QUIZ, question.getQuizKDID());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);

    }

    /* this method only used if you want to retrieve the entire questions*/
    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setQuizKDID(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_KD_QUIZ)));
                questionList.add(question);

            }
            while (c.moveToNext());

        }
        c.close();
        return questionList;
    }

    public ArrayList<Question> getQuestions(int quizKDID) {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();

        String qKDId = String.valueOf(quizKDID);
        String[] selectionArgs = new String[]{qKDId};

        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME+
                " WHERE " + QuestionsTable.COLUMN_KD_QUIZ + " = ?", selectionArgs);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setQuizKDID(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_KD_QUIZ)));
                questionList.add(question);

            }
            while (c.moveToNext());

        }else{
            Question question = new Question();
            question.setQuestion("Empty");
            question.setOption1("Empty");
            question.setOption2("Empty");
            question.setOption3("Empty");
            question.setOption4("4 Empty");
            question.setAnswerNr(1);
            question.setQuizKDID(quizKDID);
            questionList.add(question);
        }
        c.close();
        return questionList;
    }
}
