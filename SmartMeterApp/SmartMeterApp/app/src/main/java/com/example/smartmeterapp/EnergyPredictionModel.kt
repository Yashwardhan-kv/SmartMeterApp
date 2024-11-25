package com.example.smartmeterapp

import android.content.Context
import org.tensorflow.lite.Interpreter
import java.nio.MappedByteBuffer
import java.nio.channels.FileChannel
import java.io.FileInputStream

class EnergyPredictionModel(context: Context) {

    private val tfliteInterpreter: Interpreter

    init {
        tfliteInterpreter = Interpreter(loadModelFile(context, "energy_prediction_model.tflite"))
    }

    private fun loadModelFile(context: Context, modelFileName: String): MappedByteBuffer {
        val assetFileDescriptor = context.assets.openFd(modelFileName)
        val fileInputStream = FileInputStream(assetFileDescriptor.fileDescriptor)
        val fileChannel = fileInputStream.channel
        val startOffset = assetFileDescriptor.startOffset
        val declaredLength = assetFileDescriptor.declaredLength
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength)
    }

    fun predict(features: FloatArray): Float {
        val input = arrayOf(features)
        val output = Array(1) { FloatArray(1) }
        tfliteInterpreter.run(input, output)
        return output[0][0]
    }

    fun close() {
        tfliteInterpreter.close()
    }
}
