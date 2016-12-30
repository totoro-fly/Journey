package com.totoro_fly.journey;

/**
 * Created by totoro-fly on 2016/12/30.
 */

public class Scenery {
    private int mImage;
    private String mTitel;
    private String mContent;

    public Scenery(int mImage, String mTitel, String mContent) {
        this.mImage = mImage;
        this.mTitel = mTitel;
        this.mContent = mContent;
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }

    public String getmTitel() {
        return mTitel;
    }

    public void setmTitel(String mTitel) {
        this.mTitel = mTitel;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }
}
