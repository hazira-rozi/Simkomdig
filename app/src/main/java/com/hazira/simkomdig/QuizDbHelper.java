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
    private static final int DATABASE_VERSION = 8;


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
        /*1. Ms Office*/
        Question q1 = new Question("Program pengolah kata pada microsoft windows adalah...","MS-Excel","MS-Access","MS-Word","MS-Power Point",3,2);addQuestion(q1);
        Question q2 = new Question("Untuk membuka program Microsoft Office dengan menu shortcut secara cepat maka digunakan alat bantu ?","Keyboard","Mouse","Disket","Monitor",1,2);addQuestion(q2);
        Question q3 = new Question("Berikut ini manakah yang bukan merupakan program Microsoft Office","MS-Excel","MS-Access","MS-Word","Corel Draw",4,2);addQuestion(q3);
        Question q4 = new Question("Shortcut untuk untuk mengatur paragraf agar berada ditengah dokumen adalah?","Ctrl+D","Ctrl+E","Ctrl+F","Ctrl+G",2,2);addQuestion(q4);
        Question q5 = new Question("Fitur yang digunakan untuk mengatur tata letak dokumen adalah?","Page Layout","Page Size","Paper Size","Document layout",1,2);addQuestion(q5);
        Question q6 = new Question("Untuk mengatur jarak pengetikan dari pinggir kertas digunakan?","Gutter","Margins","Paper Hang","Typing Area",2,1);addQuestion(q6);
        Question q7 = new Question("Fitur untuk menebalkan huruf adalah","Underline","Italic","Strikethrough","Bold",4,1);addQuestion(q7);
        Question q8 = new Question("Fitur yang berhubungan dengan huruf adalah","Page Layout","Typeface","Font","Margins",3,1);addQuestion(q8);
        Question q9 = new Question("Shortcut untuk untuk memberi garis bawah pada tulisan adalah","Ctrl+U","Ctrl+B","Ctrl+I","Ctrl+G",1,1);addQuestion(q9);
        Question q10 = new Question("Pengaturan paragraf rata kiri digunakan","Align Center","Align Left","Align Right","Justify",2,1);addQuestion(q10);
        Question q11 = new Question("Untuk merinci uraian yang berurutan digunakan?","Bullet","Numbering","Bullet and Numbering","Icon",2,1);addQuestion(q11);
        Question q12 = new Question("Untuk mencari kata atau kalimat maka digunakan","Replace","Search","Explore","Find",4,1);addQuestion(q12);
        Question q13 = new Question("Untuk mengganti kata atau kalimat digunakan fitur","Replace","Find and Replace","Replace","Override",2,1);addQuestion(q13);
        Question q14 = new Question("Fitur yang digunakan agar tulisan menjorok adalah","Hanging","Tab","Indentasi","Text Delay",3,1);addQuestion(q14);
        Question q15 = new Question("Mengatur agar paragraf menjorok ke kanan digunakan","Hanging Right","Tab Right","Right Indent","Delay Right",3,1);addQuestion(q15);
        Question q16 = new Question("Fitur untuk membuat daftar isi otomatis pada Microsoft Word adalah","Table of Content","List of Content","Content Listing","Table of pages",1,1);addQuestion(q16);
        Question q17 = new Question("Untuk menjaga konstistensi jenis font, ukuran, dan pengatauran spasi maka fitur yg digunakan adalah","Header","Footer","Heading","Styles",4,1);addQuestion(q17);
        Question q18 = new Question("Untuk mengkases fitur daftar isi otomatis maka menu yang diakses adalah","Layout","View","References","Mailing",3,1);addQuestion(q18);
        Question q19 = new Question("Untuk mengatur posisi kertas (Horizontal/Vertikal) maka fitur yg digunakan","Orientation","Margins","Section Break","Gutter",1,1);addQuestion(q19);
        Question q20 = new Question("Untuk mengatur ukuran batas kertas  maka fitur yg digunakan","Orientation","Margins","Section Break","Gutter",3,1);addQuestion(q20);
        /*2. Excel*/
        Question q21 = new Question("Format dokumen berikut yang tidak bisa dibuat menggukan excel adalah",".docx",".xlsx",".xml",".html",1,2);addQuestion(q21);
        Question q22 = new Question("Untuk menyimpan dokumen excel yang sedang dibuka dengan nama baru maka digunakan fitur...","Save","Share","Save as","Share as",3,2);addQuestion(q22);
        Question q23 = new Question("Penulisan formula sederhana dibawah ini yang benar adalah ...","=A1*A2","A1+A2=","= A1:A2","A1/A2=",1,2);addQuestion(q23);
        Question q24 = new Question("Fitur excel yang digunakan untuk menampilkan visualisasi dari data adalah","Chart","Graph","Diagram","Sketch",1,2);addQuestion(q24);
        Question q25 = new Question("Pertemuan antara kolom dan baris pada Ms. Excel disbeut dengan...","Log","Row","Box","Cell",4,2);addQuestion(q25);
        /*3. Ebook*/
        Question q26 = new Question("Buku digital yang ada beredar saat ini jumlahnya sangat banyak dan terdapat beberapa jenis format buku digital yang biasa digunakan oleh masyarakat. Berikut ini yang bukan jenis format buku digital adalah ...","EPUB","PDF","JAVA","AZW",3,2);addQuestion(q26);
        Question q27 = new Question("Pembuatan buku digital epub menggunakan beberapa aplikasi untuk mendukungnya. Contoh aplikasi yang digunakan sebagai ePub editor adalah ...","Ms Office","Sigil","Calibre","Photoshop",2,2);addQuestion(q27);
        Question q28 = new Question("Pembuatan buku digital dengan format epub memiliki keunggulan dapat memasukan file video. Format file video yang dapat langsung digunakan dalam proses tersebut adalah ...","MKV","AVI","FLV","MP4",4,2);addQuestion(q28);
        Question q29 = new Question("Sebuah informasi yang digunakan untuk mendeskripsikan Judul, Nama Pengarang, Tahun Penerbitan pada file buku digital epub terdapat pada ...","Metadata","Daftar Isi","Index","Properties",1,2);addQuestion(q29);
        Question q30 = new Question("Keunggulan ebook dibandingakan dengan buku cetak salah satunya adalah adalah ...","Murah","Lebih mudah dibaca","Penyebaran yang lebih luas","Tersedia tanpa alat tambahan",3,2);addQuestion(q30);
        /*4. Power point*/
        Question q31 = new Question("Untuk menampilkan slide presentasi juga dapat dilakukan dengan lebih cepat dengan menekan pada keyboard tombol...","F4","F5","F6","F7",2,2);addQuestion(q31);
        Question q32 = new Question("Efek Animasi yang berfungsi untuk memberikan efek penekanan pada objek adalah...","Entrance","Exit","Delay","Emphasis",4,2);addQuestion(q32);
        Question q33 = new Question("Efek untuk mengatur perpindahan slide disebut...","Transition","Shifting","Changing","Migration",1,2);addQuestion(q33);
        Question q34 = new Question("Sebuah file powerpoint dapat disimpan menjadi format berikut, kecuali",".pdf","ppt",".mp3",".mp4",2,2);addQuestion(q34);
        Question q35 = new Question("untuk menampilkan slide yang sedang dipilih ke slide show maka digunakan shortcut...","Ctrl + F5","Alt + F5","Shift + ","Tab + F5",3,2);addQuestion(q35);
        /*5. Peta Minda*/
        Question q36 = new Question("Menurut Buzan metode peta minda dapat bermanfaat untuk ..., kecuali ...","Merangsang bekerjanya otak kiri dan otak kanan secara sinergis","Membebaskan diri dari seluruh jeratan aturan ketika mengawali belajar","Membantu seseorang mengalirkan gagasan tanpa hambatan","Membuat cerita yang berkesan dan sangat menarik",4,2);addQuestion(q36);
        Question q37 = new Question("Yang tidak tepat dijadikan cabang dari topik Sepeda Motor adalah","Setir","Ban","Spion","Jok",1,2);addQuestion(q37);
        Question q38 = new Question("Salah satu cara untuk memvisualkan proses berpikir adalah dengan menggunakan ...","Algoritma","Ide","Peta Minda","Gagasan",3,2);addQuestion(q38);
        Question q39 = new Question("Yang bukan termasuk kegunaan metode peta minda antara lain sebagai berikut:"," Menemukan masalah secara urut dan rinci","Memberi pandangan menyeluruh pada permasalahan pokok","Mengumpulkan sejumlah besar data di suatu tempat","Mendorong pemecahan masalah dengan kreatif.",1,2);addQuestion(q39);
        Question q40 = new Question("Salah satu cabang utama yang tepat dari Subjek “SEKOLAH” adalah...","Upacara","Belajar","Istirahat","Memakai seragam",2,2);addQuestion(q40);
        /*6. Algoritma*/
        Question q41 = new Question("Sebuah bagan yang menunjukkan aliran algoritma dan menampilkan langkah-langkah penyelesaian terhadap suatu masalah. Adalah pengertian dari ...","Algoritma","Logika","Flowchart","Bagan",3,2);addQuestion(q41);
        Question q42 = new Question("Pernyataan yang logis sama dengan ...","Pernyataan yang pas","Pernyataan yang sesuai hati","Pernyataan yang sesuai ilmuwan","Pernyataan yang masuk akal",4,2);addQuestion(q42);
        Question q43 = new Question("Dibawah ini contoh dari logika yang tepat dan benar adalah ...","Manusia berjalan ke belakang","Bola sepak berbentuk bulat","Motor mempunyai 3 roda","Komputer harus berpasangan dengan CPU",2,2);addQuestion(q43);
        Question q44 = new Question("Diagram alir disebut juga dengan ...","Algoritma","Logika","Logis","Flowchart",4,2);addQuestion(q44);
        Question q45 = new Question("Sebuah bagan yang menunjukkan aliran algoritma dan menampilkan langkah-langkah penyelesaian terhadap suatu masalah. Adalah pengertian dari ...","Algoritma","Flowchart","Pseudocode","Mind Map",2,2);addQuestion(q45);      
        
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
