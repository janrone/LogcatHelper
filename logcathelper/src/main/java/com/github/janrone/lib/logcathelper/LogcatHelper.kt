package com.github.janrone.lib.logcathelper

import android.content.Context
import android.os.Environment

import java.io.BufferedReader
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStreamReader
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class LogcatHelper private constructor(context: Context) {

    private var mLogDumper: LogDumper? = null
    /**应用进程ID */
    private val mPId: Int

    lateinit var PATH_LOGCAT: String

    init {
        init(context)
        mPId = android.os.Process.myPid()
    }

    companion object {
        @Volatile
        var instance: LogcatHelper? = null

        fun getInstance(context: Context): LogcatHelper {
            if (instance == null) {
                synchronized(LogcatHelper::class) {
                    if (instance == null) {
                        instance = LogcatHelper(context)
                    }
                }
            }
            return instance!!
        }

        // 2012-10-03
        val fileName: String
            get() {
                val format = SimpleDateFormat("yyyy-MM-dd", Locale.CHINA)
                return format.format(Date(System.currentTimeMillis()))
            }

        // 2012-10-03 23:41:31
        val dateEN: String
            get() {
                val format1 = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA)
                return format1.format(Date(System.currentTimeMillis()))
            }
    }


    //初始化目录 "包名+logcat"
    private fun init(context: Context) {

//        PATH_LOGCAT = when (Environment.getExternalStorageState()) {
//            Environment.MEDIA_MOUNTED -> // 优先保存到SD卡中
//                Environment.getExternalStorageDirectory().absolutePath + File.separator + context.packageName + File.separator + "logcat"
//            else -> //如果SD卡不存在，就保存到本应用的目录下【why 直接保存到本应用的目录下】
//                context.filesDir.absolutePath + File.separator + "logcat"
//        }
        PATH_LOGCAT = context.filesDir.absolutePath + File.separator + "logcat"
        val file = File(PATH_LOGCAT)
        if (!file.exists()) {
            file.mkdirs()
        }
    }

    fun start() {
        if (mLogDumper == null)
            mLogDumper = LogDumper(mPId.toString(), PATH_LOGCAT)
        mLogDumper!!.start()
    }

    fun stop() {
        if (mLogDumper != null) {
            mLogDumper!!.stopLogs()
            mLogDumper = null
        }
    }

    private inner class LogDumper(private val mPID: String, dir: String) : Thread() {

        private var logcatProc: Process? = null
        private var mReader: BufferedReader? = null
        private var mRunning = true
        internal var cmds: String? = null
        private var out: FileOutputStream? = null

        init {
            try {
                out = FileOutputStream(File(dir, "logcat-$fileName.log"))
            } catch (e: FileNotFoundException) {
                // TODO Auto-generated catch block
                e.printStackTrace()
            }

            /**
             *
             * 日志等级：*:v , *:d , *:w , *:e , *:f , *:s
             *
             * 显示当前mPID程序的 E和W等级的日志.
             *
             */

            // cmds = "logcat *:e *:w | grep \"(" + mPID + ")\"";
            cmds = "logcat  | grep \"($mPID)\""//打印所有日志信息
            // cmds = "logcat -s way";//打印标签过滤信息
            //cmds = "logcat *:e *:i | grep \"(" + mPID + ")\"";

        }

        fun stopLogs() {
            mRunning = false
        }

        override fun run() = try {
            //val text:List<String> = bufferedReader.readLines()
            //https://www.tutorialkart.com/kotlin/read-contents-of-a-file-in-kotlin/
            logcatProc = Runtime.getRuntime().exec(cmds)
            mReader = BufferedReader(InputStreamReader(logcatProc!!.inputStream), 1024)

            var line: String

            while (mRunning) {
                if (!mRunning) {
                    break
                }
                line = mReader!!.readLine() ?: break
                if (line!!.isEmpty()) {
                    continue
                }
                if (out != null && line!!.contains(mPID)) {
                    out!!.write(
                        "$dateEN  $line\n"
                            .toByteArray()
                    )
                }
            }

        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            if (logcatProc != null) {
                logcatProc!!.destroy()
                logcatProc = null
            }
            if (mReader != null) {
                try {
                    mReader!!.close()
                    mReader = null
                } catch (e: IOException) {
                    e.printStackTrace()
                }

            }
            if (out != null) {
                try {
                    out!!.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }

                out = null
            }
        }
    }

    // <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    //    <uses-permission android:name="android.permission.READ_LOGS" />
}
