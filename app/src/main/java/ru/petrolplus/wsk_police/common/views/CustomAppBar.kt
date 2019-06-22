package ru.petrolplus.wsk_police.common.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.app_bar.view.*

import ru.petrolplus.wsk_police.R





class CustomAppBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppBarLayout(context, attrs) {



    init {
        LayoutInflater.from(context).inflate(R.layout.app_bar, this, true)
        attrs?.let {



            // Считываем полученые атрибуты

            val typedArray = context.obtainStyledAttributes(it,
                R.styleable.CustomAppBar, 0, 0)
            header.text = typedArray.getString(R.styleable.CustomAppBar_header_text)
            back_button.visibility = if (typedArray.getBoolean(R.styleable.CustomAppBar_back_button_visible, true)){View.VISIBLE}else{View.INVISIBLE}


            //Вызываем методы интерфейса
            back_button.setOnClickListener {
                if (context is CustomAppBarInterface){
                    context.onBackClick()
                }
            }



            typedArray.recycle()
        }
    }





}