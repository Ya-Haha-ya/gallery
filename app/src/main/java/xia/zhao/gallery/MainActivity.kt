package xia.zhao.gallery

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import xia.zhao.gallery.photo.PhotoFragment

class MainActivity : AppCompatActivity() {

    companion object {
        private const val REQUEST_CODE_READ_EXTERNAL_STORAGE = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (checkSelfPermission(READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(READ_EXTERNAL_STORAGE), REQUEST_CODE_READ_EXTERNAL_STORAGE)
        } else {
            loadPhotos()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_READ_EXTERNAL_STORAGE && grantResults.isNotEmpty()){
          if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
              loadPhotos()
          } else {
              finish()
          }
        }
    }

    private fun loadPhotos() {
        supportFragmentManager.beginTransaction().replace(R.id.root, PhotoFragment.newInstance())
            .commit()
    }
}
