package com.iqoption.dto.entity.result;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.SerializedName;
import com.iqoption.mobbtech.connect.response.m;
import java.util.HashMap;
import java.util.Map.Entry;

public class KycQuestionsResult extends m implements Parcelable {
    public static final Creator<KycQuestionsResult> CREATOR = new Creator<KycQuestionsResult>() {
        public KycQuestionsResult createFromParcel(Parcel parcel) {
            return new KycQuestionsResult(parcel);
        }

        public KycQuestionsResult[] newArray(int i) {
            return new KycQuestionsResult[i];
        }
    };
    @SerializedName("result")
    public HashMap<Integer, Question> questionMap;

    public static class Answer implements Parcelable {
        public static final Creator<Answer> CREATOR = new Creator<Answer>() {
            public Answer createFromParcel(Parcel parcel) {
                return new Answer(parcel);
            }

            public Answer[] newArray(int i) {
                return new Answer[i];
            }
        };
        @SerializedName("description")
        public String description;
        @SerializedName("name")
        public String name;
        @SerializedName("next_question")
        public Integer nextQuestion;

        public int describeContents() {
            return 0;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Answer{name='");
            stringBuilder.append(this.name);
            stringBuilder.append('\'');
            stringBuilder.append(", description=");
            stringBuilder.append(this.description);
            stringBuilder.append(", nextQuestion=");
            stringBuilder.append(this.nextQuestion);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.name);
            parcel.writeString(this.description);
            parcel.writeValue(this.nextQuestion);
        }

        protected Answer(Parcel parcel) {
            this.name = parcel.readString();
            this.description = parcel.readString();
            this.nextQuestion = (Integer) parcel.readValue(Integer.class.getClassLoader());
        }
    }

    public static class Question implements Parcelable {
        public static final Creator<Question> CREATOR = new Creator<Question>() {
            public Question createFromParcel(Parcel parcel) {
                return new Question(parcel);
            }

            public Question[] newArray(int i) {
                return new Question[i];
            }
        };
        public HashMap<Integer, Answer> answers;
        @SerializedName("description")
        public String description;
        @SerializedName("is_multiple_choice_allowed")
        public Boolean isMultipleChoiceAllowed;
        @SerializedName("mandatory")
        public Boolean mandatory;
        @SerializedName("name")
        public String name;

        public int describeContents() {
            return 0;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Question{name='");
            stringBuilder.append(this.name);
            stringBuilder.append('\'');
            stringBuilder.append(", description=");
            stringBuilder.append(this.description);
            stringBuilder.append(", mandatory=");
            stringBuilder.append(this.mandatory);
            stringBuilder.append(", isMultipleChoiceAllowed=");
            stringBuilder.append(this.isMultipleChoiceAllowed);
            stringBuilder.append(", answers=");
            stringBuilder.append(this.answers);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.name);
            parcel.writeString(this.description);
            parcel.writeValue(this.mandatory);
            parcel.writeValue(this.isMultipleChoiceAllowed);
            parcel.writeLong(this.answers == null ? 0 : (long) this.answers.size());
            if (this.answers != null) {
                for (Entry entry : this.answers.entrySet()) {
                    parcel.writeValue(entry.getKey());
                    parcel.writeParcelable((Parcelable) entry.getValue(), 0);
                }
            }
        }

        @SuppressLint({"UseSparseArrays"})
        protected Question(Parcel parcel) {
            this.name = parcel.readString();
            this.description = parcel.readString();
            this.mandatory = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
            this.isMultipleChoiceAllowed = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
            long readLong = parcel.readLong();
            this.answers = new HashMap();
            for (long j = 0; j < readLong; j++) {
                this.answers.put((Integer) parcel.readValue(Integer.class.getClassLoader()), (Answer) parcel.readParcelable(Answer.class.getClassLoader()));
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.questionMap == null ? 0 : (long) this.questionMap.size());
        if (this.questionMap != null) {
            for (Entry entry : this.questionMap.entrySet()) {
                parcel.writeValue(entry.getKey());
                parcel.writeParcelable((Parcelable) entry.getValue(), 0);
            }
        }
    }

    @SuppressLint({"UseSparseArrays"})
    protected KycQuestionsResult(Parcel parcel) {
        this.questionMap = new HashMap();
        long readLong = parcel.readLong();
        for (long j = 0; j < readLong; j++) {
            this.questionMap.put((Integer) parcel.readValue(Integer.class.getClassLoader()), (Question) parcel.readParcelable(Question.class.getClassLoader()));
        }
    }
}
