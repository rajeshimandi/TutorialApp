package com.example.anuraj.tutorialsapplication.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by AnuRaj on 10/31/2018.
 */

public class Contact implements Parcelable {

    private String name;

    private String lastName;

    private int id;

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public Contact(String name, String lastName, int id) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
    }

    protected Contact(Parcel in) {
        name = in.readString();
        lastName = in.readString();
        id = in.readInt();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(lastName);
        dest.writeInt(id);
    }


}
