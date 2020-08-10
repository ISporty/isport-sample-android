package tv.wiinvent.isportsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import tv.wiinvent.isportsdk.ISportManager
import tv.wiinvent.isportsdk.interfaces.ISportEventListener
import tv.wiinvent.isportsdk.models.ISportData
import tv.wiinvent.isportsdk.ui.ISportView

class MainActivity: AppCompatActivity() {
    companion object {
        val TAG = MainActivity.javaClass.canonicalName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val isportData = ISportData.Builder()
            .token("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE1OTY3ODMyOTAyMzcsImp0aSI6ImIwZmI0MTY4LTM4YmMtNDgxZC1hZDQ2LTdkYjU1ZTYzODUzNSIsInN1YiI6Ijk3MDAxNzAifQ.jrCpLf1-OIhH8f7bWaYlH7pf9bASgoRET4gORzVjdEE")
            .matchId("11886291")
            .type(ISportData.ViewType.DETAIL)
            .env(ISportData.Environment.DEV)
            .build()

        val iSportManager = ISportManager(this, R.id.isport_view, isportData)

        iSportManager.addISportListener(object: ISportEventListener{
            override fun onLoadError() {
            }

            override fun onTimeout() {

            }

            override fun onUserExchangeLoyalty(point: Long) {

            }

            override fun onUserLogin() {

            }

            override fun onUserPurchase(packageId: String) {

            }

            override fun onUserStartLiveDetail(channelId: String) {

            }

        } )

    }
}