package com.example.commonlib

import android.text.TextUtils
import androidx.annotation.IntegerRes
import java.lang.StringBuilder
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.logging.Logger
import kotlin.experimental.and

fun md5(str: String): String {
    if (TextUtils.isEmpty(str)) {
        return ""
    }
    try {
        val md5 = MessageDigest.getInstance("MD5")
        val bytes = md5.digest(str.toByteArray())
        val res = StringBuilder()
        bytes
            .map {
                val tmp = it.toInt() and 0xff
                Integer.toHexString(tmp)
            }.map {
                if (it.length == 1) "0$it" else it
            }.forEach {
                res.append(it)
            }
        return res.toString()
    } catch (e: NoSuchAlgorithmException) {
        loge("md5", e.message ?: "no msg")
    }
    return ""
}