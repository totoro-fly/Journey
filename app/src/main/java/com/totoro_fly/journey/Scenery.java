package com.totoro_fly.journey;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by totoro-fly on 2016/12/30.
 */

public class Scenery implements Parcelable {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mImage);
        dest.writeString(this.mTitel);
        dest.writeString(this.mContent);
    }

    protected Scenery(Parcel in) {
        this.mImage = in.readInt();
        this.mTitel = in.readString();
        this.mContent = in.readString();
    }

    public static final Parcelable.Creator<Scenery> CREATOR = new Parcelable.Creator<Scenery>() {
        @Override
        public Scenery createFromParcel(Parcel source) {
            return new Scenery(source);
        }

        @Override
        public Scenery[] newArray(int size) {
            return new Scenery[size];
        }
    };
}
