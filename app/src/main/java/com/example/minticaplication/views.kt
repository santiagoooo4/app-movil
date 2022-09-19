package com.example.minticaplication

import android.content.pm.PackageManager
import androidx.fragment.app.Fragment
import android.os.Build


fun Fragment.checkPermission(permission: String, code: Int): Boolean {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        val granted = requireActivity().checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED

        if(!granted) this.requestPermissions(arrayOf(permission), code)

        return granted
    }
    return true
}