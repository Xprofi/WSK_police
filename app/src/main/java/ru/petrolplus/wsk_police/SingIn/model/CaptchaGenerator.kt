package ru.petrolplus.wsk_police.SingIn.model

import android.R
import android.app.Activity
import android.graphics.*
import java.io.File
import kotlin.random.Random


class CaptchaGenerator( val captchaSize: Int,
                        val backGroundImageId: Int,
                        val textSize: Float ,
                        val colorId: Int) {

    var captcha: String? = null


    data class Builder(
    var captchaSize: Int= 4,
    var  backGroundImageId: Int = R.drawable.bottom_bar,
    var textSize: Float =  70F,
    var colorId: Int = Color.BLUE){

        fun captchaSize(captchaSize: Int) = apply { this.captchaSize = captchaSize }
        fun backGroundImageId(backGroundImageId: Int) = apply { this.backGroundImageId = backGroundImageId }
        fun textSize(textSize: Float) = apply { this.textSize = textSize }
        fun colorId(colorId: Int) = apply { this.colorId = colorId }
        fun build() = CaptchaGenerator(captchaSize, backGroundImageId, textSize, colorId)
    }




    // Генерируем каптчу
    fun generateCaptcha(activity: Activity): Bitmap? {
        val src = BitmapFactory.decodeResource(activity.resources, backGroundImageId)
        val dest = Bitmap.createBitmap(src.width, src.height, Bitmap.Config.ARGB_8888)


        val STRING_CHARACTERS = ('0'..'z').toList().toTypedArray()
         captcha = (1..captchaSize).map { STRING_CHARACTERS.random() }.joinToString("")


        val cs = Canvas(dest)
        val tPaint = Paint()
        tPaint.textSize = textSize
        tPaint.color = colorId
        tPaint.style = Paint.Style.FILL
        cs.drawBitmap(src, 0f, 0f, null)
        val height = tPaint.measureText("yY")
        val width = tPaint.measureText(captcha)
        val x_coord = (src.width - width) / 2
        cs.drawText(
            captcha,
            x_coord,
            height + 15f,
            tPaint
        )

        return dest

    }




    //проверяем равенство значений на изображении и введеный декст
    fun checkCaptcha(value: String): Boolean{
        return captcha == value
    }

}