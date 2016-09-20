package edu.depaul.jmorton.boschhack.boschhackathon.utils;

import android.util.Log;

import java.util.Locale;

/**
 * Created by Jonathan Morton on 9/20/16.
 */

public class L {

    public static final String TAG = "boschhackathon";

    private static boolean ENABLE_DEBUG_LOGGING = false;

    private L() {
        // prevent instantiation
    }

    public static void enableDebugLogging(final boolean enabled) {
        ENABLE_DEBUG_LOGGING = enabled;
    }

    public static void v(final String msg) {
        if (ENABLE_DEBUG_LOGGING) {
            String logMsg = debugInfo() + msg;
            Log.v(TAG, logMsg);
        }
    }

    public static void d(final String msg) {
        if (ENABLE_DEBUG_LOGGING) {
            String logMsg = debugInfo() + msg;
            Log.d(TAG, logMsg);
        }
    }

    public static void i(final String msg) {
        String logMsg = debugInfo() + msg;
        Log.i(TAG, logMsg);
    }

    public static void w(final String msg) {
        String logMsg = debugInfo() + msg;
        Log.w(TAG, logMsg);
    }

    public static void e(final String msg) {
        String logMsg = debugInfo() + msg;
        Log.e(TAG, logMsg);
    }

    public static void e(final String msg, final Throwable e) {
        String logMsg = debugInfo() + msg;
        Log.e(TAG, logMsg, e);
    }

    public static void wtf(final String msg) {
        String logMsg = debugInfo() + msg;
        Log.wtf(TAG, logMsg);
    }

    public static void wtf(final String msg, final Exception exception) {
        String logMsg = debugInfo() + msg;
        Log.wtf(TAG, logMsg, exception);
    }

    private static String debugInfo() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String className = stackTrace[4].getClassName();
        String methodName = Thread.currentThread().getStackTrace()[4].getMethodName();
        int lineNumber = stackTrace[4].getLineNumber();
        return String.format(Locale.US, "%s.%s:%d ", className, methodName, lineNumber);
    }
}
