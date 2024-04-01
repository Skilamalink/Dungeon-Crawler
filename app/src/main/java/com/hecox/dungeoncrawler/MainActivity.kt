package com.hecox.dungeoncrawler

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var background: ImageView
    //top
    lateinit var room1top: ImageView
    lateinit var room2topLeft: ImageView
    lateinit var room2topRight: ImageView
    lateinit var room3topLeft: ImageView
    lateinit var room3topRight: ImageView
    lateinit var room3topMiddle: ImageView
    lateinit var room3topLeftLeft: ImageView
    lateinit var hallway34top: ImageView
    lateinit var room4top: ImageView
    lateinit var hallway45top: ImageView
    lateinit var room5rightTop: ImageView
    lateinit var room5topRight: ImageView
    lateinit var room5topLeft: ImageView
    lateinit var room6top: ImageView
    lateinit var hallway57top: ImageView
    lateinit var room7top: ImageView

    //bottom

    lateinit var room1bottomLeft: ImageView
    lateinit var room1bottomRight: ImageView
    lateinit var room2bottomLeft: ImageView
    lateinit var room2bottomRight: ImageView
    lateinit var room3bottom: ImageView
    lateinit var hallway34bottom: ImageView
    lateinit var room4bottom: ImageView
    lateinit var hallway45bottom: ImageView
    lateinit var room5bottom: ImageView
    lateinit var room6bottomRight: ImageView
    lateinit var room6bottomLeft: ImageView
    lateinit var hallway57bottom: ImageView
    lateinit var room7bottom: ImageView

    //left

    lateinit var room1left: ImageView
    lateinit var hallway12left: ImageView
    lateinit var room2left: ImageView
    lateinit var hallway23left: ImageView
    lateinit var room3leftRight: ImageView
    lateinit var room3leftLeft: ImageView
    lateinit var room4leftBottom: ImageView
    lateinit var room4leftTop: ImageView
    lateinit var room5leftBottom: ImageView
    lateinit var room5leftTop: ImageView
    lateinit var hallway56Left: ImageView
    lateinit var room6left: ImageView
    lateinit var room7left: ImageView


    //right

    lateinit var room1right: ImageView
    lateinit var hallway12right: ImageView
    lateinit var room2right: ImageView
    lateinit var hallway23right: ImageView
    lateinit var room3rightRight: ImageView
    lateinit var room3leftRightTop: ImageView
    lateinit var room3leftRightBottom: ImageView
    lateinit var room4right: ImageView
    lateinit var room5rightBottom: ImageView
    lateinit var hallway56Right: ImageView
    lateinit var room6right: ImageView
    lateinit var room7rightBottom: ImageView
    lateinit var room7rightTop: ImageView








    private var enemy1Undefeated = true

    lateinit var grayScreen: ImageView

    private var pause = false

    lateinit var pauseButton: Button


    private var movingLeft = false
    private var movingRight = false
    private var movingUp = false
    private var movingDown = false

    private var attackDirection = 1

    private var hp = 100
    private var enemyHp1 = 100

    private var canLook = false


//    var coin = 0

    lateinit var monster1Detect: ImageView

    private var swordFrame = 1


    lateinit var upButton: Button
    lateinit var downButton: Button
    lateinit var leftButton: Button
    lateinit var rightButton: Button
    lateinit var attackButton: Button

    lateinit var LButton: Button


    lateinit var character: ImageView
    lateinit var attackTest: ImageView

    lateinit var characterHitBox: ImageView
    lateinit var monster1HitBox: ImageView

    lateinit var HealthBar: ProgressBar
    lateinit var monster1HealthBar: ProgressBar


    lateinit var monster1: ImageView


    private var handler = Handler(Looper.getMainLooper())

//    attackTest = findViewById(R.id.attackTest)


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        background = findViewById(R.id.background)

        //top
        room1top = findViewById(R.id.room1top)
        room2topLeft = findViewById(R.id.room2topLeft)
        room2topRight = findViewById(R.id.room2topRight)
        room3topLeft = findViewById(R.id.room3topLeft)
        room3topRight = findViewById(R.id.room3topRight)
        room3topMiddle = findViewById(R.id.room3topMiddle)
        room3topLeftLeft = findViewById(R.id.room3topLeftLeft)
        hallway34top = findViewById(R.id.hallway34top)
        room4top = findViewById(R.id.room4top)
        hallway45top = findViewById(R.id.hallway45top)
        room5rightTop = findViewById(R.id.room5rightTop)
        room5topRight = findViewById(R.id.room5topRight)
        room5topLeft = findViewById(R.id.room5topLeft)
        room6top = findViewById(R.id.room6top)
        hallway57top = findViewById(R.id.hallway57top)
        room7top = findViewById(R.id.room7top)



        //bottom
        room1bottomLeft = findViewById(R.id.room1bottomLeft)
        room1bottomRight = findViewById(R.id.room1bottomRight)
        room2bottomLeft = findViewById(R.id.room2bottomLeft)
        room2bottomRight = findViewById(R.id.room2bottomRight)
        room3bottom = findViewById(R.id.room3bottom)
        hallway34bottom = findViewById(R.id.hallway34bottom)
        room4bottom = findViewById(R.id.room4bottom)
        hallway45bottom = findViewById(R.id.hallway45bottom)
        room5bottom = findViewById(R.id.room5bottom)
        room6bottomRight = findViewById(R.id.room6bottomRight)
        room6bottomLeft = findViewById(R.id.room6bottomLeft)
        hallway57bottom = findViewById(R.id.hallway57bottom)
        room7bottom = findViewById(R.id.room7bottom)



        //left
        room1left = findViewById(R.id.room1left)
        hallway12left = findViewById(R.id.hallway12left)
        room2left = findViewById(R.id.room2left)
        hallway23left = findViewById(R.id.hallway23left)
        room3leftRight = findViewById(R.id.room3leftRight)
        room3leftLeft = findViewById(R.id.room3leftLeft)
        room4leftBottom = findViewById(R.id.room4leftBottom)
        room4leftTop = findViewById(R.id.room4leftTop)
        room5leftBottom = findViewById(R.id.room5leftBottom)
        room5leftTop = findViewById(R.id.room5leftTop)
        hallway56Left = findViewById(R.id.hallway56Left)
        room6left = findViewById(R.id.room6left)
        room7left = findViewById(R.id.room7left)



        //right
        room1right = findViewById(R.id.room1right)
        hallway12right = findViewById(R.id.hallway12right)
        room2right = findViewById(R.id.room2right)
        hallway23right = findViewById(R.id.hallway23right)
        room3rightRight = findViewById(R.id.room3rightRight)
        room3leftRightTop = findViewById(R.id.room3leftRightTop)
        room3leftRightBottom = findViewById(R.id.room3leftRightBottom)
        room4right = findViewById(R.id.room4right)
        room5rightBottom = findViewById(R.id.room5rightBottom)
        hallway56Right = findViewById(R.id.hallway56Right)
        room6right = findViewById(R.id.room6right)
        room7rightBottom = findViewById(R.id.room7rightBottom)
        room7rightTop = findViewById(R.id.room7rightTop)






         upButton = findViewById(R.id.upButton)
         downButton = findViewById(R.id.downButton)
         leftButton = findViewById(R.id.leftButton)
         rightButton = findViewById(R.id.rightButton)

        pauseButton = findViewById((R.id.pauseButton))

        LButton = findViewById(R.id.LButton)

        grayScreen = findViewById(R.id.grayScreen)

        var coin = intent.getIntExtra("coin", 0)


//         background = findViewById(R.id.map1)
         character  = findViewById(R.id.character)
//         chest = findViewById(R.id.chest)
//        bottom = findViewById(R.id.bottom1)

//        right = findViewById(R.id.testingHitbox)

        characterHitBox = findViewById(R.id.characterHitBox)
        monster1HitBox = findViewById(R.id.monster1HitBox)


        HealthBar = findViewById(R.id.healthBar)
        monster1HealthBar = findViewById(R.id.monster1Bar)

        var coinCount: TextView = findViewById(R.id.coinCount)

        monster1Detect = findViewById(R.id.monster1detection)


        attackTest = findViewById(R.id.attackTest)
        attackButton = findViewById(R.id.attackButton)


        monster1 = findViewById(R.id.monster1)


        var LButtonImage: ImageView = findViewById(R.id.lbuttonimage)




//        val handler = Handler(Looper.getMainLooper())

        fun checkHitBox(first: ImageView, second: ImageView): Boolean {
            return (((first.x < (second.x + second.width)) && (second.x < (first.x + first.width))) && ((first.y < (second.y + second.height)) && (second.y < (first.y + first.height))))
        }

        val checkForHitBoxes = object : Runnable {
            override fun run() {

                if (pause == false) {

                    if (canLook == false) {
                        LButtonImage.alpha = 0.5F
                    } else {
                        LButtonImage.alpha = 1F
                    }

                    if (hp <= 0) {
                        val intent = Intent(this@MainActivity, YouDied::class.java)
                        startActivity(intent)
                        pause = true
                        finish()
                    }

                    if ((enemyHp1 <= 0) && (enemy1Undefeated)) {
                        banishment(monster1)
                        banishment(monster1HitBox)
                        banishment(monster1Detect)
                        banishHealth(monster1HealthBar)
                        enemy1Undefeated = false

                        coin += Random.nextInt(10)
                    }

                    HealthBar.progress = hp
                    monster1HealthBar.progress = enemyHp1

                    coinCount.text = ("" + coin + " Coins")


                    if (checkHitBox(first = characterHitBox, second = monster1HitBox)) {
                        hp -= 1
//                    HP.progress = hp
                    }

                    if (checkHitBox(first = attackTest, second = monster1HitBox)) {
                        enemyHp1 -= 20
                    }


                    if (checkHitBox(first = characterHitBox, second = monster1Detect)) {
                        track(hunter = monster1, target = character)
                        track(hunter = monster1HitBox, target = character)
                        trackProgress(hunter = monster1HealthBar, target = character)
                    } else if (enemy1Undefeated) {
                        track(hunter = monster1, target = monster1Detect)
                        track(hunter = monster1HitBox, target = monster1Detect)
                        trackProgress(hunter = monster1HealthBar, target = monster1Detect)
                    }


                if ((checkHitBox(first = character, second = room1top))||(checkHitBox(first = character, second = room2topLeft))||(checkHitBox(first = character, second = room2topRight))||(checkHitBox(first = character, second = room3topLeft))||(checkHitBox(first = character, second = room3topRight))||(checkHitBox(first = character, second = room3topMiddle))||(checkHitBox(first = character, second = room3topLeftLeft))||(checkHitBox(first = character, second = hallway34top))||(checkHitBox(first = character, second = room4top))||(checkHitBox(first = character, second = hallway45top))||(checkHitBox(first = character, second = room5rightTop))||(checkHitBox(first = character, second = room5topRight))||(checkHitBox(first = character, second = room5topLeft))||(checkHitBox(first = character, second = room6top))||(checkHitBox(first = character, second = hallway57top))||(checkHitBox(first = character, second = room7top))) {
                    movingUp = false
                }

//
//                if (checkHitBox(first = characterHitBox, second = left)) {
//                    movingLeft = false
//                }
//                else {
//                    movingLeft = true
//                }
//
//                if (checkHitBox(first = characterHitBox, second = bottom)) {
//                    movingRight = false
//                }
////                else {
////                    movingRight = true
////                }
//
//                if (checkHitBox(first = characterHitBox, second = bottom)) {
//                    movingDown = false
//                }
//                else {
//                    movingDown = true
//                }

                    handler.postDelayed(this, 100)

                }
            }

        }
        handler.post(checkForHitBoxes)






        upButton.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN
                -> {
                    moveUp()
                    true
                }

                MotionEvent.ACTION_UP
                -> {
                    movingUp = false
                    true
                }

                else -> false
            }
        }

        downButton.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN
                -> {
                    moveDown()
                    true
                }

                MotionEvent.ACTION_UP
                -> {
                    movingDown = false
                    true
                }

                else -> false
            }
        }

        leftButton.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN
                -> {
                    moveLeft()
                    true
                }

                MotionEvent.ACTION_UP
                -> {
                    movingLeft = false
                    true
                }

                else -> false
            }
        }

        rightButton.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN
                -> {
                    moveRight()
                    true
                }

                MotionEvent.ACTION_UP
                -> {
                    movingRight = false
                    true
                }

                else -> false
            }
        }

        attackButton.setOnClickListener {
            knightAttack()
        }

        pauseButton.setOnClickListener {
            pauseScreen()
        }


    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

        when (keyCode) {
            KeyEvent.KEYCODE_A -> { moveLeft(speed = 5) }
            KeyEvent.KEYCODE_W -> { moveUp(speed = 5) }
            KeyEvent.KEYCODE_S -> { moveDown(speed = 5) }
            KeyEvent.KEYCODE_D -> { moveRight(speed = 5) }

            KeyEvent.KEYCODE_P -> { pauseScreen() }

            KeyEvent.KEYCODE_K -> { knightAttack() }
            KeyEvent.KEYCODE_L -> {  }
        }

        return super.onKeyDown(keyCode, event)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_A -> { movingLeft = false }
            KeyEvent.KEYCODE_W -> { movingUp = false }
            KeyEvent.KEYCODE_S -> { movingDown = false }
            KeyEvent.KEYCODE_D -> { movingRight = false }
        }

        return super.onKeyUp(keyCode, event)
    }

    private fun moveUp(speed:Int = 1) {
        if (pause == false) {

            movingRight = false
            movingDown = false
            movingLeft = false
            movingUp = true

            Thread {
                while (movingUp) {
//                    background.y += 5 * speed
//                chest.y += 5*speed
//                bottom.y += 5*speed
//                top.y += 5*speed
//                left.y += 5*speed
                    moveBackgroundY(speed = (5 * speed))
                    monster1.y += 5 * speed
                    monster1HealthBar.y += 5 * speed
                    monster1Detect.y += 5 * speed
                    monster1HitBox.y += 5 * speed
                    character.rotation = 0F
                    attackTest.rotation = 0F
                    attackDirection = 1
                    Thread.sleep(20)
                }
            }.start()
        }
    }


    private fun moveDown(speed:Int = 1) {
        if (pause == false) {

            movingUp = false
            movingRight = false
            movingLeft = false
            movingDown = true

            Thread {
                while (movingDown) {
//                    background.y -= 5 * speed
//                chest.y -= 5*speed
//                bottom.y -= 5*speed
//                top.y -= 5*speed
//                left.y -= 5*speed
                    moveBackgroundY(speed = (-5 * speed))
                    monster1.y -= 5 * speed
                    monster1HealthBar.y -= 5 * speed
                    monster1Detect.y -= 5 * speed
                    monster1HitBox.y -= 5 * speed

                    character.rotation = 180F
                    attackTest.rotation = 180F
                    attackDirection = 3
                    Thread.sleep(20)
                }
            }.start()
        }
    }




    private fun moveLeft(speed:Int = 1) {
        if (pause == false) {
            movingUp = false
            movingDown = false
            movingRight = false
            movingLeft = true

            Thread {
                while (movingLeft) {
//                    background.x += 5 * speed
//                chest.x += 5*speed
//                bottom.x += 5*speed
//                top.x += 5*speed
//                left.x += 5*speed
                    moveBackgroundX(speed = (5 * speed))
                    monster1.x += 5 * speed
                    monster1HealthBar.x += 5 * speed
                    monster1Detect.x += 5 * speed
                    monster1HitBox.x += 5 * speed

                    character.rotation = 270F
                    attackTest.rotation = 270F
                    attackDirection = 4
                    Thread.sleep(20)
                }
            }.start()
        }
    }

    private fun moveRight(speed:Int = 1) {
        if (pause == false) {
            movingUp = false
            movingDown = false
            movingLeft = false
            movingRight = true

            Thread {
                while (movingRight) {
//                    background.x -= 5 * speed
//                chest.x -= 5*speed
//                bottom.x -= 5*speed
//                top.x -= 5*speed
//                left.x -= 5*speed
                    moveBackgroundX(speed = (-5 * speed))
                    monster1.x -= 5 * speed
                    monster1HealthBar.x -= 5 * speed
                    monster1Detect.x -= 5 * speed
                    monster1HitBox.x -= 5 * speed
                    character.rotation = 90F
                    attackTest.rotation = 90F
                    attackDirection = 2
                    Thread.sleep(20)
                }
            }.start()
        }
    }

    @SuppressLint("SuspiciousIndentation")
    private fun knightAttack() {
        if (pause == false) {
        when (attackDirection) {
            1 -> {
                attackTest.x = 380F
                attackTest.y = 650F
            }
            2 -> {
                attackTest.x = 610F
                attackTest.y = 870F
            }
            3 -> {
                attackTest.x = 380F
                attackTest.y = 1100F}
            4 -> {
                attackTest.x = 150F
                attackTest.y = 870F}

        }
//            swordFrame = 1
        attackTest.visibility = View.VISIBLE
//        while (swordFrame < 6) {
//            handler.postDelayed({
                    (attackTest.setImageResource(R.drawable.sword1))
//            }, 60)
            handler.postDelayed({
                (attackTest.setImageResource(R.drawable.sword2))
            }, 60)
            handler.postDelayed({
                (attackTest.setImageResource(R.drawable.sword3))
            }, 120)
            handler.postDelayed({
                (attackTest.setImageResource(R.drawable.sword4))
            }, 180)
            handler.postDelayed({
                (attackTest.setImageResource(R.drawable.sword5))
            }, 240)
        handler.postDelayed({
            attackTest.visibility = View.GONE
            attackTest.setImageResource(R.drawable.hitbox)
            attackTest.y = -10000F
        }, 300)
        }
    }

    private fun banishment(target: ImageView) {
        target.y = 10000F
    }
    private fun banishHealth(target: ProgressBar) {
        target.y = 10000F
    }

    private fun track(hunter: ImageView, target: ImageView) {

            var XattackDirection = 1
            var YattackDirection = 1

            XattackDirection = ((target.x - hunter.x).toInt())
            YattackDirection = ((target.y - hunter.y).toInt())

            hunter.x += (XattackDirection / 50)
            hunter.y += (YattackDirection / 50)


    }

    private fun trackProgress(hunter: ProgressBar, target: ImageView) {

            var XattackDirection = 1
            var YattackDirection = 1

            XattackDirection = ((target.x - hunter.x).toInt())
            YattackDirection = ((target.y - hunter.y).toInt())

            hunter.x += (XattackDirection / 50)
            hunter.y += (YattackDirection / 50)


    }

    private fun pauseScreen() {
        pause = !pause

//        if (pause == false) {
//            grayScreen.visibility = View.GONE
//            handler.post(checkForHitBoxes)
//        } else {
//            grayScreen.visibility = View.VISIBLE
//        }
    }

    private fun moveBackgroundX(speed: Int) {
        background.x += speed
        //top
        room1top.x += speed
        room2topLeft.x += speed
        room2topRight.x += speed
        room3topLeft.x += speed
        room3topRight.x += speed
        room3topMiddle.x += speed
        room3topLeftLeft.x += speed
        hallway34top.x += speed
        room4top.x += speed
        hallway45top.x += speed
        room5rightTop.x += speed
        room5topRight.x += speed
        room5topLeft.x += speed
        room6top.x += speed
        hallway57top.x += speed
        room7top.x += speed
        //bottom
        room1bottomLeft.x += speed
        room1bottomRight.x += speed
        room2bottomLeft.x += speed
        room2bottomRight.x += speed
        room3bottom.x += speed
        hallway34bottom.x += speed
        room4bottom.x += speed
        hallway45bottom.x += speed
        room5bottom.x += speed
        room6bottomRight.x += speed
        room6bottomLeft.x += speed
        hallway57bottom.x += speed
        room7bottom.x += speed
        //left
        room1left.x += speed
        hallway12left.x += speed
        room2left.x += speed
        hallway23left.x += speed
        room3leftRight.x += speed
        room3leftLeft.x += speed
        room4leftBottom.x += speed
        room4leftTop.x += speed
        room5leftBottom.x += speed
        room5leftTop.x += speed
        hallway56Left.x += speed
        room6left.x += speed
        room7left.x += speed
        //right
        room1right.x += speed
        hallway12right.x += speed
        room2right.x += speed
        hallway23right.x += speed
        room3rightRight.x += speed
        room3leftRightTop.x += speed
        room3leftRightBottom.x += speed
        room4right.x += speed
        room5rightBottom.x += speed
        hallway56Right.x += speed
        room6right.x += speed
        room7rightBottom.x += speed
        room7rightTop.x += speed
    }

    private fun moveBackgroundY(speed: Int) {
        background.y += speed
        //top
        room1top.y += speed
        room2topLeft.y += speed
        room2topRight.y += speed
        room3topLeft.y += speed
        room3topRight.y += speed
        room3topMiddle.y += speed
        room3topLeftLeft.y += speed
        hallway34top.y += speed
        room4top.y += speed
        hallway45top.y += speed
        room5rightTop.y += speed
        room5topRight.y += speed
        room5topLeft.y += speed
        room6top.y += speed
        hallway57top.y += speed
        room7top.y += speed
        //bottom
        room1bottomLeft.y += speed
        room1bottomRight.y += speed
        room2bottomLeft.y += speed
        room2bottomRight.y += speed
        room3bottom.y += speed
        hallway34bottom.y += speed
        room4bottom.y += speed
        hallway45bottom.y += speed
        room5bottom.y += speed
        room6bottomRight.y += speed
        room6bottomLeft.y += speed
        hallway57bottom.y += speed
        room7bottom.y += speed
        //left
        room1left.y += speed
        hallway12left.y += speed
        room2left.y += speed
        hallway23left.y += speed
        room3leftRight.y += speed
        room3leftLeft.y += speed
        room4leftBottom.y += speed
        room4leftTop.y += speed
        room5leftBottom.y += speed
        room5leftTop.y += speed
        hallway56Left.y += speed
        room6left.y += speed
        room7left.y += speed
        //right
        room1right.y += speed
        hallway12right.y += speed
        room2right.y += speed
        hallway23right.y += speed
        room3rightRight.y += speed
        room3leftRightTop.y += speed
        room3leftRightBottom.y += speed
        room4right.y += speed
        room5rightBottom.y += speed
        hallway56Right.y += speed
        room6right.y += speed
        room7rightBottom.y += speed
        room7rightTop.y += speed


    }

    }

/*

a hunter b target

find slope??

move 1/y of slope for y

move 1/x of slope for x


 */









