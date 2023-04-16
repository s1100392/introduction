package tw.edu.pu.s1100392.introduction

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.GestureDetector.OnGestureListener
import android.view.MotionEvent
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity(), OnGestureListener {
    lateinit var txv: TextView
    lateinit var gDetector: GestureDetector
    var count:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txv = findViewById(R.id.txv)
        txv.setTextColor(Color.parseColor("#ceefde"))
        txv.setBackgroundColor(Color.WHITE)
        txv.setTypeface(
            Typeface.createFromAsset(assets,
                "font/HanyiSentyGarden.ttf"))
        //txv.getBackground().setAlpha(155)  //0~255透明度值
        gDetector = GestureDetector(this,this)



    }
    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (txv.text == "呂涵郁的自介"){
            txv.text = "資管二B 411003926"
        }
        else{
            txv.text = "呂涵郁的自介"
        }
        gDetector.onTouchEvent(event)
        return true
    }

    override fun onDown(p0: MotionEvent): Boolean {
        //txv.text = "按下"
        return true
    }

    override fun onShowPress(p0: MotionEvent) {
        //txv.text = "按下後無後續動作"
    }

    override fun onSingleTapUp(p0: MotionEvent): Boolean {
        //txv.text = "短按"
        return true
    }

    override fun onScroll(e1: MotionEvent, e2: MotionEvent, distanceX: Float, distanceY: Float): Boolean {
        /*if (e1.y < e2.y) {
            txv.text = "向下拖曳"
        }
        else {
            txv.text = "向上拖曳"
        }*/

        return true
    }


    override fun onLongPress(p0: MotionEvent) {
        //txv.text = "長按"

    }

    override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
        if (e1.x < e2.x) {
            //txv.text = "往右快滑"
            count++
            if(count>3) {
                count = 0
            }
        }
        else {
            //txv.text = "往左快滑"
            count--
            if(count<0) {
                count = 3
            }

        }
        var res:Int = getResources().getIdentifier("pu" + count.toString(),
            "drawable", getPackageName())
        findViewById<LinearLayout>(R.id.bg).setBackgroundResource(res)

        return true
    }

}