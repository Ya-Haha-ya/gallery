package xia.zhao.gallery.photo

import android.content.Context
import android.widget.FrameLayout
import androidx.core.widget.ContentLoadingProgressBar
import xia.zhao.gallery.R

class PhotoView(context: Context) : FrameLayout(context) {

    private val progressBar: ContentLoadingProgressBar

    init {
        inflate(context, R.layout.photo_view, this)
        progressBar = findViewById(R.id.progress)
    }

    fun showProgressBar() {
        progressBar.show()
    }

    fun hideProgressBar() {
        progressBar.hide()
    }

}