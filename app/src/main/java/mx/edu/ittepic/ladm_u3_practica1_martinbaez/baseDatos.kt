package mx.edu.ittepic.ladm_u3_practica1_martinbaez

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class baseDatos(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE ACTIVIDAD(ID_ACTIVIDAD INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "DESCRIPCION VARCHAR(500)," +
                "FECHA_C DATE," +
                "FECHA_E DATE)")

        db?.execSQL("CREATE TABLE EVIDENCIA(ID_EVIDENCIA INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "ID_ACTIVIDAD INTEGER NOT NULL," +
                "FOTO BLOB," +
                "FOREIGN KEY (ID_ACTIVIDAD) REFERENCES ACTIVIDAD(ID_ACTIVIDAD))")
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

}