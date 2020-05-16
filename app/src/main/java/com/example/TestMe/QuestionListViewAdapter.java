package com.example.TestMe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class QuestionListViewAdapter extends BaseAdapter {
    private Context context;
    private List<Question> questionList;

    public QuestionListViewAdapter(Context context, List<Question> questionList) {
        this.context = context;
        this.questionList = questionList;
    }

    @Override
    public int getCount() {
        return questionList.size();
    }

    @Override
    public Object getItem(int position) {
        return questionList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return questionList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.question_list_view_item, parent, false);
        Question question = questionList.get(position);

        TextView questionText = convertView.findViewById(R.id.question_text_list);
        TextView choiceOne = convertView.findViewById(R.id.choice_one_list);
        TextView choiceTwo = convertView.findViewById(R.id.choice_two_list);
        TextView choiceThree = convertView.findViewById(R.id.choice_three_list);
        TextView choiceFour = convertView.findViewById(R.id.choice_four_list);
        questionText.setText("Question: " +question.getQuestion_text());
        choiceOne.setText("Choice 1 (Correct): " +question.getChoice_one());
        choiceTwo.setText("Choice 2: " +question.getChoice_two());
        choiceThree.setText("Choice 3: " +question.getChoice_three());
        choiceFour.setText("Choice 4: " +question.getChoice_four());


        return convertView;
    }
}
