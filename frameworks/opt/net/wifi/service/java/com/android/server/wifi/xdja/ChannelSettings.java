/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.server.wifi.cells;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.nio.ByteBuffer;


/**
 * Represents a LLCP packet received in a LLCP Connectionless communication;
 */
public class ChannelSettings implements Parcelable {
    public int frequency;
    public int dwell_time_ms;
    public boolean passive;

    public ChannelSettings() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(frequency);
        dest.writeInt(dwell_time_ms);
        dest.writeInt(passive?1:0);
    }

    public static final Parcelable.Creator<ChannelSettings> CREATOR =
            new Parcelable.Creator<ChannelSettings>() {
        @Override
        public ChannelSettings createFromParcel(Parcel in) {
            ChannelSettings params = new ChannelSettings();
            params.frequency = in.readInt();
            params.dwell_time_ms = in.readInt();
            params.passive = (in.readInt()==1?true:false);
            return params;
        }
        @Override
        public ChannelSettings[] newArray(int size) {
            return new ChannelSettings[size];
        }
    };

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = frequency;
        result = prime * result + dwell_time_ms;
        result = prime * result + (passive?1:0);
        return result;
    }

    /**
     * Returns true if the specified NDEF Message contains
     * identical NDEF Records.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        ChannelSettings other = (ChannelSettings) obj;
        return (frequency == other.frequency) && 
               (dwell_time_ms == other.dwell_time_ms) &&
               (passive == other.passive);
    }

    @Override
    public String toString() {
        return " frequency: " + frequency + 
               " dwell_time_ms: " + dwell_time_ms + 
               " passive: " + passive ;
    }

}
