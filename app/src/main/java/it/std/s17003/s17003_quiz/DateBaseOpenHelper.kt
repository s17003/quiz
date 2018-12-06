package it.std.s17003.s17003_quiz

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.io.*

private const val DB_NAME = "QuizDateBase"
private const val DB_VERSION = 1

class DateBaseOpenHelper(context: Context?)
    : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("""
            CREATE TABLE Question(
            _id INTEGER PRIMARY KEY,
            pattern INTEGER NOT NULL,
            degree INTEGER NOT NULL,
            filename TEXT,
            question TEXT NOT NULL,
            select1 TEXT NOT NULL,
            select2 TEXT NOT NULL,
            select3 TEXT NOT NULL,
            select4 TEXT NOT NULL,
            commentary TEXT NOT NULL);
        """.trimIndent())
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

}

class CsvReader {
    internal var objects: MutableList<Quiz> = ArrayList<Quiz>()
    fun reader(context: Context) {
        val assetManager = context.resources.assets
        try {
            // CSVファイルの読み込み
            val inputStream = assetManager.open("s17003_quiz.csv")
            val inputStreamReader = InputStreamReader(inputStream)
            val bufferReader = BufferedReader(inputStreamReader)
            var line: String
            do {
                line = bufferReader.readLine()
                if (line == null)
                    break
                //カンマ区切りで１つづつ配列に入れる
                val RowData = line.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

                fun main(args: Array<String>) {
                    val DataClass = Quiz(RowData[0], RowData[1], RowData[2], RowData[3], RowData[4],
                        RowData[5], RowData[6], RowData[7], RowData[8], RowData[9])
                    var (Id, Pattern, Degree, File_Name, Question,
                            Select1, Select2, Select3, Select4, Commentary) = DataClass

                    objects.add(DataClass)
                }
            } while (true)
            bufferReader.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }
}

//データクラス
data class Quiz(
    var Id: String,
    var Pattern: String,
    var Degree: String,
    val File_Name: String,
    val Question: String,
    val Select1: String,
    val Select2: String,
    val Select3: String,
    val Select4: String,
    val Commentary: String
)
