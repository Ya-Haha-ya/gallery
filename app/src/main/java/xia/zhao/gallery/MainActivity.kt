package xia.zhao.gallery

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import xia.zhao.gallery.photo.PhotoFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.root, PhotoFragment.newInstance()).commit()
    }
}
