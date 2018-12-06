package it.std.s17003.s17003_quiz

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.io.*

private const val DB_NAME = "QuizDateBase"
private const val DB_VERSION = 1

class DataBaseOpenHelper(context: Context?)
    : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("""
            CREATE TABLE quiz(
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

    fun quizTexts(context: Context) : List<Quiz> {
        //読み込み用のデータベース
        val database = DataBaseOpenHelper(context).readableDatabase
        //データベースから全件検索する
        val cursor = database.query(
            "quiz", null, null, null, null, null, "created_at DESC")

        val quizes = mutableListOf<Quiz>()
        cursor.use {
            val id = cursor.getInt(cursor.getColumnIndex("_id"))
            val pattern = cursor.getInt(cursor.getColumnIndex("pattern"))
            val degree = cursor.getInt(cursor.getColumnIndex("degree"))
            val filename = cursor.getString(cursor.getColumnIndex("filename"))
            val question = cursor.getString(cursor.getColumnIndex("question"))
            val select1 = cursor.getString(cursor.getColumnIndex("select1"))
            val select2 = cursor.getString(cursor.getColumnIndex("select2"))
            val select3 = cursor.getString(cursor.getColumnIndex("select3"))
            val select4 = cursor.getString(cursor.getColumnIndex("select4"))
            val commentary = cursor.getString(cursor.getColumnIndex("commentary"))

            quizes.add(Quiz(id, pattern, degree, filename, question, select1, select2, select3, select4, commentary))
        }

        database.close()
        return quizes
    }

    fun insertQuiz(context: Context, quiz: List<Quiz>) {
        val database = DataBaseOpenHelper(context).writableDatabase

        database.use {db ->
            quiz.forEach{ quiz ->
                    val record = ContentValues().apply {
                        put("_id", quiz.Id)
                        put("pattern", quiz.Pattern)
                        put("degree", quiz.Degree)
                        put("filename", quiz.File_Name)
                        put("question", quiz.Question)
                        put("select1", quiz.Select1)
                        put("select2", quiz.Select2)
                        put("select3", quiz.Select3)
                        put("select4", quiz.Select4)
                        put("commentary", quiz.Commentary)
                    }
                    db.insert("quiz", null, record)
                }
        }
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
                val rowData = line.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

                fun main(args: Array<String>) {
                    val dataClass = Quiz(rowData[0].toInt(), rowData[1].toInt(), rowData[2].toInt(), rowData[3], rowData[4],
                        rowData[5], rowData[6], rowData[7], rowData[8], rowData[9])

                    objects.add(dataClass)
                }
            } while (true)
            bufferReader.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }
}

//クラス
data class Quiz(
    var Id: Int,
    var Pattern: Int,
    var Degree: Int,
    val File_Name: String,
    val Question: String,
    val Select1: String,
    val Select2: String,
    val Select3: String,
    val Select4: String,
    val Commentary: String
)
