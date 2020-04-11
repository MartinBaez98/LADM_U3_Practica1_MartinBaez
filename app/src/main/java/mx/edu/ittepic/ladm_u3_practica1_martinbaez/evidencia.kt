package mx.edu.ittepic.ladm_u3_practica1_martinbaez

import android.app.Activity
import android.content.ContentValues
import android.database.sqlite.SQLiteException

class evidencia(ida:Int, img:ByteArray) {


    fun asignarPuntero (p:MainActivity){
        puntero = p
    }

    fun insertar():Boolean{
        error=-1
        try{
            var base= baseDatos(puntero!!,nombreBaseDeDatos,null,1)
            var insertar = base.writableDatabase
            var datos= ContentValues()

            datos.put("ID_ACTIVIDAD",id_act)
            datos.put("FOTO",imagen)


            var respuesta =insertar.insert("EVIDENCIA","ID_EVIDENCIA",datos)
            if(respuesta.toInt()==-1){
                error=2
                return false
            }
        }catch (e: SQLiteException){
            error=1
            return false
        }
        return true
    }


    fun mostrarTodos(id:String):ArrayList<ByteArray>{
        var data = ArrayList<ByteArray>()
        error = -1
        try {
            var base= baseDatos(puntero!!,nombreBaseDeDatos,null,1)
            var select = base.readableDatabase
            var columnas = arrayOf("*")
            var idBuscar = arrayOf(id)
            var cursor = select.query("EVIDENCIA",columnas,"ID_ACTIVIDAD=?",idBuscar,null,null,null)
            if(cursor.moveToFirst()){
                do{
                    data.add(cursor.getBlob(2))
                }while (cursor.moveToNext())
            }else{
                error = 3
            }

        }catch (e:SQLiteException){
            error=1
        }

        return data
    }

    var id_evi=0
    var id_act= ida
    var imagen:ByteArray=img


    val nombreBaseDeDatos = "ACTIVIDADES"
    var puntero : Activity?= null
    var error = -1
}