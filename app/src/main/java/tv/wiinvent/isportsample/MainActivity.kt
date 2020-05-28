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
            .token("")
            .matchId("11886291")
            .type(ISportData.ViewType.DETAIL)
            .env(ISportData.Environment.DEV)
            .build()

        val iSportManager = ISportManager(this, R.id.isport_view, isportData)

        iSportManager.addISportListener(object: ISportEventListener{
            override fun onUserLogin() {
                TODO("Not yet implemented")
            }

            override fun onUserPurchase() {
                TODO("Not yet implemented")
            }

            override fun onLoadError() {
                TODO("Not yet implemented")
            }

            override fun onTimeout() {
                TODO("Not yet implemented")
            }
        } )

    }
}