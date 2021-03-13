package com.example.movieapp.utilities

import android.util.Log
import java.io.File
import java.io.IOException

object JsonReader {
  fun readStringFromFile(path: String) : String {
    try {
      val uri = this.javaClass.classLoader!!.getResource(path)
      val file = File(uri.path)
      return String(file.readBytes())
    } catch (e: IOException) {
      throw e
    }
  }
}