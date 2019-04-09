package com.zafar.quizit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddCategoryActivity extends AppCompatActivity {


    TextView addCategory;
    Button submitButton;
    Category category;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);

        addCategory = (EditText)findViewById(R.id.addCategory);
        submitButton = (Button)findViewById(R.id.button_submitAdd);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addIntent = new Intent(AddCategoryActivity.this,AddCategoryActivity.class);
                category = new Category(addCategory.getText().toString().trim());
                addCategory(category);
                finish();
                startActivity(addIntent);
            }
        });



    }

    private void addCategory(Category category){
        QuizDbHelper.getInstance(this).addCategory((category));
    }


}
