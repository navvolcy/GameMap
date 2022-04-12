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
        val forest:Bitmap
        val grass : Bitmap
        val ocean : Bitmap



        init {
           //load images
            mount = BitmapFactory.decodeResource(resources, R.drawable.mountain,null)
            forest = BitmapFactory.decodeResource(resources, R.drawable.forest,null)
            grass = BitmapFactory.decodeResource(resources, R.drawable.plain,null)
            ocean = BitmapFactory.decodeResource(resources, R.drawable.water,null)
        }
        // displayed on canvas
        override fun onDraw(canvas: Canvas) {
            var X = 0F
            var Y = 0F

            val imageList = arrayOf(arrayOf<Bitmap>(mount, forest, grass,ocean),arrayOf<Bitmap>(mount, forest, grass,ocean))

            for (i in imageList){


                Log.i("cs22", "solution ${i}")
                X += 150F
                //Log.i("CS220", "On draw2")
                for (j in imageList){
                    // canvas.drawBitmap(imageList[j], X , Y , null)
                    Log.i("CS220", "On draw2${j}")

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




