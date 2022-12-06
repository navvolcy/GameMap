package com.p2.gamemap

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.lifecycle.Transformations.map

class MapView (context: Context, attrs: AttributeSet? = null): View(context, attrs) {

        var nextX = 50F
        var nextY = 50F
        val mount:  Bitmap
        val forest: Bitmap
        val grass : Bitmap
        val ocean : Bitmap
        var person: Bitmap



        init {
            // Load images
            mount = BitmapFactory.decodeResource(resources, R.drawable.mountain,null)
            forest = BitmapFactory.decodeResource(resources, R.drawable.forest,null)
            grass = BitmapFactory.decodeResource(resources, R.drawable.plain,null)
            ocean = BitmapFactory.decodeResource(resources, R.drawable.water,null)
            person = BitmapFactory.decodeResource(resources,R.drawable.person,null)


              //val map = mapOf<Char, Bitmap>('M' to BitmapFactory.decodeResource(resources, R.drawable.mountain,null), 'F' to BitmapFactory.decodeResource(resources, R.drawable.forest,null), '.' to BitmapFactory.decodeResource(resources, R.drawable.plain,null), '~' to BitmapFactory.decodeResource(resources, R.drawable.water,null))

        }
        // displayed on canvas
        override fun onDraw(canvas: Canvas) {
            var X = 0F
            var Y = 0F
            var r = 0
            var c = 0


            //map of images with a specific key<map>
            val map = hashMapOf<Char, Bitmap?>('M' to BitmapFactory.decodeResource(resources, R.drawable.mountain,null), 'F' to BitmapFactory.decodeResource(resources, R.drawable.forest,null), '.' to BitmapFactory.decodeResource(resources, R.drawable.plain,null), '~' to BitmapFactory.decodeResource(resources, R.drawable.water,null))
            // array of chars
            val imageList = arrayOf(arrayOf<Char>('M', 'M', 'M', 'M'),arrayOf<Char>('F', 'F', 'F', 'F'),arrayOf<Char>('.', '.', '.', '.'), arrayOf<Char>('~', '~', '~', '~'))

            Log.i("cs22", "map ${map['M']}")
            for (row in imageList) {

                for (terrain in row) {
                    //calculate x from c and y from r
                    //one of Kotlin's Scope functions which allow you to execute a code block within the context of an object
                    map[terrain]?.let {canvas.drawBitmap(it, X, Y, null)}
                    map[terrain]?.let{canvas.drawBitmap(person,nextX,nextY,null)}
                    Log.i("cs22", "map ${terrain}")
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




