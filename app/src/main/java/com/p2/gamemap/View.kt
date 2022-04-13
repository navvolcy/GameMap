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
        val mount:  Bitmap
        val forest: Bitmap
        val grass : Bitmap
        val ocean : Bitmap



        init {
            // Load images
            mount = BitmapFactory.decodeResource(resources, R.drawable.mountain,null)
            forest = BitmapFactory.decodeResource(resources, R.drawable.forest,null)
            grass = BitmapFactory.decodeResource(resources, R.drawable.plain,null)
            ocean = BitmapFactory.decodeResource(resources, R.drawable.water,null)
        }
        // displayed on canvas
        override fun onDraw(canvas: Canvas) {
            var X = 0F
            var Y = 0F
            var r = 0
            var c = 0

            val imageList = arrayOf(arrayOf<Bitmap>(mount, mount,mount,mount), arrayOf<Bitmap>(forest, forest,forest,forest), arrayOf<Bitmap>(grass, grass,grass,grass), arrayOf<Bitmap>(ocean, ocean,ocean,ocean))

            for (row in imageList) {
                //track coordinates
                for (image in row) {
                    //calculate x from c and y from r
                    // canvas.drawBitmap(imageList[r][c], X, Y, null)
                    canvas.drawBitmap(image, X, Y, null)
                    X += 150F



                }
                Y += 150F
                X = 0F
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




