package com.vn.custom.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import java.util.*

class PreferenceUtils(context: Context) {

    companion object {
        const val KEY_LANGUAGE = "vn.com.ttc.ecommerce.utils.prefs.KEY_LANGUAGE"
        const val KEY_LANGUAGE_ID = "vn.com.ttc.ecommerce.utils.prefs.KEY_LANGUAGE_ID"

        /**
         * Login response
         */
        const val KEY_TOKEN = "vn.com.ttc.ecommerce.prefs.KEY_TOKEN"
        const val KEY_FULL_NAME = "vn.com.ttc.ecommerce.prefs.KEY_FULL_NAME"
        const val KEY_AVATAR = "vn.com.ttc.ecommerce.prefs.KEY_AVATAR"
        const val KEY_GENDER = "vn.com.ttc.ecommerce.prefs.KEY_GENDER"
        const val KEY_EMAIL = "vn.com.ttc.ecommerce.prefs.KEY_EMAIL"
        const val KEY_PHONE_NUMBER = "vn.com.ttc.ecommerce.prefs.KEY_PHONE_NUMBER"

        const val KEY_NOTIFICATION_LIST = "vn.com.ttc.ecommerce.utils.prefs.KEY_NOTIFICATION_LIST"
        private val TAG = "PreferenceUtil"
        private var instance: PreferenceUtils? = null

        fun newInstance(context: Context): PreferenceUtils {
            if (instance == null) {
                instance = PreferenceUtils(context)
            }
            return instance as PreferenceUtils
        }

        fun getBoolean(con: Context, key: String, defValue: Boolean): Boolean {
            try {
                return pref(con).getBoolean(key, defValue)
            } catch (e: Exception) {
                return defValue
            }

        }

        fun getInt(con: Context, key: String, defValue: Int): Int {
            try {
                return pref(con).getInt(key, defValue)
            } catch (e: Exception) {
                return defValue
            }

        }

        fun getString(con: Context, key: String, defValue: String?): String? {
            try {
                return pref(con).getString(key, defValue)
            } catch (e: Exception) {
                return defValue
            }

        }

        fun getLong(con: Context, key: String, defValue: Long): Long {
            try {
                return pref(con).getLong(key, defValue)
            } catch (e: Exception) {
                return defValue
            }

        }

        fun getFloat(con: Context, key: String, defValue: Float): Float {
            try {
                return pref(con).getFloat(key, defValue)
            } catch (e: Exception) {
                return defValue
            }

        }

        fun getStringSet(con: Context, key: String, defValue: Set<String>): Set<String>? {
            try {
                var ret: HashSet<String>? = null
                val set = pref(con).getStringSet(key, null)
                if (set != null) {
                    ret = HashSet(set)
                }
                return ret
            } catch (e: Exception) {
                return defValue
            }

        }

        fun writeString(con: Context, key: String, value: String?) {
            try {
                pref(con).edit().putString(key, value).commit()
            } catch (e: Exception) {
            }

        }

        fun writeBoolean(con: Context, key: String, value: Boolean) {
            try {
                pref(con).edit().putBoolean(key, value).commit()
            } catch (e: Exception) {
            }

        }

        fun writeInt(con: Context, key: String, value: Int) {
            try {
                pref(con).edit().putInt(key, value).commit()
            } catch (e: Exception) {
            }

        }

        fun writeLong(con: Context, key: String, value: Long) {
            try {
                pref(con).edit().putLong(key, value).commit()
            } catch (e: Exception) {
            }

        }

        fun writeFloat(con: Context, key: String, value: Float) {
            try {
                pref(con).edit().putFloat(key, value).commit()
            } catch (e: Exception) {
            }

        }

        fun writeSet(con: Context, key: String, set: Set<String>) {
            try {
                pref(con).edit().putStringSet(key, set).commit()
            } catch (e: Exception) {
            }

        }

        fun remove(con: Context, key: String) {
            try {
                pref(con).edit().remove(key).commit()
            } catch (e: Exception) {
            }

        }

        private fun pref(con: Context): SharedPreferences {
            return PreferenceManager.getDefaultSharedPreferences(con)
        }
    }
}
