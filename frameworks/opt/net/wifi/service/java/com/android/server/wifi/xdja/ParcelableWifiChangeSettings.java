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

import android.net.wifi.WifiScanner.WifiChangeSettings;

public class ParcelableWifiChangeSettings implements Parcelable {

    public WifiChangeSettings mResult;

    public ParcelableWifiChangeSettings(WifiChangeSettings result) {
        mResult = result;
    }

    public WifiChangeSettings getResult() {
        return mResult;
    }

    /** Implement the Parcelable interface {@hide} */
    public int describeContents() {
        return 0;
    }

    /** Implement the Parcelable interface {@hide} */
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(mResult, flags);
    }

    /** Implement the Parcelable interface {@hide} */
    public static final Creator<ParcelableWifiChangeSettings> CREATOR =
            new Creator<ParcelableWifiChangeSettings>() {
                public ParcelableWifiChangeSettings createFromParcel(Parcel in) {
                    WifiChangeSettings result =WifiChangeSettings.CREATOR.createFromParcel(in);;
                    return new ParcelableWifiChangeSettings(result);
                }

                public ParcelableWifiChangeSettings[] newArray(int size) {
                    return new ParcelableWifiChangeSettings[size];
                }
            };
}
