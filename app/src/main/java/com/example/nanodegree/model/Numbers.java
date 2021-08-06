
package com.example.nanodegree.model;

public class Numbers {

    public String englishWord ;
    public String miwokWord;
    private int imageResourceId = NO_IMAGE_PROVIDED;
    private int audioResourceId;

    private static final int NO_IMAGE_PROVIDED = -1;

    public Numbers(String englishWord, String miwokWord, int imageResourceId, int audioResourceId) {
        this.englishWord = englishWord;
        this.miwokWord = miwokWord;
        this.imageResourceId = imageResourceId;
        this.audioResourceId = audioResourceId;
    }

    public Numbers(String englishWord, String miwokWord, int audioResourceId) {
        this.englishWord = englishWord;
        this.miwokWord = miwokWord;
        this.audioResourceId = audioResourceId;
    }

    public String getEnglishTranslation () {
        return englishWord;
    }

    public String getMiwokTranslation () {
        return miwokWord;
    }

    public int getImageResourceId () {return imageResourceId;}

    public boolean hasImage () {
        return imageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getAudioResourceId () {return audioResourceId;}
}

