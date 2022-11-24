package com.example.homeworkout.dashboard;

import android.content.Context;
import android.speech.tts.TextToSpeech;

import java.util.Locale;

public class TextToSpeechClass {
    TextToSpeech textToSpeech;
    Context context;
    String text;

    public TextToSpeechClass(TextToSpeech textToSpeech, Context context, String text) {
        this.textToSpeech = textToSpeech;
        this.context = context;
        this.text = text;
        speak(text);
    }

    public void speak(String text) {
        textToSpeech = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.ENGLISH);
                    textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });
    }


}
