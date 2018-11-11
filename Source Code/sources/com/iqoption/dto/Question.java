package com.iqoption.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class Question {
    public List<Answer> answers = new ArrayList();
    public int id;
    public String name;
    public Integer selectedAnswerId;

    public static Question fromJSON(int i, JSONObject jSONObject) {
        Question question = new Question();
        question.id = i;
        question.name = jSONObject.getString("name");
        JSONObject jSONObject2 = jSONObject.getJSONObject("answers");
        Iterator keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            question.answers.add(Answer.fromJSON(Integer.valueOf(str).intValue(), jSONObject2.getJSONObject(str)));
        }
        return question;
    }
}
