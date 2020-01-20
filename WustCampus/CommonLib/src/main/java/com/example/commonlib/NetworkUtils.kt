package com.example.commonlib

import android.content.Context
import android.net.ConnectivityManager
import androidx.annotation.RequiresPermission

@JvmName("NetworkUtils")

@RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
@Deprecated("need to replace")
fun isNetworkAvailable(ctx: Context?): Boolean {
    return true
}