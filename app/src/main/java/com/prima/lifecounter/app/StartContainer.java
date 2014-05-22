package com.prima.lifecounter.app;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Primoz on 18.5.2014.
 */
public class StartContainer implements Parcelable {
    public Integer startLife;
    public Integer startPlayers;

    public StartContainer(Integer _startLife, Integer _startPlayers){
        startLife = _startLife;
        startPlayers = _startPlayers;
    }

    public Integer getStartLife(){
        return startLife;
    }

    public Integer getStartPlayers(){
        return startPlayers;
    }

    public void setStartLife(Integer _starLife){
        startLife = _starLife;
    }

    public void setStartPlayers(Integer _startPlayers){
        startPlayers = _startPlayers;
    }


    public StartContainer(Parcel in){
        String[] data = new String[2];
        in.readStringArray(data);
        this.startLife = Integer.parseInt(data[0]);
        this.startPlayers = Integer.parseInt(data[1]);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(new String[] { this.startLife.toString(), this.startPlayers.toString() });
    }

    public static final Parcelable.Creator<StartContainer> CREATOR = new Parcelable.Creator<StartContainer>(){

        @Override
        public StartContainer createFromParcel(Parcel parcel) {
            return new StartContainer(parcel);
        }

        @Override
        public StartContainer[] newArray(int i) {
            return new StartContainer[i];
        }
    };

}
