package com.example.adminbooking;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.OpenableColumns;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtils {
    private static final String TAG = "FileUtils";


    @WorkerThread
    @Nullable
    public static String getReadablePathFromUri(Context context, Uri uri) {

        String file_Name = getFileName(context, uri);

        if (file_Name.endsWith(".pdf")) {

            String path = null;
            path = makeStaticfile(context, uri, file_Name);

            return path;

        } else {

            return "invalid file";
        }
    }


    public static String getFileName(Context context, Uri uri) {

        Cursor cursor = context.getContentResolver().query(uri, null, null, null, null);
        int nameindex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
        cursor.moveToFirst();

        return cursor.getString(nameindex);
    }


    private static boolean copyFile(Context context, Uri uri, String dstPath) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = context.getContentResolver().openInputStream(uri);
            outputStream = new FileOutputStream(dstPath);

            byte[] buff = new byte[100 * 1024];
            int len;
            while ((len = inputStream.read(buff)) != -1) {
                outputStream.write(buff, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }


    private static String makeStaticfile(Context context, Uri uri, String file_name) {

        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Booking Melbourne";
        File file = new File(path);
        file.mkdir();

        path = path + "/" + file_name;

        if (copyFile(context, uri, path)) {

            return path;
        } else {
            return "invalid file";
        }

    }

}
