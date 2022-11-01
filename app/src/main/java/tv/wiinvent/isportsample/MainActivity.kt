package tv.wiinvent.isportsample

import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import tv.wiinvent.isportsdk.ISportManager
import tv.wiinvent.isportsdk.interfaces.ISportEventListener
import tv.wiinvent.isportsdk.models.ISportData

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG: String = MainActivity::class.java.canonicalName as String
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        supportActionBar?.hide(); // hide the title bar
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_main)

        val isportData = ISportData.Builder()
            .token("eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIxMyIsImV4cCI6MTY5Njk5MDkzNCwidXNlcklkIjoiMTMiLCJmdWxsTmFtZSI6IlllbiBCQSIsImF2YXRhclVybCI6IiJ9.M0oi_RdFjxSLQimX-S66aR4G1AoXIOkNHEzxA5T9uQKmsbSaeD2l0K6yEJqUXtRcEvNqKIsNfnCOdMkhYn3bStSic1M6x0sobDmjIZncq2Lgq296s5azHzWqv3DXn4swb10D_T-4-zcujaJr8pO0vK9A04zoZ637c8tB8vD5VQo")
            .matchId("18535559")
            .type(ISportData.ViewType.HOME).paramDeepLink("screen=fixture_detail&param=333")
            .env(ISportData.Environment.DEV)
            .build()

        val iSportManager = ISportManager(this, R.id.isport_view, isportData)

        iSportManager.addISportListener(object: ISportEventListener {
            override fun onLoadError() {
            }

            override fun onTimeout() {

            }

            override fun onExchangeLoyalty(packageId: String, point: Long) {

                iSportManager.onUserExchangeLoyaltyFailed()

            }

            override fun onStartLiveDetail(channelId: String) {
                Log.d(TAG, "========onUserStartLiveDetail: $channelId")
            }

            override fun onDismiss() {
            }

            override fun onLogin() {

            }

            override fun onPurchase(packageId: String) {
                Log.d(TAG, "========onUserPurchase: $packageId")

                iSportManager.onUserPurchaseFailed();
            }
        })
    }
}