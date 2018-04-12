/*
 * Copyright (C) 2008 The Android Open Source Project
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

package android.net.cells;

import android.os.ParcelFileDescriptor;
import android.net.DhcpResults;

/**
 *
 * {@hide}
 */
interface IcellsNetworkUtils {

     int doResetConnections(String interfaceName, int mask);

     boolean doStartDhcp(String interfaceName);

     boolean doStartDhcpRenew(String interfaceName);

     boolean doGetDhcpResults(String interfaceName, out DhcpResults dhcpResults);

     boolean doStopDhcp(String interfaceName);

     boolean doReleaseDhcpLease(String interfaceName);

     String doGetDhcpError();

     void doAttachDhcpFilter(in ParcelFileDescriptor fd);

     boolean doBindProcessToNetwork(int netId);

     int doGetBoundNetworkForProcess();

     boolean doBindProcessToNetworkForHostResolution(int netId);

     int doBindSocketToNetwork(int socketfd, int netId);

     boolean doProtectFromVpn(int socketfd);

     boolean doQueryUserAccess(int uid, int netId);

}
