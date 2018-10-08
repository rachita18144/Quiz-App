package com.example.rachitabhagchandani.quizapp;

import android.content.Context;

import java.util.ArrayList;

public class QuizQuestions {
    DatabaseHelper databaseHelper;

    QuizQuestions(Context context){
        databaseHelper = new DatabaseHelper(context);
        insertQuizData();
    }
    void insertQuizData(){
        databaseHelper.insertData(new Question("The Language that the computer can understand is called Machine Language.","true"));
        databaseHelper.insertData(new Question("Magnetic Tape used random access method.","false"));
        databaseHelper.insertData(new Question("Twitter is an online social networking and blogging service.","true"));
        databaseHelper.insertData(new Question("The Language that the computer can understand is called Machine Language.","true"));
        databaseHelper.insertData(new Question("Magnetic Tape used random access method.","false"));
        databaseHelper.insertData(new Question("Twitter is an online social networking and blogging service.","true"));
        databaseHelper.insertData(new Question("The Language that the computer can understand is called Machine Language.","true"));
        databaseHelper.insertData(new Question("Magnetic Tape used random access method.","false"));
        databaseHelper.insertData(new Question("Twitter is an online social networking and blogging service.","true"));
        databaseHelper.insertData(new Question("The Language that the computer can understand is called Machine Language.","true"));
        databaseHelper.insertData(new Question("Magnetic Tape used random access method.","false"));
        databaseHelper.insertData(new Question("Twitter is an online social networking and blogging service.","true"));
    }

    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questions = databaseHelper.getAllQuestions();
        return questions;
    }

    public void saveResponseTodb(int id, String answer){
        databaseHelper.addDataToDb(id,answer);
    }
}
