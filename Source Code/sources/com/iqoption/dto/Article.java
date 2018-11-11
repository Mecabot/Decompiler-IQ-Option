package com.iqoption.dto;

import android.text.Html;
import org.json.JSONObject;

public class Article {
    public String answer;
    public String question;

    public Article(JSONObject jSONObject) {
        this.answer = Html.fromHtml(jSONObject.getString("text")).toString().replace("\n", "");
        this.question = Html.fromHtml(jSONObject.getString("header")).toString().replace("\n", "");
    }
}
