package com.code.datalayer.provider

import android.content.Context
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Log


fun QueryPhoneNumber(context: Context){
    val contentResolver = context.contentResolver

    val mUri : Uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
    val mProjection :Array<String>? = null//arrayOf(UserDictionary.Words._ID,UserDictionary.Words.WORD,UserDictionary.Words.LOCALE)
    val mSelectionClause = null
    val mSelectionArgs = null
    val mSortOrder = null
    try {
        showTable(mUri,context)
    }catch (e:Exception){
        Log.i("query","error")
    }
}
fun showTable(uri: Uri, ct: Context){
    Log.i("query","/////////////////////")
    val  cursor  = ct.contentResolver.query(uri,null,null,null,null)
    checkNotNull(cursor).apply {
        cursor.moveToFirst()
        while (!isAfterLast){
            Log.i("query","//////")
//                    for (colName in columnNames){
            val index = getColumnIndex(MediaStore.MediaColumns.DISPLAY_NAME)
            val index_2 = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                getColumnIndex(MediaStore.MediaColumns.DATE_ADDED)
            } else {
                null
            }

            Log.i("query",getString(index))
            if(index_2 != null) Log.i("query",getString(index_2))
//                    }
            moveToNext()
        }
        close()
    }
}