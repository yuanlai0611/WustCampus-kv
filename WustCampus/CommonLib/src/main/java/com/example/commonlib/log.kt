package com.example.commonlib

import android.util.Log

fun logd(clazz: Class<*>, msg: String) {
    Log.d(clazz.simpleName, msg)
}

fun logd(tag: String, msg: String) {
    Log.d(tag, msg)
}

fun loge(clazz: Class<*>, msg: String) {
    Log.e(clazz.simpleName, msg)
}

fun loge(tag: String, msg: String) {
    Log.e(tag, msg)
}