/*
 * Copyright (C) 2015 The Android Open Source Project
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

package edu.depaul.jmorton.boschhack.boschhackathon.bluetooth;

import android.os.ParcelUuid;


public class Constants {

    public static final ParcelUuid Service_UUID = ParcelUuid
            .fromString("5d6c07bd-442a-4bdc-9881-f69c175a772a");

    public static final String ACCIDENT_TYPE = "accident_type";
    public static final String SAFE = "SAFE";
    public static final String ACCIDENT_FIRE = "FIRE";
    public static final String ACCIDENT_ROLLOVER = "ROLL";

    public static final int REQUEST_ENABLE_BT = 1;

}
