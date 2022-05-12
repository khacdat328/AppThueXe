package com.example.thuexe

import Adapter.userCommentAdapter
import Model.userCommentModel
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class carDetailActivity : AppCompatActivity() {
    private lateinit var imageSwitcher: ImageSwitcher
    private lateinit var imageBefore: RelativeLayout
    private lateinit var imageNext: RelativeLayout
    private lateinit var recyclerView_userCmt: RecyclerView

    private var recycleLayoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<userCommentAdapter.ViewHolder>? = null
    private lateinit var userComment: userCommentModel
    private lateinit var list_userComment: ArrayList<userCommentModel>
    private lateinit var userCommentAdapter: userCommentAdapter

    val images = arrayOf(R.drawable.bmw_m5_img, R.drawable.mercedes, R.drawable.ford_mustang)
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.car_detail_layout)

        imageSwitcher = findViewById(R.id.imageSwitcher)
        imageBefore = findViewById(R.id.imageBefore)
        imageNext = findViewById(R.id.imageNext)
        setForSwitching()

        imageNext.setOnClickListener {
            counter++
            if(counter == images.size){
                counter = 0
            }
            val imageForChange = images[counter]
            imageSwitcher.setImageResource(imageForChange)
        }

        imageBefore.setOnClickListener {
            counter--
            if(counter < 0){
                counter = images.size-1
            }
            val imageForChange = images[counter]
            imageSwitcher.setImageResource(imageForChange)
        }

        recyclerView_userCmt = findViewById(R.id.recyclerView_userCmt)

        recycleLayoutManager = LinearLayoutManager(this)

        recyclerView_userCmt.layoutManager = recycleLayoutManager

        list_userComment = arrayListOf()
        getData()


    }

    fun setForSwitching(){
        setFactory()
        setAnimations()
    }

    fun setFactory(){
        imageSwitcher.setFactory{
            getImageView()
        }
    }

    fun getImageView(): ImageView{
        val imageView = ImageView(this)
        imageView.layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT)
        imageView.scaleType=ImageView.ScaleType.FIT_XY
        imageView.setImageResource(images[0])
        return imageView
    }

    fun setAnimations(){
        val animOut = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right)
        val animIn = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left)

        val animOut1 = AnimationUtils.loadAnimation(this, android.R.anim.fade_out)
        val animIn1 = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)

        imageSwitcher.outAnimation = animOut1
        imageSwitcher.inAnimation = animIn1
    }

    fun getData() {
        list_userComment.add(userCommentModel("JohnWih", R.drawable.user_img,"Đánh giá chiếc xe này rất ngon"))
        list_userComment.add(userCommentModel("Nothing", R.drawable.user_img,"Đánh giá chiếc xe này rất ngon"))
        list_userComment.add(userCommentModel("NoHject", R.drawable.user_img,"Đánh giá chiếc xe này rất ngon"))
        list_userComment.add(userCommentModel("JemMye", R.drawable.user_img,"Đánh giá chiếc xe này rất ngon"))


        recyclerView_userCmt.adapter = userCommentAdapter(list_userComment)
    }
}