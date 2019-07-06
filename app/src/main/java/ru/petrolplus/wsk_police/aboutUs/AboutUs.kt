package ru.petrolplus.wsk_police.aboutUs

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_about_us.*
import ru.petrolplus.wsk_police.BaseActivityFun
import ru.petrolplus.wsk_police.R

class AboutUs : BaseActivityFun() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)

        var pInfo = this.packageManager.getPackageInfo(packageName, 0);
         version_app.text = pInfo.versionName

    }
}
