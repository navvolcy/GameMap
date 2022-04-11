package com.p2.gamemap

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

class MapView (context: Context, attrs: AttributeSet? = null): View(context, attrs) {

        var nextX = 50F
        var nextY = 50F
        val mount: Bitmap



        init {
           //load images
            mount = BitmapFactory.decodeResource(resources, R.drawable.mountain,null)

        }
        // displayed on canvas
        override fun onDraw(canvas: Canvas) {
            var X = 0F
            var Y = 0F
            //Log.i("CS220", "On draw ")
           // canvas.drawBitmap(mount, X, Y, null)
           // canvas.drawBitmap(mount, X + 150F, Y , null)
            var col = 0
            var row = 0
            for (col in 0..10){

                canvas.drawBitmap(mount, X , Y , null)
                X += 150F
                Log.i("CS220", "On draw2 ${col}")
                for (row in 0..10){
                    //if statement  

                }


            }





        }

        override fun onTouchEvent(event: MotionEvent): Boolean {
            if (event.action == MotionEvent.ACTION_UP) {
                Log.i("CS3680", "Touch event ${event.x}, ${event.y}")
                nextX = event.x
                nextY = event.y
                invalidate()
                return true
            }
            return true
        }
    }




